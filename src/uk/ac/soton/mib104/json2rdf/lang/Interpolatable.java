package uk.ac.soton.mib104.json2rdf.lang;

import java.util.regex.Pattern;

public interface Interpolatable<T> extends Sendable<T> {
	
	public static final Pattern interpolatePattern = Pattern.compile(String.format("%s(?:%s(?:[^%s]|\\.)*%s){1}", Pattern.quote("$"), Pattern.quote("{"), Pattern.quote("}"), Pattern.quote("}")));
		
	public String interpolate(final String input) throws InterpolationException;
	
}
