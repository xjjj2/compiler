package compilerNode;

public class Castnode extends Exprnode {
	protected Exprnode castee;
	public Castnode() {}
	public Castnode(Exprnode castee) {super();this.castee=castee;}
	public Castnode(Exprnode castee,String type) {
		super(type);
		this.castee=castee;
	}
	public void setcastee(Exprnode n) {
		castee=n;
	}
	public Exprnode castee() {
		return castee;
	}
}
