package uk.ac.soton.mib104.json2rdf.lang.template;

import uk.ac.soton.mib104.json2rdf.lang.EvaluationException;
import uk.ac.soton.mib104.json2rdf.lang.EvaluationProvider;
import uk.ac.soton.mib104.json2rdf.lang.NullValueException;

import com.hp.hpl.jena.graph.Node;

public final class AnonNodeTemplate extends NodeTemplate {
	
	private Template<?> idTemplate;
	
	public AnonNodeTemplate() {
		this(null);
	}
	
	public AnonNodeTemplate(final Template<?> idTemplate) {
		super();
		
		this.setIdTemplate(idTemplate);
	}

	@Override
	public Node evaluate(final EvaluationProvider<?> context) throws EvaluationException {
		if (context == null) {
			throw new IllegalArgumentException("context == null");
		}
		
		final Template<?> idTemplate = this.getIdTemplate();
		
		if (idTemplate == null) {
			return context.getNamedNode(String.format("@%d", this.hashCode()), true);
		} else {
			final Object id = idTemplate.evaluate(context);
			
			if (id == null) {
				throw new NullValueException(this, context);
			} else {
				return context.getNamedNode(String.format("&%s", id.toString()), true);
			}
		}
	}

	public Template<?> getIdTemplate() {
		return idTemplate;
	}

	public void setIdTemplate(final Template<?> idTemplate) {
		this.idTemplate = idTemplate;
	}

}
