package visitor;

import java.util.*;

import Error.SemeticError;
import IR.*;
import compilerNode.Arraynode;
import compilerNode.Assignnode;
import compilerNode.AstRoot;
import compilerNode.Binarynode;
import compilerNode.Blocknode;
import compilerNode.Blockstatenode;
import compilerNode.Boolliteralnode;
import compilerNode.Boolnode;
import compilerNode.Breaknode;
import compilerNode.Charliteralnode;
import compilerNode.Classbodydec;
import compilerNode.Classbodynode;
import compilerNode.Classdecnode;
import compilerNode.Classnamenode;
import compilerNode.Continuenode;
import compilerNode.EmptyBlocknode;
import compilerNode.EmptyClassdecnode;
import compilerNode.Exprnode;
import compilerNode.Fielddecnode;
import compilerNode.Fornode;
import compilerNode.Funcallnode;
import compilerNode.Ifnode;
import compilerNode.Intliteralnode;
import compilerNode.Localvaridecnode;
import compilerNode.Membernode;
import compilerNode.Methodnode;
import compilerNode.Newnode;
import compilerNode.Nullnode;
import compilerNode.Postfixnode;
import compilerNode.Prefixnode;
import compilerNode.Primarynode;
import compilerNode.Returnnode;
import compilerNode.Seminode;
import compilerNode.SourcePosition;
import compilerNode.Stateexprnode;
import compilerNode.Stringliteralnode;
import compilerNode.Thisexprnode;
import compilerNode.Thisnode;
import compilerNode.Typenode;
import compilerNode.Vardeclaratornode;
import compilerNode.Vardeclaratorsnode;
import compilerNode.Variablenode;
import compilerNode.Voidnode;
import compilerNode.Whilenode;
import compilerNode.arraycreatenode;
import compilerNode.classcreaterestnode;
import compilerNode.constructordecnode;
import compilerNode.creatednamenode;
import compilerNode.creatornode;
import compilerNode.exprlistnode;
import compilerNode.forcontrolnode;
import compilerNode.forinitnode;
import compilerNode.formalparalistnode;
import compilerNode.formalparanode;
import compilerNode.formalparasnode;
import compilerNode.methoddec;
import compilerNode.node;
import type.*;

