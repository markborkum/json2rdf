package uk.ac.soton.mib104.json2rdf.lang.expression;

import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import uk.ac.soton.mib104.json2rdf.lang.EvaluationException;
import uk.ac.soton.mib104.json2rdf.lang.EvaluationProvider;
import uk.ac.soton.mib104.json2rdf.lang.FatalEvaluationException;
import uk.ac.soton.mib104.json2rdf.lang.template.Template;

import com.hp.hpl.jena.graph.Triple;

public final class MatchBlock extends Block {
	
	private Template<?> patternTemplate;
	
	private Template<?> targetTemplate;
	
	public MatchBlock(final Block parent, final Template<?> patternTemplate, final Template<?> targetTemplate) {
		super(parent);
		
		this.setPatternTemplate(patternTemplate);
		this.setTargetTemplate(targetTemplate);
	}
	
	public MatchBlock(final Template<?> patternTemplate, final Template<?> targetTemplate) {
		this(null, patternTemplate, targetTemplate);
	}
	
	@Override
	protected void evaluate(final EvaluationProvider<?> context, final Collection<Triple> triples) throws EvaluationException {
		if (context == null) {
			throw new IllegalArgumentException("context == null");
		} else if (triples == null) {
			throw new IllegalArgumentException("triples == null");
		}
		
		final Template<?> patternTemplate = this.getPatternTemplate(), targetTemplate = this.getTargetTemplate();
		
		if ((patternTemplate != null) && (targetTemplate != null)) {
			try {
				final Object pattern = patternTemplate.evaluate(context), target = targetTemplate.evaluate(context);
				
				if ((pattern != null) && (target != null)) {
					for (final Matcher matcher = Pattern.compile(pattern.toString()).matcher(target.toString()); matcher.find(); ) {
						this.evaluateChildren(context.createChild(matcher), triples);
					}
				}
			} catch (final FatalEvaluationException e) {
				throw e;
			} catch (final EvaluationException e) {
				// Do nothing...
			}
		}
	}

	public Template<?> getPatternTemplate() {
		return patternTemplate;
	}

	public Template<?> getTargetTemplate() {
		return targetTemplate;
	}

	public void setPatternTemplate(final Template<?> patternTemplate) {
		this.patternTemplate = patternTemplate;
	}

	public void setTargetTemplate(final Template<?> targetTemplate) {
		this.targetTemplate = targetTemplate;
	}

}
