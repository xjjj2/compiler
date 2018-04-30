package compilerNode;

import visitor.*;

public abstract class node{
	public node() {}
	public SourcePosition location;
	public void setlocation(SourcePosition location) {this.location=location;}
	public String loc() {
		return location.toString();
	}
	public Scope scope;
	public void setScope(Scope scope) {
		this.scope=scope;
	}
	public Scope getScope() {return scope;}
	public node parent;
	/*public void dump() {
		dump(System.out);
	}
	public void dump(PrintStream s) {
		dump(new Dumper(s));
	}
	public void dump(Dumper d) {
		d.printClass(this, location());
		_dump(d);
	}
	abstract protected void _dump(Dumper d);*/
	
}
