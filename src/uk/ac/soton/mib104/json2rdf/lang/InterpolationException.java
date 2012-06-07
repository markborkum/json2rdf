package uk.ac.soton.mib104.json2rdf.lang;

public class InterpolationException extends Exception {

	private static final long serialVersionUID = -8374615601811042885L;

	private String input;
	
	private Interpolatable<?> interpolatable;
	
	public InterpolationException(final Interpolatable<?> interpolatable, final String input) {
		this(interpolatable, input, null, null);
	}
	
	public InterpolationException(final Interpolatable<?> interpolatable, final String input, final String message) {
		this(interpolatable, input, message, null);
	}
	
	public InterpolationException(final Interpolatable<?> interpolatable, final String input, final String message, final Throwable cause) {
		super(message, cause);
		
		this.setInterpolatable(interpolatable);
		this.setInput(input);
	}
	
	public InterpolationException(final Interpolatable<?> interpolatable, final String input, final Throwable cause) {
		this(interpolatable, input, null, cause);
	}

	public String getInput() {
		return input;
	}

	public Interpolatable<?> getInterpolatable() {
		if (interpolatable == null) {
			throw new IllegalStateException("interpolatable == null");
		}
		
		return interpolatable;
	}

	private void setInput(final String input) {
		this.input = input;
	}

	private void setInterpolatable(final Interpolatable<?> interpolatable) {
		if (interpolatable == null) {
			throw new IllegalArgumentException("interpolatable == null");
		}
		
		this.interpolatable = interpolatable;
	}

}
