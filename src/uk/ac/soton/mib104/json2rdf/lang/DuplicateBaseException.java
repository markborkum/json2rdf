package uk.ac.soton.mib104.json2rdf.lang;

import com.hp.hpl.jena.graph.Node;

import uk.ac.soton.mib104.json2rdf.lang.template.Template;

public final class DuplicateBaseException extends FatalEvaluationException {

	private static final long serialVersionUID = 9166400091381116071L;
	
	private Template<Node> nodeTemplate;

	public DuplicateBaseException(final Evaluatable<?> evaluatable, final EvaluationProvider<?> evaluationProvider, final Template<Node> nodeTemplate) {
		super(evaluatable, evaluationProvider, String.format("Base is already defined in this scope. Attempted replacement: %s", nodeTemplate));
		
		this.setNodeTemplate(nodeTemplate);
	}
	
	private void setNodeTemplate(final Template<Node> nodeTemplate) {
		this.nodeTemplate = nodeTemplate;
	}

	public Template<Node> getNodeTemplate() {
		return nodeTemplate;
	}

}
