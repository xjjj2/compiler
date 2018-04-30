package compilerNode;

public class Stringliteralnode extends Literalnode {
	protected String s;
	public Stringliteralnode(String t) {s=t.substring(1,t.length()-1);}
	/**
	 * @return the s
	 */
	public String getS() {
		return s;
	}
	/**
	 * @param s the s to set
	 */
	public void setS(String s) {
		this.s = s;
	}
	
}
