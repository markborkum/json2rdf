package uk.ac.soton.mib104.json2rdf.lang.method;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.hp.hpl.jena.datatypes.xsd.XSDDateTime;

import uk.ac.soton.mib104.json2rdf.lang.EvaluationProvider;

public final class ParseXSDDateTimeMethod extends Method {
	
	public static final int getMethodArgumentsCount() {
		return 1;
	}
	
	public static final String getMethodName() {
		return "parseXSDDateTime";
	}

	@Override
	public EvaluationProvider<?> call(final EvaluationProvider<?> context, final Object[] arguments) {
		if (context == null) {
			throw new IllegalArgumentException("context == null");
		}
		
		final Object object = context.getObject();
		
		if (object instanceof String) {
			final String string = object.toString();
			
			try {
				final String arg0 = (String) arguments[0];
			
				final Date date = new SimpleDateFormat(arg0).parse(string);
			 
				final Calendar calendar = Calendar.getInstance();
			
				calendar.setTime(date);
			
				return context.createChild(new XSDDateTime(calendar));
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
