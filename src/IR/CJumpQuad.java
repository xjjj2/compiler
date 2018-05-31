package IR;

import type.Variable;

public class CJumpQuad extends Quad {
	public Var par;
	public Label Truelab;
	public Label Falselab;
	public CJumpQuad(Var par, Label truelab, Label falselab) {
		super();
		this.par = par;
		Truelab = truelab;
		Falselab = falselab;
	}
	public CJumpQuad() {
		super();
	}
	
}