public class LinearIRconverter extends ASTBaseVisitor<Var> {
	public List<Quad> quadlist;
	public List<Conststring> contoplist;
	public List<Resarea> restoplist;
	public List<String> global;
	public Map<String,Label> Labels;
	public Map<Label,Function> lab2fun;
	public Map<node,Vari> reflect;
	public Map<String,Function> topfuncs;
	public Map<String,Variable> topvars;
	public Map<String,definedtype> classtype;
	public Stack<Label> contipt;
	public Stack<Label> breakpt;  
	public LinearIRconverter (Map<String,Function>topfuncs,Map<String,Variable> topvars,Map<String,definedtype> classtype) {
		quadlist=new ArrayList<>();
		contoplist=new ArrayList<>();
		restoplist=new ArrayList<>();
		global=new ArrayList<>();
		Labels=new HashMap<>();
		lab2fun=new HashMap<>();
		reflect=new HashMap<>();
		contipt=new Stack<Label>();
		breakpt=new Stack<Label>();
		this.topfuncs=topfuncs;
		this.topvars=topvars;
		this.classtype=classtype;
	}
	public boolean Assigning(node n){
		if (n.parent.getClass().equals(Assignnode.class)) return true;
		if (n.parent.getClass().equals(Prefixnode.class) && 
			(((Prefixnode)n.parent).prefix().equals("++") || ((Prefixnode)n.parent).prefix().equals("--")))
			return true;
		if (n.parent.getClass().equals(Postfixnode.class) && 
			(((Postfixnode)n.parent).postfix().equals("++") || ((Postfixnode)n.parent).postfix().equals("--")))
			return true;
		return false;
	}
	int labelcount=0;
	int stringcount=0;
	int tempnum=0;
	int functempnum;
	int initnum=0;
	int stringnum=0;
	definedtype nowClass;
	Function nowFunc;
	public boolean ifreturn;
	public void init() throws SemeticError {
		Label initl=newLabel("_init");
		initnum=0;
		insert(initl);
		Function init=new Function("_init",null);
		lab2fun.put(initl, init);
		quadtop().functionhead=true;
		for (Map.Entry<String, Variable> entry:topvars.entrySet()) {
			Variable v=entry.getValue();
			global.add(v.name);
			Resarea temp=new Resarea();
			temp.sz=8;
			temp.name=entry.getKey();
			restoplist.add(temp);
			reflect.put(v.definenode, temp);
			if (v.init!=null) {
				Var tmp=Visit(v.init);
				insert(new AssignQuad(temp,tmp));
			}
		}
		init.templong=initnum*8;
		insert(new Return());
		for (Map.Entry<String, definedtype> entry:classtype.entrySet()) {
			definedtype type=entry.getValue();
			int typelong=0;
			for (Map.Entry<String, Variable> e:type.field.entrySet()) {
				type.fieldoffset.put(e.getKey(), typelong);
				typelong+=8;
			}
			type.typelong=typelong;
		}
	}
	public Imm getimm(int i) {
		return new Imm(i);
	}
	public boolean ismem(Var i) {
		return (i.getClass().equals(Mem.class));
	}
	public Label newLabel() {
		labelcount++;
		String str="_Label"+String.valueOf(labelcount);
		Label lab=new Label(str);
		Labels.put(str, lab);
		return lab;
	}
	public Label newLabel(String str) {
		Label lab=new Label(str);
		Labels.put(str, lab);
		return lab;
	}
	public void pop() {
		contipt.pop();
		breakpt.pop();
	}
	public boolean ifint(ArrayorType type) {
		return (type.arraynum==0 && type.type.name.equals("int"));
	}
	public boolean ifbool(ArrayorType type) {
		return (type.arraynum==0 && type.type.name.equals("bool"));
	}
	public boolean ifstring(ArrayorType type) {
		return (type.arraynum==0 && type.type.name.equals("string"));
	}
	public boolean ifnull(ArrayorType type) {
		return (type.type.name.equals("null"));
	}
	public boolean ifsametype(ArrayorType type1,ArrayorType type2) {
		return (type1.type==type2.type && type1.arraynum==type2.arraynum);
	}
	public boolean ifimm(Var i) {
		return i.getClass().equals(Imm.class);
	}
	public Temp newtemp() {
		++functempnum;
		++tempnum;
		++initnum;
		return new Temp("_t"+String.valueOf(tempnum),getimm(-(functempnum-1)*8));
		
	}
	public Conststring newstring(String val) {
		++stringnum;
		Conststring str=new Conststring("_String"+String.valueOf(stringnum),val);
		contoplist.add(str);
		return str;
	}
	public Quad quadtop() {
		return quadlist.get(quadlist.size()-1);
	}
	public void insert(Quad q) {
		if (quadlist.size()!=0) {
			quadtop().next=q;
			q.prev=quadtop();
		}
		quadlist.add(q);
	}
	public Vari recnew(LinkedList<Var> exp) {
		Vari temp=newtemp();
		Vari tempmul=newtemp();
		Var x=exp.pollFirst();
		if (ifimm(x)) {
			Vari temp2=newtemp();
			insert(new AssignQuad(temp2,x));
			x=temp2;
		}
		insert(new BinaryQuad("+",x,getimm(1),tempmul));
		insert(new BinaryQuad("x",tempmul,getimm(8),tempmul));
		insert(new MallocQuad(temp,tempmul));
		insert(new AssignQuad(new Mem(temp),x));
		insert(new BinaryQuad("+",temp,getimm(8),temp));
		Vari temp2=newtemp();
		insert(new AssignQuad(temp2,temp));
		if (exp.size()>0) {
			Label lab1=newLabel();
			Label lab2=newLabel();
			insert(lab1);
			Vari temp3=recnew(exp);
			insert(new AssignQuad(new Mem(temp2),temp3));
			insert(new BinaryQuad("+",temp2,getimm(8),temp2));
			insert(new BinaryQuad("-",x,getimm(1),(Vari) x));
			insert(new CJumpQuad(x,lab1,lab2));
			insert(lab2);
		}
		return temp;
	}
	@Override
	public Var Visit(arraycreatenode node) throws SemeticError {
		return null;
	}

