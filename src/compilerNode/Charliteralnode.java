package compilerNode;

public class Charliteralnode extends Literalnode {
	protected char c;
	
	/**
	 * @return the c
	 */
	public Charliteralnode(String t) {
		c=t.toCharArray()[1];
	};
	public char getC() {
		return c;
	}

	/**
	 * @param c the c to set
	 */
	public void setC(char c) {
		this.c = c;
	}
	
}
