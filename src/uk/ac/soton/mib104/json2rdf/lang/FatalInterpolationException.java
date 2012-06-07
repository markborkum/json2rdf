package uk.ac.soton.mib104.json2rdf.lang;

public class FatalInterpolationException extends InterpolationException {

	private static final long serialVersionUID = -1805489471229686829L;

	public FatalInterpolationException(final Interpolatable<?> interpolatable, final String input) {
		this(interpolatable, input, null, null);
	}
	
	public FatalInterpolationException(final Interpolatable<?> interpolatable, final String input, final String message) {
		this(interpolatable, input, message, null);
	}
	
	public FatalInterpolationException(final Interpolatable<?> interpolatable, final String input, final String message, final Throwable cause) {
		super(interpolatable, input, message, cause);
	}
	
	public FatalInterpolationException(final Interpolatable<?> interpolatable, final String input, final Throwable cause) {
		this(interpolatable, input, null, cause);
	}

}
