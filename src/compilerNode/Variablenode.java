package compilerNode;

import type.Variable;

public class Variablenode extends LHSnode {
	public String id;
	public Variable vardef;
	public boolean isfield;
	public Variablenode () {isfield=false;}
	public Variablenode(String id) {
		this.id=id;
		isfield=false;
	}
}
