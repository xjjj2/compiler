package type;

import compilerNode.node;

public class ArrayorType extends defined {
	public definedtype type;
	public int arraynum;
	public definedtype getType() {
		return type;
	}
	public void setType(definedtype type) {
		this.type = type;
		name=type.name;
	}
	public int getArraynum() {
		return arraynum;
	}
	public void setArraynum(int arraynum) {
		this.arraynum = arraynum;
	}
	public ArrayorType(String name, node definenode, definedtype type, int arraynum) {
		super(name, definenode);
		this.type = type;
		this.arraynum = arraynum;
	}
	public ArrayorType(String name, node definenode) {
		super(name, definenode);
		this.arraynum=0;
	}
	public ArrayorType() {
		super();
	}
	public ArrayorType(definedtype type, int arraynum) {
		super();
		if (type!=null) {
			name=type.name;
			definenode=type.definenode;
		}
		else {
			name=null;
			definenode=null;
		}
		this.type = type;
		this.arraynum = arraynum;
	}
	
}	
