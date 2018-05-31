package compilerNode;
import IR.Label;
import type.*;
public class Binarynode extends Exprnode {
	public Exprnode left;
	public Exprnode right;
	public String opcode;
	public Binarynode() {}
	public Binarynode(Exprnode left,Exprnode right,String opcode) {
		super();
		this.left=left;
		this.right=right;
		this.opcode=opcode;
	}
	public Binarynode(Exprnode left,Exprnode right,String opcode,ArrayorType type) {
		super(type);
		this.left=left;
		this.right=right;
		this.opcode=opcode;
	}
	public String loc() {return left.loc();}
	
}
