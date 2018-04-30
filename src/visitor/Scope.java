package visitor;

import java.util.*;

import type.ArrayorType;
import type.Function;
import type.Variable;
import type.defined;

public abstract class Scope {
	public List<localScope> child;
	public Map<String,Variable> variable;
	public Map<String,Function> method;
	public Scope parent;
	public Scope() {
		variable=new HashMap<>();
		child=new ArrayList<localScope>();
		method=new HashMap<>();
		parent=null;
	}
}
