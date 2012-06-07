package uk.ac.soton.mib104.json2rdf.lang.template;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import uk.ac.soton.mib104.json2rdf.lang.EvaluationException;
import uk.ac.soton.mib104.json2rdf.lang.EvaluationProvider;
import uk.ac.soton.mib104.json2rdf.lang.FatalEvaluationException;
import uk.ac.soton.mib104.json2rdf.lang.MethodNotFoundException;
import uk.ac.soton.mib104.json2rdf.lang.NullValueException;
import uk.ac.soton.mib104.json2rdf.lang.Sendable;

public final class MethodCallList extends Template<Object> implements Iterable<MethodCall> {
	
	private List<MethodCall> methodCalls;
	
	public MethodCallList() {
		super();
		
		this.setMethodCalls(new LinkedList<MethodCall>());
	}
	
	public void add(final int index, final MethodCall methodCall) {
		final List<MethodCall> methodCalls = this.getMethodCalls();
		
		methodCalls.add(index, methodCall);
	}

	public boolean add(final MethodCall methodCall) {
		final List<MethodCall> methodCalls = this.getMethodCalls();
		
		return methodCalls.add(methodCall);
	}

	public void clear() {
		final List<MethodCall> methodCalls = this.getMethodCalls();
		
		methodCalls.clear();
	}

	@Override
	public Object evaluate(final EvaluationProvider<?> context) throws EvaluationException {
		if (context == null) {
			throw new IllegalArgumentException("context == null");
		}
		
		if (this.isEmpty()) {
			final Object value = context.getObject();
			
			if (value == null) {
				throw new NullValueException(this, context);
			} else {
				return value;
			}
		} else {
			Sendable<?> accumulator = context;
			
			for (final MethodCall methodCall : this) {
				if (accumulator == null) {
					break;
				} else if (methodCall == null) {
					continue;
				} else {
					final String methodName = methodCall.getMethodName();
					final Object[] arguments = methodCall.getArguments();
					
					try {
						accumulator = (arguments == null) ? accumulator.send(methodName) : accumulator.send(methodName, arguments);
					} catch (final MethodNotFoundException e) {
						throw new FatalEvaluationException(this, context, e);
					}
				}
			}
			
			if (accumulator == null) {
				throw new NullValueException(this, context);
			} else {
				final Object value = accumulator.getObject();
				
				if (value == null) {
					throw new NullValueException(this, context);
				} else {
					return value;
				}
			}
		}
	}

	public MethodCall get(final int index) {
		final List<MethodCall> methodCalls = this.getMethodCalls();
		
		return methodCalls.get(index);
	}

	private List<MethodCall> getMethodCalls() {
		if (methodCalls == null) {
			throw new IllegalStateException("methodCalls == null");
		}
		
		return methodCalls;
	}

	public boolean isEmpty() {
		final List<MethodCall> methodCalls = this.getMethodCalls();
		
		return methodCalls.isEmpty();
	}

	@Override
	public Iterator<MethodCall> iterator() {
		final List<MethodCall> methodCalls = this.getMethodCalls();
		
		return methodCalls.iterator();
	}
	
	public ListIterator<MethodCall> listIterator() {
		final List<MethodCall> methodCalls = this.getMethodCalls();
		
		return methodCalls.listIterator();
	}

	public MethodCall remove(final int index) {
		final List<MethodCall> methodCalls = this.getMethodCalls();
		
		return methodCalls.remove(index);
	}

	public boolean remove(final MethodCall methodCall) {
		final List<MethodCall> methodCalls = this.getMethodCalls();
		
		return methodCalls.remove(methodCall);
	}

	private void setMethodCalls(final List<MethodCall> methodCalls) {
		if (methodCalls == null) {
			throw new IllegalArgumentException("methodCalls == null");
		}
		
		this.methodCalls = methodCalls;
	}

	public int size() {
		final List<MethodCall> methodCalls = this.getMethodCalls();
		
		return methodCalls.size();
	}

}
