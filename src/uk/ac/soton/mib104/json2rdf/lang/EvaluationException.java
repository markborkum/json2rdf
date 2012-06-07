package uk.ac.soton.mib104.json2rdf.lang;

public class EvaluationException extends Exception {

	private static final long serialVersionUID = -7159182488818227007L;
	
	private Evaluatable<?> evaluatable;
	
	private EvaluationProvider<?> evaluationProvider;
	
	public EvaluationException(final Evaluatable<?> evaluatable, final EvaluationProvider<?> evaluationProvider) {
		this(evaluatable, evaluationProvider, null, null);
	}
	
	public EvaluationException(final Evaluatable<?> evaluatable, final EvaluationProvider<?> evaluationProvider, final String message) {
		this(evaluatable, evaluationProvider, message, null);
	}
	
	public EvaluationException(final Evaluatable<?> evaluatable, final EvaluationProvider<?> evaluationProvider, final String message, final Throwable cause) {
		super(message, cause);
		
		this.setEvaluatable(evaluatable);
		this.setEvaluationProvider(evaluationProvider);
	}
	
	public EvaluationException(final Evaluatable<?> evaluatable, final EvaluationProvider<?> evaluationProvider, final Throwable cause) {
		this(evaluatable, evaluationProvider, null, cause);
	}

	public Evaluatable<?> getEvaluatable() {
		if (evaluatable == null) {
			throw new IllegalStateException("evaluatable == null");
		}
		
		return evaluatable;
	}

	public EvaluationProvider<?> getEvaluationProvider() {
		if (evaluationProvider == null) {
			throw new IllegalStateException("evaluationProvider == null");
		}
		
		return evaluationProvider;
	}

	private void setEvaluatable(final Evaluatable<?> evaluatable) {
		if (evaluatable == null) {
			throw new IllegalArgumentException("evaluatable == null");
		}
		
		this.evaluatable = evaluatable;
	}

	private void setEvaluationProvider(final EvaluationProvider<?> evaluationProvider) {
		if (evaluationProvider == null) {
			throw new IllegalArgumentException("evaluationProvider == null");
		}
		
		this.evaluationProvider = evaluationProvider;
	}

}
