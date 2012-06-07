package uk.ac.soton.mib104.json2rdf.lang.template;

import java.net.URI;

import com.hp.hpl.jena.graph.Node;

import uk.ac.soton.mib104.json2rdf.lang.EvaluationException;
import uk.ac.soton.mib104.json2rdf.lang.EvaluationProvider;
import uk.ac.soton.mib104.json2rdf.lang.InvalidBaseException;
import uk.ac.soton.mib104.json2rdf.lang.NullValueException;
import uk.ac.soton.mib104.json2rdf.util.NodeFactory;

public final class URINodeTemplate extends NodeTemplate {
	
	private Template<?> uriTemplate;
	
	public URINodeTemplate(final Template<?> uriTemplate) {
		super();
		
		this.setUriTemplate(uriTemplate);
	}

	@Override
	public Node evaluate(final EvaluationProvider<?> context) throws EvaluationException {
		if (context == null) {
			throw new IllegalArgumentException("context == null");
		}
		
		final Template<?> uriTemplate = this.getUriTemplate();
		
		if (uriTemplate != null) {
			final Object uriObject = uriTemplate.evaluate(context);
			
			if (uriObject != null) {
				try {
					final URI uri = URI.create(uriObject.toString());
					
					if (uri.isAbsolute()) {
						return NodeFactory.createURI(uri.toString());
					} else {
						final Node baseNode = context.getBaseNode();
						
						if (baseNode == null) {
							return NodeFactory.createURI(uri.toString());
						} else if (baseNode.isURI()) {
//							return NodeFactory.createURI(baseNode.getURI() + uri.toString());
							return NodeFactory.createURI(URI.create(baseNode.getURI()).resolve(uri).toString());
						} else {
							throw new InvalidBaseException(this, context, baseNode);
						}
					}
				} catch (final IllegalArgumentException e) {
					throw new EvaluationException(this, context, e);
				}
			}
		}
		
		throw new NullValueException(this, context);
	}

	public Template<?> getUriTemplate() {
		return uriTemplate;
	}

	public void setUriTemplate(final Template<?> uriTemplate) {
		this.uriTemplate = uriTemplate;
	}

}
