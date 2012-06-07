package uk.ac.soton.mib104.json2rdf.lang;

import java.util.List;

import com.hp.hpl.jena.datatypes.xsd.XSDDateTime;
import com.hp.hpl.jena.graph.Node;

public interface EvaluationProvider<T> extends Interpolatable<T> {
	
public EvaluationProvider<?> createChild();
	
	public EvaluationProvider<?> createChild(final Object object);
	
	public Iterable<EvaluationProvider<?>> createChildren();
	
	public Iterable<EvaluationProvider<?>> createChildren(final Object object);
	
	public Node getBaseNode();
	
	@Deprecated
	public List<EvaluationProvider<?>> getChildren();
	
	public XSDDateTime getCurrentTime();
	
	public Node getCurrentTimeNode();
	
	public Node getNamedNode(final String name);
	
	public Node getNamedNode(final String name, final boolean createIfNull);
	
	public Node getNamespaceNode(final String namespacePrefix);
	
	public EvaluationProvider<?> getParent();
	
	public EvaluationProvider<?> getRoot();
	
	public boolean hasBaseNode();
	
	public boolean hasBaseNode(final boolean recursive);
	
	public boolean hasNamedNode(final String name);
	
	public boolean hasNamedNode(final String name, final boolean recursive);
	
	public boolean hasNamespaceNode(final String namespacePrefix);
	
	public boolean hasNamespaceNode(final String namespacePrefix, final boolean recursive);
	
	public void setBaseNode(final Node baseNode);
	
	public void setNamedNode(final String name, final Node node);
	
	public void setNamespaceNode(final String namespacePrefix, final Node namespaceNode);
	
	public void setParent(final EvaluationProvider<?> parent);
	
}
