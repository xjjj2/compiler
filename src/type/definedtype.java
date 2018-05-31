package type;

import java.util.HashMap;
import java.util.Map;

import compilerNode.*;

public class definedtype extends defined{
	public Map<String,Variable> field;
	public Map<String,Function> method;
	public Map<String,Integer> fieldoffset;
	public Function constructor;
	public int typelong;
	public boolean consetted;
	public definedtype(String name, node definenode) {
		super(name, definenode);
		setdefaultconstructor();
		field=new HashMap<String,Variable>();
		method=new HashMap<String,Function>();
		fieldoffset=new HashMap<>();
		consetted=false;
		typelong=0;
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
		setdefaultconstructor();
		consetted=false;
		typelong=0;
		field=new HashMap<String,Variable>();
		method=new HashMap<String,Function>();
		fieldoffset=new HashMap<>();
	}
	
}
