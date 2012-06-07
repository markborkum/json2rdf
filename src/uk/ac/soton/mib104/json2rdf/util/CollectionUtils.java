package uk.ac.soton.mib104.json2rdf.util;

import java.util.Collection;

public final class CollectionUtils {

	public static final <T> boolean isBlank(final Collection<T> collection) {
		return (collection == null) || isEmpty(collection);
	}
	
	public static final <T> boolean isEmpty(final Collection<T> collection) {
		return (collection == null) || collection.isEmpty();
	}
	
	public static final <T> boolean isNotBlank(final Collection<T> collection) {
		return !isBlank(collection);
	}
	
	public static final <T> boolean isNotEmpty(final Collection<T> collection) {
		return !isEmpty(collection);
	}
	
	private CollectionUtils() {
		// Do nothing...
	}
	
}
