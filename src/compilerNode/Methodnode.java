package compilerNode;

import type.*;

public class Methodnode extends Exprnode {
	public Funcallnode method;
	public Exprnode expr;
	public Methodnode () {}
	public Methodnode (Funcallnode method,Exprnode expr) {
		this.method=method;
		this.expr=expr;
	}
	public Methodnode (Funcallnode method,Exprnode expr,ArrayorType type) {
		this.method=method;
		this.expr=expr;
		this.type=type;
	}
	
}
