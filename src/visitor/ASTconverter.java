package visitor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import compilerNode.*;
import visitor.mlperParser.ArrayContext;
import visitor.mlperParser.ArrayCreatorRestContext;
import visitor.mlperParser.AssignContext;
import visitor.mlperParser.BinaryContext;
import visitor.mlperParser.BlockContext;
import visitor.mlperParser.BlockstatContext;
import visitor.mlperParser.BlockvaridecContext;
import visitor.mlperParser.BoolContext;
import visitor.mlperParser.BooleanContext;
import visitor.mlperParser.BreakContext;
import visitor.mlperParser.CharContext;
import visitor.mlperParser.ClassBodyContext;
import visitor.mlperParser.ClassCreatorRestContext;
import visitor.mlperParser.ClassDeclarationContext;
import visitor.mlperParser.ClassOrInterfaceTypeContext;
import visitor.mlperParser.ClassblockContext;
import visitor.mlperParser.ClassdecContext;
import visitor.mlperParser.CompilationUnitContext;
import visitor.mlperParser.ConstructdecContext;
import visitor.mlperParser.ConstructorDeclarationContext;
import visitor.mlperParser.ContinueContext;
import visitor.mlperParser.CreatorContext;
import visitor.mlperParser.EmptyclassContext;
import visitor.mlperParser.EmptymethodContext;
import visitor.mlperParser.EmptytypeContext;
import visitor.mlperParser.ExprContext;
import visitor.mlperParser.ExpressContext;
import visitor.mlperParser.ExpressionListContext;
import visitor.mlperParser.FieldDeclarationContext;
import visitor.mlperParser.FielddecContext;
import visitor.mlperParser.ForControlContext;
import visitor.mlperParser.ForexprlistContext;
import visitor.mlperParser.FormalParameterContext;
import visitor.mlperParser.FormalParameterListContext;
import visitor.mlperParser.FormalParametersContext;
import visitor.mlperParser.ForstatContext;
import visitor.mlperParser.ForvariableContext;
import visitor.mlperParser.FuncdecContext;
import visitor.mlperParser.FunctionContext;
import visitor.mlperParser.FunctionDeclarationContext;
import visitor.mlperParser.IfstatContext;
import visitor.mlperParser.IntContext;
import visitor.mlperParser.IntegerContext;
import visitor.mlperParser.LiteralsContext;
import visitor.mlperParser.LocalVariableDeclarationContext;
import visitor.mlperParser.MemberContext;
import visitor.mlperParser.MemdecContext;
import visitor.mlperParser.MethodCallContext;
import visitor.mlperParser.MethodContext;
import visitor.mlperParser.MethodDeclarationContext;
import visitor.mlperParser.MethodblockContext;
import visitor.mlperParser.MethoddecContext;
import visitor.mlperParser.NewContext;
import visitor.mlperParser.NewclassContext;
import visitor.mlperParser.NewprimitiveContext;
import visitor.mlperParser.NullContext;
import visitor.mlperParser.ParExpressionContext;
import visitor.mlperParser.PostfixContext;
import visitor.mlperParser.PrefixContext;
import visitor.mlperParser.PriContext;
import visitor.mlperParser.ReturnContext;
import visitor.mlperParser.SemiContext;
import visitor.mlperParser.StatblockContext;
import visitor.mlperParser.StringContext;
import visitor.mlperParser.ThisContext;
import visitor.mlperParser.ThisexprContext;
import visitor.mlperParser.TypeContext;
import visitor.mlperParser.TypeTypeContext;
import visitor.mlperParser.TypedecContext;
import visitor.mlperParser.VariableContext;
import visitor.mlperParser.VariableDeclaratorContext;
import visitor.mlperParser.VariableDeclaratorIdContext;
import visitor.mlperParser.VariableDeclaratorsContext;
import visitor.mlperParser.VariableInitializerContext;
import visitor.mlperParser.VaridecContext;
import visitor.mlperParser.VoidContext;
import visitor.mlperParser.WhilestatContext;
public class ASTconverter extends mlperBaseVisitor<node> {

	@Override
	public Prefixnode visitPrefix(PrefixContext ctx) {
		Exprnode b=(Exprnode) visit(ctx.expression());
		Prefixnode a=new Prefixnode(b,ctx.prefix.getText());
		b.parent=a;
		return a;
	}

