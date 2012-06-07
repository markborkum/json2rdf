package uk.ac.soton.mib104.json2rdf.lang.template;

import uk.ac.soton.mib104.json2rdf.lang.EvaluationException;
import uk.ac.soton.mib104.json2rdf.lang.EvaluationProvider;
import uk.ac.soton.mib104.json2rdf.lang.FatalEvaluationException;
import uk.ac.soton.mib104.json2rdf.lang.FatalInterpolationException;
import uk.ac.soton.mib104.json2rdf.lang.InterpolationException;
import uk.ac.soton.mib104.json2rdf.lang.NullValueException;

public final class InterpolatedStringTemplate extends Template<String> {
	
	private Template<?> stringTemplate;

	public InterpolatedStringTemplate(final Template<?> stringTemplate) {
		super();
		
		this.setStringTemplate(stringTemplate);
	}

	@Override
	public String evaluate(final EvaluationProvider<?> context) throws EvaluationException {
		if (context == null) {
			throw new IllegalArgumentException("context == null");
		}
		
		final Template<?> stringTemplate = this.getStringTemplate();
		
		if (stringTemplate == null) {
			throw new NullValueException(this, context);
		} else {
			try {
				final Object string = stringTemplate.evaluate(context);
				
				if (string == null) {
					throw new NullValueException(this, context);
				} else {
					return context.interpolate(string.toString());
				}
			} catch (final FatalInterpolationException e) {
				throw new FatalEvaluationException(this, context, e);
			} catch (final InterpolationException e) {
				throw new EvaluationException(this, context, e);
			}
		}
	}

	public Template<?> getStringTemplate() {
		return stringTemplate;
	}

	public void setStringTemplate(final Template<?> stringTemplate) {
		this.stringTemplate = stringTemplate;
	}

}
