package compilerNode;

public class Ifnode extends Statementnode {
	public Exprnode parexpr;
	public Statementnode ifstatement;
	public Statementnode elsestatement;
	public boolean ifelse;
	public Ifnode() {}
	public Ifnode(Exprnode par,Statementnode ifstate,Statementnode elsestate) {
		this.parexpr=par;
		this.ifstatement=ifstate;
		this.elsestatement=elsestate;
		ifelse= (elsestate!=null); 
	}
	
	
}
