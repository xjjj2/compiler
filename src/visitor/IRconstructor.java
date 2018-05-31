package visitor;

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

public class IRconstructor extends ASTBaseVisitor<Integer> {

	@Override
	public Integer Visit(arraycreatenode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer Visit(Arraynode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer Visit(Assignnode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer Visit(AstRoot node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer Visit(Binarynode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer Visit(Blocknode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer Visit(Blockstatenode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer Visit(Boolliteralnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer Visit(Boolnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer Visit(Breaknode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer Visit(Charliteralnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer Visit(Classbodydec node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer Visit(Classbodynode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer Visit(classcreaterestnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer Visit(Classdecnode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer Visit(Classnamenode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer Visit(constructordecnode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer Visit(Continuenode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer Visit(creatednamenode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer Visit(creatornode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer Visit(EmptyBlocknode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer Visit(EmptyClassdecnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer Visit(exprlistnode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer Visit(Fielddecnode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer Visit(forcontrolnode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer Visit(forinitnode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer Visit(formalparalistnode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer Visit(formalparanode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer Visit(formalparasnode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer Visit(Fornode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer Visit(Funcallnode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer Visit(Ifnode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer Visit(Intliteralnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer Visit(Localvaridecnode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer Visit(Membernode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer Visit(methoddec node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer Visit(Methodnode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer Visit(Newnode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer Visit(Nullnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer Visit(Postfixnode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer Visit(Prefixnode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer Visit(Primarynode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer Visit(Returnnode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer Visit(Seminode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer Visit(SourcePosition node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer Visit(Stateexprnode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer Visit(Stringliteralnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer Visit(Thisexprnode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer Visit(Thisnode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer Visit(Typenode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer Visit(Vardeclaratornode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer Visit(Vardeclaratorsnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer Visit(Variablenode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer Visit(Voidnode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer Visit(Whilenode node) throws SemeticError {
		// TODO Auto-generated method stub
		return null;
	}

}
