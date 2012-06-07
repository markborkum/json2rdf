package uk.ac.soton.mib104.json2rdf.util;

import java.io.BufferedReader;
import java.io.IOException;

public final class ReaderUtils {

	private ReaderUtils() {
		// Do nothing...
	}

	public static final CharSequence readAsUTF8(final BufferedReader reader) throws IOException {
		final StringBuilder sb = new StringBuilder();
		
		try {
			for (String inputLine = null; (inputLine = reader.readLine()) != null; ) {
				sb.append(inputLine);
				sb.append(System.getProperty("line.separator"));
			}
		} finally {
			reader.close();
		}
		
		return sb;
	}
	
}
