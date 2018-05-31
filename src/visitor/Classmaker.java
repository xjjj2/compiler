package visitor;


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

import java.util.*;

import org.antlr.v4.misc.Graph.Node;
import type.*;
import Error.SemeticError;
public class Classmaker extends ASTBaseVisitor<defined>{
	public Map<String,definedtype> classtype;
	public Map<String,Function> Topfunctions;
	public Function nowFunc;
/*	public Stack<Scope> Scoper;
	public TopScope Top;
	public void push() {
		if (Scoper.size()!=0) {
			localScope sp=new localScope();
			sp.parent=Scoper.peek();
			sp.parent.child.add(sp);
			Scoper.push(sp);
		}
		else {
			Top=new TopScope();
			Scoper.push(Top);
		}
			
	}
	public void pop() {
		Scoper.pop();
	}*/
	public Classmaker(Map<String, definedtype> classtype,Map<String,Function> funcs) {
		super();
		this.classtype = classtype;
		Topfunctions=funcs;
	//	Scoper=new Stack<Scope>();
	}

	@Override
	public defined Visit(arraycreatenode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public defined Visit(Arraynode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public defined Visit(Assignnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public defined Visit(AstRoot node) throws SemeticError {
//		push();
		for (int i=0;i<node.childlist.size();++i) {
			node t=node.childlist.get(i);
			if (t!=null) {
				if (t.getClass().equals(Classdecnode.class))
					Visit(t);
				else if (t.getClass().equals(methoddec.class)) {
					Visit(t);
				}
				else Visit(t);
			}
		}
		return null;
	}

	@Override
	public defined Visit(Binarynode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public defined Visit(Blocknode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public defined Visit(Blockstatenode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public defined Visit(Boolliteralnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public defined Visit(Boolnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public defined Visit(Breaknode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public defined Visit(Charliteralnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public defined Visit(Classbodydec node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public defined Visit(Classbodynode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public defined Visit(classcreaterestnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public defined Visit(Classdecnode node) throws SemeticError{
		// TODO Auto-generated method stub
/*		push();
		localScope scope=(localScope) Scoper.peek();*/
		definedtype builder=classtype.get(node.classname);
		Classbodynode body=node.body;
		List<Classbodydec> list=body.statement; 
		boolean ifcons=false;
		for (Classbodydec dec:list) {
//			dec.member.setScope(scope);
			if (dec.member.getClass().equals(Fielddecnode.class)) {
				Fielddecnode field=(Fielddecnode)(dec.member);
				for (Vardeclaratornode vars:field.vars.vardecs) {
					Variable variable=new Variable(vars.id.id,vars);
					definedtype type=classtype.get(field.type.name);
					if (type==null) throw new SemeticError("Field with no such type");
					else field.type.type.type=type;
					variable.type=field.type.type;
					variable.init=vars.init;
//					variable.scope=scope;
					
					if (builder.field.containsKey(variable.getName())) {
						throw new SemeticError("Duplicated Fields");
					}
					builder.field.put(vars.id.id, variable);
				}
			}
			else if(dec.member.getClass().equals(constructordecnode.class)) {
				if (ifcons) throw new SemeticError();
				constructordecnode consnode=(constructordecnode) dec.member;
				if (!consnode.name.equals(node.classname)) throw new SemeticError("Constructor's name error");
				if (builder.consetted) throw new SemeticError("2 Constructors");
				builder.consetted=true;
				Function cons=builder.constructor;
				consnode.type=builder;
				cons.setDefinenode(consnode);
			}
			else if(dec.member.getClass().equals(methoddec.class)) {
				methoddec methodnode=(methoddec) dec.member;
				Function method=new Function(methodnode.name,methodnode);
				if (builder.method.containsKey(method.getName())) {
					throw new SemeticError("Duplicated methods");
				}
				builder.method.put(method.getName(), method);
				methodnode.func=method;
				Visit(methodnode);
			}
		}
		return null;
	}

	@Override
	public defined Visit(Classnamenode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public defined Visit(constructordecnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public defined Visit(Continuenode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public defined Visit(creatednamenode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public defined Visit(creatornode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public defined Visit(EmptyBlocknode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public defined Visit(EmptyClassdecnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public defined Visit(exprlistnode node) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public defined Visit(Fielddecnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public defined Visit(forcontrolnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public defined Visit(forinitnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public defined Visit(formalparalistnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Variable Visit(formalparanode node) throws SemeticError {
		// TODO Auto-generated method stub
		Variable val=new Variable();
		val.type=Visit(node.type);
		val.setDefinenode(node);
		val.setName(node.var.id);
		val.init=null;
		return val;
		
	}

	@Override
	public defined Visit(formalparasnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public defined Visit(Fornode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public defined Visit(Funcallnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public defined Visit(Ifnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public defined Visit(Intliteralnode node) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public defined Visit(Localvaridecnode node) throws SemeticError {
		return null;
	}

	@Override
	public defined Visit(Membernode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public defined Visit(methoddec node) throws SemeticError {
		// TODO Auto-generated method stub
		Map<String,Boolean> attr=new HashMap<>();
		nowFunc=node.func;
		if (node.type.getClass().equals(Voidnode.class)) {
			nowFunc.returnval=new ArrayorType("void",null);
			nowFunc.ifvoid=true;
		}
		else {
			nowFunc.returnval=(ArrayorType) Visit(node.type);
		}
		List<formalparanode> attributes=node.attribute.paras.para;
		for (formalparanode i:attributes) {
			Variable var=Visit(i);
			if (attr.containsKey(var.getName())) throw new SemeticError("Duplicated attribute name");
			attr.put(var.getName(), true);
			nowFunc.attribute.add(var);
			
		}
		return null;
	}

	@Override
	public defined Visit(Methodnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public defined Visit(Newnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public defined Visit(Nullnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public defined Visit(Postfixnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public defined Visit(Prefixnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public defined Visit(Primarynode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public defined Visit(Returnnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public defined Visit(Seminode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public defined Visit(SourcePosition node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public defined Visit(Stateexprnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public defined Visit(Stringliteralnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public defined Visit(Thisexprnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public defined Visit(Thisnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayorType Visit(Typenode node) throws SemeticError {
		node.type.type=classtype.get(node.type.getName());
		if (node.type.type==null) throw new SemeticError("Attribute with no such type");
		return node.type;
	}

	@Override
	public defined Visit(Vardeclaratornode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public defined Visit(Vardeclaratorsnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public defined Visit(Variablenode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public defined Visit(Voidnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public defined Visit(Whilenode node) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
