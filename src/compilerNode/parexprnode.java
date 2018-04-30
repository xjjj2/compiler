package compilerNode;

class parexprnode extends node {
	protected Exprnode expr;

	public parexprnode(Exprnode expr) {
		super();
		this.expr = expr;
	}

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
	
}
