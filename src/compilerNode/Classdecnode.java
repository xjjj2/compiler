package compilerNode;

import type.definedtype;

public class Classdecnode extends node {
	public String classname;
	public definedtype classtype;
	public Classbodynode body;
	public Classdecnode(String classname, definedtype classtype, Classbodynode body) {
		super();
		this.classname = classname;
		this.classtype = classtype;
		this.body = body;
	}
	public Classdecnode() {
		super();
	}
	
}
