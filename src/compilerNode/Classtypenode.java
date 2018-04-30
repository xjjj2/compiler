package compilerNode;

import type.definedtype;

public class Classtypenode extends node{
	public String name;
	public definedtype type;
	public Classtypenode(String name, definedtype type) {
		super();
		this.name = name;
		this.type = type;
	}
	public Classtypenode(String name) {
		super();
		this.name = name;
	}
	
}
