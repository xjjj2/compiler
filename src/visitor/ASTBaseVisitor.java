package visitor;
import Error.SemeticError;
import compilerNode.*;
abstract class ASTBaseVisitor<T> {
	public abstract T Visit(arraycreatenode node) throws SemeticError;
	public abstract T Visit(Arraynode node) throws SemeticError;
	public abstract T Visit(Assignnode node) throws SemeticError;
	public abstract T Visit(AstRoot node) throws SemeticError;
	public abstract T Visit(Binarynode node) throws SemeticError;
	public abstract T Visit(Blocknode node) throws SemeticError;
	public abstract T Visit(Blockstatenode node) throws SemeticError;
	public abstract T Visit(Boolliteralnode node);
	public abstract T Visit(Boolnode node);
	public abstract T Visit(Breaknode node) throws SemeticError;
	public abstract T Visit(Charliteralnode node);
	public abstract T Visit(Classbodydec node) throws SemeticError;
	public abstract T Visit(Classbodynode node) throws SemeticError;
	public abstract T Visit(classcreaterestnode node);
	public abstract T Visit(Classdecnode node) throws SemeticError;
	public abstract T Visit(Classnamenode node);
	public abstract T Visit(constructordecnode node) throws SemeticError;
	public abstract T Visit(Continuenode node) throws SemeticError;
	public abstract T Visit(creatednamenode node) throws SemeticError;
	public abstract T Visit(creatornode node) throws SemeticError;
	public abstract T Visit(EmptyBlocknode node);
	public abstract T Visit(EmptyClassdecnode node);
	public abstract T Visit(exprlistnode node) throws SemeticError;
//	public abstract T Visit(Exprthisnode node);
	public abstract T Visit(Fielddecnode node) throws SemeticError;
	public abstract T Visit(forcontrolnode node) throws SemeticError;
	public abstract T Visit(forinitnode node) throws SemeticError;
	public abstract T Visit(formalparalistnode node) throws SemeticError;
	public abstract T Visit(formalparanode node) throws SemeticError;
	public abstract T Visit(formalparasnode node) throws SemeticError;
	public abstract T Visit(Fornode node) throws SemeticError;
	public abstract T Visit(Funcallnode node) throws SemeticError;
//	public abstract T Visit(Identstringnode node);
	public abstract T Visit(Ifnode node) throws SemeticError;
	public abstract T Visit(Intliteralnode node);
	public abstract T Visit(Localvaridecnode node) throws SemeticError;
	public abstract T Visit(Membernode node) throws SemeticError;
	public abstract T Visit(methoddec node) throws SemeticError;
	public abstract T Visit(Methodnode node) throws SemeticError;
	public abstract T Visit(Newnode node) throws SemeticError;
	public abstract T Visit(Nullnode node);
	public abstract T Visit(Postfixnode node) throws SemeticError;
	public abstract T Visit(Prefixnode node) throws SemeticError;
	public abstract T Visit(Primarynode node) throws SemeticError;
	public abstract T Visit(Returnnode node) throws SemeticError;
	public abstract T Visit(Seminode node);
	public abstract T Visit(SourcePosition node);
	public abstract T Visit(Stateexprnode node) throws SemeticError;
	public abstract T Visit(Stringliteralnode node);
	public abstract T Visit(Thisexprnode node) throws SemeticError;
	public abstract T Visit(Thisnode node) throws SemeticError;
	public abstract T Visit(Typenode node) throws SemeticError;
	public abstract T Visit(Vardeclaratornode node) throws SemeticError;
	public abstract T Visit(Vardeclaratorsnode node) throws SemeticError;
	public abstract T Visit(Variablenode node) throws SemeticError;
	public abstract T Visit(Voidnode node);
	public abstract T Visit(Whilenode node) throws SemeticError;
	public T Visit(node nodename) throws SemeticError{
	   if (nodename.getClass().equals(arraycreatenode.class)) return Visit((arraycreatenode)nodename);
	   else if (nodename.getClass().equals(Arraynode.class)) return Visit((Arraynode)nodename);
	   else if (nodename.getClass().equals(Assignnode.class)) return Visit((Assignnode)nodename);
	   else if (nodename.getClass().equals(AstRoot.class)) return Visit((AstRoot)nodename);
	   else if (nodename.getClass().equals(Binarynode.class)) return Visit((Binarynode)nodename);
	   else if (nodename.getClass().equals(Blocknode.class)) return Visit((Blocknode)nodename);
	   else if (nodename.getClass().equals(Blockstatenode.class)) return Visit((Blockstatenode)nodename);
	   else if (nodename.getClass().equals(Boolliteralnode.class)) return Visit((Boolliteralnode)nodename);
	   else if (nodename.getClass().equals(Boolnode.class)) return Visit((Boolnode)nodename);
	   else if (nodename.getClass().equals(Breaknode.class)) return Visit((Breaknode)nodename);
	   else if (nodename.getClass().equals(Charliteralnode.class)) return Visit((Charliteralnode)nodename);
	   else if (nodename.getClass().equals(Classbodydec.class)) return Visit((Classbodydec)nodename);
	   else if (nodename.getClass().equals(Classbodynode.class)) return Visit((Classbodynode)nodename);
	   else if (nodename.getClass().equals(classcreaterestnode.class)) return Visit((classcreaterestnode)nodename);
	   else if (nodename.getClass().equals(Classdecnode.class)) return Visit((Classdecnode)nodename);
	   else if (nodename.getClass().equals(Classnamenode.class)) return Visit((Classnamenode)nodename);
	   else if (nodename.getClass().equals(constructordecnode.class)) return Visit((constructordecnode)nodename);
	   else if (nodename.getClass().equals(Continuenode.class)) return Visit((Continuenode)nodename);
	   else if (nodename.getClass().equals(creatednamenode.class)) return Visit((creatednamenode)nodename);
	   else if (nodename.getClass().equals(creatornode.class)) return Visit((creatornode)nodename);
	   else if (nodename.getClass().equals(EmptyBlocknode.class)) return Visit((EmptyBlocknode)nodename);
	   else if (nodename.getClass().equals(EmptyClassdecnode.class)) return Visit((EmptyClassdecnode)nodename);
	   else if (nodename.getClass().equals(exprlistnode.class)) return Visit((exprlistnode)nodename);
//	   else if (nodename.getClass().equals(Exprnode.class)) return Visit((Exprnode)nodename);
//	   else if (nodename.getClass().equals(Exprthisnode.class)) return Visit((Exprthisnode)nodename);
	   else if (nodename.getClass().equals(Fielddecnode.class)) return Visit((Fielddecnode)nodename);
	   else if (nodename.getClass().equals(forcontrolnode.class)) return Visit((forcontrolnode)nodename);
	   else if (nodename.getClass().equals(forinitnode.class)) return Visit((forinitnode)nodename);
	   else if (nodename.getClass().equals(formalparalistnode.class)) return Visit((formalparalistnode)nodename);
	   else if (nodename.getClass().equals(formalparanode.class)) return Visit((formalparanode)nodename);
	   else if (nodename.getClass().equals(formalparasnode.class)) return Visit((formalparasnode)nodename);
	   else if (nodename.getClass().equals(Fornode.class)) return Visit((Fornode)nodename);
	   else if (nodename.getClass().equals(Funcallnode.class)) return Visit((Funcallnode)nodename);
//	   else if (nodename.getClass().equals(Identstringnode.class)) return Visit((Identstringnode)nodename);
	   else if (nodename.getClass().equals(Ifnode.class)) return Visit((Ifnode)nodename);
	   else if (nodename.getClass().equals(Intliteralnode.class)) return Visit((Intliteralnode)nodename);
	   else if (nodename.getClass().equals(Intnode.class)) return Visit((Intnode)nodename);
//	   else if (nodename.getClass().equals(LHSnode.class)) return Visit((LHSnode)nodename);
	   else if (nodename.getClass().equals(Literalnode.class)) return Visit((Literalnode)nodename);
	   else if (nodename.getClass().equals(Localvaridecnode.class)) return Visit((Localvaridecnode)nodename);
	   else if (nodename.getClass().equals(Membernode.class)) return Visit((Membernode)nodename);
	   else if (nodename.getClass().equals(methoddec.class)) return Visit((methoddec)nodename);
	   else if (nodename.getClass().equals(Methodnode.class)) return Visit((Methodnode)nodename);
	   else if (nodename.getClass().equals(Newnode.class)) return Visit((Newnode)nodename);
	   else if (nodename.getClass().equals(Nullnode.class)) return Visit((Nullnode)nodename);
	   else if (nodename.getClass().equals(Postfixnode.class)) return Visit((Postfixnode)nodename);
	   else if (nodename.getClass().equals(Prefixnode.class)) return Visit((Prefixnode)nodename);
	   else if (nodename.getClass().equals(Primarynode.class)) return Visit((Primarynode)nodename);
	   else if (nodename.getClass().equals(Returnnode.class)) return Visit((Returnnode)nodename);
	   else if (nodename.getClass().equals(Seminode.class)) return Visit((Seminode)nodename);
	   else if (nodename.getClass().equals(Stateexprnode.class)) return Visit((Stateexprnode)nodename);
//	   else if (nodename.getClass().equals(Statementnode.class)) return Visit((Statementnode)nodename);
	   else if (nodename.getClass().equals(Stringliteralnode.class)) return Visit((Stringliteralnode)nodename);
	   else if (nodename.getClass().equals(Thisexprnode.class)) return Visit((Thisexprnode)nodename);
	   else if (nodename.getClass().equals(Thisnode.class)) return Visit((Thisnode)nodename);
	   else if (nodename.getClass().equals(Typenode.class)) return Visit((Typenode)nodename);
	   else if (nodename.getClass().equals(Vardeclaratornode.class)) return Visit((Vardeclaratornode)nodename);
	   else if (nodename.getClass().equals(Vardeclaratorsnode.class)) return Visit((Vardeclaratorsnode)nodename);
	   else if (nodename.getClass().equals(Variablenode.class)) return Visit((Variablenode)nodename);
	   else if (nodename.getClass().equals(Voidnode.class)) return Visit((Voidnode)nodename);
	   else if (nodename.getClass().equals(Whilenode.class)) return Visit((Whilenode)nodename);
	   else return null;
	}
}
