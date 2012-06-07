package uk.ac.soton.mib104.json2rdf.lang.expression;

import java.util.Collection;

import uk.ac.soton.mib104.json2rdf.lang.DuplicateNamedNodeException;
import uk.ac.soton.mib104.json2rdf.lang.EvaluationException;
import uk.ac.soton.mib104.json2rdf.lang.EvaluationProvider;
import uk.ac.soton.mib104.json2rdf.lang.FatalEvaluationException;
import uk.ac.soton.mib104.json2rdf.lang.template.AnonNodeTemplate;
import uk.ac.soton.mib104.json2rdf.lang.template.Template;

import com.hp.hpl.jena.graph.Node;
import com.hp.hpl.jena.graph.Triple;
import com.hp.hpl.jena.rdf.model.Model;

public final class NamedNodeDeclaration extends Declaration {
	
	private Template<?> nameTemplate;
	
	private Template<Node> nodeTemplate;

	public NamedNodeDeclaration(final Template<?> nameTemplate, final Template<Node> nodeTemplate) {
		this(null, nameTemplate, nodeTemplate);
	}

	public NamedNodeDeclaration(final Block parent, final Template<?> nameTemplate, final Template<Node> nodeTemplate) {
		super(parent);
		
		this.setNameTemplate(nameTemplate);
		this.setNodeTemplate(nodeTemplate);
	}

	@Override
	protected void evaluate(final EvaluationProvider<?> context, final Collection<Triple> triples) throws EvaluationException {
		if (context == null) {
			throw new IllegalArgumentException("context == null");
		} else if (triples == null) {
			throw new IllegalArgumentException("triples == null");
		}
		
		final Template<?> nameTemplate = this.getNameTemplate();
		
		if (nameTemplate != null) {
			try {
				final Object name = nameTemplate.evaluate(context);
				
				final String nodeName = name.toString();
				
				if (context.hasNamedNode(nodeName, false)) {
					throw new DuplicateNamedNodeException(this, context, nodeName);
				} else {
					final Template<Node> nodeTemplate = this.getNodeTemplate();
					
					if (nodeTemplate == null) {
						context.setNamedNode(nodeName, new AnonNodeTemplate().evaluate(context));
					} else {
						try {
							final Node node = nodeTemplate.evaluate(context);
							
							if (node == null) {
								context.setNamedNode(nodeName, new AnonNodeTemplate().evaluate(context));
							} else {
								context.setNamedNode(nodeName, node);
							}
						} catch (final FatalEvaluationException e) {
							throw e;
						} catch (final EvaluationException e) {
							context.setNamedNode(nodeName, new AnonNodeTemplate().evaluate(context));
						}
					}
				}
			} catch (final FatalEvaluationException e) {
				throw e;
			} catch (final EvaluationException e) {
				// Do nothing...
			}
		}
	}
	
	@Override
	protected void evaluate(final EvaluationProvider<?> context, final Model model) throws EvaluationException {
		// Do nothing...
	}

	public Template<?> getNameTemplate() {
		return nameTemplate;
	}

	public Template<Node> getNodeTemplate() {
		return nodeTemplate;
	}

	@Override
	public int getPrecedence() {
		// BaseDeclaration < PrefixDeclaration < NamedNodeDeclaration < ... < Expression < ...
		return Integer.MIN_VALUE + 2;
	}

	public void setNameTemplate(final Template<?> nameTemplate) {
		this.nameTemplate = nameTemplate;
	}

	public void setNodeTemplate(final Template<Node> nodeTemplate) {
		this.nodeTemplate = nodeTemplate;
	}

}
