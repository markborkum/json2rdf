package uk.ac.soton.mib104.json2rdf.lang.template;

import uk.ac.soton.mib104.json2rdf.lang.Evaluatable;
import uk.ac.soton.mib104.json2rdf.lang.EvaluationException;
import uk.ac.soton.mib104.json2rdf.lang.EvaluationProvider;
import uk.ac.soton.mib104.json2rdf.lang.NullValueException;

public abstract class Template<T> implements Evaluatable<T> {
	
	public static final <T> Template<T> toTemplate(final T object) {
		return new Template<T>() {

			@Override
			public T evaluate(final EvaluationProvider<?> context) throws EvaluationException {
				if (context == null) {
					throw new IllegalArgumentException("context == null");
				} else if (object == null) {
					throw new NullValueException(this, context);
				} else {
					return object;
				}
			}
			
		};
	}
	
	public Template() {
		// Do nothing...
	}
	
}
