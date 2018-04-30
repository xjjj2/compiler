package type;

import compilerNode.Exprnode;
import compilerNode.node;
import visitor.Scope;

public class Variable extends defined{
	public ArrayorType type;
	public Exprnode init;
	public Variable(String name, node definenode, ArrayorType type, Exprnode init) {
		super(name, definenode);
		this.type = type;
		this.init = init;
	}
	public Variable(String name, node definenode) {
		super(name, definenode);
	}
	public Variable() {
	}
	
}
