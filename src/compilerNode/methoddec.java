package compilerNode;

import type.Function;

public class methoddec extends node {
	public node type;
	public String name;
	public formalparasnode attribute;
	public Blocknode body;
	public Function func;
	public methoddec() {
		super();
	}
	public methoddec(node type, String name, formalparasnode attribute) {
		super();
		this.type = type;
		this.name = name;
		this.attribute = attribute;
	}
	
}
