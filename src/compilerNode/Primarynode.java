package compilerNode;

import type.*;

public class Primarynode extends Exprnode {
	public Exprnode expr;
	public Primarynode() {}
	public Primarynode(Exprnode expr) {this.expr=expr;}
	public Primarynode(Exprnode expr,ArrayorType type) {
		super(type);
		this.expr=this;
	}
}
