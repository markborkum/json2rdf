package uk.ac.soton.mib104.json2rdf.lang.method;

import uk.ac.soton.mib104.json2rdf.lang.EvaluationProvider;
import uk.ac.soton.mib104.json2rdf.util.JSONUtils;

public final class AsJSONMethod extends Method {
	
	public static final int getMethodArgumentsCount() {
		return 0;
	}
	
	public static final String getMethodName() {
		return "asJSON";
	}

	@Override
	public EvaluationProvider<?> call(final EvaluationProvider<?> context, final Object[] arguments) {
		return context.createChild(JSONUtils.toString(context.getObject()));
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
