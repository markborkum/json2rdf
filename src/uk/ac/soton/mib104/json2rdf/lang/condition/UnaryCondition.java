package uk.ac.soton.mib104.json2rdf.lang.condition;

public abstract class UnaryCondition extends Condition {
	
	private Condition arg0;

	public UnaryCondition(final Condition arg0) {
		super();
		
		this.setArg0(arg0);
	}

	public Condition getArg0() {
		return arg0;
	}

	public void setArg0(final Condition arg0) {
		this.arg0 = arg0;
	}

}
