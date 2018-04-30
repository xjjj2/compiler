package compilerNode;

public class formalparasnode extends node {
	public formalparalistnode paras;

	public formalparalistnode getParas() {
		return paras;
	}

	public void setParas(formalparalistnode paras) {
		this.paras = paras;
	}

	public formalparasnode(formalparalistnode paras) {
		super();
		this.paras = paras;
	}

	public formalparasnode() {
		super();
	}
	
}
