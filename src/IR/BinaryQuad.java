package IR;

import type.Variable;

public class BinaryQuad extends Quad {
	public String op;
	public Var var1;
	public Var var2;
	public Vari vardest;
	public BinaryQuad(Var var1, Var var2, Vari vardest) {
		super();
		this.var1 = var1;
		this.var2 = var2;
		this.vardest = vardest;
	}
	public BinaryQuad(String op, Var var1, Var var2, Vari vardest) {
		super();
		this.op = op;
		this.var1 = var1;
		this.var2 = var2;
		this.vardest = vardest;
	}
	
}
