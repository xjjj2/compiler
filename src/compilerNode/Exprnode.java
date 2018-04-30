package compilerNode;
import type.*;
public class Exprnode extends node {
	public ArrayorType type;// node returning type
	public boolean iflhs;
	public Exprnode() {iflhs=false;}
	/**
	 * @return the type
	 */
	public ArrayorType getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(ArrayorType type) {
		this.type = type;
	}
	public Exprnode(ArrayorType type) {
		super();
		this.type = type;
		iflhs=false;
	}
	
}
