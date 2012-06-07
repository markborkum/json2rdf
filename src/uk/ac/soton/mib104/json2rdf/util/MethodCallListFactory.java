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
import uk.ac.soton.mib104.json2rdf.lang.template.MethodCallList;

public final class MethodCallListFactory {
	
	private static final MethodCallList createMethodCallList(final CharStream charStream) throws RecognitionException {
		return new JSON2RDFParser(new CommonTokenStream(new JSON2RDFLexer(charStream))).interpolatedVariable();
	}
	
	public static final MethodCallList createMethodCallList(final InputStream inputStream) throws RecognitionException, IOException {
		return createMethodCallList(new ANTLRInputStream(inputStream));
	}
	
	public static final MethodCallList createMethodCallList(final Reader reader) throws RecognitionException, IOException {
		return createMethodCallList(new ANTLRReaderStream(reader));
	}
	
	public static final MethodCallList createMethodCallList(final String string) throws RecognitionException {
		return createMethodCallList(new ANTLRStringStream(string));
	}
	
	public static final MethodCallList createMethodCallList(final String filename, final String encoding) throws RecognitionException, IOException {
		return createMethodCallList(new ANTLRFileStream(filename, encoding));
	}

	private MethodCallListFactory() {
		// Do nothing...
	}
	
}
