package uk.ac.soton.mib104.json2rdf.lang.method;

import uk.ac.soton.mib104.json2rdf.lang.EvaluationProvider;

public final class ThisMethod extends Method {
	
	public static final int getMethodArgumentsCount() {
		return 0;
	}
	
	public static final String getMethodName() {
		return "this";
	}

	@Override
	public EvaluationProvider<?> call(final EvaluationProvider<?> context, final Object[] arguments) {
		return context;
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
