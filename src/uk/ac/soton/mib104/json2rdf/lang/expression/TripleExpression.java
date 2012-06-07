package uk.ac.soton.mib104.json2rdf.lang.expression;

import java.util.Collection;

import com.hp.hpl.jena.graph.Node;
import com.hp.hpl.jena.graph.Triple;

import uk.ac.soton.mib104.json2rdf.lang.EvaluationException;
import uk.ac.soton.mib104.json2rdf.lang.EvaluationProvider;
import uk.ac.soton.mib104.json2rdf.lang.FatalEvaluationException;
import uk.ac.soton.mib104.json2rdf.lang.template.Template;

public final class TripleExpression extends Expression {

	private Template<Node> objectTemplate;
	
	private Template<Node> predicateTemplate;
	
	private Template<Node> subjectTemplate;
	
	public TripleExpression(final Template<Node> subjectTemplate, final Template<Node> predicateTemplate, final Template<Node> objectTemplate) {
		this(null, subjectTemplate, predicateTemplate, objectTemplate);
	}

	public TripleExpression(final Block parent, final Template<Node> subjectTemplate, final Template<Node> predicateTemplate, final Template<Node> objectTemplate) {
		super(parent);
		
		this.setSubjectTemplate(subjectTemplate);
		this.setPredicateTemplate(predicateTemplate);
		this.setObjectTemplate(objectTemplate);
	}

	@Override
	protected void evaluate(final EvaluationProvider<?> context, final Collection<Triple> triples) throws EvaluationException {
		if (context == null) {
			throw new IllegalArgumentException("context == null");
		} else if (triples == null) {
			throw new IllegalArgumentException("triples == null");
		}
		
		final Template<Node> subjectTemplate = this.getSubjectTemplate(), predicateTemplate = this.getPredicateTemplate(), objectTemplate = this.getObjectTemplate();
		
		if ((subjectTemplate != null) && (predicateTemplate != null) && (objectTemplate != null)) {
			try {
				final Node subject = subjectTemplate.evaluate(context), predicate = predicateTemplate.evaluate(context), object = objectTemplate.evaluate(context);
				
				if ((subject != null) && (predicate != null) && (object != null)) {
					triples.add(new Triple(subject, predicate, object));	
				}
			} catch (final FatalEvaluationException e) {
				throw e;
			} catch (final EvaluationException e) {
				// Do nothing...
			}
		}
	}

	public Template<Node> getObjectTemplate() {
		return objectTemplate;
	}

	public Template<Node> getPredicateTemplate() {
		return predicateTemplate;
	}

	public Template<Node> getSubjectTemplate() {
		return subjectTemplate;
	}

	public void setObjectTemplate(final Template<Node> objectTemplate) {
		this.objectTemplate = objectTemplate;
	}

	public void setPredicateTemplate(final Template<Node> predicateTemplate) {
		this.predicateTemplate = predicateTemplate;
	}

	public void setSubjectTemplate(final Template<Node> subjectTemplate) {
		this.subjectTemplate = subjectTemplate;
	}

}
