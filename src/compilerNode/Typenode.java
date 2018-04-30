package compilerNode;
import type.*;
public class Typenode extends node {
	public String name;
	public ArrayorType type;
	public Typenode(String name, ArrayorType type) {
		super();
		this.name = name;
		this.type = type;
	}
	public Typenode(String name) {
		super();
		this.name = name;
		type=new ArrayorType();
	}
	public Typenode() {
		super();
		type=new ArrayorType();
	}
	
}
