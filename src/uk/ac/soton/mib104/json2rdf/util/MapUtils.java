package uk.ac.soton.mib104.json2rdf.util;

import java.util.Map;

public final class MapUtils {
	
	public static final <K, V> boolean isBlank(final Map<K, V> map) {
		return (map == null) || isEmpty(map);
	}
	
	public static final <K, V> boolean isEmpty(final Map<K, V> map) {
		return (map == null) || map.isEmpty();
	}
	
	public static final <K, V> boolean isNotBlank(final Map<K, V> map) {
		return !isBlank(map);
	}
	
	public static final <K, V> boolean isNotEmpty(final Map<K, V> map) {
		return !isEmpty(map);
	}
	
	private MapUtils() {
		// Do nothing...
	}
	
}
