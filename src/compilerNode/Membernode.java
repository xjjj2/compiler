package compilerNode;
import type.*;
public class Membernode extends LHSnode{
	public Variablenode identifier;
	public Exprnode expr;
	public Membernode() {}
	public Membernode(Variablenode identfier,Exprnode expr,ArrayorType type) {
		this.identifier=identfier;
		this.expr=expr;
		this.type=type;
	}
	public Membernode(Variablenode identfier,Exprnode expr) {
		this.identifier=identfier;
		this.expr=expr;
	}
}
