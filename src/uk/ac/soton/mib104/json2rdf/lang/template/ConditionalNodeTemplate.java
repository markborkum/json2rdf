package uk.ac.soton.mib104.json2rdf.lang.template;

import uk.ac.soton.mib104.json2rdf.lang.EvaluationException;
import uk.ac.soton.mib104.json2rdf.lang.EvaluationProvider;
import uk.ac.soton.mib104.json2rdf.lang.condition.Condition;

import com.hp.hpl.jena.graph.Node;

public final class ConditionalNodeTemplate extends NodeTemplate {
	
	private Condition condition;
	
	private Template<Node> falseNodeTemplate;

	private Template<Node> trueNodeTemplate;

	public ConditionalNodeTemplate(final Condition condition, final Template<Node> trueNodeTemplate, final Template<Node> falseNodeTemplate) {
		super();
		
		this.setCondition(condition);
		this.setTrueNodeTemplate(trueNodeTemplate);
		this.setFalseNodeTemplate(falseNodeTemplate);
	}

	@Override
	public Node evaluate(final EvaluationProvider<?> context) throws EvaluationException {
		if (context == null) {
			throw new IllegalArgumentException("context == null");
		}
		
		final Condition condition = this.getCondition();
		
		final Template<Node> trueNodeTemplate = this.getTrueNodeTemplate(), falseNodeTemplate = this.getFalseNodeTemplate();
		
		if (condition == null) {
			if (falseNodeTemplate == null) {
				return null;
			} else {
				return falseNodeTemplate.evaluate(context);
			}
		} else if (Boolean.TRUE.equals(condition.evaluate(context))) {
			if (trueNodeTemplate == null) {
				return null;
			} else {
				return trueNodeTemplate.evaluate(context);
			}
		} else {
			if (falseNodeTemplate == null) {
				return null;
			} else {
				return falseNodeTemplate.evaluate(context);
			}
		}
	}

	public Condition getCondition() {
		return condition;
	}

	public Template<Node> getFalseNodeTemplate() {
		return falseNodeTemplate;
	}

	public Template<Node> getTrueNodeTemplate() {
		return trueNodeTemplate;
	}
	
	public void setCondition(final Condition condition) {
		this.condition = condition;
	}

	public void setFalseNodeTemplate(final Template<Node> falseNodeTemplate) {
		this.falseNodeTemplate = falseNodeTemplate;
	}

	public void setTrueNodeTemplate(final Template<Node> trueNodeTemplate) {
		this.trueNodeTemplate = trueNodeTemplate;
	}

}
