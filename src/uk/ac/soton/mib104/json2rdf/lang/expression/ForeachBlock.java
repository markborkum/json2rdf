package uk.ac.soton.mib104.json2rdf.lang.expression;

import java.util.Collection;

import uk.ac.soton.mib104.json2rdf.lang.EvaluationException;
import uk.ac.soton.mib104.json2rdf.lang.EvaluationProvider;
import uk.ac.soton.mib104.json2rdf.lang.FatalEvaluationException;
import uk.ac.soton.mib104.json2rdf.lang.template.Template;

import com.hp.hpl.jena.graph.Triple;

public final class ForeachBlock extends Block {
	
	private Template<?> template;

	public ForeachBlock(final Block parent, final Template<?> template) {
		super(parent);
		
		this.setTemplate(template);
	}

	public ForeachBlock(final Template<?> template) {
		this(null, template);
	}

	@Override
	protected void evaluate(final EvaluationProvider<?> context, final Collection<Triple> triples) throws EvaluationException {
		if (context == null) {
			throw new IllegalArgumentException("context == null");
		} else if (triples == null) {
			throw new IllegalArgumentException("triples == null");
		}

		final Template<?> template = this.getTemplate();
		
		if (template != null) {
			try {
				this.evaluateChildren(context.createChildren(template.evaluate(context)), triples);
			} catch (final FatalEvaluationException e) {
				throw e;
			} catch (final EvaluationException e) {
				// Do nothing...
			}
		}
	}

	public Template<?> getTemplate() {
		return template;
	}

	public void setTemplate(final Template<?> template) {
		this.template = template;
	}

}
