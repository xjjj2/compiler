package compilerNode;

public class Boolliteralnode extends Literalnode {
	protected boolean b;

	public Boolliteralnode(String t) {
		super();
		b=t.equals("true");
	}

	/**
	 * @return the b
	 */
	public boolean isB() {
		return b;
	}

	/**
	 * @param b the b to set
	 */
	public void setB(boolean b) {
		this.b = b;
	}
	
}
