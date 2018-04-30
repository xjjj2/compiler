package compilerNode;

public class formalparanode extends node {
	public Typenode type;
	public Variablenode var;
	public formalparanode() {
		super();
	}
	public formalparanode(Typenode type, Variablenode var) {
		super();
		this.type = type;
		this.var = var;
	}
	
}