	@Override
	public Var Visit(Arraynode node) throws SemeticError {
		Var l=Visit(node.name);
		Var r=Visit(node.sub);
		if (ismem(l)) {Var temp=newtemp();insert(new AssignQuad(temp,l));l=temp;}
		if (ifimm(r)) {Var temp=newtemp();insert(new AssignQuad(temp,r));r=temp;}
		Mem mem=new Mem();
		mem.pos=(Vari)(l);
		mem.varoff=(Vari) r;
		mem.scale=8;
		if (Assigning(node))
			return mem;
		else {
			Var temp=newtemp();
			insert(new AssignQuad(temp,mem));
			return temp;
		}
	}

	@Override
	public Var Visit(Assignnode node) throws SemeticError {
		Var r=Visit(node.right);
		if (ismem(r)) {Var temp1=newtemp();insert(new AssignQuad(temp1,r));r=temp1;}
		Var l=Visit(node.left);
		insert(new AssignQuad(l,r));
		if (ismem(l)) {Var temp1=newtemp();insert(new AssignQuad(temp1,l));l=temp1;}
		return l;
	}

	@Override
	public Var Visit(AstRoot node) throws SemeticError {
		init();
		for (node i:node.childlist) {
			Visit(i);
		}
		return null;
	}

	@Override
	public Var Visit(Binarynode node) throws SemeticError {
		if (ifint(node.left.type)) {
			Var left=Visit(node.left);
			if (ismem(left)) {Var temp1=newtemp();insert(new AssignQuad(temp1,left));left=temp1;}
			Var right=Visit(node.right);
/*			if (ifimm(left) && ifimm(right)) {
				int a;
				if (node.opcode)
				((Imm)left).val+((Imm)right).val;
				return getimm(a);
			}
			else {*/
				BinaryQuad now=new BinaryQuad(left,right,newtemp());
				now.op=node.opcode;
				insert(now);
				return now.vardest;
//			}
		}
		else if (ifstring(node.left.type)){
			Var left=Visit(node.left);
			Var right=Visit(node.right);
			if (ismem(left)) {Var temp1=newtemp();insert(new AssignQuad(temp1,left));left=temp1;}
			if (ismem(right)) {Var temp1=newtemp();insert(new AssignQuad(temp1,right));right=temp1;}
			insert(new Param(left));
			insert(new Param(right));
			Vari temp=newtemp();
			if (node.opcode.equals("+")) insert(new Call(temp,"_Str_ADD",2));
			else 
			if (node.opcode.equals("<")) insert(new Call(temp,"_Str_LT",2));
			else
			if (node.opcode.equals("<=")) insert(new Call(temp,"_Str_LE",2));
			else
			if (node.opcode.equals(">")) insert(new Call(temp,"_Str_GT",2));
			else
			if (node.opcode.equals(">=")) insert(new Call(temp,"_Str_GE",2));
			else
			if (node.opcode.equals("==")) insert(new Call(temp,"_Str_EQ",2));
			else
			if (node.opcode.equals("!=")) insert(new Call(temp,"_Str_NE",2));
			return temp;
		}
		else { 
			Vari temp=newtemp();
			Var left=Visit(node.left);
			if (ismem(left)) {Var temp1=newtemp();insert(new AssignQuad(temp1,left));left=temp1;}
			Label rightlab=newLabel();
			Label shortcut=newLabel();
			Label notshortcut=newLabel();
			Label last=newLabel();
			CJumpQuad cjump=new CJumpQuad();
			cjump.par=left;
			if (node.opcode.equals("&&")) {
				cjump.Falselab=shortcut;
				cjump.Truelab=rightlab;
			}
			else {
				cjump.Falselab=rightlab;
				cjump.Truelab=shortcut;
			}
			insert(cjump);
			insert(rightlab);
			Var right=Visit(node.right);
			insert(new JumpQuad(notshortcut));
			insert(shortcut);
			insert(new AssignQuad(temp,left));
			insert(new JumpQuad(last));
			insert(notshortcut);
			insert(new BinaryQuad(node.opcode,left,right,temp));
			insert(last);
			return temp;
		}
	}

