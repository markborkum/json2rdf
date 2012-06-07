package uk.ac.soton.mib104.json2rdf.lang;

public final class NullValueException extends EvaluationException {

	private static final long serialVersionUID = -90262586808916318L;

	public NullValueException(final Evaluatable<?> evaluatable, final EvaluationProvider<?> evaluationProvider) {
		this(evaluatable, evaluationProvider, null, null);
	}

	public NullValueException(final Evaluatable<?> evaluatable, final EvaluationProvider<?> evaluationProvider, final String message) {
		this(evaluatable, evaluationProvider, message, null);
	}
	
	public NullValueException(final Evaluatable<?> evaluatable, final EvaluationProvider<?> evaluationProvider, final String message, final Throwable cause) {
		super(evaluatable, evaluationProvider, message, cause);
	}
	
	public NullValueException(final Evaluatable<?> evaluatable, final EvaluationProvider<?> evaluationProvider, final Throwable cause) {
		this(evaluatable, evaluationProvider, null, cause);
	}

}
