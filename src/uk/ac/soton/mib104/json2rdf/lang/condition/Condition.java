package uk.ac.soton.mib104.json2rdf.lang.condition;

import uk.ac.soton.mib104.json2rdf.lang.Evaluatable;
import uk.ac.soton.mib104.json2rdf.lang.EvaluationException;
import uk.ac.soton.mib104.json2rdf.lang.EvaluationProvider;

public abstract class Condition implements Evaluatable<Boolean> {
	
	public static final Condition FALSE = new Condition() {

		@Override
		public Boolean evaluate(final EvaluationProvider<?> context) throws EvaluationException {
			return Boolean.FALSE;
		}
		
	};
	
	public static final Condition TRUE = new Condition() {

		@Override
		public Boolean evaluate(final EvaluationProvider<?> context) throws EvaluationException {
			return Boolean.TRUE;
		}
		
	};
	
	public Condition() {
		// Do nothing...
	}
	
}
