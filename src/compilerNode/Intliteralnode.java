package compilerNode;

public class Intliteralnode extends Literalnode {
	protected int val;
	public Intliteralnode(String t) {
		val=Integer.parseInt(t);
	}
	/**
	 * @return the val
	 */
	public int getVal() {
		return val;
	}
	/**
	 * @param val the val to set
	 */
	public void setVal(int val) {
		this.val = val;
	}
	
}
