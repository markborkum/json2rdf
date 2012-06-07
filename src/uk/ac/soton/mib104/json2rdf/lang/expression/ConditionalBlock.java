package uk.ac.soton.mib104.json2rdf.lang.expression;

import java.util.Collection;

import uk.ac.soton.mib104.json2rdf.lang.EvaluationException;
import uk.ac.soton.mib104.json2rdf.lang.EvaluationProvider;
import uk.ac.soton.mib104.json2rdf.lang.FatalEvaluationException;
import uk.ac.soton.mib104.json2rdf.lang.condition.Condition;

import com.hp.hpl.jena.graph.Triple;

public final class ConditionalBlock extends Block {

	private Condition condition;
	
	public ConditionalBlock(final Block parent, final Condition condition) {
		super(parent);
		
		this.setCondition(condition);
	}

	public ConditionalBlock(final Condition condition) {
		this(null, condition);
	}
	
	@Override
	protected void evaluate(final EvaluationProvider<?> context, final Collection<Triple> triples) throws EvaluationException {
		if (context == null) {
			throw new IllegalArgumentException("context == null");
		} else if (triples == null) {
			throw new IllegalArgumentException("triples == null");
		}
		
		final Condition condition = this.getCondition();
		
		if (condition != null) {
			try {
				if (Boolean.TRUE.equals(condition.evaluate(context))) {
					this.evaluateChildren(context.createChild(), triples);
				}
			} catch (final FatalEvaluationException e) {
				throw e;
			} catch (final EvaluationException e) {
				// Do nothing...
			}
		}
	}

	public Condition getCondition() {
		return condition;
	}

	public void setCondition(final Condition condition) {
		this.condition = condition;
	}
	
}
