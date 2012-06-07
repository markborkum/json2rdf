package uk.ac.soton.mib104.json2rdf.lang.condition;

import uk.ac.soton.mib104.json2rdf.lang.EvaluationException;
import uk.ac.soton.mib104.json2rdf.lang.EvaluationProvider;
import uk.ac.soton.mib104.json2rdf.lang.FatalEvaluationException;
import uk.ac.soton.mib104.json2rdf.lang.template.Template;

public final class ConditionFactory {
	
	public static final Condition createAndCondition(final Condition arg0, final Condition arg1) {
		return new Condition() {

			@Override
			public Boolean evaluate(final EvaluationProvider<?> context) throws EvaluationException {
				if (arg0 == null) {
					return Boolean.FALSE;
				} else if (arg1 == null) {
					return Boolean.FALSE;
				} else {
					return (Boolean.TRUE.equals(arg0.evaluate(context)) && Boolean.TRUE.equals(arg1.evaluate(context))) ? Boolean.TRUE : Boolean.FALSE;
				}
			}
			
		};
	}

	public static final Condition createIsDefinedCondition(final Template<?> template) {
		return new Condition() {

			@Override
			public Boolean evaluate(final EvaluationProvider<?> context) throws EvaluationException {
				if (template == null) {
					return Boolean.FALSE;
				} else {
					try {
						return (template.evaluate(context) == null) ? Boolean.FALSE : Boolean.TRUE;
					} catch (final FatalEvaluationException e) {
						throw e;
					} catch (final EvaluationException e) {
						return Boolean.FALSE;
					}
				}
			}
			
		};
	}
	
	public static final Condition createNotCondition(final Condition arg0) {
		return new Condition() {

			@Override
			public Boolean evaluate(final EvaluationProvider<?> context) throws EvaluationException {
				if (arg0 == null) {
					return Boolean.TRUE;
				} else {
					return Boolean.TRUE.equals(arg0.evaluate(context)) ? Boolean.FALSE : Boolean.TRUE;
				}
			}
			
		};
	}
	
	public static final Condition createOrCondition(final Condition arg0, final Condition arg1) {
		return new Condition() {

			@Override
			public Boolean evaluate(final EvaluationProvider<?> context) throws EvaluationException {
				if (arg0 == null) {
					if (arg1 == null) {
						return Boolean.FALSE;
					} else {
						return Boolean.TRUE.equals(arg1.evaluate(context)) ? Boolean.TRUE : Boolean.FALSE;
					}
				} else if (arg1 == null) {
					return Boolean.TRUE.equals(arg0.evaluate(context)) ? Boolean.TRUE : Boolean.FALSE;
				} else {
					return (Boolean.TRUE.equals(arg0.evaluate(context)) || Boolean.TRUE.equals(arg1.evaluate(context))) ? Boolean.TRUE : Boolean.FALSE;
				}
			}
			
		};
	}
	
	private ConditionFactory() {
		// Do nothing...
	}
	
}