	@Override
	public Var Visit(Blocknode node) throws SemeticError {
		for (Blockstatenode i:node.statements) {
			Visit(i);
		}
		return null;
	}

	@Override
	public Var Visit(Blockstatenode node) throws SemeticError {
		Visit(node.child);
		return null;
	}

	@Override
	public Var Visit(Boolliteralnode node) {
		int i;
		if (node.isB()) i=1;
		else i=0;
		return new Imm(i);
	}

	@Override
	public Var Visit(Boolnode node) {
		return null;
	}

	@Override
	public Var Visit(Breaknode node) throws SemeticError {
		insert(new JumpQuad(breakpt.peek()));
		return null;
	}

	@Override
	public Var Visit(Charliteralnode node) {
		return new Imm(node.getC());
	}

	@Override
	public Var Visit(Classbodydec node) throws SemeticError {
		Visit(node.member);
		return null;
	}

	@Override
	public Var Visit(Classbodynode node) throws SemeticError {
		for (Classbodydec i:node.statement)
			Visit(i);
		return null;
	}

	@Override
	public Var Visit(classcreaterestnode node) {
		return null;
	}

	@Override
	public Var Visit(Classdecnode node) throws SemeticError {
		nowClass=node.classtype;
		Visit(node.body);
		nowClass=null;
		return null;
	}

	@Override
	public Var Visit(Classnamenode node) {
		return null;
	}

	@Override
	public Var Visit(constructordecnode node) throws SemeticError {
		functempnum=0;
		nowFunc=nowClass.constructor;
		ifreturn=false;
		String str="_cons"+nowClass.name;
		global.add(str);
		insert(newLabel(str));
		lab2fun.put((Label) quadtop(), nowFunc);
		Temp temp=newtemp();
		reflect.put(node, temp);
		topfuncs.put(str, nowFunc);
		nowFunc.ifmethod=true;
		nowFunc.temps.add(temp);
		quadtop().functionhead=true;
		Visit(node.block);
		nowFunc.templong=functempnum;
		nowFunc=null;
		if (!ifreturn) insert(new Return());
		return null;
	}

	@Override
	public Var Visit(Continuenode node) throws SemeticError {
		insert(new JumpQuad(contipt.peek()));
		return null;
	}

	@Override
	public Var Visit(creatednamenode node) throws SemeticError {
		return null;
	}

	@Override
	public Var Visit(creatornode node) throws SemeticError {
		if (node.createrest.getClass().equals(classcreaterestnode.class)) {
			Var temp=newtemp();
			insert(new MallocQuad(temp,getimm(node.name.type.typelong)));
			insert(new Param(temp));
			insert(new Call(null,"_cons"+nowClass.name,1));
			return temp;
		}
		else {
			arraycreatenode array=(arraycreatenode) node.createrest;
			LinkedList<Var> exp=new LinkedList<Var>();
			for (int i=0;i<array.exprs.size();++i) {
				exp.addLast(Visit(array.exprs.get(i)));
			}
			return recnew(exp);
		}
	}

