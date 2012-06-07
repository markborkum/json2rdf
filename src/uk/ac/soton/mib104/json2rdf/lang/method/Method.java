package uk.ac.soton.mib104.json2rdf.lang.method;

import uk.ac.soton.mib104.json2rdf.lang.EvaluationProvider;
import uk.ac.soton.mib104.json2rdf.util.BinaryFunction;

public abstract class Method extends BinaryFunction<EvaluationProvider<?>, EvaluationProvider<?>, Object[]> {
	
	public static int getMethodArgumentsCount() {
		throw new UnsupportedOperationException();
	}
	
	public static String getMethodName() {
		throw new UnsupportedOperationException();
	}
	
	public Method() {
		// Do nothing...
	}
	
	public int getArgumentsCount() {
		return getMethodArgumentsCount();
	}
	
	public String getName() {
		return getMethodName();
	}
	
}
