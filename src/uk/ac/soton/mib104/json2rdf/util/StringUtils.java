package uk.ac.soton.mib104.json2rdf.util;

import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StringUtils {
	
	public static final String emptyString = "";
	
	public static final String[] emptyStringArray = new String[0];
	
	public static final String concat(final Object... objects) {
		final StringBuffer sb = new StringBuffer();
		
		for (final Object object : objects) {
			if (object != null) {
				sb.append(object);
			}
		}
		
		return sb.toString();
	}
	
	private static final Pattern createPatternForReplaceAll(final Set<String> targets) {
		final StringBuffer sb = new StringBuffer();
		
		if (CollectionUtils.isNotBlank(targets)) {
			sb.append('(');
			
			final int headLength = sb.length();
			
			for (final String target : targets) {
				if (sb.length() > headLength) {
					sb.append('|');
				}
				
				sb.append(Pattern.quote(target));
			}
			
			sb.append(')');
		}
		
		return Pattern.compile(sb.toString());
	}
	
	public static final boolean isBlank(final String string) {
		return (string == null) || isEmpty(string.trim());
	}
	
	public static final boolean isEmpty(final String string) {
		return (string == null) || string.isEmpty();
	}
	
	public static final boolean isNotBlank(final String string) {
		return !isBlank(string);
	}
	
	public static final boolean isNotEmpty(final String string) {
		return !isEmpty(string);
	}
	
	public static final String replaceAll(final String string, final Map<String, String> replacements) {
		if (MapUtils.isBlank(replacements)) {
			return string;
		} else {
			return replaceAll(string, createPatternForReplaceAll(replacements.keySet()), new UnaryFunction<String, Matcher>() {

				@Override
				public String call(final Matcher matcher) {
					return replacements.get(matcher.group());
				}
				
			});
		}
	}
	
	public static final String replaceAll(final String string, final Pattern pattern, final UnaryFunction<String, Matcher> block) {
		if (isBlank(string) || (pattern == null) || (block == null)) {
			return string;
		} else {
			final StringBuffer sb = new StringBuffer();
			
			final Matcher matcher = pattern.matcher(string);
			
			if (matcher != null) {
				while (matcher.find()) {
					final String replacement = block.call(matcher);
					
					if (replacement != null) {
						matcher.appendReplacement(sb, Matcher.quoteReplacement(replacement));
					}
				}
				
				matcher.appendTail(sb);
			}
			
			return sb.toString();
		}
	}
	
	private StringUtils() {
		// Do nothing...
	}
	
}