	@Override
	public Var Visit(EmptyBlocknode node) {
		return null;
	}

	@Override
	public Var Visit(EmptyClassdecnode node) {
		return null;
	}

	@Override
	public Var Visit(exprlistnode node) throws SemeticError {
		for (Exprnode i:node.child)
			Visit(i);
		return null;
	}

	@Override
	public Var Visit(Fielddecnode node) throws SemeticError {
		return null;
	}

	@Override
	public Var Visit(forcontrolnode node) throws SemeticError {
		return null;
	}

	@Override
	public Var Visit(forinitnode node) throws SemeticError {
		return null;
	}

	@Override
	public Var Visit(formalparalistnode node) throws SemeticError {
		for (formalparanode i:node.para) {
			Visit(i);
		}
		return null;
	}

	@Override
	public Var Visit(formalparanode node) throws SemeticError {
		Temp temp=newtemp();
		nowFunc.temps.add(temp);
		reflect.put(node, temp);
		return null;
	}

	@Override
	public Var Visit(formalparasnode node) throws SemeticError {
		Visit(node.paras);
		return null;
	}

	@Override
	public Var Visit(Fornode node) throws SemeticError {
		if (node.con.init!=null)
			Visit(node.con.init);
		Label begin=newLabel();
		Label Truelab=newLabel();
		Label conduct=newLabel();
		Label Falselab=newLabel();
		contipt.push(conduct);
		breakpt.push(Falselab);
		insert(begin);
		Var par;
		if (node.con.parexpr!=null)
			par=Visit(node.con.parexpr);
		else par=getimm(1);
		CJumpQuad now1=new CJumpQuad();
		now1.par=par;
		insert(now1);
		insert(Truelab);
		now1.Truelab=Truelab;
		Visit(node.statement);
		insert(conduct);
		if (node.con.exprlist!=null)
			Visit(node.con.exprlist);
		JumpQuad j=new JumpQuad();
		j.label=begin;
		insert(j);
		insert(Falselab);
		now1.Falselab=Falselab;
		pop();
		return null;
	}

	@Override
	public Var Visit(Funcallnode node) throws SemeticError {
		if (!node.ifmethod) {
			List<Exprnode> t=node.exprlist.child;
			for (int i=0;i<t.size();++i) {
				Var left=Visit(t.get(i));
				if (ismem(left)) {Var temp1=newtemp();insert(new AssignQuad(temp1,left));left=temp1;}
				insert(new Param(left));
			}
			Vari temp=newtemp();
			insert(new Call(temp,node.func.name,t.size()));
			return temp;
		}
		else {
			insert(new Param(nowFunc.temps.get(0)));
			List<Exprnode> t=node.exprlist.child;
			for (int i=0;i<t.size();++i) {
				Var left=Visit(t.get(i));
				if (ismem(left)) {Var temp1=newtemp();insert(new AssignQuad(temp1,left));left=temp1;}
				insert(new Param(left));
			}
			Vari temp=newtemp();
			insert(new Call(temp,"_"+node.func.name+"_"+nowClass.name,t.size()+1));
			return temp;
		}
	}

	@Override
	public Var Visit(Ifnode node) throws SemeticError {
		Var par=Visit(node.parexpr);
		CJumpQuad now1=new CJumpQuad();
		now1.par=par;
		insert(now1);
		Label Truelab=newLabel();
		insert(Truelab);
		now1.Truelab=Truelab;
		Visit(node.ifstatement);
		Label Falselab=newLabel();
		insert(Falselab);
		now1.Falselab=Falselab;
		if (node.ifelse) {
			Visit(node.elsestatement);
		}
		return null;
	}

	@Override
	public Var Visit(Intliteralnode node) {
		return new Imm(node.getVal());
	}

	@Override
	public Var Visit(Localvaridecnode node) throws SemeticError {
		if (nowFunc!=null)
			Visit(node.id);
		return null;
	}

