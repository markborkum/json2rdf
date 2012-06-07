package uk.ac.soton.mib104.json2rdf.lang.method;

import org.json.JSONException;

import uk.ac.soton.mib104.json2rdf.lang.EvaluationProvider;
import uk.ac.soton.mib104.json2rdf.util.JSONUtils;

public final class ParseJSONMethod extends Method {
	
	public static final int getMethodArgumentsCount() {
		return 0;
	}
	
	public static final String getMethodName() {
		return "parseJSON";
	}
	
	@Override
	public EvaluationProvider<?> call(final EvaluationProvider<?> context, final Object[] arguments) {
		final Object object = context.getObject();
		
		if (object == null) {
			return context.createChild(null);
		} else if (object instanceof String) {
			try {
				final EvaluationProvider<?> childContext = JSONUtils.parseJSON(object.toString());
				
				childContext.setParent(context);
				
				return childContext;
			} catch (final JSONException e) {
				return context.createChild(null);
			}
		} else {
			return context.createChild(object);
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
