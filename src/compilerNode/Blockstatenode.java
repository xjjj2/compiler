package compilerNode;

public class Blockstatenode extends node {
	public node child;

	/**
	 * @return the child
	 */
	public node getChild() {
		return child;
	}

	/**
	 * @param child the child to set
	 */
	public void setChild(node child) {
		this.child = child;
	}

	public Blockstatenode(node child) {
		super();
		this.child = child;
	}
	
}
