package uk.ac.soton.mib104.json2rdf.lang;

public interface Sendable<T> {
	
	public static final Object[] emptyObjectArray = new Object[0];
	
	public T getObject();
	
	public Sendable<?> send(final String methodName) throws MethodNotFoundException;
	
	public Sendable<?> send(final String methodName, final Object[] arguments) throws MethodNotFoundException;
	
}
