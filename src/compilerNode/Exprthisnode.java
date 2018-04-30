package compilerNode;
import type.*;
public class Exprthisnode extends Exprnode {
	protected Thisnode th;
	protected Exprnode expr;
	public Exprthisnode() {}
	public Exprthisnode(Exprnode expr,ArrayorType type) {
		this.expr=expr;
		this.type=type;
	}
	public Exprthisnode(Exprnode expr) {
		this.expr=expr;
	}
	public Thisnode getthis() {return th;}
	public Exprnode getexpr() {return expr;}
}
