package compilerNode;

public class Vardeclaratornode extends node {
	public Variablenode id;
	public Exprnode init;
	public Vardeclaratornode(Variablenode id, Exprnode init) {
		super();
		this.id = id;
		this.init = init;
	}
	public Vardeclaratornode() {
		super();
	}
	
}
