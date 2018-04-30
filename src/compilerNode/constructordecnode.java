package compilerNode;

import type.definedtype;

public class constructordecnode extends node {
	public String name;
	public definedtype type;
	public formalparasnode paras;
	public Blocknode block;
	public constructordecnode(String name, definedtype type, formalparasnode paras, Blocknode block) {
		super();
		this.name = name;
		this.type = type;
		this.paras = paras;
		this.block = block;
	}
	public constructordecnode() {
		super();
	}
	
}