	@Override
	public Literalnode visitLiterals(LiteralsContext ctx) {
		return (Literalnode) visit(ctx.literal());
	}

	@Override
	public Statementnode visitExpress(ExpressContext ctx) {
		Stateexprnode a;
		Exprnode b=(Exprnode)visit(ctx.statementExpression);
		a=new Stateexprnode(b);
		b.parent=a;
		return a;
	}

	@Override
	public Intliteralnode visitInteger(IntegerContext ctx) {
		return(new Intliteralnode(ctx.DECIMAL_LITERAL().getText()));
	}


	@Override
	public Typenode visitType(TypeContext ctx) {
		return (Typenode)visit(ctx.typeType());
	}

	@Override
	public methoddec visitMethoddec(MethoddecContext ctx) {
		return (methoddec)(visit(ctx.methodDeclaration()));
	}

	@Override
	public creatednamenode visitNewprimitive(NewprimitiveContext ctx) {
		creatednamenode a=new creatednamenode();
		node b=visit(ctx.primitiveType());
		if (b.getClass().equals(Intnode.class)) {
			a.name="int";
		}
		else a.name="bool";
		return a;
	}

	@Override
	public creatednamenode visitNewclass(NewclassContext ctx) {
		creatednamenode a=new creatednamenode();
		Classnamenode b=new Classnamenode(ctx.IDENTIFIER().getText());
		a.name=b.name;
		return a;
	}

	@Override
	public Continuenode visitContinue(ContinueContext ctx) {
		return (new Continuenode());
	}

	@Override
	public forinitnode visitForexprlist(ForexprlistContext ctx) {
		forinitnode a=new forinitnode();
		a.expr=visit(ctx.expressionList());
		a.expr.parent=a;
		return a;
	}

	@Override
	public Funcallnode visitFunction(FunctionContext ctx) {
		return (Funcallnode) visit(ctx.methodCall());
	}

	@Override
	public Blocknode visitBlock(BlockContext ctx) {
		Blocknode a=new Blocknode();
		List<Blockstatenode> b=new ArrayList<Blockstatenode>();
		if (ctx.blockStatement()!=null)
		for (int i=0;i<ctx.blockStatement().size();++i) {
			b.add((Blockstatenode)(visit(ctx.blockStatement(i))));
			b.get(i).parent=a;
		}
		a.statements=b;
		return a;
	}

	@Override
	public methoddec visitFuncdec(FuncdecContext ctx) {
		return (methoddec)(visit(ctx.functionDeclaration()));
	}

	@Override
	public Newnode visitNew(NewContext ctx) {
		creatornode creator=(creatornode) visit(ctx.creator());
		Newnode a=new Newnode(creator);
		creator.parent=a;
		return a;
	}

	@Override
	public Voidnode visitVoid(VoidContext ctx) {
		return new Voidnode();
	}

	@Override
	public Methodnode visitMethod(MethodContext ctx) {
		Exprnode expr=(Exprnode) visit(ctx.expression());
		Funcallnode method=(Funcallnode) visit(ctx.methodCall());
		Methodnode a=new Methodnode(method,expr);
		expr.parent=a;
		method.parent=a;
		return a;
	}

	@Override
	public Typenode visitTypeType(TypeTypeContext ctx) {
		Typenode a=new Typenode();
		if (ctx.LBRACK()!=null)
			a.type.arraynum=ctx.LBRACK().size();
		else a.type.arraynum=0;
		if (ctx.classOrInterfaceType()!=null) {
			Classnamenode name=(Classnamenode) visit(ctx.classOrInterfaceType());
			a.name=name.name;
		}
		else {
			node name=visit(ctx.primitiveType());
			if (name.getClass().equals(Intnode.class)) a.name="int";
			else a.name="bool";
		}
		a.type.name=a.name;
		return a;
	}

	@Override
	public Primarynode visitPri(PriContext ctx) {
		Primarynode a;
		Exprnode expr=(Exprnode) visit(ctx.primary());
		a=new Primarynode(expr);
		expr.parent=a;
		return a;
	}

