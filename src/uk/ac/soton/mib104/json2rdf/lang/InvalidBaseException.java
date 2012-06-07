package uk.ac.soton.mib104.json2rdf.lang;

import com.hp.hpl.jena.graph.Node;

public final class InvalidBaseException extends FatalEvaluationException {
	
	private static final long serialVersionUID = 1243551914881829866L;

	private Node baseNode;

	public InvalidBaseException(final Evaluatable<?> evaluatable, final EvaluationProvider<?> evaluationProvider, final Node baseNode) {
		super(evaluatable, evaluationProvider, String.format("Base is bound to an invalid node: %s (expecting IRI reference)", baseNode));
		
		this.setBaseNode(baseNode);
	}

	public Node getBaseNode() {
		return baseNode;
	}
	
	private void setBaseNode(final Node baseNode) {
		this.baseNode = baseNode;
	}

}
