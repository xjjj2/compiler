package type;

import compilerNode.node;

public class ArrayorType extends defined {
	public defined type;
	public int arraynum;
	public int size=0;
	public defined getType() {
		return type;
	}
	public void setType(defined type) {
		this.type = type;
		name=type.name;
	}
	public int getArraynum() {
		return arraynum;
	}
	public void setArraynum(int arraynum) {
		this.arraynum = arraynum;
	}
	public ArrayorType(String name, node definenode, defined type, int arraynum) {
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
	public ArrayorType(defined type, int arraynum) {
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
