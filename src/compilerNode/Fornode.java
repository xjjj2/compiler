package compilerNode;

public class Fornode extends Statementnode {
	public forcontrolnode con;
	public Statementnode statement;
	public Fornode(forcontrolnode con, Statementnode statement) {
		super();
		this.con = con;
		this.statement = statement;
	}
	public Fornode() {
		super();
	}
	public forcontrolnode getCon() {
		return con;
	}
	public void setCon(forcontrolnode con) {
		this.con = con;
	}
	public Statementnode getStatement() {
		return statement;
	}
	public void setStatement(Statementnode statement) {
		this.statement = statement;
	}
	
}
