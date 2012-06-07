package uk.ac.soton.mib104.json2rdf.util;

import java.io.IOException;
import java.io.InputStream;

import com.hp.hpl.jena.util.FileUtils;

public final class InputStreamUtils {
	
	public static final CharSequence readAsUTF8(final InputStream inputStream) throws IOException {
		return ReaderUtils.readAsUTF8(FileUtils.asBufferedUTF8(inputStream));
	}

	private InputStreamUtils() {
		// Do nothing...
	}
	
}
