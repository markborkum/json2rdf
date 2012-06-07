package uk.ac.soton.mib104.json2rdf.lang.expression;

import java.util.Collection;

import uk.ac.soton.mib104.json2rdf.lang.DuplicateBaseException;
import uk.ac.soton.mib104.json2rdf.lang.EvaluationException;
import uk.ac.soton.mib104.json2rdf.lang.EvaluationProvider;
import uk.ac.soton.mib104.json2rdf.lang.FatalEvaluationException;
import uk.ac.soton.mib104.json2rdf.lang.template.Template;

import com.hp.hpl.jena.graph.Node;
import com.hp.hpl.jena.graph.Triple;
import com.hp.hpl.jena.rdf.model.Model;

public final class BaseDeclaration extends Declaration {

	private Template<Node> nodeTemplate;

	public BaseDeclaration(final Block parent, final Template<Node> nodeTemplate) {
		super(parent);
		
		this.setNodeTemplate(nodeTemplate);
	}

	public BaseDeclaration(final Template<Node> nodeTemplate) {
		this(null, nodeTemplate);
	}

	@Override
	protected void evaluate(final EvaluationProvider<?> context, final Collection<Triple> triples) throws EvaluationException {
		if (context == null) {
			throw new IllegalArgumentException("context == null");
		} else if (triples == null) {
			throw new IllegalArgumentException("triples == null");
		}
		
		final Template<Node> nodeTemplate = this.getNodeTemplate();
		
		if (nodeTemplate != null) {
			if (context.hasBaseNode(false)) {
				throw new DuplicateBaseException(this, context, nodeTemplate);
			} else {
				try {
					final Node node = nodeTemplate.evaluate(context);
					
					if (node != null) {
						context.setBaseNode(node);
					}
				} catch (final FatalEvaluationException e) {
					throw e;
				} catch (final EvaluationException e) {
					// Do nothing...
				}
			}
		}
	}
	
	@Override
	protected void evaluate(final EvaluationProvider<?> context, final Model model) throws EvaluationException {
		// Do nothing...
	}

	public Template<Node> getNodeTemplate() {
		return nodeTemplate;
	}

	@Override
	public int getPrecedence() {
		// BaseDeclaration < PrefixDeclaration < NamedNodeDeclaration < ... < Expression < ...
		return Integer.MIN_VALUE;
	}

	public void setNodeTemplate(final Template<Node> nodeTemplate) {
		this.nodeTemplate = nodeTemplate;
	}

}
