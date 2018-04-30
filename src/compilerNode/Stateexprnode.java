package compilerNode;

public class Stateexprnode extends Statementnode{
	protected Exprnode expr;

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

	public Stateexprnode(Exprnode expr) {
		super();
		this.expr = expr;
	}
	
}
