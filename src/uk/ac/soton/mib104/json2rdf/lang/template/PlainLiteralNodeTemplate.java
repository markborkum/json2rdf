package uk.ac.soton.mib104.json2rdf.lang.template;

import com.hp.hpl.jena.graph.Node;

import uk.ac.soton.mib104.json2rdf.lang.EvaluationException;
import uk.ac.soton.mib104.json2rdf.lang.EvaluationProvider;
import uk.ac.soton.mib104.json2rdf.lang.NullValueException;
import uk.ac.soton.mib104.json2rdf.util.NodeFactory;

public final class PlainLiteralNodeTemplate extends NodeTemplate {
	
	private static final boolean isXML = false;

	private Template<?> languageTemplate;
	
	private Template<?> valueTemplate;
	
	public PlainLiteralNodeTemplate(final Template<?> valueTemplate) {
		this(valueTemplate, null);
	}
	
	public PlainLiteralNodeTemplate(final Template<?> valueTemplate, final Template<?> languageTemplate) {
		super();
		
		this.setTemplateTemplate(valueTemplate);
		this.setLanguageTemplate(languageTemplate);
	}

	@Override
	public Node evaluate(final EvaluationProvider<?> context) throws EvaluationException {
		if (context == null) {
			throw new IllegalArgumentException("context == null");
		}
		
		final Template<?> valueTemplate = this.getTemplateTemplate(), languageTemplate = this.getLanguageTemplate();
		
		if (valueTemplate != null) {
			final Object value = valueTemplate.evaluate(context);
			
			if (value != null) {
				if (languageTemplate == null) {
					return NodeFactory.createPlainLiteral(value.toString(), null, isXML);
				} else {
					final Object language = languageTemplate.evaluate(context);
					
					if (language == null) {
						return NodeFactory.createPlainLiteral(value.toString(), null, isXML);
					} else {
						return NodeFactory.createPlainLiteral(value.toString(), language.toString(), isXML);
					}
				}
			}
		}
		
		throw new NullValueException(this, context);
	}

	public Template<?> getLanguageTemplate() {
		return languageTemplate;
	}

	public Template<?> getTemplateTemplate() {
		return valueTemplate;
	}

	public void setLanguageTemplate(final Template<?> languageTemplate) {
		this.languageTemplate = languageTemplate;
	}
	
	public void setTemplateTemplate(final Template<?> valueTemplate) {
		this.valueTemplate = valueTemplate;
	}

}
