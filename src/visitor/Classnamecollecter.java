package visitor;

import java.lang.*;
import java.io.*;
import Error.SemeticError;
import java.util.*;
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
public class Classnamecollecter extends ASTBaseVisitor<String> {
	public Map<String,Classdecnode> classname;
	public Map<String,methoddec> funcname;
	
	public Classnamecollecter() {
		super();
		classname=new HashMap<String,Classdecnode>();
		funcname=new HashMap<String,methoddec>();
	}

	@Override
	public String Visit(arraycreatenode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Visit(Arraynode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Visit(Assignnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Visit(AstRoot node) throws SemeticError {
		for (int i=0;i<node.childlist.size();++i) {
			if (node.childlist.get(i)!=null) {
				Visit(node.childlist.get(i));
			}
		}
		return null;
	}

	@Override
	public String Visit(Binarynode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Visit(Blocknode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Visit(Blockstatenode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Visit(Boolliteralnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Visit(Boolnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Visit(Breaknode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Visit(Charliteralnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Visit(Classbodydec node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Visit(Classbodynode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Visit(classcreaterestnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Visit(Classdecnode node) throws SemeticError{
		// TODO Auto-generated method stub
		if (node.classname!=null)
			if (classname.containsKey(node.classname)) throw new SemeticError();
				else classname.put(node.classname, node);
		return null;
	}

	@Override
	public String Visit(Classnamenode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Visit(constructordecnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Visit(Continuenode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Visit(creatednamenode node) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String Visit(creatornode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Visit(EmptyBlocknode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Visit(EmptyClassdecnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Visit(exprlistnode node) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String Visit(Fielddecnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Visit(forcontrolnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Visit(forinitnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Visit(formalparalistnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Visit(formalparanode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Visit(formalparasnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Visit(Fornode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Visit(Funcallnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Visit(Ifnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Visit(Intliteralnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Visit(Localvaridecnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Visit(Membernode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Visit(methoddec node) throws SemeticError {
		if (node.name!=null)
			if (funcname.containsKey(node.name)) throw new SemeticError();
				else funcname.put(node.name, node);
		return null;
		// TODO Auto-generated method stub
	}

	@Override
	public String Visit(Methodnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Visit(Newnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Visit(Nullnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Visit(Postfixnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Visit(Prefixnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Visit(Primarynode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Visit(Returnnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Visit(Seminode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Visit(SourcePosition node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Visit(Stateexprnode node) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String Visit(Stringliteralnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Visit(Thisexprnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Visit(Thisnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Visit(Typenode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Visit(Vardeclaratornode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Visit(Vardeclaratorsnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Visit(Variablenode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Visit(Voidnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Visit(Whilenode node) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
