package uk.ac.soton.mib104.json2rdf.lang.method;

import org.json.JSONArray;
import org.json.JSONObject;

import uk.ac.soton.mib104.json2rdf.lang.EvaluationProvider;

public final class ChildMethod extends Method {
	
	public static final int getMethodArgumentsCount() {
		return 1;
	}
	
	public static final String getMethodName() {
		return "child";
	}

	private static final EvaluationProvider<?> pure(final EvaluationProvider<?> context, final Object object) {
		if (context == null) {
			throw new IllegalArgumentException("context == null");
		} else if (object == null) {
			return context.createChild(null);
		} else if (JSONObject.NULL.equals(object)) {
			return context.createChild(null);
		} else {
			return context.createChild(object);
		}
	}
	
	@Override
	public EvaluationProvider<?> call(final EvaluationProvider<?> context, final Object[] arguments) {
		final Object object = context.getObject();
		
		if (object instanceof JSONArray) {
			try {
				final Integer arg0 = (Integer) arguments[0];
				
				if (arg0 == null) {
					return context.createChild(null);
				} else {
					final JSONArray castObject = (JSONArray) object;
					
					final int index = arg0.intValue();
					
					if (index < 0) {
						return pure(context, castObject.get(castObject.length() + index));
					} else {
						return pure(context, castObject.get(index));
					}
				}
			} catch (final Exception e) {
				return context.createChild(null);
			}
		} else if (object instanceof JSONObject) {
			try {
				final String arg0 = (String) arguments[0];
				
				if (arg0 == null) {
					return context.createChild(null);
				} else {
					return pure(context, ((JSONObject) object).get(arg0));
				}
			} catch (final Exception e) {
				return context.createChild(null);
			}
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
