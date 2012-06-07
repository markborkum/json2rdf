package uk.ac.soton.mib104.json2rdf.lang;

import com.hp.hpl.jena.graph.Node;

public final class InvalidNamespaceException extends FatalEvaluationException {
	
	private static final long serialVersionUID = 1243551914881829866L;

	private Node namespaceNode;
	
	private String namespacePrefix;

	public InvalidNamespaceException(final Evaluatable<?> evaluatable, final EvaluationProvider<?> evaluationProvider, final String namespacePrefix, final Node namespaceNode) {
		super(evaluatable, evaluationProvider, String.format("Namespace prefix '%s' is bound to an invalid node: %s (expecting IRI reference)", namespacePrefix, namespaceNode));
		
		this.setNamespacePrefix(namespacePrefix);
		this.setNamespaceNode(namespaceNode);
	}

	public Node getNamespaceNode() {
		return namespaceNode;
	}

	public String getNamespacePrefix() {
		return namespacePrefix;
	}
	
	private void setNamespaceNode(final Node namespaceNode) {
		this.namespaceNode = namespaceNode;
	}

	private void setNamespacePrefix(final String namespacePrefix) {
		this.namespacePrefix = namespacePrefix;
	}

}
