package uk.ac.soton.mib104.json2rdf.lang.method;

import uk.ac.soton.mib104.json2rdf.lang.EvaluationProvider;

public final class IdentityMethod extends Method {

	public static final int getMethodArgumentsCount() {
		return 1;
	}
	
	public static final String getMethodName() {
		return "id";
	}
	
	@Override
	public EvaluationProvider<?> call(final EvaluationProvider<?> context, final Object[] arguments) {
		if (context == null) {
			throw new IllegalArgumentException("context == null");
		} else {
			try {
				final Object arg0 = arguments[0];
				
				return context.createChild(arg0);
			} catch (final Exception e) {
				return context.createChild(null);
			}
		}
	}
	
	@Override
	public int getArgumentsCount() {
		return getMethodArgumentsCount();
	}
	
	@Override
	public String getName() {
		return getMethodName();
	}

}