	@Override
	public Thisnode visitThis(ThisContext ctx) {
		return new Thisnode();
	}

	@Override
	public Blocknode visitMethodblock(MethodblockContext ctx) {
		return (Blocknode) visit(ctx.block());
	}

	@Override
	public Classdecnode visitTypedec(TypedecContext ctx) {
		return (Classdecnode) visit(ctx.typeDeclaration());
	}

	@Override
	public formalparalistnode visitFormalParameterList(FormalParameterListContext ctx) {
		formalparalistnode a=new formalparalistnode();
		List<formalparanode> b=new ArrayList<formalparanode>();
		if (ctx.formalParameter()!=null)
		for (int i=0;i<ctx.formalParameter().size();++i) {
			b.add((formalparanode) visit(ctx.formalParameter(i)));
			b.get(i).parent=a;
		}
		a.para=b;
		return a;
	}

	@Override
	public forinitnode visitForvariable(ForvariableContext ctx) {
		forinitnode a=new forinitnode();
		Localvaridecnode dec=(Localvaridecnode) visit(ctx.localVariableDeclaration());
		a.expr=dec;
		dec.parent=a;
		return a;
	}

	@Override
	public exprlistnode visitExpressionList(ExpressionListContext ctx) {
		exprlistnode a=new exprlistnode();
		List<Exprnode> b=new ArrayList<Exprnode>();
		if (ctx.expression()!=null)
		for (int i=0;i<ctx.expression().size();++i) {
			b.add((Exprnode)visit(ctx.expression(i)));
			b.get(i).parent=a;
		}
		a.child=b;
		return a;
	}

	@Override
	public AstRoot visitCompilationUnit(CompilationUnitContext ctx) {
		AstRoot a=new AstRoot();
		List<node> b=new ArrayList<node>();
		if (ctx.classOrfunctionOrvariableDeclaration()!=null)
		for (int i=0;i<ctx.classOrfunctionOrvariableDeclaration().size();++i) {
			b.add(visit(ctx.classOrfunctionOrvariableDeclaration(i)));
			if (b.get(i)!=null)
				b.get(i).parent=a;
		}
		a.childlist=b;
		return a;
	}

	@Override
	public Nullnode visitNull(NullContext ctx) {
		return new Nullnode();
	}

	@Override
	public Blocknode visitStatblock(StatblockContext ctx) {
		return (Blocknode) visit(ctx.blockLabel);
	}

	@Override
	public Classnamenode visitClassOrInterfaceType(ClassOrInterfaceTypeContext ctx) {
		return (new Classnamenode(ctx.IDENTIFIER().getText()));
	}

	@Override
	public Binarynode visitBinary(BinaryContext ctx) {
		Binarynode a=new Binarynode();
		a.opcode=ctx.bop.getText();
		a.left=(Exprnode) visit(ctx.expression(0));
		a.right=(Exprnode) visit(ctx.expression(1));
		a.left.parent=a;
		a.right.parent=a;
		return a;
	}

	@Override
	public Localvaridecnode visitVaridec(VaridecContext ctx) {
		return (Localvaridecnode) visit(ctx.localVariableDeclaration());
	}

	@Override
	public Variablenode visitVariableDeclaratorId(VariableDeclaratorIdContext ctx) {
		return new Variablenode(ctx.IDENTIFIER().getText());
	}

	@Override
	public Fornode visitForstat(ForstatContext ctx) {
		Fornode a=new Fornode();
		a.con=(forcontrolnode) visit(ctx.forControl());
		a.statement=(Statementnode) visit(ctx.statement());
		a.con.parent=a;
		a.statement.parent=a;
		return a;
	}

	@Override
	public Funcallnode visitMethodCall(MethodCallContext ctx) {
		Funcallnode a=new Funcallnode();
		a.name=ctx.IDENTIFIER().getText();
		if (ctx.expressionList()!=null)
		a.exprlist=(exprlistnode)(visit(ctx.expressionList()));
		if (a.exprlist!=null) {
			a.exprlist.parent=a;
			a.exprnum=a.exprlist.child.size();
		}
		else {
			a.exprnum=0;
			a.exprlist=new exprlistnode();
			a.exprlist.child=Collections.emptyList();
		}
		return a;
	}

