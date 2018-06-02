package irnode;

import type.Variable;

public class Var extends Expnode {
	public Variable var;

	public Var(Variable var) {
		super();
		this.var = var;
	}

	public Var() {
		super();
	}
	
}
