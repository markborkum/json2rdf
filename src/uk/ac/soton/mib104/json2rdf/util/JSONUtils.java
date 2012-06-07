package uk.ac.soton.mib104.json2rdf.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.regex.Matcher;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.hp.hpl.jena.datatypes.xsd.XSDDateTime;

import uk.ac.soton.mib104.json2rdf.lang.EvaluationProvider;
import uk.ac.soton.mib104.json2rdf.lang.context.ObjectContext;

public final class JSONUtils {
	
	public static final boolean looksLikeJSON(final String string) {
		if (StringUtils.isBlank(string)) {
			return false;
		} else {
			final String trimmedString = string.trim();
			
			if (trimmedString.startsWith("{") && trimmedString.endsWith("}")) {
				return true;
			} else if (trimmedString.startsWith("[") && trimmedString.endsWith("]")) {
				return true;
			} else if ((trimmedString.startsWith("\"") && trimmedString.endsWith("\"")) || (trimmedString.startsWith("'") && trimmedString.endsWith("'"))) {
				return true;
			} else {
				final Object object = JSONObject.stringToValue(trimmedString);
				
				if ((object != null) && !(object instanceof String)) {
					return true;
				} else {
					return false;
				}
			}
		}
	}
	
	public static final EvaluationProvider<?> parseJSON(final InputStream inputStream) throws JSONException, IOException {
		return parseJSON(InputStreamUtils.readAsUTF8(inputStream).toString());
	}
	
	public static final EvaluationProvider<?> parseJSON(final String string) throws JSONException {
		if (StringUtils.isBlank(string)) {
			return new ObjectContext<Void>();
		} else {
			final String trimmedString = string.trim();
			
			if (trimmedString.startsWith("{") && trimmedString.endsWith("}")) {
				return new ObjectContext<JSONObject>(new JSONObject(trimmedString));
			} else if (trimmedString.startsWith("[") && trimmedString.endsWith("]")) {
				return new ObjectContext<JSONArray>(new JSONArray(trimmedString));
			} else if ((trimmedString.startsWith("\"") && trimmedString.endsWith("\"")) || (trimmedString.startsWith("'") && trimmedString.endsWith("'"))) {
				final String newString = trimmedString.substring(1, trimmedString.length() - 1);
				
				return new ObjectContext<String>(newString);
			} else {
				final Object object = JSONObject.stringToValue(trimmedString);
				
				if ((object != null) && !(object instanceof String)) {
					return new ObjectContext<Object>(object);
				} else {
					throw new JSONException(JSONObject.quote(trimmedString) + " is not a JSONObject");
				}
			}
		}
	}
	
	public static final JSONArray toJSONArray(final Matcher matcher) throws JSONException {
		if (matcher == null) {
			return null;
		} else {
			final String[] captureGroups = new String[matcher.groupCount() + 1];
			
			captureGroups[0] = matcher.group();
			
			for (int index = 1; index <= matcher.groupCount(); index++) {
				captureGroups[index] = matcher.group(index);
			}
			
			return new JSONArray(captureGroups);
		}
	}
	
	public static final String toString(final Object object) {
		if (object == null) {
			return StringUtils.emptyString;
		} else if (object instanceof String) {
			return '"' + JSONObject.quote(object.toString()) + '"';
		} else if (object instanceof XSDDateTime) {
			return '"' + JSONObject.quote(object.toString()) + '"';
		} else if (object instanceof Calendar) {
			return '"' + JSONObject.quote(new XSDDateTime((Calendar) object).toString()) + '"';
		} else {
			return object.toString();
		}
	}
	
	private JSONUtils() {
		// Do nothing...
	}
	
}
