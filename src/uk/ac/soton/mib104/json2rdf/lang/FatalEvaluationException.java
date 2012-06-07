package uk.ac.soton.mib104.json2rdf.lang;

public class FatalEvaluationException extends EvaluationException {

	private static final long serialVersionUID = -7634712652624102556L;

	public FatalEvaluationException(final Evaluatable<?> evaluatable, final EvaluationProvider<?> evaluationProvider) {
		super(evaluatable, evaluationProvider);
	}

	public FatalEvaluationException(final Evaluatable<?> evaluatable, final EvaluationProvider<?> evaluationProvider, final String message) {
		super(evaluatable, evaluationProvider, message);
	}
	
	public FatalEvaluationException(final Evaluatable<?> evaluatable, final EvaluationProvider<?> evaluationProvider, final String message, final Throwable cause) {
		super(evaluatable, evaluationProvider, message, cause);
	}
	
	public FatalEvaluationException(final Evaluatable<?> evaluatable, final EvaluationProvider<?> evaluationProvider, final Throwable cause) {
		super(evaluatable, evaluationProvider, cause);
	}

}