	@Override
	public Var Visit(Membernode node) throws SemeticError {
		Vari l=(Vari) Visit(node.expr);
		int offset=((definedtype)node.expr.type.type).fieldoffset.get(node.identifier.id);
		Mem mem=new Mem(l,getimm(offset));
		if (Assigning(node)) return mem;
		else {
			Var temp=newtemp();
			insert(new AssignQuad(temp,mem));
			return temp;
		}
	}

	@Override
	public Var Visit(methoddec node) throws SemeticError {
		functempnum=0;
		nowFunc=node.func;
		ifreturn=false;
		if (nowClass==null) {
			global.add(node.func.name);
			insert(newLabel(node.func.name));
			lab2fun.put((Label) quadtop(), node.func);
			quadtop().functionhead=true;
			if (nowFunc.name.equals("main")) insert(new Call(null,"_init",0));
		}
		else {
			String str="_"+node.func.name+"_"+nowClass.name;
			global.add(str);
			insert(newLabel(str));
			lab2fun.put((Label) quadtop(), node.func);
			Temp temp=newtemp();
			reflect.put(node, temp);
			topfuncs.put(str, nowFunc);
			nowFunc.ifmethod=true;
			nowFunc.temps.add(temp);
			quadtop().functionhead=true;
		}
		Visit(node.attribute);
		for (int i=0;i<nowFunc.temps.size();++i) {
			if (i>=6) {
				nowFunc.temps.get(i).offset=getimm((i-4)*8);
			}
		}
		if (functempnum>6) functempnum=6;
		Visit(node.body);
		nowFunc.templong=functempnum;
		nowFunc=null;
		if (!ifreturn) insert(new Return());
		return null;
	}

	@Override
	public Var Visit(Methodnode node) throws SemeticError {
		Vari object=(Vari) Visit(node.expr);
		if (!node.method.name.equals("size")) {
			List<Exprnode> t=node.method.exprlist.child;
			insert(new Param(object));
			for (int i=0;i<t.size();++i) {
				Var left=Visit(t.get(i));
				if (ismem(left)) {Var temp1=newtemp();insert(new AssignQuad(temp1,left));left=temp1;}
				insert(new Param(left));
			}
			Vari temp=newtemp();
			insert(new Call(temp,"_"+node.method.func.name+"_"+node.expr.type.name,t.size()));
			return temp;
		}
		else {
			Var temp=newtemp();
			Var mem=new Mem(object,getimm(-8));
			insert(new AssignQuad(temp,mem));
			return temp;
		}
	}

	@Override
	public Var Visit(Newnode node) throws SemeticError {
		return Visit(node.creator);
	}

	@Override
	public Var Visit(Nullnode node) {
		return getimm(0);
	}

	@Override
	public Var Visit(Postfixnode node) throws SemeticError {
		Var a=Visit(node.getexpr());
		Vari temp=newtemp();
		if (node.postfix().equals("++")||node.postfix().equals("--")) {
			if (!ismem(a)) {
				Quad now1=new AssignQuad(temp,a);
				insert(now1);
				BinaryQuad now2=new BinaryQuad(a,getimm(1),(Vari) a);
				if (node.postfix().equals("++")) now2.op="+";
				else now2.op="-";
				insert(now2);
			}
			else {
				Vari temp2=newtemp();
				insert(new AssignQuad(temp2,a));
				insert(new AssignQuad(temp,a));
				BinaryQuad now=new BinaryQuad(temp2,getimm(1),temp2);
				if (node.postfix().equals("++")) now.op="+";
				else now.op="-";
				insert(now);
				insert(new AssignQuad(a,temp2));
			}
		}
		else {
			Quad now=new UniQuad(a,temp,node.postfix());
			insert(now);
		}
		return temp;
	}

