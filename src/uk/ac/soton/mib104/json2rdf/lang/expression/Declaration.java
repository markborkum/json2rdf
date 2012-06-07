package uk.ac.soton.mib104.json2rdf.lang.expression;

import uk.ac.soton.mib104.json2rdf.lang.EvaluationException;
import uk.ac.soton.mib104.json2rdf.lang.EvaluationProvider;

import com.hp.hpl.jena.rdf.model.Model;

public abstract class Declaration extends Expression {

	public Declaration() {
		this(null);
	}

	public Declaration(final Block parent) {
		super(parent);
	}

	protected abstract void evaluate(final EvaluationProvider<?> context, final Model model) throws EvaluationException;

}
