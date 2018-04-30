package compilerNode;

public class Methodbodynode extends node {
	public Blocknode child;

	public Methodbodynode(Blocknode child) {
		super();
		this.child = child;
	}

	public Methodbodynode() {
		super();
	}
	
}
