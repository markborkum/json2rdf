package uk.ac.soton.mib104.json2rdf.lang.method;

import uk.ac.soton.mib104.json2rdf.lang.EvaluationProvider;

public final class ToLowerCaseMethod extends Method {

	public static final int getMethodArgumentsCount() {
		return 0;
	}
	
	public static final String getMethodName() {
		return "downcase";
	}
	
	@Override
	public EvaluationProvider<?> call(final EvaluationProvider<?> context, final Object[] arguments) {
		if (context == null) {
			throw new IllegalArgumentException("context == null");
		}
		
		final Object object = context.getObject();
		
		if (object instanceof String) {
			final String string = object.toString();
			
			return context.createChild(string.toLowerCase());
		} else {
			return context.createChild(null);
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
