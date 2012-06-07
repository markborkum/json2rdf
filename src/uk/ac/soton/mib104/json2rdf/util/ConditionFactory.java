package uk.ac.soton.mib104.json2rdf.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.ANTLRReaderStream;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;

import uk.ac.soton.mib104.json2rdf.JSON2RDFLexer;
import uk.ac.soton.mib104.json2rdf.JSON2RDFParser;
import uk.ac.soton.mib104.json2rdf.lang.condition.Condition;

public final class ConditionFactory {
	
	private static final Condition createCondition(final CharStream charStream) throws RecognitionException {
		return new JSON2RDFParser(new CommonTokenStream(new JSON2RDFLexer(charStream))).conditionalExpression();
	}
	
	public static final Condition createCondition(final InputStream inputStream) throws RecognitionException, IOException {
		return createCondition(new ANTLRInputStream(inputStream));
	}
	
	public static final Condition createCondition(final Reader reader) throws RecognitionException, IOException {
		return createCondition(new ANTLRReaderStream(reader));
	}
	
	public static final Condition createCondition(final String string) throws RecognitionException {
		return createCondition(new ANTLRStringStream(string));
	}
	
	public static final Condition createCondition(final String filename, final String encoding) throws RecognitionException, IOException {
		return createCondition(new ANTLRFileStream(filename, encoding));
	}
	
	private ConditionFactory() {
		// Do nothing...
	}
	
}
