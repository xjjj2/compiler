package compilerNode;
import type.*;

public class Funcallnode extends Exprnode {
	public String name;
	public Function func;
	public exprlistnode exprlist;
	public boolean ifmethod;
	public int exprnum;
	public Funcallnode() {ifmethod=false;}
	public Funcallnode(exprlistnode exprlist) {
		ifmethod=false;
		this.exprlist=exprlist;
	}
}
