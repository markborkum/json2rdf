package uk.ac.soton.mib104.json2rdf.lang.template;

import uk.ac.soton.mib104.json2rdf.lang.EvaluationException;
import uk.ac.soton.mib104.json2rdf.lang.EvaluationProvider;
import uk.ac.soton.mib104.json2rdf.lang.NullValueException;
import uk.ac.soton.mib104.json2rdf.util.NodeFactory;

import com.hp.hpl.jena.graph.Node;

public final class TypedLiteralNodeTemplate extends NodeTemplate {
	
	private Template<Node> datatypeTemplate;
	
	private Template<?> valueTemplate;
	
	public TypedLiteralNodeTemplate(final Template<?> valueTemplate) {
		this(valueTemplate, null);
	}

	public TypedLiteralNodeTemplate(final Template<?> valueTemplate, final Template<Node> datatypeTemplate) {
		super();
		
		this.setValueTemplate(valueTemplate);
		this.setDatatypeTemplate(datatypeTemplate);
	}

	@Override
	public Node evaluate(final EvaluationProvider<?> context) throws EvaluationException {
		if (context == null) {
			throw new IllegalArgumentException("context == null");
		}
		
		final Template<?> valueTemplate = this.getValueTemplate();
		
		if (valueTemplate != null) {
			final Object value = valueTemplate.evaluate(context);
			
			if (value != null) {
				final Template<Node> datatypeTemplate = this.getDatatypeTemplate();
				
				if (datatypeTemplate == null) {
					return NodeFactory.createTypedLiteral(value);
				} else {
					final Node datatype = datatypeTemplate.evaluate(context);
					
					if (datatype == null) {
						return NodeFactory.createTypedLiteral(value);
					} else {
						return NodeFactory.createTypedLiteral(value, datatype);
					}
				}
			}
		}
		
		throw new NullValueException(this, context);
	}

	public Template<Node> getDatatypeTemplate() {
		return datatypeTemplate;
	}

	public Template<?> getValueTemplate() {
		return valueTemplate;
	}

	public void setDatatypeTemplate(final Template<Node> datatypeTemplate) {
		this.datatypeTemplate = datatypeTemplate;
	}
	
	public void setValueTemplate(final Template<?> valueTemplate) {
		this.valueTemplate = valueTemplate;
	}

}
