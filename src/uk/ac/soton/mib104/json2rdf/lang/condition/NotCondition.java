package uk.ac.soton.mib104.json2rdf.lang.condition;

import uk.ac.soton.mib104.json2rdf.lang.EvaluationException;
import uk.ac.soton.mib104.json2rdf.lang.EvaluationProvider;

public final class NotCondition extends UnaryCondition {
	
	public NotCondition(final Condition arg0) {
		super(arg0);
	}

	@Override
	public Boolean evaluate(final EvaluationProvider<?> context) throws EvaluationException {
		final Condition arg0 = this.getArg0();
		
		if (arg0 == null) {
			return Boolean.TRUE;
		} else {
			return Boolean.TRUE.equals(arg0.evaluate(context)) ? Boolean.FALSE : Boolean.TRUE;
		}
	}

}
