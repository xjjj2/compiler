package compilerNode;
import type.*;
public class Classnamenode extends node {
	public String name;
	public definedtype type;
	public Classnamenode(String name, definedtype type) {
		super();
		this.name = name;
		this.type = type;
	}
	public Classnamenode(String name) {
		super();
		this.name = name;
	}
	public Classnamenode() {
		super();
	}
	
}