	@Override
	public classcreaterestnode visitClassCreatorRest(ClassCreatorRestContext ctx) {
		return new classcreaterestnode();
	}

	@Override
	public methoddec visitMethodDeclaration(MethodDeclarationContext ctx) {
		methoddec a;
		node type=visit(ctx.typeTypeOrVoid());
		String name=ctx.IDENTIFIER().getText();
		formalparasnode attr=(formalparasnode)visit(ctx.formalParameters());
		a=new methoddec(type,name,attr);
		attr.parent=a;
		type.parent=a;
		a.body=(Blocknode) visit(ctx.methodBody());
		if (a.body!=null) {
			a.body.parent=a;
		}
		return a;
	}

	@Override
	public Stringliteralnode visitString(StringContext ctx) {
		return new Stringliteralnode(ctx.STRING_LITERAL().getText());
	}

	@Override
	public Boolliteralnode visitBool(BoolContext ctx) {
		return (new Boolliteralnode(ctx.BOOL_LITERAL().getText()));
	}

	@Override
	public Classbodydec visitClassblock(ClassblockContext ctx) {
		Classbodydec a=new Classbodydec();
		a.member=visit(ctx.block());
		a.member.parent=a;
		return a;
	}

	@Override
	public constructordecnode visitConstructdec(ConstructdecContext ctx) {
		return (constructordecnode) visit(ctx.constructorDeclaration());
	}

	@Override
	public Whilenode visitWhilestat(WhilestatContext ctx) {
		Whilenode a=new Whilenode();
		a.parexpr=(Exprnode) visit(ctx.parExpression());
		a.statement=(Statementnode) visit(ctx.statement());
		a.parexpr.parent=a;
		a.statement.parent=a;
		return a;
	}

	@Override
	public Classdecnode visitClassdec(ClassdecContext ctx) {
		return (Classdecnode) visit(ctx.classDeclaration());
	}

	@Override
	public Classdecnode visitClassDeclaration(ClassDeclarationContext ctx) {
		Classdecnode a=new Classdecnode();
		a.classname=ctx.IDENTIFIER().getText();
		a.body=(Classbodynode) visit(ctx.classBody());
		a.body.parent=a;
		return a;
	}

	@Override
	public Classbodydec visitMemdec(MemdecContext ctx) {
		Classbodydec a=new Classbodydec();
		a.member=visit(ctx.memberDeclaration());
		a.member.parent=a;
		return a;
	}

	@Override
	public Thisexprnode visitThisexpr(ThisexprContext ctx) {
		Thisexprnode a=new Thisexprnode();
		a.expr=(Exprnode) visit(ctx.expression());
		a.expr.parent=a;
		return a;
	}

	@Override
	public Vardeclaratornode visitVariableDeclarator(VariableDeclaratorContext ctx) {
		Vardeclaratornode a=new Vardeclaratornode();
		a.id=(Variablenode) visit(ctx.variableDeclaratorId());
		if (ctx.variableInitializer()!=null)
			a.init=(Exprnode) visit(ctx.variableInitializer());
		if (a.init!=null) {
			a.init.parent=a;
		}
		a.id.parent=a;
		return a;
	}

	@Override
	public Arraynode visitArray(ArrayContext ctx) {
		Arraynode a=new Arraynode();
		a.name=(Exprnode) visit(ctx.expression(0));
		a.sub=(Exprnode) visit(ctx.expression(1));
		a.name.parent=a;
		a.sub.parent=a;
		return a; 
	}

	@Override
	public Classbodydec visitEmptyclass(EmptyclassContext ctx) {
		return new Classbodydec();
	}

	@Override
	public Membernode visitMember(MemberContext ctx) {
		Membernode a=new Membernode();
		a.identifier=new Variablenode(ctx.IDENTIFIER().getText());
		a.expr=(Exprnode) visit(ctx.expression());
		a.expr.parent=a;
		a.identifier.parent=a;
		return a;
	}

	@Override
	public Classbodynode visitClassBody(ClassBodyContext ctx) {
		Classbodynode a=new Classbodynode();
		List<Classbodydec> dec=new ArrayList<Classbodydec>();
		if (ctx.classBodyDeclaration()!=null)
		for (int i=0;i<ctx.classBodyDeclaration().size();++i) {
			dec.add((Classbodydec) visit(ctx.classBodyDeclaration(i)));
			if (dec.get(i)!=null) {
				dec.get(i).parent=a;
			}
		}
		a.statement=dec;
		return a;
	}

