package compilerNode;

public class Whilenode extends Statementnode {
	public Exprnode parexpr;
	public Statementnode statement;
	public Whilenode(Exprnode parexpr, Statementnode statement) {
		super();
		this.parexpr = parexpr;
		this.statement = statement;
	}
	public Whilenode() {
		super();
	}
	
}
