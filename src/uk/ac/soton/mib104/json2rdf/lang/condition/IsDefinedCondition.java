package uk.ac.soton.mib104.json2rdf.lang.condition;

import uk.ac.soton.mib104.json2rdf.lang.EvaluationException;
import uk.ac.soton.mib104.json2rdf.lang.EvaluationProvider;
import uk.ac.soton.mib104.json2rdf.lang.FatalEvaluationException;
import uk.ac.soton.mib104.json2rdf.lang.template.Template;

public final class IsDefinedCondition extends Condition {
	
	private Template<?> template;

	public IsDefinedCondition(final Template<?> template) {
		super();
		
		this.setTemplate(template);
	}

	@Override
	public Boolean evaluate(final EvaluationProvider<?> context) throws EvaluationException {
		final Template<?> template = this.getTemplate();
		
		if (template == null) {
			return Boolean.FALSE;
		} else {
			try {
				return (template.evaluate(context) == null) ? Boolean.FALSE : Boolean.TRUE;
			} catch (final FatalEvaluationException e) {
				throw e;
			} catch (final EvaluationException e) {
				return Boolean.FALSE;
			}
		}
	}

	public Template<?> getTemplate() {
		return template;
	}

	public void setTemplate(final Template<?> template) {
		this.template = template;
	}

}