	@Override
	public Exprnode visitExpr(ExprContext ctx) {
		return (Exprnode) visit(ctx.expression());
	}

	@Override
	public Seminode visitSemi(SemiContext ctx) {
		return new Seminode();
	}

	@Override
	public Postfixnode visitPostfix(PostfixContext ctx) {
		Exprnode b=(Exprnode) visit(ctx.expression());
		Postfixnode a=new Postfixnode(b,ctx.postfix.getText());
		b.parent=a;
		return a;
	}

	@Override
	public formalparanode visitFormalParameter(FormalParameterContext ctx) {
		formalparanode a=new formalparanode();
		a.type=(Typenode) visit(ctx.typeType());
		a.var=(Variablenode) visit(ctx.variableDeclaratorId());
		a.type.parent=a;
		a.var.parent=a;
		return a;
		
	}

	@Override
	public Exprnode visitParExpression(ParExpressionContext ctx) {
		return (Exprnode) visit(ctx.expression());
	}

	@Override
	public Exprnode visitVariableInitializer(VariableInitializerContext ctx) {
		return (Exprnode) visit(ctx.expression());
	}

	@Override
	public creatornode visitCreator(CreatorContext ctx) {
		creatornode a=new creatornode(); 
		a.name=(creatednamenode) visit(ctx.createdName());
		if (ctx.classCreatorRest()!=null)
			a.createrest=(createdrestnode) visit(ctx.classCreatorRest());
		else a.createrest=(createdrestnode) visit(ctx.arrayCreatorRest());
		a.name.parent=a;
		if (a.createrest!=null) {
			a.createrest.parent=a;
		}
		return a;
	}

	@Override
	public arraycreatenode visitArrayCreatorRest(ArrayCreatorRestContext ctx) {
		arraycreatenode a=new arraycreatenode();
		List<Exprnode> exprs=new ArrayList<Exprnode>();
		if (ctx.LBRACK()!=null)
		a.num=ctx.LBRACK().size();
		else a.num=ctx.expression().size();
		for (int i=0;i<ctx.expression().size();++i) {
			exprs.add((Exprnode) visit(ctx.expression(i)));
			exprs.get(i).parent=a;
		}
		a.exprs=exprs;
		return a;
	}

	@Override
	public Breaknode visitBreak(BreakContext ctx) {
		return new Breaknode();
	}

	@Override
	public Fielddecnode visitFielddec(FielddecContext ctx) {
		return (Fielddecnode) visit(ctx.fieldDeclaration());
	}

	@Override
	public Fielddecnode visitFieldDeclaration(FieldDeclarationContext ctx) {
		Fielddecnode a=new Fielddecnode();
		a.type=(Typenode) visit(ctx.typeType());
		a.vars=(Vardeclaratorsnode) visit(ctx.variableDeclarators());
		a.type.parent=a;
		a.vars.parent=a;
		return a;
	}

	@Override
	public Classdecnode visitEmptytype(EmptytypeContext ctx) {
		return new EmptyClassdecnode();
	}

	@Override
	public constructordecnode visitConstructorDeclaration(ConstructorDeclarationContext ctx) {
		constructordecnode a=new constructordecnode();
		a.name=ctx.IDENTIFIER().getText();
		a.paras=(formalparasnode) visit(ctx.formalParameters());
		if (a.paras.paras==null) a.paras=null;else a.paras.parent=a;
		a.block=(Blocknode) visit(ctx.constructorBody);
		if (a.block!=null) a.block.parent=a;
		return a;
	
	}

	@Override
	public Intnode visitInt(IntContext ctx) {
		return new Intnode();
	}

	@Override
	public Blockstatenode visitBlockstat(BlockstatContext ctx) {
		Statementnode b=(Statementnode)(visit(ctx.statement()));
		Blockstatenode a=new Blockstatenode(b);
		b.parent=a;
		return a;
	}

