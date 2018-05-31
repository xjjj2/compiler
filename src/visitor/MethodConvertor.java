package visitor;

import java.util.Map;
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
import type.ArrayorType;
import type.Function;
import type.Variable;
import type.definedtype;

public class MethodConvertor extends ASTBaseVisitor<node> {
	public Map<String,definedtype> classtype;
	public Map<String,Function> topfuncs;
	public TopScope top;
	public Stack<Scope> scoper;
	public ArrayorType aint;
	public ArrayorType abool;
	public ArrayorType astring;
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
	@Override
	public node Visit(arraycreatenode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public node Visit(Arraynode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public node Visit(Assignnode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public node Visit(AstRoot node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public node Visit(Binarynode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public node Visit(Blocknode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public node Visit(Blockstatenode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public node Visit(Boolliteralnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public node Visit(Boolnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public node Visit(Breaknode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public node Visit(Charliteralnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public node Visit(Classbodydec node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public node Visit(Classbodynode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public node Visit(classcreaterestnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public node Visit(Classdecnode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public node Visit(Classnamenode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public node Visit(constructordecnode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public node Visit(Continuenode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public node Visit(creatednamenode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public node Visit(creatornode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public node Visit(EmptyBlocknode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public node Visit(EmptyClassdecnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public node Visit(exprlistnode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public node Visit(Fielddecnode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public node Visit(forcontrolnode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public node Visit(forinitnode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public node Visit(formalparalistnode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public node Visit(formalparanode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public node Visit(formalparasnode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public node Visit(Fornode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public node Visit(Funcallnode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public node Visit(Ifnode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public node Visit(Intliteralnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public node Visit(Localvaridecnode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public node Visit(Membernode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public node Visit(methoddec node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public node Visit(Methodnode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public node Visit(Newnode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public node Visit(Nullnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public node Visit(Postfixnode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public node Visit(Prefixnode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public node Visit(Primarynode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public node Visit(Returnnode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public node Visit(Seminode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public node Visit(SourcePosition node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public node Visit(Stateexprnode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public node Visit(Stringliteralnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public node Visit(Thisexprnode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public node Visit(Thisnode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public node Visit(Typenode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public node Visit(Vardeclaratornode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public node Visit(Vardeclaratorsnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public node Visit(Variablenode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public node Visit(Voidnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public node Visit(Whilenode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

}
