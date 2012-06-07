package uk.ac.soton.mib104.json2rdf.lang.template;

import uk.ac.soton.mib104.json2rdf.lang.EvaluationException;
import uk.ac.soton.mib104.json2rdf.lang.EvaluationProvider;
import uk.ac.soton.mib104.json2rdf.lang.NullValueException;

import com.hp.hpl.jena.graph.Node;

public final class NamedNodeTemplate extends NodeTemplate {
	
	private Template<?> nameTemplate;
	
	public NamedNodeTemplate(final Template<?> nameTemplate) {
		super();
		
		this.setNameTemplate(nameTemplate);
	}

	@Override
	public Node evaluate(final EvaluationProvider<?> context) throws EvaluationException {
		if (context == null) {
			throw new IllegalArgumentException("context == null");
		}
		
		final Template<?> nameTemplate = this.getNameTemplate();
		
		if (nameTemplate == null) {
			throw new NullValueException(this, context);
		} else {
			final Object name = nameTemplate.evaluate(context);
			
			if (name == null) {
				throw new NullValueException(this, context);
			} else {
				return context.getNamedNode(name.toString(), true);
			}
		}
	}

	public void setNameTemplate(final Template<?> nameTemplate) {
		this.nameTemplate = nameTemplate;
	}

	public Template<?> getNameTemplate() {
		return nameTemplate;
	}

}