	@Override
	public Ifnode visitIfstat(IfstatContext ctx) {
		Ifnode a=new Ifnode();
		a.parexpr=(Exprnode) visit(ctx.parExpression());
		a.parexpr.parent=a;
		a.ifstatement=(Statementnode) visit(ctx.statement(0));
		a.ifstatement.parent=a;
		if (ctx.statement().size()==2) {
			a.ifelse=true;
			a.elsestatement=(Statementnode) visit(ctx.statement(1));
			a.elsestatement.parent=a;
		}
		else {
			a.ifelse=false;
		}
		return a;
	}

	@Override
	public forcontrolnode visitForControl(ForControlContext ctx) {
		forcontrolnode a=new forcontrolnode();
		if (ctx.forInit()!=null)
		a.init=(forinitnode) visit(ctx.forInit());
		if (ctx.expression()!=null)
		a.parexpr=(Exprnode) visit(ctx.expression());
		if (ctx.expressionList()!=null)
		a.exprlist=(exprlistnode) visit(ctx.expressionList());
		if (a.init!=null)
			a.init.parent=a;
		if (a.parexpr!=null)
			a.parexpr.parent=a;
		if (a.exprlist!=null)
			a.exprlist.parent=a;
		return a;
	}

	@Override
	public Localvaridecnode visitLocalVariableDeclaration(LocalVariableDeclarationContext ctx) {
		Localvaridecnode a=new Localvaridecnode();
		a.type=(Typenode) visit(ctx.typeType());
		a.id=(Vardeclaratorsnode) visit(ctx.variableDeclarators());
		a.type.parent=a;
		a.id.parent=a;
		return a;
	}

	@Override
	public Boolnode visitBoolean(BooleanContext ctx) {
		return new Boolnode();
	}

	@Override
	public Blockstatenode visitBlockvaridec(BlockvaridecContext ctx) {
		Localvaridecnode b=(Localvaridecnode)(visit(ctx.localVariableDeclaration()));
		Blockstatenode a=new Blockstatenode(b);
		b.parent=a;
		return a;
	}

	@Override
	public Vardeclaratorsnode visitVariableDeclarators(VariableDeclaratorsContext ctx) {
		Vardeclaratorsnode a=new Vardeclaratorsnode();
		List<Vardeclaratornode> b=new ArrayList<Vardeclaratornode>();
		if (ctx.variableDeclarator()!=null)
		for (int i=0;i<ctx.variableDeclarator().size();++i) {
			b.add((Vardeclaratornode) visit(ctx.variableDeclarator(i)));
			b.get(i).parent=a;
		}
		a.vardecs=b;
		return a;
	}

	@Override
	public Charliteralnode visitChar(CharContext ctx) {
		return (new Charliteralnode(ctx.CHAR_LITERAL().getText()));
	}

	@Override
	public Variablenode visitVariable(VariableContext ctx) {
		return new Variablenode(ctx.IDENTIFIER().getText());
	}

	@Override
	public formalparasnode visitFormalParameters(FormalParametersContext ctx) {
		formalparasnode a=new formalparasnode();
		if (ctx.formalParameterList()!=null) {
			a.paras=(formalparalistnode) visit(ctx.formalParameterList());
			a.paras.parent=a;
		}
		else {
			a.paras=new formalparalistnode();
			a.paras.para=Collections.emptyList();
		}
		return a;
	}

	@Override
	public methoddec visitFunctionDeclaration(FunctionDeclarationContext ctx) {
		return (methoddec)(visit(ctx.methodDeclaration()));
	}

	@Override
	public Blocknode visitEmptymethod(EmptymethodContext ctx) {
		return new EmptyBlocknode();
	}

	@Override
	public Returnnode visitReturn(ReturnContext ctx) {
		Returnnode a=new Returnnode();
		if (ctx.expression()!=null)
		a.expr=(Exprnode) visit(ctx.expression());
		if (a.expr!=null)
			a.expr.parent=a;
		return a;
	}

	@Override
	public Assignnode visitAssign(AssignContext ctx) {
		Assignnode a=new Assignnode();
		a.left=(Exprnode) visit(ctx.expression(0));
		a.right=(Exprnode) visit(ctx.expression(1));
		a.left.parent=a;
		a.right.parent=a;
		return a;
	}
	
}
