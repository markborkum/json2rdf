package uk.ac.soton.mib104.json2rdf.lang.context;

import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;

import org.antlr.runtime.RecognitionException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import uk.ac.soton.mib104.json2rdf.lang.EvaluationException;
import uk.ac.soton.mib104.json2rdf.lang.EvaluationProvider;
import uk.ac.soton.mib104.json2rdf.lang.FatalEvaluationException;
import uk.ac.soton.mib104.json2rdf.lang.FatalInterpolationException;
import uk.ac.soton.mib104.json2rdf.lang.Interpolatable;
import uk.ac.soton.mib104.json2rdf.lang.InterpolationException;
import uk.ac.soton.mib104.json2rdf.lang.MethodNotFoundException;
import uk.ac.soton.mib104.json2rdf.lang.NullValueException;
import uk.ac.soton.mib104.json2rdf.lang.Sendable;
import uk.ac.soton.mib104.json2rdf.lang.method.AsJSONMethod;
import uk.ac.soton.mib104.json2rdf.lang.method.ChildMethod;
import uk.ac.soton.mib104.json2rdf.lang.method.CurrentTimeMethod;
import uk.ac.soton.mib104.json2rdf.lang.method.LengthMethod;
import uk.ac.soton.mib104.json2rdf.lang.method.Method;
import uk.ac.soton.mib104.json2rdf.lang.method.ParentMethod;
import uk.ac.soton.mib104.json2rdf.lang.method.ParseJSONMethod;
import uk.ac.soton.mib104.json2rdf.lang.method.ParseXSDDateTimeMethod;
import uk.ac.soton.mib104.json2rdf.lang.method.RootMethod;
import uk.ac.soton.mib104.json2rdf.lang.method.ThisMethod;
import uk.ac.soton.mib104.json2rdf.lang.method.ToLowerCaseMethod;
import uk.ac.soton.mib104.json2rdf.lang.method.ToUpperCaseMethod;
import uk.ac.soton.mib104.json2rdf.lang.method.TrimMethod;
import uk.ac.soton.mib104.json2rdf.lang.template.MethodCallList;
import uk.ac.soton.mib104.json2rdf.util.JSONUtils;
import uk.ac.soton.mib104.json2rdf.util.MethodCallListFactory;
import uk.ac.soton.mib104.json2rdf.util.NodeFactory;
import uk.ac.soton.mib104.json2rdf.util.StringUtils;

import com.hp.hpl.jena.datatypes.xsd.XSDDateTime;
import com.hp.hpl.jena.graph.Node;

public class ObjectContext<T> implements EvaluationProvider<T> {
	
	private static final Map<String, Method> nameToMethod = new HashMap<String, Method>();
	
