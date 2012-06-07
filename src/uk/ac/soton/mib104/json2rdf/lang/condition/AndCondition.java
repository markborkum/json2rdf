package uk.ac.soton.mib104.json2rdf.lang.condition;

import uk.ac.soton.mib104.json2rdf.lang.EvaluationException;
import uk.ac.soton.mib104.json2rdf.lang.EvaluationProvider;

public final class AndCondition extends BinaryCondition {
	
	public AndCondition(final Condition arg0, final Condition arg1) {
		super(arg0, arg1);
	}

	@Override
	public Boolean evaluate(final EvaluationProvider<?> context) throws EvaluationException {
		final Condition arg0 = this.getArg0(), arg1 = this.getArg1();
		
		if (arg0 == null) {
			return Boolean.FALSE;
		} else if (arg1 == null) {
			return Boolean.FALSE;
		} else {
			return (Boolean.TRUE.equals(arg0.evaluate(context)) && Boolean.TRUE.equals(arg1.evaluate(context))) ? Boolean.TRUE : Boolean.FALSE;
		}
	}

}
