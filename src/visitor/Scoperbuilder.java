package visitor;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;

import Error.SemeticError;
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
import compilerNode.Intnode;
import compilerNode.LHSnode;
import compilerNode.Literalnode;
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
import compilerNode.Statementnode;
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
import compilerNode.createdrestnode;
import compilerNode.creatornode;
import compilerNode.exprlistnode;
import compilerNode.forcontrolnode;
import compilerNode.forinitnode;
import compilerNode.formalparalistnode;
import compilerNode.formalparanode;
import compilerNode.formalparasnode;
import compilerNode.methoddec;
import compilerNode.node;
import type.ArrayorType;
import type.Function;
import type.Variable;
import type.defined;
import type.definedtype;

public class Scoperbuilder extends ASTBaseVisitor<defined> {
	public Map<String,definedtype> classtype;
	public Map<String,Function> topfuncs;
	public TopScope top;
	public Stack<Scope> scoper;
	public ArrayorType aint;
	public ArrayorType abool;
	public ArrayorType astring;
	public Fornode nowFor;
	public Variable SearchforVar(Scope sp,String id) throws SemeticError {
		if (sp.parent!=null) {
			if (!sp.variable.containsKey(id)) {
				if (!sp.method.containsKey(id)){
					return SearchforVar(sp.parent,id);
				}
				else throw new SemeticError();
			}
			else return sp.variable.get(id);
		}
		else {
			if (!sp.variable.containsKey(id)) {
				if (!sp.method.containsKey(id)){
					return null;
				}
				else throw new SemeticError();
			}
			else return sp.variable.get(id);
		}
	}
	public Scoperbuilder(Map<String, definedtype> classtype, Map<String, Function> topfuncs, TopScope top) {
		super();
		this.classtype = classtype;
		this.topfuncs = topfuncs;
		this.top = top;
		scoper=new Stack<Scope>();
		scoper.push(top);
		aint=new ArrayorType("int",null,classtype.get("int"),0);
		abool=new ArrayorType("bool",null,classtype.get("bool"),0);
		astring=new ArrayorType("string",null,classtype.get("string"),0);
		nowClass=null;
		nowFunc=null;
	}
	public void push() {
		localScope local=new localScope();
		local.parent=scoper.peek();
		scoper.peek().child.add(local);
		scoper.push(local);
	}
	public void pop() {
		scoper.pop();
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
	public boolean assignable(ArrayorType type1,ArrayorType type2) {
		return (ifsametype(type1,type2)  || !ifnull(type1)&&!ifint(type1)&&!ifbool(type1)&&!ifstring(type1)&&ifnull(type2));
	}
	public definedtype nowClass;
	public Function nowFunc;
	@Override
	public defined Visit(arraycreatenode node) throws SemeticError {
		node.scope=scoper.peek();
		for (Exprnode expr:node.exprs) {
			ArrayorType type=(ArrayorType) Visit(expr);
			if(!ifint(type)) throw new SemeticError();
		}
		return new ArrayorType(null,node.num);
	}
	
	@Override
	public defined Visit(Arraynode node) throws SemeticError {
		ArrayorType type=(ArrayorType) Visit(node.name);
		node.iflhs=true;
		node.type=new ArrayorType(type.type,type.arraynum-1);
		node.scope=scoper.peek();
		if (node.type.arraynum<0) throw new SemeticError("array too long");
		ArrayorType type2=(ArrayorType)Visit(node.sub);
		if (!type2.name.equals("int") || type2.arraynum>0) throw new SemeticError("array attr is not int");
		return node.type;
	}
	@Override
	public defined Visit(Assignnode node) throws SemeticError {
		node.scope=scoper.peek();
		node.iflhs=false;
		ArrayorType type1=(ArrayorType) Visit(node.left);
		node.type=type1;
		if (!node.left.iflhs) throw new SemeticError("LHS error");
		ArrayorType type2=(ArrayorType) Visit(node.right);
		if (!(ifsametype(type1,type2)  || !ifnull(type1)&&!ifint(type1)&&!ifbool(type1)&&!ifstring(type1)&&ifnull(type2))) 
			throw new SemeticError("Assigning dismatched");
		return type1;
	}
	@Override
	public defined Visit(AstRoot node) throws SemeticError {
		node.scope=scoper.peek();
		for (node i:node.childlist) {
			Visit(i);
		}
		return null;
	}
	@Override
	public defined Visit(Binarynode node) throws SemeticError {
		node.iflhs=false;
		node.scope=scoper.peek();
		ArrayorType type1=(ArrayorType) Visit(node.left);
		ArrayorType type2=(ArrayorType) Visit(node.right);
		if (node.opcode.equals("*")||
			node.opcode.equals("/")||
			node.opcode.equals("%")||
			node.opcode.equals("-")||
			node.opcode.equals("<<")||
			node.opcode.equals(">>")||
			node.opcode.equals("&")||
			node.opcode.equals("^")||
			node.opcode.equals("|")
			) {
			if (!ifint(type1) || !ifint(type2)) throw new SemeticError();
			node.type=type1;
		}
		else if(node.opcode.equals("+")) {
			if ((!ifint(type1) || !ifint(type2)) && (!ifstring(type1) || !ifstring(type2))) 
				throw new SemeticError();
			node.type=type1;
		}
		else if(node.opcode.equals("<=")||
				node.opcode.equals(">=")||
				node.opcode.equals("<")||
				node.opcode.equals(">"))
				{
			if ((!ifint(type1) || !ifint(type2)) && (!ifstring(type1) || !ifstring(type2))) 
				throw new SemeticError();
			node.type=abool;
		}
		else if(node.opcode.equals("==")||
				node.opcode.equals("!=")) {
			if (!assignable(type1,type2))
				throw new SemeticError();
			node.type=abool;
		}
		else {
			if (!ifbool(type1) || !ifbool(type2)) throw new SemeticError();
			node.type=abool;
		}
		return node.type;
	}
	@Override
	public defined Visit(Blocknode node) throws SemeticError {
		if (!node.parent.getClass().equals(Fornode.class) && !node.parent.getClass().equals(methoddec.class))	push();
		for (Blockstatenode i:node.statements)
			Visit(i);
		node.scope=scoper.peek();
		if (!node.parent.getClass().equals(Fornode.class) && !node.parent.getClass().equals(methoddec.class)) pop();
		return null;
	}
	@Override
	public defined Visit(Blockstatenode node) throws SemeticError {
		node.scope=scoper.peek();
		Visit(node.child);
		return null;
	}
	@Override
	public defined Visit(Boolliteralnode node) {
		node.iflhs=false;
		node.scope=scoper.peek();
		node.type=abool;
		return node.type;
	}
	@Override
	public defined Visit(Boolnode node) {
		node.scope=scoper.peek();
		return null;
	}
	@Override
	public defined Visit(Breaknode node) {
		node.scope=scoper.peek();
		return null;
	}
	@Override
	public defined Visit(Charliteralnode node) {
		node.scope=scoper.peek();
		return null;
	}
	@Override
	public defined Visit(Classbodydec node) throws SemeticError {
		node.scope=scoper.peek();
		Visit(node.member);
		return null;
	}
	@Override
	public defined Visit(Classbodynode node) throws SemeticError {
		node.scope=scoper.peek();
		for (Classbodydec i:node.statement) {
			Visit(i);
		}
		return null;
	}
	@Override
	public defined Visit(classcreaterestnode node) {
		node.scope=scoper.peek();
		return new ArrayorType(null,0);
	}
	@Override
	public defined Visit(Classdecnode node) throws SemeticError {
		push();
		node.scope=scoper.peek();
		for (Map.Entry<String, Function> entry:node.classtype.method.entrySet()) {
			node.scope.method.put(entry.getKey(), entry.getValue());
		}
		for (Map.Entry<String, Variable> entry:node.classtype.field.entrySet()) {
			node.scope.variable.put(entry.getKey(), entry.getValue());
		}
		nowClass=node.classtype;
		Visit(node.body);
		pop();
		nowClass=null;
		return null;
	}
	@Override
	public defined Visit(Classnamenode node) {
		node.scope=scoper.peek();
		return null;
	}
	@Override
	public defined Visit(constructordecnode node) throws SemeticError {
		node.scope=scoper.peek();
		nowFunc=node.type.constructor;
		Visit(node.block);
		nowFunc=null;
		return null;
	}
	@Override
	public defined Visit(Continuenode node) throws SemeticError {
		if (nowFor==null) throw new SemeticError("nothing to continue");
		return null;
	}
	@Override
	public defined Visit(creatednamenode node) throws SemeticError {
		node.scope=scoper.peek();
		node.type=classtype.get(node.name);
		if (node.type==null) throw new SemeticError();
		return node.type;
	}
	@Override
	public defined Visit(creatornode node) throws SemeticError {
		node.scope=scoper.peek();
		definedtype typename=(definedtype) Visit(node.name);
		ArrayorType typelong=(ArrayorType) Visit(node.createrest);
		if (typelong==null) typelong=new ArrayorType();
		return new ArrayorType(typename,typelong.arraynum);
	}
	@Override
	public defined Visit(EmptyBlocknode node) {
		return null;
	}
	@Override
	public defined Visit(EmptyClassdecnode node) {
		return null;
	}
	@Override
	public defined Visit(exprlistnode node) throws SemeticError{
		for (Exprnode i:node.child) Visit(i);
		return null;
	}
	@Override
	public defined Visit(Fielddecnode node) throws SemeticError {
		ArrayorType type=Visit(node.type);
		for (Vardeclaratornode var:node.vars.vardecs) {
			if (var.init!=null) {
				ArrayorType type2=(ArrayorType) Visit(var.init);
				if(!assignable(type,type2)) throw new SemeticError();
			}
		}
		return null;
	}
	@Override
	public defined Visit(forcontrolnode node) throws SemeticError {
		if (node.init!=null)
			Visit(node.init);
		if (node.exprlist!=null)
			Visit(node.exprlist);
		if (node.parexpr!=null) {
			if (!ifbool((ArrayorType) Visit(node.parexpr))) throw new SemeticError("par not bool");
		}
		return null;
	}
	@Override
	public defined Visit(forinitnode node) throws SemeticError {
		Visit(node.expr);
		return null;
	}
	@Override
	public defined Visit(formalparalistnode node) throws SemeticError {
		for (formalparanode i:node.para) {
			Visit(i);
		}
		return null;
	}
	@Override
	public defined Visit(formalparanode node) throws SemeticError {
		ArrayorType type=Visit(node.type);
		Scope sp=scoper.peek();
		String id=node.var.id;
		if (sp.variable.containsKey(id)) throw new SemeticError();
		sp.variable.put(id,new Variable(id,node, type,null));
		return null;
	}
	@Override
	public defined Visit(formalparasnode node) throws SemeticError {
		Visit(node.paras);
		return null;
	}
	@Override
	public defined Visit(Fornode node) throws SemeticError {
		node.scope=scoper.peek();
		nowFor=node;
		push();
		Visit(node.con);
		pop();
		nowFor=null;
		return null;
	}
	@Override
	public defined Visit(Funcallnode node) throws SemeticError {
		node.iflhs=false;
		node.scope=scoper.peek();
		node.func=SearchforFunc(node.scope,node.name);
		if (node.func==null) throw new SemeticError("no such func");
		if (node.func.attribute.size()!=node.exprlist.child.size()) throw new SemeticError("no such func");
		for (int i=0;i<node.func.attribute.size();++i) {
			ArrayorType type=(ArrayorType) Visit(node.exprlist.child.get(i));
			if (!assignable(node.func.attribute.get(i).type,type)) throw new SemeticError("wrong attribute");
		}
		node.type=node.func.returnval;
		return node.func.returnval;
	}
	public Function SearchforFunc(Scope scope, String name) throws SemeticError {
		if (scope.parent!=null) {
			if (!scope.method.containsKey(name)) {
				if (!scope.variable.containsKey(name)){
					return SearchforFunc(scope.parent,name);
				}
				else throw new SemeticError();
			}
			else return scope.method.get(name);
		}
		else {
			if (!scope.method.containsKey(name)){
				if (!scope.variable.containsKey(name)){
					return null;
				}
				else throw new SemeticError();
			} 
			else return scope.method.get(name);
		}
	}
	@Override
	public defined Visit(Ifnode node) throws SemeticError {
		node.scope=scoper.peek();
		ArrayorType par=(ArrayorType) Visit(node.parexpr);
		if (!ifbool(par)) throw new SemeticError("if par not bool");
		Visit(node.ifstatement);
		if (node.ifelse)
			Visit(node.elsestatement);
		return null;
	}
	@Override
	public defined Visit(Intliteralnode node) {
		node.iflhs=false;
		node.type=aint;
		return aint;
	}
	@Override
	public defined Visit(Localvaridecnode node) throws SemeticError {
		node.scope=scoper.peek();
		Scope sp=node.scope;
		ArrayorType type=Visit(node.type);
		for(Vardeclaratornode i:node.id.vardecs) {
			if (sp.variable.containsKey(i.id.id)||sp.method.containsKey(i.id.id)) throw new SemeticError();
			if (i.init!=null) {
				if (!assignable(type,(ArrayorType) Visit(i.init)))
					throw new SemeticError("varinit not correct");
			}
			
			sp.variable.put(i.id.id, new Variable(i.id.id,node,type,i.init));
		}
		return null;
	}
	@Override
	public defined Visit(Membernode node) throws SemeticError {
		node.scope=scoper.peek();
		ArrayorType type=(ArrayorType) Visit(node.expr);
		if (type.arraynum>0) throw new SemeticError("array has no member");
		node.iflhs=node.expr.iflhs;
		String id=node.identifier.id;
		Variable get=type.type.field.get(id);
		if (get==null) throw new SemeticError("no such member");
		node.type=get.type;
		return node.type;
	}
	@Override
	public defined Visit(methoddec node) throws SemeticError {
		node.scope=scoper.peek();
		node.scope.method.put(node.name, node.func);
		nowFunc=node.func;
		push();
		Visit(node.attribute);
		Visit(node.body);
		pop();
		nowFunc=null;
		return null;
	}
	@Override
	public defined Visit(Methodnode node) throws SemeticError {
		node.scope=scoper.peek();
		node.iflhs=false;
		ArrayorType type=(ArrayorType) Visit(node.expr);
		Funcallnode id=node.method;
		if (type.arraynum>0) { 
			if (!id.name.equals("size")||!(id.exprlist.child.size()==0))
			throw new SemeticError("array has no method");
			else node.type=aint;
		}
		else {
			Function get=type.type.method.get(id.name);
			if (get==null) throw new SemeticError("no such method");
			if (get.attribute.size()!=id.exprlist.child.size()) throw new SemeticError("no such method");
			for (int i=0;i<get.attribute.size();++i) {
				if (!ifsametype(get.attribute.get(i).type,(ArrayorType) Visit(id.exprlist.child.get(i))))
					throw new SemeticError("no such method");
			}
			id.func=get;
			node.type=get.returnval;
		}
		return node.type;
	}
	@Override
	public defined Visit(Newnode node) throws SemeticError {
		node.scope=scoper.peek();
		node.iflhs=false;
		node.type=(ArrayorType) Visit(node.creator);
		return node.type;
	}
	@Override
	public defined Visit(Nullnode node) {
		node.scope=scoper.peek();
		return new ArrayorType(classtype.get("null"),0);
	}
	@Override
	public defined Visit(Postfixnode node) throws SemeticError {
		node.scope=scoper.peek();
		node.iflhs=false;
		ArrayorType type=(ArrayorType) Visit(node.getexpr());
		node.type=type;
		if (!ifint(type)) throw new SemeticError();
		return type;
	}
	@Override
	public defined Visit(Prefixnode node) throws SemeticError {
		node.scope=scoper.peek();
		node.iflhs=false;
		ArrayorType type=(ArrayorType) Visit(node.getexpr());
		node.type=type;
		if (!ifint(type)) throw new SemeticError();
		return type;
	}
	@Override
	public defined Visit(Primarynode node) throws SemeticError{
		node.scope=scoper.peek();
		node.type=(ArrayorType) Visit(node.expr);
		node.iflhs=node.expr.iflhs;
		return node.type;
	}
	@Override
	public defined Visit(Returnnode node) throws SemeticError {
		node.scope=scoper.peek();
		if (node.expr!=null) {
			ArrayorType type=(ArrayorType) Visit(node.expr);
			if (!assignable(nowFunc.returnval,type)) throw new SemeticError();
		}
		else {
			if(!nowFunc.ifvoid) {
				throw new SemeticError();
			}
		}
		return null;
	}
	@Override
	public defined Visit(Seminode node) {
		return null;
	}
	@Override
	public defined Visit(SourcePosition node) {
		return null;
	}
	@Override
	public defined Visit(Stateexprnode node)throws SemeticError {
		Visit(node.getExpr());
		return null;
	}
	@Override
	public defined Visit(Stringliteralnode node) {
		node.scope=scoper.peek();
		node.iflhs=false;
		node.type=astring;
		return node.type;
	}
	@Override
	public defined Visit(Thisexprnode node) {
		return null;
	}
	@Override
	public defined Visit(Thisnode node) throws SemeticError {
		node.iflhs=true;
		node.classtype=nowClass;
		node.scope=scoper.peek();
		if (nowClass==null) throw new SemeticError("This not in class");
		else node.type=new ArrayorType(nowClass,0);
		return node.type;
	}
	@Override
	public ArrayorType Visit(Typenode node) throws SemeticError {
		node.scope=scoper.peek();
		node.type.type=classtype.get(node.type.getName());
		if (node.type.type==null) throw new SemeticError("no such type");
		return node.type;
	}
	@Override
	public defined Visit(Vardeclaratornode node) {
		return null;
	}
	@Override
	public defined Visit(Vardeclaratorsnode node) {
		return null;
	}
	@Override
	public defined Visit(Variablenode node) throws SemeticError {
		node.scope=scoper.peek();
		node.iflhs=true;
		node.vardef=SearchforVar(scoper.peek(),node.id);
		if (node.vardef==null) throw new SemeticError();
		node.type=node.vardef.type;
		return node.vardef.type;
	}
	@Override
	public defined Visit(Voidnode node) {
		node.scope=scoper.peek();
		return null;
	}
	@Override
	public defined Visit(Whilenode node) throws SemeticError {
		node.scope=scoper.peek();
		ArrayorType type=(ArrayorType) Visit(node.parexpr);
		Visit(node.statement);
		if (!ifbool(type)) throw new SemeticError();
		return null;
	}
	
}
