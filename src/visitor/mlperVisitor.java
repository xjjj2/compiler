package visitor;// Generated from mlper.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link mlperParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface mlperVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link mlperParser#compilationUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompilationUnit(mlperParser.CompilationUnitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code typedec}
	 * labeled alternative in {@link mlperParser#classOrfunctionOrvariableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypedec(mlperParser.TypedecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funcdec}
	 * labeled alternative in {@link mlperParser#classOrfunctionOrvariableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncdec(mlperParser.FuncdecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varidec}
	 * labeled alternative in {@link mlperParser#classOrfunctionOrvariableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVaridec(mlperParser.VaridecContext ctx);
	/**
	 * Visit a parse tree produced by {@link mlperParser#functionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(mlperParser.FunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code classdec}
	 * labeled alternative in {@link mlperParser#typeDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassdec(mlperParser.ClassdecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code emptytype}
	 * labeled alternative in {@link mlperParser#typeDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptytype(mlperParser.EmptytypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link mlperParser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(mlperParser.ClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link mlperParser#classBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBody(mlperParser.ClassBodyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code emptyclass}
	 * labeled alternative in {@link mlperParser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyclass(mlperParser.EmptyclassContext ctx);
	/**
	 * Visit a parse tree produced by the {@code classblock}
	 * labeled alternative in {@link mlperParser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassblock(mlperParser.ClassblockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code memdec}
	 * labeled alternative in {@link mlperParser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemdec(mlperParser.MemdecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code methoddec}
	 * labeled alternative in {@link mlperParser#memberDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethoddec(mlperParser.MethoddecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fielddec}
	 * labeled alternative in {@link mlperParser#memberDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFielddec(mlperParser.FielddecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code constructdec}
	 * labeled alternative in {@link mlperParser#memberDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructdec(mlperParser.ConstructdecContext ctx);
	/**
	 * Visit a parse tree produced by {@link mlperParser#methodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclaration(mlperParser.MethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code methodblock}
	 * labeled alternative in {@link mlperParser#methodBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodblock(mlperParser.MethodblockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code emptymethod}
	 * labeled alternative in {@link mlperParser#methodBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptymethod(mlperParser.EmptymethodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code type}
	 * labeled alternative in {@link mlperParser#typeTypeOrVoid}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(mlperParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code void}
	 * labeled alternative in {@link mlperParser#typeTypeOrVoid}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVoid(mlperParser.VoidContext ctx);
	/**
	 * Visit a parse tree produced by {@link mlperParser#constructorDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorDeclaration(mlperParser.ConstructorDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link mlperParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDeclaration(mlperParser.FieldDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link mlperParser#variableDeclarators}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarators(mlperParser.VariableDeclaratorsContext ctx);
	/**
	 * Visit a parse tree produced by {@link mlperParser#variableDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarator(mlperParser.VariableDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link mlperParser#variableDeclaratorId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaratorId(mlperParser.VariableDeclaratorIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link mlperParser#variableInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableInitializer(mlperParser.VariableInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link mlperParser#classOrInterfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassOrInterfaceType(mlperParser.ClassOrInterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link mlperParser#formalParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameters(mlperParser.FormalParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link mlperParser#formalParameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameterList(mlperParser.FormalParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link mlperParser#formalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameter(mlperParser.FormalParameterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code integer}
	 * labeled alternative in {@link mlperParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger(mlperParser.IntegerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code char}
	 * labeled alternative in {@link mlperParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChar(mlperParser.CharContext ctx);
	/**
	 * Visit a parse tree produced by the {@code string}
	 * labeled alternative in {@link mlperParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(mlperParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bool}
	 * labeled alternative in {@link mlperParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool(mlperParser.BoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code null}
	 * labeled alternative in {@link mlperParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNull(mlperParser.NullContext ctx);
	/**
	 * Visit a parse tree produced by {@link mlperParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(mlperParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code blockvaridec}
	 * labeled alternative in {@link mlperParser#blockStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockvaridec(mlperParser.BlockvaridecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code blockstat}
	 * labeled alternative in {@link mlperParser#blockStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockstat(mlperParser.BlockstatContext ctx);
	/**
	 * Visit a parse tree produced by {@link mlperParser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVariableDeclaration(mlperParser.LocalVariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statblock}
	 * labeled alternative in {@link mlperParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatblock(mlperParser.StatblockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifstat}
	 * labeled alternative in {@link mlperParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfstat(mlperParser.IfstatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forstat}
	 * labeled alternative in {@link mlperParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForstat(mlperParser.ForstatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code whilestat}
	 * labeled alternative in {@link mlperParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhilestat(mlperParser.WhilestatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code return}
	 * labeled alternative in {@link mlperParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn(mlperParser.ReturnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code break}
	 * labeled alternative in {@link mlperParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreak(mlperParser.BreakContext ctx);
	/**
	 * Visit a parse tree produced by the {@code continue}
	 * labeled alternative in {@link mlperParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinue(mlperParser.ContinueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code semi}
	 * labeled alternative in {@link mlperParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSemi(mlperParser.SemiContext ctx);
	/**
	 * Visit a parse tree produced by the {@code express}
	 * labeled alternative in {@link mlperParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpress(mlperParser.ExpressContext ctx);
	/**
	 * Visit a parse tree produced by {@link mlperParser#forControl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForControl(mlperParser.ForControlContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forvariable}
	 * labeled alternative in {@link mlperParser#forInit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForvariable(mlperParser.ForvariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forexprlist}
	 * labeled alternative in {@link mlperParser#forInit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForexprlist(mlperParser.ForexprlistContext ctx);
	/**
	 * Visit a parse tree produced by {@link mlperParser#parExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParExpression(mlperParser.ParExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link mlperParser#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionList(mlperParser.ExpressionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link mlperParser#methodCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodCall(mlperParser.MethodCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code new}
	 * labeled alternative in {@link mlperParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNew(mlperParser.NewContext ctx);
	/**
	 * Visit a parse tree produced by the {@code thisexpr}
	 * labeled alternative in {@link mlperParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThisexpr(mlperParser.ThisexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code method}
	 * labeled alternative in {@link mlperParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod(mlperParser.MethodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code array}
	 * labeled alternative in {@link mlperParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(mlperParser.ArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pri}
	 * labeled alternative in {@link mlperParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPri(mlperParser.PriContext ctx);
	/**
	 * Visit a parse tree produced by the {@code prefix}
	 * labeled alternative in {@link mlperParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefix(mlperParser.PrefixContext ctx);
	/**
	 * Visit a parse tree produced by the {@code function}
	 * labeled alternative in {@link mlperParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(mlperParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binary}
	 * labeled alternative in {@link mlperParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinary(mlperParser.BinaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code member}
	 * labeled alternative in {@link mlperParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMember(mlperParser.MemberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code postfix}
	 * labeled alternative in {@link mlperParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfix(mlperParser.PostfixContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link mlperParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(mlperParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expr}
	 * labeled alternative in {@link mlperParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(mlperParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code this}
	 * labeled alternative in {@link mlperParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThis(mlperParser.ThisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code literals}
	 * labeled alternative in {@link mlperParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiterals(mlperParser.LiteralsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code variable}
	 * labeled alternative in {@link mlperParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(mlperParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link mlperParser#creator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreator(mlperParser.CreatorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newclass}
	 * labeled alternative in {@link mlperParser#createdName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewclass(mlperParser.NewclassContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newprimitive}
	 * labeled alternative in {@link mlperParser#createdName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewprimitive(mlperParser.NewprimitiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link mlperParser#arrayCreatorRest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayCreatorRest(mlperParser.ArrayCreatorRestContext ctx);
	/**
	 * Visit a parse tree produced by {@link mlperParser#classCreatorRest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassCreatorRest(mlperParser.ClassCreatorRestContext ctx);
	/**
	 * Visit a parse tree produced by {@link mlperParser#typeType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeType(mlperParser.TypeTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolean}
	 * labeled alternative in {@link mlperParser#primitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolean(mlperParser.BooleanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code int}
	 * labeled alternative in {@link mlperParser#primitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt(mlperParser.IntContext ctx);
}