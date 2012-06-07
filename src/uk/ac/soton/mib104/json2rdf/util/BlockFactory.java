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
import uk.ac.soton.mib104.json2rdf.lang.expression.Block;

public final class BlockFactory {
	
	private static final Block createBlock(final CharStream charStream) throws RecognitionException {
		return new JSON2RDFParser(new CommonTokenStream(new JSON2RDFLexer(charStream))).root();
	}
	
	public static final Block createBlock(final InputStream inputStream) throws RecognitionException, IOException {
		return createBlock(new ANTLRInputStream(inputStream));
	}
	
	public static final Block createBlock(final Reader reader) throws RecognitionException, IOException {
		return createBlock(new ANTLRReaderStream(reader));
	}
	
	public static final Block createBlock(final String string) throws RecognitionException {
		return createBlock(new ANTLRStringStream(string));
	}
	
	public static final Block createBlock(final String filename, final String encoding) throws RecognitionException, IOException {
		return createBlock(new ANTLRFileStream(filename, encoding));
	}
	
	private BlockFactory() {
		// Do nothing...
	}
	
}
