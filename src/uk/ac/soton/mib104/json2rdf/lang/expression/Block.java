package uk.ac.soton.mib104.json2rdf.lang.expression;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import uk.ac.soton.mib104.json2rdf.lang.EvaluationException;
import uk.ac.soton.mib104.json2rdf.lang.EvaluationProvider;

import com.hp.hpl.jena.graph.Triple;
import com.hp.hpl.jena.rdf.model.Model;

public class Block extends Expression implements Iterable<Expression> {
	
	private List<Expression> children = new LinkedList<Expression>();

	public Block() {
		this(null);
	}
	
	public Block(final Block parent) {
		super(parent);
	}
	
	protected boolean add(final Expression child) {
		final List<Expression> children = this.getChildren();
		
		return children.add(child);
	}
	
	@Override
	protected void evaluate(final EvaluationProvider<?> context, final Collection<Triple> triples) throws EvaluationException {
		this.evaluateChildren(context, triples);
	}

	protected void evaluateChildren(final EvaluationProvider<?> context, final Collection<Triple> triples) throws EvaluationException {
		if (triples == null) {
			throw new IllegalArgumentException("triples == null");
		}
		
		for (final Expression child : this) {
			if (child != null) {
				triples.addAll(child.evaluate(context));
			} 
		}
	}
	
	protected void evaluateChildren(final Iterable<EvaluationProvider<?>> contexts, final Collection<Triple> triples) throws EvaluationException {
		if (triples == null) {
			throw new IllegalArgumentException("triples == null");
		}
		
		for (final Expression child : this) {
			for (final EvaluationProvider<?> context : contexts) {
				if (child != null) {
					triples.addAll(child.evaluate(context));
				}
			}
		}
	}
	
	private List<Expression> getChildren() {
		if (children == null) {
			throw new IllegalStateException("children == null");
		}
		
		return children;
	}
	
	public boolean isEmpty() {
		final List<Expression> children = this.getChildren();
		
		return children.isEmpty();
	}

	@Override
	public Iterator<Expression> iterator() {
		final List<Expression> children = new LinkedList<Expression>(this.getChildren());
		
		Collections.sort(children);
		
		return children.iterator();
	}
	
	protected boolean remove(final Expression child) {
		final List<Expression> children = this.getChildren();
		
		return children.remove(child);
	}

	public int size() {
		final List<Expression> children = this.getChildren();
		
		return children.size();
	}

	@Override
	public Model toModel(final EvaluationProvider<?> context) throws EvaluationException {
		final Model model = super.toModel(context);
		
		for (final Expression child : this) {
			if (child instanceof Declaration) {
				((Declaration) child).evaluate(context, model);
			}
		}
		
		return model;
	}
	
}
