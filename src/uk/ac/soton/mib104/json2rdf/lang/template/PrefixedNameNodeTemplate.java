package uk.ac.soton.mib104.json2rdf.lang.template;

import uk.ac.soton.mib104.json2rdf.lang.EvaluationException;
import uk.ac.soton.mib104.json2rdf.lang.EvaluationProvider;
import uk.ac.soton.mib104.json2rdf.lang.InvalidNamespaceException;
import uk.ac.soton.mib104.json2rdf.lang.NamespaceNotFoundException;
import uk.ac.soton.mib104.json2rdf.lang.NullValueException;
import uk.ac.soton.mib104.json2rdf.util.NodeFactory;
import uk.ac.soton.mib104.json2rdf.util.StringUtils;

import com.hp.hpl.jena.graph.Node;

public final class PrefixedNameNodeTemplate extends NodeTemplate {
	
	private Template<?> localNameTemplate;
	
	private Template<?> namespacePrefixTemplate;
	
	public PrefixedNameNodeTemplate(final Template<?> namespacePrefixTemplate, final Template<?> localNameTemplate) {
		super();
		
		this.setNamespacePrefixTemplate(namespacePrefixTemplate);
		this.setLocalNameTemplate(localNameTemplate);
	}

	@Override
	public Node evaluate(final EvaluationProvider<?> context) throws EvaluationException {
		if (context == null) {
			throw new IllegalArgumentException("context == null");
		}
		
		final Template<?> namespacePrefixTemplate = this.getNamespacePrefixTemplate(), localNameTemplate = this.getLocalNameTemplate();
		
		if ((namespacePrefixTemplate != null) && (localNameTemplate != null)) {
			final Object namespacePrefix = namespacePrefixTemplate.evaluate(context), localName = localNameTemplate.evaluate(context);
			
			if ((namespacePrefix != null) && (localName != null)) {
				final Node namespaceNode = context.getNamespaceNode(namespacePrefix.toString());
				
				if (namespaceNode == null) {
					throw new NamespaceNotFoundException(this, context, namespacePrefix.toString());
				} else if (namespaceNode.isURI()) {
					return NodeFactory.createURI(StringUtils.concat(namespaceNode.getURI(), localName));
				} else {
					throw new InvalidNamespaceException(this, context, namespacePrefix.toString(), namespaceNode);
				}
			}
		}
		
		throw new NullValueException(this, context);
	}

	public Template<?> getLocalNameTemplate() {
		return localNameTemplate;
	}

	public Template<?> getNamespacePrefixTemplate() {
		return namespacePrefixTemplate;
	}

	public void setLocalNameTemplate(final Template<?> localNameTemplate) {
		this.localNameTemplate = localNameTemplate;
	}

	public void setNamespacePrefixTemplate(final Template<?> namespacePrefixTemplate) {
		this.namespacePrefixTemplate = namespacePrefixTemplate;
	}

}
