package compilerNode;
import type.*;
public class Assignnode extends Exprnode{
	public Exprnode left;
	public Exprnode right;
//	protected String type;
	public Assignnode() {}
	public Assignnode(Exprnode left, Exprnode right) {
		super();
		this.left=left;
		this.right=right;
	}
	public ArrayorType type() {
		return (type != null) ? type : null;
	}
	
}
