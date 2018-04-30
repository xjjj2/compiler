package visitor;// Generated from mlper.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class mlperParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		BOOLEAN=1, BREAK=2, CHAR=3, CLASS=4, CONST=5, CONTINUE=6, ELSE=7, FOR=8, 
		IF=9, INT=10, NEW=11, RETURN=12, THIS=13, VOID=14, WHILE=15, DECIMAL_LITERAL=16, 
		BOOL_LITERAL=17, CHAR_LITERAL=18, STRING_LITERAL=19, NULL_LITERAL=20, 
		LPAREN=21, RPAREN=22, LBRACE=23, RBRACE=24, LBRACK=25, RBRACK=26, SEMI=27, 
		COMMA=28, DOT=29, ASSIGN=30, GT=31, LT=32, BANG=33, TILDE=34, QUESTION=35, 
		COLON=36, EQUAL=37, LE=38, GE=39, NOTEQUAL=40, AND=41, OR=42, INC=43, 
		DEC=44, ADD=45, SUB=46, MUL=47, DIV=48, BITAND=49, BITOR=50, CARET=51, 
		MOD=52, LSHIFT=53, URSHIFT=54, WS=55, LINE_COMMENT=56, IDENTIFIER=57;
	public static final int
		RULE_compilationUnit = 0, RULE_classOrfunctionOrvariableDeclaration = 1, 
		RULE_functionDeclaration = 2, RULE_typeDeclaration = 3, RULE_classDeclaration = 4, 
		RULE_classBody = 5, RULE_classBodyDeclaration = 6, RULE_memberDeclaration = 7, 
		RULE_methodDeclaration = 8, RULE_methodBody = 9, RULE_typeTypeOrVoid = 10, 
		RULE_constructorDeclaration = 11, RULE_fieldDeclaration = 12, RULE_variableDeclarators = 13, 
		RULE_variableDeclarator = 14, RULE_variableDeclaratorId = 15, RULE_variableInitializer = 16, 
		RULE_classOrInterfaceType = 17, RULE_formalParameters = 18, RULE_formalParameterList = 19, 
		RULE_formalParameter = 20, RULE_literal = 21, RULE_block = 22, RULE_blockStatement = 23, 
		RULE_localVariableDeclaration = 24, RULE_statement = 25, RULE_forControl = 26, 
		RULE_forInit = 27, RULE_parExpression = 28, RULE_expressionList = 29, 
		RULE_methodCall = 30, RULE_expression = 31, RULE_primary = 32, RULE_creator = 33, 
		RULE_createdName = 34, RULE_arrayCreatorRest = 35, RULE_classCreatorRest = 36, 
		RULE_typeType = 37, RULE_primitiveType = 38;
	public static final String[] ruleNames = {
		"compilationUnit", "classOrfunctionOrvariableDeclaration", "functionDeclaration", 
		"typeDeclaration", "classDeclaration", "classBody", "classBodyDeclaration", 
		"memberDeclaration", "methodDeclaration", "methodBody", "typeTypeOrVoid", 
		"constructorDeclaration", "fieldDeclaration", "variableDeclarators", "variableDeclarator", 
		"variableDeclaratorId", "variableInitializer", "classOrInterfaceType", 
		"formalParameters", "formalParameterList", "formalParameter", "literal", 
		"block", "blockStatement", "localVariableDeclaration", "statement", "forControl", 
		"forInit", "parExpression", "expressionList", "methodCall", "expression", 
		"primary", "creator", "createdName", "arrayCreatorRest", "classCreatorRest", 
		"typeType", "primitiveType"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'bool'", "'break'", "'char'", "'class'", "'const'", "'continue'", 
		"'else'", "'for'", "'if'", "'int'", "'new'", "'return'", "'this'", "'void'", 
		"'while'", null, null, null, null, "'null'", "'('", "')'", "'{'", "'}'", 
		"'['", "']'", "';'", "','", "'.'", "'='", "'>'", "'<'", "'!'", "'~'", 
		"'?'", "':'", "'=='", "'<='", "'>='", "'!='", "'&&'", "'||'", "'++'", 
		"'--'", "'+'", "'-'", "'*'", "'/'", "'&'", "'|'", "'^'", "'%'", "'<<'", 
		"'>>'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "BOOLEAN", "BREAK", "CHAR", "CLASS", "CONST", "CONTINUE", "ELSE", 
		"FOR", "IF", "INT", "NEW", "RETURN", "THIS", "VOID", "WHILE", "DECIMAL_LITERAL", 
		"BOOL_LITERAL", "CHAR_LITERAL", "STRING_LITERAL", "NULL_LITERAL", "LPAREN", 
		"RPAREN", "LBRACE", "RBRACE", "LBRACK", "RBRACK", "SEMI", "COMMA", "DOT", 
		"ASSIGN", "GT", "LT", "BANG", "TILDE", "QUESTION", "COLON", "EQUAL", "LE", 
		"GE", "NOTEQUAL", "AND", "OR", "INC", "DEC", "ADD", "SUB", "MUL", "DIV", 
		"BITAND", "BITOR", "CARET", "MOD", "LSHIFT", "URSHIFT", "WS", "LINE_COMMENT", 
		"IDENTIFIER"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "mlper.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public mlperParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class CompilationUnitContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(mlperParser.EOF, 0); }
		public List<ClassOrfunctionOrvariableDeclarationContext> classOrfunctionOrvariableDeclaration() {
			return getRuleContexts(ClassOrfunctionOrvariableDeclarationContext.class);
		}
		public ClassOrfunctionOrvariableDeclarationContext classOrfunctionOrvariableDeclaration(int i) {
			return getRuleContext(ClassOrfunctionOrvariableDeclarationContext.class,i);
		}
		public CompilationUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compilationUnit; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitCompilationUnit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompilationUnitContext compilationUnit() throws RecognitionException {
		CompilationUnitContext _localctx = new CompilationUnitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_compilationUnit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << CLASS) | (1L << INT) | (1L << VOID) | (1L << SEMI) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(78);
				classOrfunctionOrvariableDeclaration();
				}
				}
				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(84);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassOrfunctionOrvariableDeclarationContext extends ParserRuleContext {
		public ClassOrfunctionOrvariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classOrfunctionOrvariableDeclaration; }
	 
		public ClassOrfunctionOrvariableDeclarationContext() { }
		public void copyFrom(ClassOrfunctionOrvariableDeclarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FuncdecContext extends ClassOrfunctionOrvariableDeclarationContext {
		public FunctionDeclarationContext functionDeclaration() {
			return getRuleContext(FunctionDeclarationContext.class,0);
		}
		public FuncdecContext(ClassOrfunctionOrvariableDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitFuncdec(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VaridecContext extends ClassOrfunctionOrvariableDeclarationContext {
		public LocalVariableDeclarationContext localVariableDeclaration() {
			return getRuleContext(LocalVariableDeclarationContext.class,0);
		}
		public VaridecContext(ClassOrfunctionOrvariableDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitVaridec(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypedecContext extends ClassOrfunctionOrvariableDeclarationContext {
		public TypeDeclarationContext typeDeclaration() {
			return getRuleContext(TypeDeclarationContext.class,0);
		}
		public TypedecContext(ClassOrfunctionOrvariableDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitTypedec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassOrfunctionOrvariableDeclarationContext classOrfunctionOrvariableDeclaration() throws RecognitionException {
		ClassOrfunctionOrvariableDeclarationContext _localctx = new ClassOrfunctionOrvariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_classOrfunctionOrvariableDeclaration);
		try {
			setState(89);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new TypedecContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(86);
				typeDeclaration();
				}
				break;
			case 2:
				_localctx = new FuncdecContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(87);
				functionDeclaration();
				}
				break;
			case 3:
				_localctx = new VaridecContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(88);
				localVariableDeclaration();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionDeclarationContext extends ParserRuleContext {
		public MethodDeclarationContext methodDeclaration() {
			return getRuleContext(MethodDeclarationContext.class,0);
		}
		public FunctionDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitFunctionDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDeclarationContext functionDeclaration() throws RecognitionException {
		FunctionDeclarationContext _localctx = new FunctionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_functionDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			methodDeclaration();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeDeclarationContext extends ParserRuleContext {
		public TypeDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDeclaration; }
	 
		public TypeDeclarationContext() { }
		public void copyFrom(TypeDeclarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class EmptytypeContext extends TypeDeclarationContext {
		public EmptytypeContext(TypeDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitEmptytype(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ClassdecContext extends TypeDeclarationContext {
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public ClassdecContext(TypeDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitClassdec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeDeclarationContext typeDeclaration() throws RecognitionException {
		TypeDeclarationContext _localctx = new TypeDeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_typeDeclaration);
		try {
			setState(95);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CLASS:
				_localctx = new ClassdecContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(93);
				classDeclaration();
				}
				break;
			case SEMI:
				_localctx = new EmptytypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(94);
				match(SEMI);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassDeclarationContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(mlperParser.CLASS, 0); }
		public TerminalNode IDENTIFIER() { return getToken(mlperParser.IDENTIFIER, 0); }
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public ClassDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitClassDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDeclarationContext classDeclaration() throws RecognitionException {
		ClassDeclarationContext _localctx = new ClassDeclarationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_classDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			match(CLASS);
			setState(98);
			match(IDENTIFIER);
			setState(99);
			classBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassBodyContext extends ParserRuleContext {
		public List<ClassBodyDeclarationContext> classBodyDeclaration() {
			return getRuleContexts(ClassBodyDeclarationContext.class);
		}
		public ClassBodyDeclarationContext classBodyDeclaration(int i) {
			return getRuleContext(ClassBodyDeclarationContext.class,i);
		}
		public ClassBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classBody; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitClassBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassBodyContext classBody() throws RecognitionException {
		ClassBodyContext _localctx = new ClassBodyContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_classBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			match(LBRACE);
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << INT) | (1L << VOID) | (1L << LBRACE) | (1L << SEMI) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(102);
				classBodyDeclaration();
				}
				}
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(108);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassBodyDeclarationContext extends ParserRuleContext {
		public ClassBodyDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classBodyDeclaration; }
	 
		public ClassBodyDeclarationContext() { }
		public void copyFrom(ClassBodyDeclarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class EmptyclassContext extends ClassBodyDeclarationContext {
		public EmptyclassContext(ClassBodyDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitEmptyclass(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ClassblockContext extends ClassBodyDeclarationContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ClassblockContext(ClassBodyDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitClassblock(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MemdecContext extends ClassBodyDeclarationContext {
		public MemberDeclarationContext memberDeclaration() {
			return getRuleContext(MemberDeclarationContext.class,0);
		}
		public MemdecContext(ClassBodyDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitMemdec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassBodyDeclarationContext classBodyDeclaration() throws RecognitionException {
		ClassBodyDeclarationContext _localctx = new ClassBodyDeclarationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_classBodyDeclaration);
		try {
			setState(113);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SEMI:
				_localctx = new EmptyclassContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(110);
				match(SEMI);
				}
				break;
			case LBRACE:
				_localctx = new ClassblockContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(111);
				block();
				}
				break;
			case BOOLEAN:
			case INT:
			case VOID:
			case IDENTIFIER:
				_localctx = new MemdecContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(112);
				memberDeclaration();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MemberDeclarationContext extends ParserRuleContext {
		public MemberDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_memberDeclaration; }
	 
		public MemberDeclarationContext() { }
		public void copyFrom(MemberDeclarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FielddecContext extends MemberDeclarationContext {
		public FieldDeclarationContext fieldDeclaration() {
			return getRuleContext(FieldDeclarationContext.class,0);
		}
		public FielddecContext(MemberDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitFielddec(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConstructdecContext extends MemberDeclarationContext {
		public ConstructorDeclarationContext constructorDeclaration() {
			return getRuleContext(ConstructorDeclarationContext.class,0);
		}
		public ConstructdecContext(MemberDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitConstructdec(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MethoddecContext extends MemberDeclarationContext {
		public MethodDeclarationContext methodDeclaration() {
			return getRuleContext(MethodDeclarationContext.class,0);
		}
		public MethoddecContext(MemberDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitMethoddec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MemberDeclarationContext memberDeclaration() throws RecognitionException {
		MemberDeclarationContext _localctx = new MemberDeclarationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_memberDeclaration);
		try {
			setState(118);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new MethoddecContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(115);
				methodDeclaration();
				}
				break;
			case 2:
				_localctx = new FielddecContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(116);
				fieldDeclaration();
				}
				break;
			case 3:
				_localctx = new ConstructdecContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(117);
				constructorDeclaration();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodDeclarationContext extends ParserRuleContext {
		public TypeTypeOrVoidContext typeTypeOrVoid() {
			return getRuleContext(TypeTypeOrVoidContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(mlperParser.IDENTIFIER, 0); }
		public FormalParametersContext formalParameters() {
			return getRuleContext(FormalParametersContext.class,0);
		}
		public MethodBodyContext methodBody() {
			return getRuleContext(MethodBodyContext.class,0);
		}
		public MethodDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitMethodDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodDeclarationContext methodDeclaration() throws RecognitionException {
		MethodDeclarationContext _localctx = new MethodDeclarationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_methodDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			typeTypeOrVoid();
			setState(121);
			match(IDENTIFIER);
			setState(122);
			formalParameters();
			setState(123);
			methodBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodBodyContext extends ParserRuleContext {
		public MethodBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodBody; }
	 
		public MethodBodyContext() { }
		public void copyFrom(MethodBodyContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MethodblockContext extends MethodBodyContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public MethodblockContext(MethodBodyContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitMethodblock(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EmptymethodContext extends MethodBodyContext {
		public EmptymethodContext(MethodBodyContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitEmptymethod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodBodyContext methodBody() throws RecognitionException {
		MethodBodyContext _localctx = new MethodBodyContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_methodBody);
		try {
			setState(127);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				_localctx = new MethodblockContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(125);
				block();
				}
				break;
			case SEMI:
				_localctx = new EmptymethodContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(126);
				match(SEMI);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeTypeOrVoidContext extends ParserRuleContext {
		public TypeTypeOrVoidContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeTypeOrVoid; }
	 
		public TypeTypeOrVoidContext() { }
		public void copyFrom(TypeTypeOrVoidContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VoidContext extends TypeTypeOrVoidContext {
		public TerminalNode VOID() { return getToken(mlperParser.VOID, 0); }
		public VoidContext(TypeTypeOrVoidContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitVoid(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypeContext extends TypeTypeOrVoidContext {
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public TypeContext(TypeTypeOrVoidContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeTypeOrVoidContext typeTypeOrVoid() throws RecognitionException {
		TypeTypeOrVoidContext _localctx = new TypeTypeOrVoidContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_typeTypeOrVoid);
		try {
			setState(131);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOLEAN:
			case INT:
			case IDENTIFIER:
				_localctx = new TypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(129);
				typeType();
				}
				break;
			case VOID:
				_localctx = new VoidContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(130);
				match(VOID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstructorDeclarationContext extends ParserRuleContext {
		public BlockContext constructorBody;
		public TerminalNode IDENTIFIER() { return getToken(mlperParser.IDENTIFIER, 0); }
		public FormalParametersContext formalParameters() {
			return getRuleContext(FormalParametersContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ConstructorDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructorDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitConstructorDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstructorDeclarationContext constructorDeclaration() throws RecognitionException {
		ConstructorDeclarationContext _localctx = new ConstructorDeclarationContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_constructorDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			match(IDENTIFIER);
			setState(134);
			formalParameters();
			setState(135);
			((ConstructorDeclarationContext)_localctx).constructorBody = block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldDeclarationContext extends ParserRuleContext {
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public VariableDeclaratorsContext variableDeclarators() {
			return getRuleContext(VariableDeclaratorsContext.class,0);
		}
		public FieldDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitFieldDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldDeclarationContext fieldDeclaration() throws RecognitionException {
		FieldDeclarationContext _localctx = new FieldDeclarationContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_fieldDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			typeType();
			setState(138);
			variableDeclarators();
			setState(139);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableDeclaratorsContext extends ParserRuleContext {
		public List<VariableDeclaratorContext> variableDeclarator() {
			return getRuleContexts(VariableDeclaratorContext.class);
		}
		public VariableDeclaratorContext variableDeclarator(int i) {
			return getRuleContext(VariableDeclaratorContext.class,i);
		}
		public VariableDeclaratorsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclarators; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitVariableDeclarators(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclaratorsContext variableDeclarators() throws RecognitionException {
		VariableDeclaratorsContext _localctx = new VariableDeclaratorsContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_variableDeclarators);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			variableDeclarator();
			setState(146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(142);
				match(COMMA);
				setState(143);
				variableDeclarator();
				}
				}
				setState(148);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableDeclaratorContext extends ParserRuleContext {
		public VariableDeclaratorIdContext variableDeclaratorId() {
			return getRuleContext(VariableDeclaratorIdContext.class,0);
		}
		public VariableInitializerContext variableInitializer() {
			return getRuleContext(VariableInitializerContext.class,0);
		}
		public VariableDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclarator; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitVariableDeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclaratorContext variableDeclarator() throws RecognitionException {
		VariableDeclaratorContext _localctx = new VariableDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_variableDeclarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			variableDeclaratorId();
			setState(152);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(150);
				match(ASSIGN);
				setState(151);
				variableInitializer();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableDeclaratorIdContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(mlperParser.IDENTIFIER, 0); }
		public VariableDeclaratorIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaratorId; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitVariableDeclaratorId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclaratorIdContext variableDeclaratorId() throws RecognitionException {
		VariableDeclaratorIdContext _localctx = new VariableDeclaratorIdContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_variableDeclaratorId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableInitializerContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VariableInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableInitializer; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitVariableInitializer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableInitializerContext variableInitializer() throws RecognitionException {
		VariableInitializerContext _localctx = new VariableInitializerContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_variableInitializer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassOrInterfaceTypeContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(mlperParser.IDENTIFIER, 0); }
		public ClassOrInterfaceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classOrInterfaceType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitClassOrInterfaceType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassOrInterfaceTypeContext classOrInterfaceType() throws RecognitionException {
		ClassOrInterfaceTypeContext _localctx = new ClassOrInterfaceTypeContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_classOrInterfaceType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormalParametersContext extends ParserRuleContext {
		public FormalParameterListContext formalParameterList() {
			return getRuleContext(FormalParameterListContext.class,0);
		}
		public FormalParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameters; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitFormalParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalParametersContext formalParameters() throws RecognitionException {
		FormalParametersContext _localctx = new FormalParametersContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_formalParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			match(LPAREN);
			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << INT) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(161);
				formalParameterList();
				}
			}

			setState(164);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormalParameterListContext extends ParserRuleContext {
		public List<FormalParameterContext> formalParameter() {
			return getRuleContexts(FormalParameterContext.class);
		}
		public FormalParameterContext formalParameter(int i) {
			return getRuleContext(FormalParameterContext.class,i);
		}
		public FormalParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameterList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitFormalParameterList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalParameterListContext formalParameterList() throws RecognitionException {
		FormalParameterListContext _localctx = new FormalParameterListContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_formalParameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			formalParameter();
			setState(171);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(167);
				match(COMMA);
				setState(168);
				formalParameter();
				}
				}
				setState(173);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormalParameterContext extends ParserRuleContext {
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public VariableDeclaratorIdContext variableDeclaratorId() {
			return getRuleContext(VariableDeclaratorIdContext.class,0);
		}
		public FormalParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitFormalParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalParameterContext formalParameter() throws RecognitionException {
		FormalParameterContext _localctx = new FormalParameterContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_formalParameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			typeType();
			setState(175);
			variableDeclaratorId();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
	 
		public LiteralContext() { }
		public void copyFrom(LiteralContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StringContext extends LiteralContext {
		public TerminalNode STRING_LITERAL() { return getToken(mlperParser.STRING_LITERAL, 0); }
		public StringContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolContext extends LiteralContext {
		public TerminalNode BOOL_LITERAL() { return getToken(mlperParser.BOOL_LITERAL, 0); }
		public BoolContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitBool(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NullContext extends LiteralContext {
		public TerminalNode NULL_LITERAL() { return getToken(mlperParser.NULL_LITERAL, 0); }
		public NullContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitNull(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CharContext extends LiteralContext {
		public TerminalNode CHAR_LITERAL() { return getToken(mlperParser.CHAR_LITERAL, 0); }
		public CharContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitChar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntegerContext extends LiteralContext {
		public TerminalNode DECIMAL_LITERAL() { return getToken(mlperParser.DECIMAL_LITERAL, 0); }
		public IntegerContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitInteger(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_literal);
		try {
			setState(182);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DECIMAL_LITERAL:
				_localctx = new IntegerContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(177);
				match(DECIMAL_LITERAL);
				}
				break;
			case CHAR_LITERAL:
				_localctx = new CharContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(178);
				match(CHAR_LITERAL);
				}
				break;
			case STRING_LITERAL:
				_localctx = new StringContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(179);
				match(STRING_LITERAL);
				}
				break;
			case BOOL_LITERAL:
				_localctx = new BoolContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(180);
				match(BOOL_LITERAL);
				}
				break;
			case NULL_LITERAL:
				_localctx = new NullContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(181);
				match(NULL_LITERAL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public List<BlockStatementContext> blockStatement() {
			return getRuleContexts(BlockStatementContext.class);
		}
		public BlockStatementContext blockStatement(int i) {
			return getRuleContext(BlockStatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			match(LBRACE);
			setState(188);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << BREAK) | (1L << CONTINUE) | (1L << FOR) | (1L << IF) | (1L << INT) | (1L << NEW) | (1L << RETURN) | (1L << THIS) | (1L << WHILE) | (1L << DECIMAL_LITERAL) | (1L << BOOL_LITERAL) | (1L << CHAR_LITERAL) | (1L << STRING_LITERAL) | (1L << NULL_LITERAL) | (1L << LPAREN) | (1L << LBRACE) | (1L << SEMI) | (1L << BANG) | (1L << TILDE) | (1L << INC) | (1L << DEC) | (1L << ADD) | (1L << SUB) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(185);
				blockStatement();
				}
				}
				setState(190);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(191);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockStatementContext extends ParserRuleContext {
		public BlockStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockStatement; }
	 
		public BlockStatementContext() { }
		public void copyFrom(BlockStatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BlockvaridecContext extends BlockStatementContext {
		public LocalVariableDeclarationContext localVariableDeclaration() {
			return getRuleContext(LocalVariableDeclarationContext.class,0);
		}
		public BlockvaridecContext(BlockStatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitBlockvaridec(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlockstatContext extends BlockStatementContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public BlockstatContext(BlockStatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitBlockstat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockStatementContext blockStatement() throws RecognitionException {
		BlockStatementContext _localctx = new BlockStatementContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_blockStatement);
		try {
			setState(197);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				_localctx = new BlockvaridecContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(193);
				localVariableDeclaration();
				setState(194);
				match(SEMI);
				}
				break;
			case 2:
				_localctx = new BlockstatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(196);
				statement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LocalVariableDeclarationContext extends ParserRuleContext {
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public VariableDeclaratorsContext variableDeclarators() {
			return getRuleContext(VariableDeclaratorsContext.class,0);
		}
		public LocalVariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localVariableDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitLocalVariableDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocalVariableDeclarationContext localVariableDeclaration() throws RecognitionException {
		LocalVariableDeclarationContext _localctx = new LocalVariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_localVariableDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			typeType();
			setState(200);
			variableDeclarators();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IfstatContext extends StatementContext {
		public TerminalNode IF() { return getToken(mlperParser.IF, 0); }
		public ParExpressionContext parExpression() {
			return getRuleContext(ParExpressionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(mlperParser.ELSE, 0); }
		public IfstatContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitIfstat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatblockContext extends StatementContext {
		public BlockContext blockLabel;
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public StatblockContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitStatblock(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BreakContext extends StatementContext {
		public TerminalNode BREAK() { return getToken(mlperParser.BREAK, 0); }
		public TerminalNode IDENTIFIER() { return getToken(mlperParser.IDENTIFIER, 0); }
		public BreakContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitBreak(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ContinueContext extends StatementContext {
		public TerminalNode CONTINUE() { return getToken(mlperParser.CONTINUE, 0); }
		public TerminalNode IDENTIFIER() { return getToken(mlperParser.IDENTIFIER, 0); }
		public ContinueContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitContinue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressContext extends StatementContext {
		public ExpressionContext statementExpression;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitExpress(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SemiContext extends StatementContext {
		public TerminalNode SEMI() { return getToken(mlperParser.SEMI, 0); }
		public SemiContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitSemi(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WhilestatContext extends StatementContext {
		public TerminalNode WHILE() { return getToken(mlperParser.WHILE, 0); }
		public ParExpressionContext parExpression() {
			return getRuleContext(ParExpressionContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public WhilestatContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitWhilestat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ReturnContext extends StatementContext {
		public TerminalNode RETURN() { return getToken(mlperParser.RETURN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitReturn(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ForstatContext extends StatementContext {
		public TerminalNode FOR() { return getToken(mlperParser.FOR, 0); }
		public ForControlContext forControl() {
			return getRuleContext(ForControlContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ForstatContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitForstat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_statement);
		int _la;
		try {
			setState(239);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				_localctx = new StatblockContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(202);
				((StatblockContext)_localctx).blockLabel = block();
				}
				break;
			case IF:
				_localctx = new IfstatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(203);
				match(IF);
				setState(204);
				parExpression();
				setState(205);
				statement();
				setState(208);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(206);
					match(ELSE);
					setState(207);
					statement();
					}
					break;
				}
				}
				break;
			case FOR:
				_localctx = new ForstatContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(210);
				match(FOR);
				setState(211);
				match(LPAREN);
				setState(212);
				forControl();
				setState(213);
				match(RPAREN);
				setState(214);
				statement();
				}
				break;
			case WHILE:
				_localctx = new WhilestatContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(216);
				match(WHILE);
				setState(217);
				parExpression();
				setState(218);
				statement();
				}
				break;
			case RETURN:
				_localctx = new ReturnContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(220);
				match(RETURN);
				setState(222);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW) | (1L << THIS) | (1L << DECIMAL_LITERAL) | (1L << BOOL_LITERAL) | (1L << CHAR_LITERAL) | (1L << STRING_LITERAL) | (1L << NULL_LITERAL) | (1L << LPAREN) | (1L << BANG) | (1L << TILDE) | (1L << INC) | (1L << DEC) | (1L << ADD) | (1L << SUB) | (1L << IDENTIFIER))) != 0)) {
					{
					setState(221);
					expression(0);
					}
				}

				setState(224);
				match(SEMI);
				}
				break;
			case BREAK:
				_localctx = new BreakContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(225);
				match(BREAK);
				setState(227);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIER) {
					{
					setState(226);
					match(IDENTIFIER);
					}
				}

				setState(229);
				match(SEMI);
				}
				break;
			case CONTINUE:
				_localctx = new ContinueContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(230);
				match(CONTINUE);
				setState(232);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIER) {
					{
					setState(231);
					match(IDENTIFIER);
					}
				}

				setState(234);
				match(SEMI);
				}
				break;
			case SEMI:
				_localctx = new SemiContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(235);
				match(SEMI);
				}
				break;
			case NEW:
			case THIS:
			case DECIMAL_LITERAL:
			case BOOL_LITERAL:
			case CHAR_LITERAL:
			case STRING_LITERAL:
			case NULL_LITERAL:
			case LPAREN:
			case BANG:
			case TILDE:
			case INC:
			case DEC:
			case ADD:
			case SUB:
			case IDENTIFIER:
				_localctx = new ExpressContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(236);
				((ExpressContext)_localctx).statementExpression = expression(0);
				setState(237);
				match(SEMI);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForControlContext extends ParserRuleContext {
		public ExpressionListContext forUpdate;
		public ForInitContext forInit() {
			return getRuleContext(ForInitContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public ForControlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forControl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitForControl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForControlContext forControl() throws RecognitionException {
		ForControlContext _localctx = new ForControlContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_forControl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << INT) | (1L << NEW) | (1L << THIS) | (1L << DECIMAL_LITERAL) | (1L << BOOL_LITERAL) | (1L << CHAR_LITERAL) | (1L << STRING_LITERAL) | (1L << NULL_LITERAL) | (1L << LPAREN) | (1L << BANG) | (1L << TILDE) | (1L << INC) | (1L << DEC) | (1L << ADD) | (1L << SUB) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(241);
				forInit();
				}
			}

			setState(244);
			match(SEMI);
			setState(246);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW) | (1L << THIS) | (1L << DECIMAL_LITERAL) | (1L << BOOL_LITERAL) | (1L << CHAR_LITERAL) | (1L << STRING_LITERAL) | (1L << NULL_LITERAL) | (1L << LPAREN) | (1L << BANG) | (1L << TILDE) | (1L << INC) | (1L << DEC) | (1L << ADD) | (1L << SUB) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(245);
				expression(0);
				}
			}

			setState(248);
			match(SEMI);
			setState(250);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW) | (1L << THIS) | (1L << DECIMAL_LITERAL) | (1L << BOOL_LITERAL) | (1L << CHAR_LITERAL) | (1L << STRING_LITERAL) | (1L << NULL_LITERAL) | (1L << LPAREN) | (1L << BANG) | (1L << TILDE) | (1L << INC) | (1L << DEC) | (1L << ADD) | (1L << SUB) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(249);
				((ForControlContext)_localctx).forUpdate = expressionList();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForInitContext extends ParserRuleContext {
		public ForInitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forInit; }
	 
		public ForInitContext() { }
		public void copyFrom(ForInitContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ForvariableContext extends ForInitContext {
		public LocalVariableDeclarationContext localVariableDeclaration() {
			return getRuleContext(LocalVariableDeclarationContext.class,0);
		}
		public ForvariableContext(ForInitContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitForvariable(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ForexprlistContext extends ForInitContext {
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public ForexprlistContext(ForInitContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitForexprlist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForInitContext forInit() throws RecognitionException {
		ForInitContext _localctx = new ForInitContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_forInit);
		try {
			setState(254);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				_localctx = new ForvariableContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(252);
				localVariableDeclaration();
				}
				break;
			case 2:
				_localctx = new ForexprlistContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(253);
				expressionList();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParExpressionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitParExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParExpressionContext parExpression() throws RecognitionException {
		ParExpressionContext _localctx = new ParExpressionContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_parExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			match(LPAREN);
			setState(257);
			expression(0);
			setState(258);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitExpressionList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionListContext expressionList() throws RecognitionException {
		ExpressionListContext _localctx = new ExpressionListContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_expressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			expression(0);
			setState(265);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(261);
				match(COMMA);
				setState(262);
				expression(0);
				}
				}
				setState(267);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodCallContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(mlperParser.IDENTIFIER, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public MethodCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodCall; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitMethodCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodCallContext methodCall() throws RecognitionException {
		MethodCallContext _localctx = new MethodCallContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_methodCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
			match(IDENTIFIER);
			setState(269);
			match(LPAREN);
			setState(271);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW) | (1L << THIS) | (1L << DECIMAL_LITERAL) | (1L << BOOL_LITERAL) | (1L << CHAR_LITERAL) | (1L << STRING_LITERAL) | (1L << NULL_LITERAL) | (1L << LPAREN) | (1L << BANG) | (1L << TILDE) | (1L << INC) | (1L << DEC) | (1L << ADD) | (1L << SUB) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(270);
				expressionList();
				}
			}

			setState(273);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NewContext extends ExpressionContext {
		public TerminalNode NEW() { return getToken(mlperParser.NEW, 0); }
		public CreatorContext creator() {
			return getRuleContext(CreatorContext.class,0);
		}
		public NewContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitNew(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ThisexprContext extends ExpressionContext {
		public Token bop;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode THIS() { return getToken(mlperParser.THIS, 0); }
		public ThisexprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitThisexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MethodContext extends ExpressionContext {
		public Token bop;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public MethodCallContext methodCall() {
			return getRuleContext(MethodCallContext.class,0);
		}
		public MethodContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitMethod(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ArrayContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitArray(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PriContext extends ExpressionContext {
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public PriContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitPri(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrefixContext extends ExpressionContext {
		public Token prefix;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PrefixContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitPrefix(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunctionContext extends ExpressionContext {
		public MethodCallContext methodCall() {
			return getRuleContext(MethodCallContext.class,0);
		}
		public FunctionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BinaryContext extends ExpressionContext {
		public Token bop;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public BinaryContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitBinary(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MemberContext extends ExpressionContext {
		public Token bop;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(mlperParser.IDENTIFIER, 0); }
		public MemberContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitMember(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PostfixContext extends ExpressionContext {
		public Token postfix;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PostfixContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitPostfix(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignContext extends ExpressionContext {
		public Token bop;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AssignContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 62;
		enterRecursionRule(_localctx, 62, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				{
				_localctx = new PriContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(276);
				primary();
				}
				break;
			case 2:
				{
				_localctx = new FunctionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(277);
				methodCall();
				}
				break;
			case 3:
				{
				_localctx = new NewContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(278);
				match(NEW);
				setState(279);
				creator();
				}
				break;
			case 4:
				{
				_localctx = new PrefixContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(280);
				((PrefixContext)_localctx).prefix = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INC) | (1L << DEC) | (1L << ADD) | (1L << SUB))) != 0)) ) {
					((PrefixContext)_localctx).prefix = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(281);
				expression(13);
				}
				break;
			case 5:
				{
				_localctx = new PrefixContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(282);
				((PrefixContext)_localctx).prefix = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==BANG || _la==TILDE) ) {
					((PrefixContext)_localctx).prefix = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(283);
				expression(12);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(337);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(335);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(286);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(287);
						((BinaryContext)_localctx).bop = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MUL) | (1L << DIV) | (1L << MOD))) != 0)) ) {
							((BinaryContext)_localctx).bop = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(288);
						expression(12);
						}
						break;
					case 2:
						{
						_localctx = new BinaryContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(289);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(290);
						((BinaryContext)_localctx).bop = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((BinaryContext)_localctx).bop = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(291);
						expression(11);
						}
						break;
					case 3:
						{
						_localctx = new BinaryContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(292);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(293);
						((BinaryContext)_localctx).bop = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==LSHIFT || _la==URSHIFT) ) {
							((BinaryContext)_localctx).bop = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(294);
						expression(10);
						}
						break;
					case 4:
						{
						_localctx = new BinaryContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(295);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(296);
						((BinaryContext)_localctx).bop = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GT) | (1L << LT) | (1L << LE) | (1L << GE))) != 0)) ) {
							((BinaryContext)_localctx).bop = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(297);
						expression(9);
						}
						break;
					case 5:
						{
						_localctx = new BinaryContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(298);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(299);
						((BinaryContext)_localctx).bop = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQUAL || _la==NOTEQUAL) ) {
							((BinaryContext)_localctx).bop = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(300);
						expression(8);
						}
						break;
					case 6:
						{
						_localctx = new BinaryContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(301);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(302);
						((BinaryContext)_localctx).bop = match(BITAND);
						setState(303);
						expression(7);
						}
						break;
					case 7:
						{
						_localctx = new BinaryContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(304);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(305);
						((BinaryContext)_localctx).bop = match(CARET);
						setState(306);
						expression(6);
						}
						break;
					case 8:
						{
						_localctx = new BinaryContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(307);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(308);
						((BinaryContext)_localctx).bop = match(BITOR);
						setState(309);
						expression(5);
						}
						break;
					case 9:
						{
						_localctx = new BinaryContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(310);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(311);
						((BinaryContext)_localctx).bop = match(AND);
						setState(312);
						expression(4);
						}
						break;
					case 10:
						{
						_localctx = new BinaryContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(313);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(314);
						((BinaryContext)_localctx).bop = match(OR);
						setState(315);
						expression(3);
						}
						break;
					case 11:
						{
						_localctx = new AssignContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(316);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(317);
						((AssignContext)_localctx).bop = match(ASSIGN);
						setState(318);
						expression(1);
						}
						break;
					case 12:
						{
						_localctx = new MemberContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(319);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(320);
						((MemberContext)_localctx).bop = match(DOT);
						setState(321);
						match(IDENTIFIER);
						}
						break;
					case 13:
						{
						_localctx = new MethodContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(322);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(323);
						((MethodContext)_localctx).bop = match(DOT);
						setState(324);
						methodCall();
						}
						break;
					case 14:
						{
						_localctx = new ThisexprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(325);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(326);
						((ThisexprContext)_localctx).bop = match(DOT);
						setState(327);
						match(THIS);
						}
						break;
					case 15:
						{
						_localctx = new ArrayContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(328);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(329);
						match(LBRACK);
						setState(330);
						expression(0);
						setState(331);
						match(RBRACK);
						}
						break;
					case 16:
						{
						_localctx = new PostfixContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(333);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(334);
						((PostfixContext)_localctx).postfix = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==INC || _la==DEC) ) {
							((PostfixContext)_localctx).postfix = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						break;
					}
					} 
				}
				setState(339);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class PrimaryContext extends ParserRuleContext {
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
	 
		public PrimaryContext() { }
		public void copyFrom(PrimaryContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LiteralsContext extends PrimaryContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public LiteralsContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitLiterals(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ThisContext extends PrimaryContext {
		public TerminalNode THIS() { return getToken(mlperParser.THIS, 0); }
		public ThisContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitThis(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VariableContext extends PrimaryContext {
		public TerminalNode IDENTIFIER() { return getToken(mlperParser.IDENTIFIER, 0); }
		public VariableContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprContext extends PrimaryContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExprContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_primary);
		try {
			setState(347);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				_localctx = new ExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(340);
				match(LPAREN);
				setState(341);
				expression(0);
				setState(342);
				match(RPAREN);
				}
				break;
			case THIS:
				_localctx = new ThisContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(344);
				match(THIS);
				}
				break;
			case DECIMAL_LITERAL:
			case BOOL_LITERAL:
			case CHAR_LITERAL:
			case STRING_LITERAL:
			case NULL_LITERAL:
				_localctx = new LiteralsContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(345);
				literal();
				}
				break;
			case IDENTIFIER:
				_localctx = new VariableContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(346);
				match(IDENTIFIER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CreatorContext extends ParserRuleContext {
		public CreatedNameContext createdName() {
			return getRuleContext(CreatedNameContext.class,0);
		}
		public ArrayCreatorRestContext arrayCreatorRest() {
			return getRuleContext(ArrayCreatorRestContext.class,0);
		}
		public ClassCreatorRestContext classCreatorRest() {
			return getRuleContext(ClassCreatorRestContext.class,0);
		}
		public CreatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_creator; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitCreator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CreatorContext creator() throws RecognitionException {
		CreatorContext _localctx = new CreatorContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_creator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(349);
			createdName();
			setState(352);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACK:
				{
				setState(350);
				arrayCreatorRest();
				}
				break;
			case LPAREN:
				{
				setState(351);
				classCreatorRest();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CreatedNameContext extends ParserRuleContext {
		public CreatedNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_createdName; }
	 
		public CreatedNameContext() { }
		public void copyFrom(CreatedNameContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NewprimitiveContext extends CreatedNameContext {
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public NewprimitiveContext(CreatedNameContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitNewprimitive(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NewclassContext extends CreatedNameContext {
		public TerminalNode IDENTIFIER() { return getToken(mlperParser.IDENTIFIER, 0); }
		public NewclassContext(CreatedNameContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitNewclass(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CreatedNameContext createdName() throws RecognitionException {
		CreatedNameContext _localctx = new CreatedNameContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_createdName);
		try {
			setState(356);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				_localctx = new NewclassContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(354);
				match(IDENTIFIER);
				}
				break;
			case BOOLEAN:
			case INT:
				_localctx = new NewprimitiveContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(355);
				primitiveType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayCreatorRestContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> LBRACE() { return getTokens(mlperParser.LBRACE); }
		public TerminalNode LBRACE(int i) {
			return getToken(mlperParser.LBRACE, i);
		}
		public List<TerminalNode> RBRACE() { return getTokens(mlperParser.RBRACE); }
		public TerminalNode RBRACE(int i) {
			return getToken(mlperParser.RBRACE, i);
		}
		public ArrayCreatorRestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayCreatorRest; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitArrayCreatorRest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayCreatorRestContext arrayCreatorRest() throws RecognitionException {
		ArrayCreatorRestContext _localctx = new ArrayCreatorRestContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_arrayCreatorRest);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(362); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(358);
					match(LBRACK);
					setState(359);
					expression(0);
					setState(360);
					match(RBRACK);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(364); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(370);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(366);
					match(LBRACE);
					setState(367);
					match(RBRACE);
					}
					} 
				}
				setState(372);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassCreatorRestContext extends ParserRuleContext {
		public ClassCreatorRestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classCreatorRest; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitClassCreatorRest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassCreatorRestContext classCreatorRest() throws RecognitionException {
		ClassCreatorRestContext _localctx = new ClassCreatorRestContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_classCreatorRest);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(373);
			match(LPAREN);
			setState(374);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeTypeContext extends ParserRuleContext {
		public ClassOrInterfaceTypeContext classOrInterfaceType() {
			return getRuleContext(ClassOrInterfaceTypeContext.class,0);
		}
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public List<TerminalNode> LBRACE() { return getTokens(mlperParser.LBRACE); }
		public TerminalNode LBRACE(int i) {
			return getToken(mlperParser.LBRACE, i);
		}
		public List<TerminalNode> RBRACE() { return getTokens(mlperParser.RBRACE); }
		public TerminalNode RBRACE(int i) {
			return getToken(mlperParser.RBRACE, i);
		}
		public TypeTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitTypeType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeTypeContext typeType() throws RecognitionException {
		TypeTypeContext _localctx = new TypeTypeContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_typeType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(378);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				setState(376);
				classOrInterfaceType();
				}
				break;
			case BOOLEAN:
			case INT:
				{
				setState(377);
				primitiveType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(384);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRACE) {
				{
				{
				setState(380);
				match(LBRACE);
				setState(381);
				match(RBRACE);
				}
				}
				setState(386);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimitiveTypeContext extends ParserRuleContext {
		public PrimitiveTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitiveType; }
	 
		public PrimitiveTypeContext() { }
		public void copyFrom(PrimitiveTypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BooleanContext extends PrimitiveTypeContext {
		public TerminalNode BOOLEAN() { return getToken(mlperParser.BOOLEAN, 0); }
		public BooleanContext(PrimitiveTypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitBoolean(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntContext extends PrimitiveTypeContext {
		public TerminalNode INT() { return getToken(mlperParser.INT, 0); }
		public IntContext(PrimitiveTypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mlperVisitor ) return ((mlperVisitor<? extends T>)visitor).visitInt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimitiveTypeContext primitiveType() throws RecognitionException {
		PrimitiveTypeContext _localctx = new PrimitiveTypeContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_primitiveType);
		try {
			setState(389);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOLEAN:
				_localctx = new BooleanContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(387);
				match(BOOLEAN);
				}
				break;
			case INT:
				_localctx = new IntContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(388);
				match(INT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 31:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 11);
		case 1:
			return precpred(_ctx, 10);
		case 2:
			return precpred(_ctx, 9);
		case 3:
			return precpred(_ctx, 8);
		case 4:
			return precpred(_ctx, 7);
		case 5:
			return precpred(_ctx, 6);
		case 6:
			return precpred(_ctx, 5);
		case 7:
			return precpred(_ctx, 4);
		case 8:
			return precpred(_ctx, 3);
		case 9:
			return precpred(_ctx, 2);
		case 10:
			return precpred(_ctx, 1);
		case 11:
			return precpred(_ctx, 20);
		case 12:
			return precpred(_ctx, 19);
		case 13:
			return precpred(_ctx, 18);
		case 14:
			return precpred(_ctx, 17);
		case 15:
			return precpred(_ctx, 14);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3;\u018a\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\3\2\7\2R\n\2\f\2\16"+
		"\2U\13\2\3\2\3\2\3\3\3\3\3\3\5\3\\\n\3\3\4\3\4\3\5\3\5\5\5b\n\5\3\6\3"+
		"\6\3\6\3\6\3\7\3\7\7\7j\n\7\f\7\16\7m\13\7\3\7\3\7\3\b\3\b\3\b\5\bt\n"+
		"\b\3\t\3\t\3\t\5\ty\n\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\5\13\u0082\n\13"+
		"\3\f\3\f\5\f\u0086\n\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3"+
		"\17\7\17\u0093\n\17\f\17\16\17\u0096\13\17\3\20\3\20\3\20\5\20\u009b\n"+
		"\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\5\24\u00a5\n\24\3\24\3\24"+
		"\3\25\3\25\3\25\7\25\u00ac\n\25\f\25\16\25\u00af\13\25\3\26\3\26\3\26"+
		"\3\27\3\27\3\27\3\27\3\27\5\27\u00b9\n\27\3\30\3\30\7\30\u00bd\n\30\f"+
		"\30\16\30\u00c0\13\30\3\30\3\30\3\31\3\31\3\31\3\31\5\31\u00c8\n\31\3"+
		"\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u00d3\n\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u00e1\n\33\3\33"+
		"\3\33\3\33\5\33\u00e6\n\33\3\33\3\33\3\33\5\33\u00eb\n\33\3\33\3\33\3"+
		"\33\3\33\3\33\5\33\u00f2\n\33\3\34\5\34\u00f5\n\34\3\34\3\34\5\34\u00f9"+
		"\n\34\3\34\3\34\5\34\u00fd\n\34\3\35\3\35\5\35\u0101\n\35\3\36\3\36\3"+
		"\36\3\36\3\37\3\37\3\37\7\37\u010a\n\37\f\37\16\37\u010d\13\37\3 \3 \3"+
		" \5 \u0112\n \3 \3 \3!\3!\3!\3!\3!\3!\3!\3!\3!\5!\u011f\n!\3!\3!\3!\3"+
		"!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3"+
		"!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\7"+
		"!\u0152\n!\f!\16!\u0155\13!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u015e\n\""+
		"\3#\3#\3#\5#\u0163\n#\3$\3$\5$\u0167\n$\3%\3%\3%\3%\6%\u016d\n%\r%\16"+
		"%\u016e\3%\3%\7%\u0173\n%\f%\16%\u0176\13%\3&\3&\3&\3\'\3\'\5\'\u017d"+
		"\n\'\3\'\3\'\7\'\u0181\n\'\f\'\16\'\u0184\13\'\3(\3(\5(\u0188\n(\3(\2"+
		"\3@)\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@"+
		"BDFHJLN\2\n\3\2-\60\3\2#$\4\2\61\62\66\66\3\2/\60\3\2\678\4\2!\"()\4\2"+
		"\'\'**\3\2-.\2\u01a7\2S\3\2\2\2\4[\3\2\2\2\6]\3\2\2\2\ba\3\2\2\2\nc\3"+
		"\2\2\2\fg\3\2\2\2\16s\3\2\2\2\20x\3\2\2\2\22z\3\2\2\2\24\u0081\3\2\2\2"+
		"\26\u0085\3\2\2\2\30\u0087\3\2\2\2\32\u008b\3\2\2\2\34\u008f\3\2\2\2\36"+
		"\u0097\3\2\2\2 \u009c\3\2\2\2\"\u009e\3\2\2\2$\u00a0\3\2\2\2&\u00a2\3"+
		"\2\2\2(\u00a8\3\2\2\2*\u00b0\3\2\2\2,\u00b8\3\2\2\2.\u00ba\3\2\2\2\60"+
		"\u00c7\3\2\2\2\62\u00c9\3\2\2\2\64\u00f1\3\2\2\2\66\u00f4\3\2\2\28\u0100"+
		"\3\2\2\2:\u0102\3\2\2\2<\u0106\3\2\2\2>\u010e\3\2\2\2@\u011e\3\2\2\2B"+
		"\u015d\3\2\2\2D\u015f\3\2\2\2F\u0166\3\2\2\2H\u016c\3\2\2\2J\u0177\3\2"+
		"\2\2L\u017c\3\2\2\2N\u0187\3\2\2\2PR\5\4\3\2QP\3\2\2\2RU\3\2\2\2SQ\3\2"+
		"\2\2ST\3\2\2\2TV\3\2\2\2US\3\2\2\2VW\7\2\2\3W\3\3\2\2\2X\\\5\b\5\2Y\\"+
		"\5\6\4\2Z\\\5\62\32\2[X\3\2\2\2[Y\3\2\2\2[Z\3\2\2\2\\\5\3\2\2\2]^\5\22"+
		"\n\2^\7\3\2\2\2_b\5\n\6\2`b\7\35\2\2a_\3\2\2\2a`\3\2\2\2b\t\3\2\2\2cd"+
		"\7\6\2\2de\7;\2\2ef\5\f\7\2f\13\3\2\2\2gk\7\31\2\2hj\5\16\b\2ih\3\2\2"+
		"\2jm\3\2\2\2ki\3\2\2\2kl\3\2\2\2ln\3\2\2\2mk\3\2\2\2no\7\32\2\2o\r\3\2"+
		"\2\2pt\7\35\2\2qt\5.\30\2rt\5\20\t\2sp\3\2\2\2sq\3\2\2\2sr\3\2\2\2t\17"+
		"\3\2\2\2uy\5\22\n\2vy\5\32\16\2wy\5\30\r\2xu\3\2\2\2xv\3\2\2\2xw\3\2\2"+
		"\2y\21\3\2\2\2z{\5\26\f\2{|\7;\2\2|}\5&\24\2}~\5\24\13\2~\23\3\2\2\2\177"+
		"\u0082\5.\30\2\u0080\u0082\7\35\2\2\u0081\177\3\2\2\2\u0081\u0080\3\2"+
		"\2\2\u0082\25\3\2\2\2\u0083\u0086\5L\'\2\u0084\u0086\7\20\2\2\u0085\u0083"+
		"\3\2\2\2\u0085\u0084\3\2\2\2\u0086\27\3\2\2\2\u0087\u0088\7;\2\2\u0088"+
		"\u0089\5&\24\2\u0089\u008a\5.\30\2\u008a\31\3\2\2\2\u008b\u008c\5L\'\2"+
		"\u008c\u008d\5\34\17\2\u008d\u008e\7\35\2\2\u008e\33\3\2\2\2\u008f\u0094"+
		"\5\36\20\2\u0090\u0091\7\36\2\2\u0091\u0093\5\36\20\2\u0092\u0090\3\2"+
		"\2\2\u0093\u0096\3\2\2\2\u0094\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095"+
		"\35\3\2\2\2\u0096\u0094\3\2\2\2\u0097\u009a\5 \21\2\u0098\u0099\7 \2\2"+
		"\u0099\u009b\5\"\22\2\u009a\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b\37"+
		"\3\2\2\2\u009c\u009d\7;\2\2\u009d!\3\2\2\2\u009e\u009f\5@!\2\u009f#\3"+
		"\2\2\2\u00a0\u00a1\7;\2\2\u00a1%\3\2\2\2\u00a2\u00a4\7\27\2\2\u00a3\u00a5"+
		"\5(\25\2\u00a4\u00a3\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6"+
		"\u00a7\7\30\2\2\u00a7\'\3\2\2\2\u00a8\u00ad\5*\26\2\u00a9\u00aa\7\36\2"+
		"\2\u00aa\u00ac\5*\26\2\u00ab\u00a9\3\2\2\2\u00ac\u00af\3\2\2\2\u00ad\u00ab"+
		"\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae)\3\2\2\2\u00af\u00ad\3\2\2\2\u00b0"+
		"\u00b1\5L\'\2\u00b1\u00b2\5 \21\2\u00b2+\3\2\2\2\u00b3\u00b9\7\22\2\2"+
		"\u00b4\u00b9\7\24\2\2\u00b5\u00b9\7\25\2\2\u00b6\u00b9\7\23\2\2\u00b7"+
		"\u00b9\7\26\2\2\u00b8\u00b3\3\2\2\2\u00b8\u00b4\3\2\2\2\u00b8\u00b5\3"+
		"\2\2\2\u00b8\u00b6\3\2\2\2\u00b8\u00b7\3\2\2\2\u00b9-\3\2\2\2\u00ba\u00be"+
		"\7\31\2\2\u00bb\u00bd\5\60\31\2\u00bc\u00bb\3\2\2\2\u00bd\u00c0\3\2\2"+
		"\2\u00be\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c1\3\2\2\2\u00c0\u00be"+
		"\3\2\2\2\u00c1\u00c2\7\32\2\2\u00c2/\3\2\2\2\u00c3\u00c4\5\62\32\2\u00c4"+
		"\u00c5\7\35\2\2\u00c5\u00c8\3\2\2\2\u00c6\u00c8\5\64\33\2\u00c7\u00c3"+
		"\3\2\2\2\u00c7\u00c6\3\2\2\2\u00c8\61\3\2\2\2\u00c9\u00ca\5L\'\2\u00ca"+
		"\u00cb\5\34\17\2\u00cb\63\3\2\2\2\u00cc\u00f2\5.\30\2\u00cd\u00ce\7\13"+
		"\2\2\u00ce\u00cf\5:\36\2\u00cf\u00d2\5\64\33\2\u00d0\u00d1\7\t\2\2\u00d1"+
		"\u00d3\5\64\33\2\u00d2\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00f2\3"+
		"\2\2\2\u00d4\u00d5\7\n\2\2\u00d5\u00d6\7\27\2\2\u00d6\u00d7\5\66\34\2"+
		"\u00d7\u00d8\7\30\2\2\u00d8\u00d9\5\64\33\2\u00d9\u00f2\3\2\2\2\u00da"+
		"\u00db\7\21\2\2\u00db\u00dc\5:\36\2\u00dc\u00dd\5\64\33\2\u00dd\u00f2"+
		"\3\2\2\2\u00de\u00e0\7\16\2\2\u00df\u00e1\5@!\2\u00e0\u00df\3\2\2\2\u00e0"+
		"\u00e1\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00f2\7\35\2\2\u00e3\u00e5\7"+
		"\4\2\2\u00e4\u00e6\7;\2\2\u00e5\u00e4\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6"+
		"\u00e7\3\2\2\2\u00e7\u00f2\7\35\2\2\u00e8\u00ea\7\b\2\2\u00e9\u00eb\7"+
		";\2\2\u00ea\u00e9\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec"+
		"\u00f2\7\35\2\2\u00ed\u00f2\7\35\2\2\u00ee\u00ef\5@!\2\u00ef\u00f0\7\35"+
		"\2\2\u00f0\u00f2\3\2\2\2\u00f1\u00cc\3\2\2\2\u00f1\u00cd\3\2\2\2\u00f1"+
		"\u00d4\3\2\2\2\u00f1\u00da\3\2\2\2\u00f1\u00de\3\2\2\2\u00f1\u00e3\3\2"+
		"\2\2\u00f1\u00e8\3\2\2\2\u00f1\u00ed\3\2\2\2\u00f1\u00ee\3\2\2\2\u00f2"+
		"\65\3\2\2\2\u00f3\u00f5\58\35\2\u00f4\u00f3\3\2\2\2\u00f4\u00f5\3\2\2"+
		"\2\u00f5\u00f6\3\2\2\2\u00f6\u00f8\7\35\2\2\u00f7\u00f9\5@!\2\u00f8\u00f7"+
		"\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00fc\7\35\2\2"+
		"\u00fb\u00fd\5<\37\2\u00fc\u00fb\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd\67"+
		"\3\2\2\2\u00fe\u0101\5\62\32\2\u00ff\u0101\5<\37\2\u0100\u00fe\3\2\2\2"+
		"\u0100\u00ff\3\2\2\2\u01019\3\2\2\2\u0102\u0103\7\27\2\2\u0103\u0104\5"+
		"@!\2\u0104\u0105\7\30\2\2\u0105;\3\2\2\2\u0106\u010b\5@!\2\u0107\u0108"+
		"\7\36\2\2\u0108\u010a\5@!\2\u0109\u0107\3\2\2\2\u010a\u010d\3\2\2\2\u010b"+
		"\u0109\3\2\2\2\u010b\u010c\3\2\2\2\u010c=\3\2\2\2\u010d\u010b\3\2\2\2"+
		"\u010e\u010f\7;\2\2\u010f\u0111\7\27\2\2\u0110\u0112\5<\37\2\u0111\u0110"+
		"\3\2\2\2\u0111\u0112\3\2\2\2\u0112\u0113\3\2\2\2\u0113\u0114\7\30\2\2"+
		"\u0114?\3\2\2\2\u0115\u0116\b!\1\2\u0116\u011f\5B\"\2\u0117\u011f\5> "+
		"\2\u0118\u0119\7\r\2\2\u0119\u011f\5D#\2\u011a\u011b\t\2\2\2\u011b\u011f"+
		"\5@!\17\u011c\u011d\t\3\2\2\u011d\u011f\5@!\16\u011e\u0115\3\2\2\2\u011e"+
		"\u0117\3\2\2\2\u011e\u0118\3\2\2\2\u011e\u011a\3\2\2\2\u011e\u011c\3\2"+
		"\2\2\u011f\u0153\3\2\2\2\u0120\u0121\f\r\2\2\u0121\u0122\t\4\2\2\u0122"+
		"\u0152\5@!\16\u0123\u0124\f\f\2\2\u0124\u0125\t\5\2\2\u0125\u0152\5@!"+
		"\r\u0126\u0127\f\13\2\2\u0127\u0128\t\6\2\2\u0128\u0152\5@!\f\u0129\u012a"+
		"\f\n\2\2\u012a\u012b\t\7\2\2\u012b\u0152\5@!\13\u012c\u012d\f\t\2\2\u012d"+
		"\u012e\t\b\2\2\u012e\u0152\5@!\n\u012f\u0130\f\b\2\2\u0130\u0131\7\63"+
		"\2\2\u0131\u0152\5@!\t\u0132\u0133\f\7\2\2\u0133\u0134\7\65\2\2\u0134"+
		"\u0152\5@!\b\u0135\u0136\f\6\2\2\u0136\u0137\7\64\2\2\u0137\u0152\5@!"+
		"\7\u0138\u0139\f\5\2\2\u0139\u013a\7+\2\2\u013a\u0152\5@!\6\u013b\u013c"+
		"\f\4\2\2\u013c\u013d\7,\2\2\u013d\u0152\5@!\5\u013e\u013f\f\3\2\2\u013f"+
		"\u0140\7 \2\2\u0140\u0152\5@!\3\u0141\u0142\f\26\2\2\u0142\u0143\7\37"+
		"\2\2\u0143\u0152\7;\2\2\u0144\u0145\f\25\2\2\u0145\u0146\7\37\2\2\u0146"+
		"\u0152\5> \2\u0147\u0148\f\24\2\2\u0148\u0149\7\37\2\2\u0149\u0152\7\17"+
		"\2\2\u014a\u014b\f\23\2\2\u014b\u014c\7\33\2\2\u014c\u014d\5@!\2\u014d"+
		"\u014e\7\34\2\2\u014e\u0152\3\2\2\2\u014f\u0150\f\20\2\2\u0150\u0152\t"+
		"\t\2\2\u0151\u0120\3\2\2\2\u0151\u0123\3\2\2\2\u0151\u0126\3\2\2\2\u0151"+
		"\u0129\3\2\2\2\u0151\u012c\3\2\2\2\u0151\u012f\3\2\2\2\u0151\u0132\3\2"+
		"\2\2\u0151\u0135\3\2\2\2\u0151\u0138\3\2\2\2\u0151\u013b\3\2\2\2\u0151"+
		"\u013e\3\2\2\2\u0151\u0141\3\2\2\2\u0151\u0144\3\2\2\2\u0151\u0147\3\2"+
		"\2\2\u0151\u014a\3\2\2\2\u0151\u014f\3\2\2\2\u0152\u0155\3\2\2\2\u0153"+
		"\u0151\3\2\2\2\u0153\u0154\3\2\2\2\u0154A\3\2\2\2\u0155\u0153\3\2\2\2"+
		"\u0156\u0157\7\27\2\2\u0157\u0158\5@!\2\u0158\u0159\7\30\2\2\u0159\u015e"+
		"\3\2\2\2\u015a\u015e\7\17\2\2\u015b\u015e\5,\27\2\u015c\u015e\7;\2\2\u015d"+
		"\u0156\3\2\2\2\u015d\u015a\3\2\2\2\u015d\u015b\3\2\2\2\u015d\u015c\3\2"+
		"\2\2\u015eC\3\2\2\2\u015f\u0162\5F$\2\u0160\u0163\5H%\2\u0161\u0163\5"+
		"J&\2\u0162\u0160\3\2\2\2\u0162\u0161\3\2\2\2\u0163E\3\2\2\2\u0164\u0167"+
		"\7;\2\2\u0165\u0167\5N(\2\u0166\u0164\3\2\2\2\u0166\u0165\3\2\2\2\u0167"+
		"G\3\2\2\2\u0168\u0169\7\33\2\2\u0169\u016a\5@!\2\u016a\u016b\7\34\2\2"+
		"\u016b\u016d\3\2\2\2\u016c\u0168\3\2\2\2\u016d\u016e\3\2\2\2\u016e\u016c"+
		"\3\2\2\2\u016e\u016f\3\2\2\2\u016f\u0174\3\2\2\2\u0170\u0171\7\31\2\2"+
		"\u0171\u0173\7\32\2\2\u0172\u0170\3\2\2\2\u0173\u0176\3\2\2\2\u0174\u0172"+
		"\3\2\2\2\u0174\u0175\3\2\2\2\u0175I\3\2\2\2\u0176\u0174\3\2\2\2\u0177"+
		"\u0178\7\27\2\2\u0178\u0179\7\30\2\2\u0179K\3\2\2\2\u017a\u017d\5$\23"+
		"\2\u017b\u017d\5N(\2\u017c\u017a\3\2\2\2\u017c\u017b\3\2\2\2\u017d\u0182"+
		"\3\2\2\2\u017e\u017f\7\31\2\2\u017f\u0181\7\32\2\2\u0180\u017e\3\2\2\2"+
		"\u0181\u0184\3\2\2\2\u0182\u0180\3\2\2\2\u0182\u0183\3\2\2\2\u0183M\3"+
		"\2\2\2\u0184\u0182\3\2\2\2\u0185\u0188\7\3\2\2\u0186\u0188\7\f\2\2\u0187"+
		"\u0185\3\2\2\2\u0187\u0186\3\2\2\2\u0188O\3\2\2\2\'S[aksx\u0081\u0085"+
		"\u0094\u009a\u00a4\u00ad\u00b8\u00be\u00c7\u00d2\u00e0\u00e5\u00ea\u00f1"+
		"\u00f4\u00f8\u00fc\u0100\u010b\u0111\u011e\u0151\u0153\u015d\u0162\u0166"+
		"\u016e\u0174\u017c\u0182\u0187";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}