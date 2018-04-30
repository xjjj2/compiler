package type;

import compilerNode.*;
import visitor.Scope;

public abstract class defined {
	public String name;
	public node definenode;
	public Scope scope;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the definenode
	 */
	public node getDefinenode() {
		return definenode;
	}
	public defined(String name, node definenode) {
		super();
		this.name = name;
		this.definenode = definenode;
	}
	public defined() {}
	/**
	 * @param definenode the definenode to set
	 */
	public void setDefinenode(node definenode) {
		this.definenode = definenode;
	}
	
}
