package uk.ac.soton.mib104.json2rdf.lang.method;

import com.hp.hpl.jena.datatypes.xsd.XSDDateTime;

import uk.ac.soton.mib104.json2rdf.lang.EvaluationProvider;

public final class CurrentTimeMethod extends Method {

	public static final int getMethodArgumentsCount() {
		return 0;
	}
	
	public static final String getMethodName() {
		return "now";
	}
	
	public CurrentTimeMethod() {
		super();
	}

	@Override
	public EvaluationProvider<?> call(final EvaluationProvider<?> context, final Object[] arguments) {
		return context.createChild(new XSDDateTime(context.getCurrentTime()));
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