	static {
		try {
			addMethod(new ThisMethod());
			addMethod(new ParentMethod());
			addMethod(new RootMethod());
			
			addMethod(new ChildMethod());
			addMethod(new LengthMethod());
			
			addMethod(new AsJSONMethod());
			addMethod(new ParseJSONMethod());
			
			addMethod(new ToLowerCaseMethod());
			addMethod(new ToUpperCaseMethod());
			addMethod(new TrimMethod());
			
			addMethod(new CurrentTimeMethod());
			addMethod(new ParseXSDDateTimeMethod());
		} catch (final Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	private static final boolean addMethod(final Method method) {
		if (method == null) {
			throw new IllegalArgumentException("method == null");
		} else {
			return addMethod(method, method.getName());
		}
	}
	
	private static final boolean addMethod(final Method method, final String name) {
		if (method == null) {
			throw new IllegalArgumentException("method == null");
		} else if (name == null) {
			throw new IllegalArgumentException("name == null");
		} else if (getNameToMethod().containsKey(name)) {
			throw new IllegalArgumentException("name is already registered");
		} else {
			getNameToMethod().put(name, method);
			
			return true;
		}
	}
	
	public static final Iterable<String> getMethodNames() {
		return getNameToMethod().keySet();
	}
	
	private static final Map<String, Method> getNameToMethod() {
		if (nameToMethod == null) {
			throw new IllegalStateException("nameToMethod == null");
		} else {
			return nameToMethod;
		}
	}
	
	public static final Sendable<?> send(final EvaluationProvider<?> context, final String methodName, final Object[] arguments) throws MethodNotFoundException {
		final Method method = getNameToMethod().get(methodName);
		
		if (method == null) {
			throw new MethodNotFoundException(context, methodName, arguments);
		} else {
			return method.call(context, arguments); 
		}
	}
	
	private Node baseNode;
	
	private List<EvaluationProvider<?>> children = new LinkedList<EvaluationProvider<?>>();
	
	private XSDDateTime currentTime;
	
	private Node currentTimeNode;
	
	private Map<String, Node> namedNodes = new HashMap<String, Node>();
	
	private Map<String, Node> namespaceNodes = new HashMap<String, Node>();
	
	private T object;
	
	private EvaluationProvider<?> parent;
	
	public ObjectContext() {
		this(null, null);
	}
	
	public ObjectContext(final EvaluationProvider<?> parent) {
		this(parent, null);
	}
	
	public ObjectContext(final EvaluationProvider<?> parent, final T object) {
		this.setParent(parent);
		this.setObject(object);
	}
	
	public ObjectContext(final T object) {
		this(null, object);
	}
	
	@Override
	public EvaluationProvider<?> createChild() {
		final T object = this.getObject();
		
		return this.createChild(object);
	}
	
	@Override
	public EvaluationProvider<?> createChild(final Object object) {
		if ((object == null) || JSONObject.NULL.equals(object)) {
			return new ObjectContext<Void>(this);
		} else if (object instanceof Matcher) {
			try {
				return new ObjectContext<JSONArray>(this, JSONUtils.toJSONArray((Matcher) object));
			} catch (final JSONException e) {
				return new ObjectContext<Void>(this);
			}
		} else {
			return new ObjectContext<Object>(this, object);
		}
	}
	
	@Override
	public Iterable<EvaluationProvider<?>> createChildren() {
		final T object = this.getObject();
		
		return this.createChildren(object);
	}
	
	@Override
	public Iterable<EvaluationProvider<?>> createChildren(final Object object) {
		final List<EvaluationProvider<?>> children = new LinkedList<EvaluationProvider<?>>();
		
		if (object instanceof JSONArray) {
			final JSONArray array = (JSONArray) object;
			
			for (int index = 0; index < array.length(); index++) {
				try {
					final Object element = array.get(index);
					
					final EvaluationProvider<?> childContext = this.createChild(element);
					
					if (childContext != null) {
						children.add(index, childContext);
					}
				} catch (final JSONException e) {
					final EvaluationProvider<?> childContext = this.createChild(null);
					
					if (childContext != null) {
						children.add(index, childContext);
					}
				}
			}
		} else {
			final EvaluationProvider<?> childContext = this.createChild(object);
			
			if (childContext != null) {
				children.add(childContext);
			}
		}
		
		return children;
	}
	
	@Override
	public Node getBaseNode() {
		if (baseNode == null) {
			final EvaluationProvider<?> parent = this.getParent();
			
			if (parent == null) {
				return null;
			} else {
				return parent.getBaseNode();
			}
		} else {
			return baseNode;
		}
	}
	
	@Deprecated
	@Override
	public List<EvaluationProvider<?>> getChildren() {
		if (children == null) {
			throw new IllegalStateException("children == null");
		}
		
		return children;
	}
	
	@Override
	public XSDDateTime getCurrentTime() {
		final EvaluationProvider<?> parent = this.getParent();
		
		if (parent == null) {
			if (currentTime == null) {
				currentTime = new XSDDateTime(Calendar.getInstance());
			}
			
			return currentTime;
		} else {
			return parent.getCurrentTime();
		}
	}
	
	@Override
	public Node getCurrentTimeNode() {
		final EvaluationProvider<?> parent = this.getParent();
		
		if (parent == null) {
			if (currentTime == null) {
				currentTime = new XSDDateTime(Calendar.getInstance());
			}
			
			if (currentTimeNode == null) {
				currentTimeNode = NodeFactory.createTypedLiteral(currentTime);
			}
			
			return currentTimeNode;
		} else {
			return parent.getCurrentTimeNode();
		}
	}
	
	@Override
	public Node getNamedNode(final String name) {
		return this.getNamedNode(name, false);
	}
	
	@Override
	public Node getNamedNode(final String name, final boolean createIfNull) {
		if (StringUtils.isBlank(name)) {
			throw new IllegalArgumentException("StringUtils.isBlank(name) == true");
		} else {
			final Map<String, Node> namedNodes = this.getNamedNodes();
			
			final Node node = namedNodes.get(name);
			
			if (node == null) {
				final EvaluationProvider<?> parent = this.getParent();
				
				if (parent != null) {
					final Node parentNode = parent.getNamedNode(name, false);
					
					if (parentNode != null) {
						return parentNode;
					}
				}
				
				if (createIfNull) {
					final Node newNode = NodeFactory.createAnon();
					
					this.setNamedNode(name, newNode);
					
					return newNode;
				} else {
					return null;
				}
			} else {
				return node;
			}
		}
	}
	
	protected Map<String, Node> getNamedNodes() {
		if (namedNodes == null) {
			throw new IllegalStateException("namedNodes == null");
		}
		
		return namedNodes;
	}
	
	@Override
	public Node getNamespaceNode(final String namespacePrefix) {
		if (StringUtils.isBlank(namespacePrefix)) {
			return null;
		} else {
			final Map<String, Node> namespaceNodes = this.getNamespaceNodes();
			
			final Node namespaceNode = namespaceNodes.get(namespacePrefix);
			
			if (namespaceNode == null) {
				final EvaluationProvider<?> parent = this.getParent();
				
				if (parent == null) {
					return null;
				} else {
					return parent.getNamespaceNode(namespacePrefix);
				}
			} else {
				return namespaceNode;
			}
		}
	}
	
	protected Map<String, Node> getNamespaceNodes() {
		if (namespaceNodes == null) {
			throw new IllegalStateException("namespaceNodes == null");
		}
		
		return namespaceNodes;
	}
	
	@Override
	public T getObject() {
		return object;
	}
	
	@Override
	public EvaluationProvider<?> getParent() {
		return parent;
	}
	
	@Override
	public EvaluationProvider<?> getRoot() {
		final EvaluationProvider<?> parent = this.getParent();
		
		if (parent == null) {
			return this; 
		} else {
			return parent.getRoot();
		}
	}
	
	@Override
	public boolean hasBaseNode() {
		return this.hasBaseNode(true);
	}
	
	@Override
	public boolean hasBaseNode(final boolean recursive) {
		if (baseNode == null) {
			if (recursive) {
				final EvaluationProvider<?> parent = this.getParent();
				
				if (parent == null) {
					return false;
				} else {
					return parent.hasBaseNode(recursive);
				}
			} else {
				return false;
			}
		} else {
			return true;
		}
	}
	
	@Override
	public boolean hasNamedNode(final String name) {
		return this.hasNamedNode(name, true);
	}
	
	@Override
	public boolean hasNamedNode(final String name, final boolean recursive) {
		if (StringUtils.isBlank(name)) {
			throw new IllegalArgumentException("StringUtils.isBlank(name) == true");
		} else {
			final Map<String, Node> namedNodes = this.getNamedNodes();
			
			final Node node = namedNodes.get(name);
			
			if (node == null) {
				if (recursive) {
					final EvaluationProvider<?> parent = this.getParent();
					
					if (parent == null) {
						return false;
					} else {
						return parent.hasNamedNode(name, recursive);
					}
				} else {
					return false;
				}
			} else {
				return true;
			}
		}
	}
	
	@Override
	public boolean hasNamespaceNode(final String namespacePrefix) {
		return this.hasNamespaceNode(namespacePrefix, true);
	}
	
	@Override
	public boolean hasNamespaceNode(final String namespacePrefix, final boolean recursive) {
		if (StringUtils.isBlank(namespacePrefix)) {
			return false;
		} else {
			final Map<String, Node> namespaceNodes = this.getNamespaceNodes();
			
			final Node namespaceNode = namespaceNodes.get(namespacePrefix);
			
			if (namespaceNode == null) {
				if (recursive) {
					final EvaluationProvider<?> parent = this.getParent();
					
					if (parent == null) {
						return false;
					} else {
						return parent.hasNamespaceNode(namespacePrefix, recursive);
					}
				} else {
					return false;
				}
			} else {
				return true;
			}
		}
	}
	
	@Override
	public String interpolate(final String input) throws InterpolationException {
		if (StringUtils.isBlank(input)) {
			return StringUtils.emptyString;
		} else {
			final Map<String, String> replacements = new HashMap<String, String>();
			
			for (final Matcher matcher = Interpolatable.interpolatePattern.matcher(input); matcher.find(); ) {
				final String target = matcher.group();
				
				if (!replacements.containsKey(target)) {
					try {
						final MethodCallList methodCallList = MethodCallListFactory.createMethodCallList(target);
						
						final Object replacement = methodCallList.evaluate(this);
						
						if (replacement == null) {
							throw new InterpolationException(this, input, new NullValueException(methodCallList, this));
						} else {
							replacements.put(target, replacement.toString()); 
						}
					} catch (final RecognitionException e) {
						throw new InterpolationException(this, input, e);
					} catch (final FatalEvaluationException e) {
						throw new FatalInterpolationException(this, input, e);
					} catch (final EvaluationException e) {
						throw new InterpolationException(this, input, e);
					} 
				}
			}
			
			return StringUtils.replaceAll(input, replacements);
		}
	}
	
	@Override
	public Sendable<?> send(final String methodName) throws MethodNotFoundException {
		return this.send(methodName, Sendable.emptyObjectArray);
	}

	@Override
	public Sendable<?> send(final String methodName, final Object[] arguments) throws MethodNotFoundException {
		return send(this, methodName, arguments);
	}
	
	@Override
	public void setBaseNode(final Node baseNode) {
		this.baseNode = baseNode;
	}

	@Override
	public void setNamedNode(final String name, final Node node) {
		if (StringUtils.isBlank(name)) {
			throw new IllegalArgumentException("StringUtils.isBlank(name) == true");
		} else if (node == null) {
			throw new IllegalArgumentException("node == null");
		} else {
			final Map<String, Node> namedNodes = this.getNamedNodes();
			
			namedNodes.put(name, node);
			
			return;
		}
	}

	@Override
	public void setNamespaceNode(final String namespacePrefix, final Node namespaceNode) {
		if (StringUtils.isBlank(namespacePrefix)) {
			throw new IllegalArgumentException("StringUtils.isBlank(namespacePrefix) == true");
		} else {
			final Map<String, Node> namespaceNodes = this.getNamespaceNodes();
			
			namespaceNodes.put(namespacePrefix, namespaceNode);
			
			return;
		}
	}

	protected void setObject(final T object) {
		this.object = object;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void setParent(final EvaluationProvider<?> parent) {
		final EvaluationProvider<?> currentParent = this.getParent();
		
		if (currentParent != null) {
			currentParent.getChildren().remove(this);
		}
		
		this.parent = parent;
		
		if (parent != null) {
			parent.getChildren().add(this);
		}
		
		return;
	}

}
