package compilerNode;

import type.Variable;

public class Variablenode extends LHSnode {
	public String id;
	public Variable vardef;
	public Variablenode () {}
	public Variablenode(String id) {
		this.id=id;
	}
}
