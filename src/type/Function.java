package type;

import java.util.*;

import IR.Temp;
import IR.Var;
import compilerNode.node;
import visitor.Scope;

public class Function extends defined {
	public List<Variable> attribute;
	public List<Temp> temps;
	public ArrayorType returnval;
	public boolean ifvoid;
	public Scope scope;
	public int templong;
	public boolean ifmethod=false;
	public Function(String name, node definenode, List<Variable> attribute, ArrayorType returnval) {
		super(name, definenode);
		this.attribute = attribute;
		this.returnval = returnval;
		this.ifvoid = false;
	}
	public Function(String name, node definenode) {
		super(name, definenode);
		attribute=new ArrayList<Variable>();
		temps=new ArrayList<>();
		this.ifvoid = false;
	}
	public Function() {
		super();
		this.ifvoid = false;
	}
	
	
}
