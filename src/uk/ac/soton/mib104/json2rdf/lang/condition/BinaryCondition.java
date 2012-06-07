package uk.ac.soton.mib104.json2rdf.lang.condition;

public abstract class BinaryCondition extends Condition {
	
	private Condition arg0;
	
	private Condition arg1;
	
	public BinaryCondition(final Condition arg0, final Condition arg1) {
		super();
		
		this.setArg0(arg0);
		this.setArg1(arg1);
	}

	public Condition getArg0() {
		return arg0;
	}

	public Condition getArg1() {
		return arg1;
	}

	public void setArg0(final Condition arg0) {
		this.arg0 = arg0;
	}

	public void setArg1(final Condition arg1) {
		this.arg1 = arg1;
	}

}
