package uk.ac.soton.mib104.json2rdf.lang.template;

import uk.ac.soton.mib104.json2rdf.lang.EvaluationException;
import uk.ac.soton.mib104.json2rdf.lang.EvaluationProvider;
import uk.ac.soton.mib104.json2rdf.lang.FatalEvaluationException;
import uk.ac.soton.mib104.json2rdf.lang.MethodNotFoundException;
import uk.ac.soton.mib104.json2rdf.lang.NullValueException;
import uk.ac.soton.mib104.json2rdf.lang.Sendable;

public final class MethodCall extends Template<Object> {
	
	private Object[] arguments;
	
	private String methodName;
	
	public MethodCall(final String methodName) {
		this(methodName, null);
	}
	
	public MethodCall(final String methodName, final Object[] arguments) {
		super();
		
		this.setMethodName(methodName);
		this.setArguments(arguments);
	}
	
	@Override
	public Object evaluate(final EvaluationProvider<?> context) throws EvaluationException {
		if (context == null) {
			throw new IllegalArgumentException("context == null");
		}
		
		try {
			final Object[] arguments = this.getArguments();
			
			final Sendable<?> valueSendable = (arguments == null) ? context.send(this.getMethodName()) : context.send(this.getMethodName(), arguments);
			
			if (valueSendable == null) {
				throw new NullValueException(this, context);
			} else {
				final Object value = valueSendable.getObject();
				
				if (value == null) {
					throw new NullValueException(this, context);
				} else {
					return value;
				}
			}
		} catch (final MethodNotFoundException e) {
			throw new FatalEvaluationException(this, context, e);
		}
	}
	
	public Object[] getArguments() {
		return arguments;
	}
	
	public String getMethodName() {
		return methodName;
	}
	
	public void setArguments(final Object[] arguments) {
		this.arguments = arguments;
	}
	
	public void setMethodName(final String methodName) {
		this.methodName = methodName;
	}
	
}
