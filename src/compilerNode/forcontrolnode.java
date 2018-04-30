package compilerNode;

public class forcontrolnode extends node {
	public forinitnode init;
	public Exprnode parexpr;
	public exprlistnode exprlist;
	
	public forcontrolnode(forinitnode init, Exprnode parexpr, exprlistnode exprlist) {
		super();
		this.init = init;
		this.parexpr = parexpr;
		this.exprlist = exprlist;
	}
	public forcontrolnode() {
		super();
	}
	
}
