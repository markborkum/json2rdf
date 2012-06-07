package uk.ac.soton.mib104.json2rdf.lang.method;

import org.json.JSONArray;
import org.json.JSONObject;

import uk.ac.soton.mib104.json2rdf.lang.EvaluationProvider;

public final class LengthMethod extends Method {
	
	public static final int getMethodArgumentsCount() {
		return 0;
	}
	
	public static final String getMethodName() {
		return "length";
	}

	@Override
	public EvaluationProvider<?> call(final EvaluationProvider<?> context, final Object[] arguments) {
		if (context == null) {
			throw new IllegalArgumentException("context == null");
		}
		
		final Object object = context.getObject();
		
		if (object == null) {
			return context.createChild(null);
		} else if (object instanceof JSONArray) {
			final int length = ((JSONArray) object).length();
			
			return context.createChild(length);
		} else if (object instanceof JSONObject) {
			final int length = ((JSONObject) object).length();
			
			return context.createChild(length);
		} if (object instanceof String) {
			final String string = object.toString();
			
			final int length = string.length();
			
			return context.createChild(length);
		} else {
			return context.createChild(1);
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
