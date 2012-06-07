package uk.ac.soton.mib104.json2rdf;

public final class Version {

	public static final int MAJOR = 0, MINOR = 0, TINY = 1;
	
	public static final String EXTRA = "rc1";
	
	public static final String asString() {
		final StringBuilder sb = new StringBuilder();
		
		sb.append(MAJOR);
		sb.append('.');
		sb.append(MINOR);
		sb.append('.');
		sb.append(TINY);
		
		if (EXTRA != null) {
			sb.append('-');
			sb.append(EXTRA);
		}
		
		return sb.toString();
	}
	
	private Version() {
		// Do nothing...
	}
	
}
