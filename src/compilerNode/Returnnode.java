package compilerNode;

public class Returnnode extends Statementnode {
	public Exprnode expr;

	/**
	 * @return the expr
	 */
	public Exprnode getExpr() {
		return expr;
	}

	/**
	 * @param expr the expr to set
	 */
	public void setExpr(Exprnode expr) {
		this.expr = expr;
	}

	public Returnnode(Exprnode expr) {
		super();
		this.expr = expr;
	}

	public Returnnode() {
		super();
	}
	
	
}
