package uk.ac.soton.mib104.json2rdf.lang;

public final class NamespaceNotFoundException extends FatalEvaluationException {
	
	private static final long serialVersionUID = 1243551914881829866L;

	private String namespacePrefix;

	public NamespaceNotFoundException(final Evaluatable<?> evaluatable, final EvaluationProvider<?> evaluationProvider, final String namespacePrefix) {
		super(evaluatable, evaluationProvider, String.format("Namespace prefix '%s' is unbound (expecting IRI reference)", namespacePrefix));
		
		this.setNamespacePrefix(namespacePrefix);
	}

	public String getNamespacePrefix() {
		return namespacePrefix;
	}

	private void setNamespacePrefix(final String namespacePrefix) {
		this.namespacePrefix = namespacePrefix;
	}

}
