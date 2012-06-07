package uk.ac.soton.mib104.json2rdf.lang;

public interface Evaluatable<T> {

	public T evaluate(final EvaluationProvider<?> context) throws EvaluationException;
	
}
