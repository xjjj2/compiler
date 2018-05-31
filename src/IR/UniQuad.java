package IR;

import type.Variable;

public class UniQuad extends Quad {
	public Var src;
	public Vari dest;
	public String op;
	public UniQuad(Var src, Vari dest, String op) {
		super();
		this.src = src;
		this.dest = dest;
		this.op = op;
	}
	
}
