package compilerNode;

public class Arraynode extends LHSnode {
	public Exprnode name;
	public Exprnode sub;
	public Arraynode() {}
	public Arraynode(Exprnode name,Exprnode sub) {
		super();
		this.name=name;
		this.sub=sub;
	}
	
	
}