	@Override
	public Var Visit(Prefixnode node) throws SemeticError {
		Var a=Visit(node.getexpr());
		if (node.prefix().equals("++")||node.prefix().equals("--")) {
			if (!ismem(a)) {
				BinaryQuad now=new BinaryQuad(a,getimm(1),(Vari) a);
				if (node.prefix().equals("++")) now.op="+";
				else now.op="-";
				insert(now);
				return a;
			}//to be optim by inc/dec
			else {
				Vari temp=newtemp();
				insert(new AssignQuad(temp,a));
				BinaryQuad now=new BinaryQuad(temp,getimm(1),temp);
				if (node.prefix().equals("++")) now.op="+";
				else now.op="-";
				insert(now);
				insert(new AssignQuad(a,temp));
				return temp;
			}
		}
		else {
			Vari temp=newtemp();
			Quad now=new UniQuad(a,temp,node.prefix());
			insert(now);
			return temp;
		}
	}

	@Override
	public Var Visit(Primarynode node) throws SemeticError {
		return Visit(node.expr);
	}

	@Override
	public Var Visit(Returnnode node) throws SemeticError {
		ifreturn=true;
		Var v=null;
		if (node.expr!=null)
			v=Visit(node.expr);
		insert(new Return(v));
		return null;
	}

	@Override
	public Var Visit(Seminode node) {
		return null;
	}

	@Override
	public Var Visit(SourcePosition node) {
		return null;
	}

	@Override
	public Var Visit(Stateexprnode node) throws SemeticError {
		Visit(node.getExpr());
		return null;
	}

	@Override
	public Var Visit(Stringliteralnode node) {
		Vari temp=newtemp();
		insert(new AssignQuad(temp,newstring(node.getS())));
		insert(new BinaryQuad("+",temp,getimm(8),temp));
		return temp;
	}

	@Override
	public Var Visit(Thisexprnode node) throws SemeticError {
		return null;
	}

	@Override
	public Var Visit(Thisnode node) throws SemeticError {
		return reflect.get(nowFunc.definenode);
	}

	@Override
	public Var Visit(Typenode node) throws SemeticError {
		return null;
	}

	@Override
	public Var Visit(Vardeclaratornode node) throws SemeticError {
		Vari tar=newtemp();
		if (node.init!=null) {
			Var t=Visit(node.init);
			insert(new AssignQuad(tar,t));
			reflect.put(node,tar);
		}
		else {
			reflect.put(node,tar);
		}
		return null;
	}

	@Override
	public Var Visit(Vardeclaratorsnode node) throws SemeticError {
		for (Vardeclaratornode i:node.vardecs) {
			Visit(i);
		}
		return null;
	}

	@Override
	public Var Visit(Variablenode node) throws SemeticError {
		if (!node.isfield) {
			return reflect.get(node.vardef.definenode);
		}
		else {
			Vari l=reflect.get(nowFunc.definenode);
			int offset=nowClass.fieldoffset.get(node.id);
			if (ismem(l)) {Vari temp=newtemp();insert(new AssignQuad(temp,l));l=temp;}
			Mem mem=new Mem(l,getimm(offset));
			if (Assigning(node))  
				return mem;
			else {
				Var temp=newtemp();
				insert(new AssignQuad(temp,mem));
				return temp;
			}
		}
	}

	@Override
	public Var Visit(Voidnode node) {
		return null;
	}

	@Override
	public Var Visit(Whilenode node) throws SemeticError {
		Label begin=newLabel();
		Label Truelab=newLabel();
		Label Falselab=newLabel();
		contipt.push(Truelab);
		breakpt.push(Falselab);
		insert(begin);
		Var par=Visit(node.parexpr);
		CJumpQuad now1=new CJumpQuad();
		now1.par=par;
		insert(now1);
		insert(Truelab);
		now1.Truelab=Truelab;
		Visit(node.statement);
		JumpQuad j=new JumpQuad();
		j.label=begin;
		insert(j);
		insert(Falselab);
		now1.Falselab=Falselab;
		pop();
		return null;
	}
	
}
