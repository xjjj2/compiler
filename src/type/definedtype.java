package type;

import java.util.HashMap;
import java.util.Map;

import compilerNode.*;

public class definedtype extends defined{
	public Map<String,Variable> field;
	public Map<String,Function> method;
	public Function constructor;
	public boolean consetted;
	public definedtype(String name, node definenode) {
		super(name, definenode);
		setdefaultconstructor();
		field=new HashMap<String,Variable>();
		method=new HashMap<String,Function>();
		consetted=false;
	}
	public void setdefaultconstructor() {
		constructor=new Function(this.name,this.definenode);
		constructor.returnval=new ArrayorType();
		constructor.returnval.type=this;
		constructor.returnval.arraynum=0;
		constructor.ifvoid=false;
		consetted=false;
	}
	public definedtype() {
		super();
		consetted=false;
	}
	
}
