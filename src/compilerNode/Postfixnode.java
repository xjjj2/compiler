package compilerNode;

import type.*;

public class Postfixnode extends Exprnode {
	protected Exprnode expr;
	protected String postfix;
	public Postfixnode() {}
	public Postfixnode(Exprnode expr,String postfix) {
		this.expr=expr;
		this.postfix=postfix;
	}
	public Postfixnode(Exprnode expr,String postfix,ArrayorType type) {
		super(type);
		this.expr=expr;
		this.postfix=postfix;
	}
	public Exprnode getexpr() {return expr;}
	public String postfix() {return postfix;}
}
