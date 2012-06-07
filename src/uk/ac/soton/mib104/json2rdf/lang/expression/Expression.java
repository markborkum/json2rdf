package uk.ac.soton.mib104.json2rdf.lang.expression;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
import java.util.LinkedList;

import com.hp.hpl.jena.graph.Graph;
import com.hp.hpl.jena.graph.Triple;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.RDFWriter;
import com.hp.hpl.jena.shared.UnknownPropertyException;
import com.hp.hpl.jena.util.FileUtils;

import uk.ac.soton.mib104.json2rdf.lang.Evaluatable;
import uk.ac.soton.mib104.json2rdf.lang.EvaluationException;
import uk.ac.soton.mib104.json2rdf.lang.EvaluationProvider;
import uk.ac.soton.mib104.json2rdf.util.StringUtils;

public abstract class Expression implements Comparable<Expression>, Evaluatable<Collection<Triple>> {
	
	private Block parent;
	
	public Expression() {
		this(null);
	}
	
	public Expression(final Block parent) {
		this.setParent(parent);
	}
	
	@Override
	public int compareTo(final Expression other) {
		if (other == null) {
			return 1;
		} else {
			final int precedence = this.getPrecedence(), otherPrecedence = other.getPrecedence();
			
			if (precedence > otherPrecedence) {
				return 1;
			} else if (precedence < otherPrecedence) {
				return -1;
			} else {
				return 0;
			}
		}
	}
	
	@Override
	public Collection<Triple> evaluate(final EvaluationProvider<?> context) throws EvaluationException {
		final Collection<Triple> triples = new LinkedList<Triple>();
		
		this.evaluate(context, triples);
		
		return triples;
	}

	protected abstract void evaluate(final EvaluationProvider<?> context, final Collection<Triple> triples) throws EvaluationException;
	
	public Block getParent() {
		return parent;
	}
	
	public int getPrecedence() {
		// BaseDeclaration < PrefixDeclaration < NamedNodeDeclaration < ... < Expression < ...
		return 0;
	}
	
	public Expression getRoot() {
		final Block parent = this.getParent();
		
		if (parent == null) {
			return this;
		} else {
			return parent.getRoot();
		}
	}

	public boolean isRoot() {
		final Block parent = this.getParent();
		
		return (parent == null);
	}
	
	public void setParent(final Block parent) {
		final Block currentParent = this.getParent();
		
		if (currentParent != null) {
			currentParent.remove(this);
		}
		
		this.parent = parent;
		
		if (parent != null) {
			parent.add(this);
		}
		
		return;
	}
	
	public Model toModel(final EvaluationProvider<?> context) throws EvaluationException {
		final Model model = ModelFactory.createDefaultModel();
		
		final Graph graph = model.getGraph();
		
		for (final Triple triple : this.evaluate(context)) {
			graph.add(triple);
		}
		
		return model;
	}
	
	public void write(final EvaluationProvider<?> context, final OutputStream outputStream) throws EvaluationException {
		this.write(context, outputStream, null);
	}
	
	public void write(final EvaluationProvider<?> context, final OutputStream outputStream, String lang) throws EvaluationException {
		if (outputStream == null) {
			throw new IllegalArgumentException("outputStream == null");
		} else {
			final String sanitizedLang = StringUtils.isBlank(lang) ? FileUtils.langXML : lang;
			
			final Model model = this.toModel(context);
			
			if (model == null) {
				throw new IllegalStateException("model == null");
			} else {
				final RDFWriter writer = model.getWriter(sanitizedLang);
				
				if (sanitizedLang.equals(FileUtils.langXML) || sanitizedLang.equals(FileUtils.langXMLAbbrev)) {
					try {
						outputStream.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n".getBytes());
					} catch (final IOException e) {
						writer.setProperty("showXMLDeclaration", "true");
					}
				}
				
				try {
					// See: http://jena.sourceforge.net/IO/iohowto.html
					writer.setProperty("relativeURIs", "same-document");
				} catch (final UnknownPropertyException e) {
					// Do nothing.
				}
				
				// Write the model to the output stream.
				writer.write(model, FileUtils.asPrintWriterUTF8(outputStream), null);
			}
		}
	}
	
}
