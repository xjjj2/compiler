package compilerNode;
import type.*;

public class Funcallnode extends Exprnode {
	public String name;
	public Function func;
	public exprlistnode exprlist;
	public int exprnum;
	public Funcallnode() {}
	public Funcallnode(exprlistnode exprlist) {
		this.exprlist=exprlist;
	}
}
