package uk.ac.soton.mib104.json2rdf.lang;

public final class DuplicateNamedNodeException extends FatalEvaluationException {
	
	private static final long serialVersionUID = -3858594906626006164L;
	
	private String name;

	public DuplicateNamedNodeException(final Evaluatable<?> evaluatable, final EvaluationProvider<?> evaluationProvider, final String name) {
		super(evaluatable, evaluationProvider, String.format("Name is already bound in this scope: '%s'", name));
		
		this.setName(name);
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
