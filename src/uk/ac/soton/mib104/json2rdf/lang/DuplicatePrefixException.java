package uk.ac.soton.mib104.json2rdf.lang;

public final class DuplicatePrefixException extends FatalEvaluationException {

	private static final long serialVersionUID = 7450135855407544955L;
	
	private String namespacePrefix;

	public DuplicatePrefixException(final Evaluatable<?> evaluatable, final EvaluationProvider<?> evaluationProvider, final String namespacePrefix) {
		super(evaluatable, evaluationProvider, String.format("Prefix is already defined in this scope: '%s'", namespacePrefix));
		
		this.setNamespacePrefix(namespacePrefix);
	}

	public String getNamespacePrefix() {
		return namespacePrefix;
	}

	private void setNamespacePrefix(final String namespacePrefix) {
		this.namespacePrefix = namespacePrefix;
	}

}
