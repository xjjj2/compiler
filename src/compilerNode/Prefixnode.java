package compilerNode;

import type.*;

public class Prefixnode extends Exprnode {
	protected Exprnode expr;
	protected String prefix;
	public Prefixnode() {}
	public Prefixnode(Exprnode expr,String prefix) {
		this.expr=expr;
		this.prefix=prefix;
	}
	public Prefixnode(Exprnode expr,String prefix,ArrayorType type) {
		super(type);
		this.expr=expr;
		this.prefix=prefix;
	}
	public Exprnode getexpr() {return expr;}
	public String prefix() {return prefix;}
}