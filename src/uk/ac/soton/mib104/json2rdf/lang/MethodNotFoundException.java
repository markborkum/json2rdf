package uk.ac.soton.mib104.json2rdf.lang;

public final class MethodNotFoundException extends Exception {
	
	private static final String toMethodCallString(final String methodName, final Object[] arguments) {
		if (methodName == null) {
			return null;
		} else if (arguments == null) {
			return null;
		} else {
			final StringBuilder sb = new StringBuilder();
			
			sb.append(methodName);
			sb.append('(');
			for (int index = 0; index < arguments.length; index++) {
				final Object nextArgument = arguments[index];
				
				if (index > 0) {
					sb.append(',');
					sb.append(' ');
				}
				
				if (nextArgument instanceof String) {
					sb.append('"');
					sb.append(nextArgument);
					sb.append('"');
				} else {
					sb.append(nextArgument);
				}
			}
			sb.append(')');
			
			return sb.toString();
		}
	}

	private static final long serialVersionUID = 2277122637990451966L;
	
	private Object[] arguments;
	
	private String methodName;
	
	private Sendable<?> sendable;
	
	public MethodNotFoundException(final Sendable<?> sendable, final String methodName, final Object[] arguments) {
		super(String.format("Method not found: %s", toMethodCallString(methodName, arguments)));
		
		this.setSendable(sendable);
		
		this.setMethodName(methodName);
		this.setArguments(arguments);
	}

	public Object[] getArguments() {
		return arguments;
	}

	public String getMethodName() {
		return methodName;
	}

	public Sendable<?> getSendable() {
		if (sendable == null) {
			throw new IllegalStateException("sendable == null");
		}
		
		return sendable;
	}

	public void setArguments(final Object[] arguments) {
		this.arguments = arguments;
	}

	public void setMethodName(final String methodName) {
		this.methodName = methodName;
	}

	public void setSendable(final Sendable<?> sendable) {
		if (sendable == null) {
			throw new IllegalArgumentException("sendable == null");
		}
		
		this.sendable = sendable;
	}

}
