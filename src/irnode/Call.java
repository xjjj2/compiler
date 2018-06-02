package irnode;

import java.util.List;

import type.Variable;

public class Call extends Expnode {
	public Expnode expr;
	public List<Variable> args;
}
