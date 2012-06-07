package uk.ac.soton.mib104.json2rdf.lang.expression;

import java.util.Collection;

import uk.ac.soton.mib104.json2rdf.lang.DuplicatePrefixException;
import uk.ac.soton.mib104.json2rdf.lang.EvaluationException;
import uk.ac.soton.mib104.json2rdf.lang.EvaluationProvider;
import uk.ac.soton.mib104.json2rdf.lang.FatalEvaluationException;
import uk.ac.soton.mib104.json2rdf.lang.InvalidNamespaceException;
import uk.ac.soton.mib104.json2rdf.lang.template.Template;

import com.hp.hpl.jena.graph.Node;
import com.hp.hpl.jena.graph.Triple;
import com.hp.hpl.jena.rdf.model.Model;

public final class PrefixDeclaration extends Declaration {
	
	private Template<?> nameTemplate;
	
	private Template<Node> nodeTemplate;

	public PrefixDeclaration(final Block parent, final Template<?> nameTemplate, final Template<Node> nodeTemplate) {
		super(parent);
		
		this.setNameTemplate(nameTemplate);
		this.setNodeTemplate(nodeTemplate);
	}

	public PrefixDeclaration(final Template<?> nameTemplate, final Template<Node> nodeTemplate) {
		this(null, nameTemplate, nodeTemplate);
	}
	
	@Override
	protected void evaluate(final EvaluationProvider<?> context, final Collection<Triple> triples) throws EvaluationException {
		if (context == null) {
			throw new IllegalArgumentException("context == null");
		} else if (triples == null) {
			throw new IllegalArgumentException("triples == null");
		}
		
		final Template<?> nameTemplate = this.getNameTemplate();
		
		final Template<Node> nodeTemplate = this.getNodeTemplate();
		
		if ((nameTemplate != null) && (nodeTemplate != null)) {
			try {
				final Object name = nameTemplate.evaluate(context);
				
				final Node node = nodeTemplate.evaluate(context);
				
				if ((name != null) && (node != null)) {
					final String namespacePrefix = name.toString();
					
					if (context.hasNamespaceNode(namespacePrefix, false)) {
						throw new DuplicatePrefixException(this, context, namespacePrefix);
					} else {
						context.setNamespaceNode(namespacePrefix, node);
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
		final Template<?> nameTemplate = this.getNameTemplate();
		
		final Template<Node> nodeTemplate = this.getNodeTemplate();
		
		if ((nameTemplate != null) && (nodeTemplate != null)) {
			try {
				final Object name = nameTemplate.evaluate(context);
				
				final Node node = nodeTemplate.evaluate(context);
				
				if ((name != null) && (node != null)) {
					if (node.isURI()) {
						model.setNsPrefix(name.toString(), node.getURI());
					} else {
						throw new InvalidNamespaceException(this, context, name.toString(), node);
					}
				}
			} catch (final FatalEvaluationException e) {
				throw e;
			} catch (final EvaluationException e) {
				// Do nothing...
			}
		}
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
		return Integer.MIN_VALUE + 1;
	}

	public void setNameTemplate(final Template<?> nameTemplate) {
		this.nameTemplate = nameTemplate;
	}

	public void setNodeTemplate(final Template<Node> nodeTemplate) {
		this.nodeTemplate = nodeTemplate;
	}

}
