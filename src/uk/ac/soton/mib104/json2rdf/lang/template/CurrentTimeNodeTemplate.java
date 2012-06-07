package uk.ac.soton.mib104.json2rdf.lang.template;

import com.hp.hpl.jena.graph.Node;

import uk.ac.soton.mib104.json2rdf.lang.EvaluationException;
import uk.ac.soton.mib104.json2rdf.lang.EvaluationProvider;

public final class CurrentTimeNodeTemplate extends NodeTemplate {
	
	public CurrentTimeNodeTemplate() {
		super();
	}

	@Override
	public Node evaluate(final EvaluationProvider<?> context) throws EvaluationException {
		if (context == null) {
			throw new IllegalArgumentException("context == null");
		}
		
		return context.getCurrentTimeNode();
	}

}
