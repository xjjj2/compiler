package visitor;// Generated from mlper.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class mlperLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"BOOLEAN", "BREAK", "CHAR", "CLASS", "CONST", "CONTINUE", "ELSE", "FOR", 
		"IF", "INT", "NEW", "RETURN", "THIS", "VOID", "WHILE", "DECIMAL_LITERAL", 
		"BOOL_LITERAL", "CHAR_LITERAL", "STRING_LITERAL", "NULL_LITERAL", "LPAREN", 
		"RPAREN", "LBRACE", "RBRACE", "LBRACK", "RBRACK", "SEMI", "COMMA", "DOT", 
		"ASSIGN", "GT", "LT", "BANG", "TILDE", "QUESTION", "COLON", "EQUAL", "LE", 
		"GE", "NOTEQUAL", "AND", "OR", "INC", "DEC", "ADD", "SUB", "MUL", "DIV", 
		"BITAND", "BITOR", "CARET", "MOD", "LSHIFT", "URSHIFT", "WS", "LINE_COMMENT", 
		"IDENTIFIER", "EscapeSequence", "Digits", "LetterOrDigit", "Letter"
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


	public mlperLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "mlper.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2;\u0182\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3"+
		"\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3"+
		"\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\21\3\21\3\21\5\21\u00d1\n\21\3\21\6\21\u00d4\n\21\r\21\16\21\u00d5\3"+
		"\21\5\21\u00d9\n\21\5\21\u00db\n\21\3\21\5\21\u00de\n\21\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u00e9\n\22\3\23\3\23\3\23\5\23\u00ee"+
		"\n\23\3\23\3\23\3\24\3\24\3\24\7\24\u00f5\n\24\f\24\16\24\u00f8\13\24"+
		"\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31"+
		"\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3"+
		" \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3&\3\'\3\'\3\'\3(\3(\3(\3)\3)"+
		"\3)\3*\3*\3*\3+\3+\3+\3,\3,\3,\3-\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61"+
		"\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\66\3\66\3\66\3\67\3\67\3\67"+
		"\38\68\u0150\n8\r8\168\u0151\38\38\39\39\39\39\79\u015a\n9\f9\169\u015d"+
		"\139\39\39\3:\3:\7:\u0163\n:\f:\16:\u0166\13:\3;\3;\3;\3;\5;\u016c\n;"+
		"\3;\5;\u016f\n;\3;\5;\u0172\n;\3<\3<\7<\u0176\n<\f<\16<\u0179\13<\5<\u017b"+
		"\n<\3=\3=\5=\u017f\n=\3>\3>\2\2?\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"+
		"\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31"+
		"\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60"+
		"_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u\2w\2y\2{\2\3\2\r\3\2\63;\4\2NNn"+
		"n\6\2\f\f\17\17))^^\6\2\f\f\17\17$$^^\5\2\13\f\16\17\"\"\4\2\f\f\17\17"+
		"\n\2$$))^^ddhhppttvv\3\2\62\65\3\2\629\3\2\62;\5\2C\\aac|\2\u018f\2\3"+
		"\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2"+
		"\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31"+
		"\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2"+
		"\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2"+
		"\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2"+
		"\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2"+
		"I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3"+
		"\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2"+
		"\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2"+
		"o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\3}\3\2\2\2\5\u0082\3\2\2\2\7\u0088\3\2"+
		"\2\2\t\u008d\3\2\2\2\13\u0093\3\2\2\2\r\u0099\3\2\2\2\17\u00a2\3\2\2\2"+
		"\21\u00a7\3\2\2\2\23\u00ab\3\2\2\2\25\u00ae\3\2\2\2\27\u00b2\3\2\2\2\31"+
		"\u00b6\3\2\2\2\33\u00bd\3\2\2\2\35\u00c2\3\2\2\2\37\u00c7\3\2\2\2!\u00da"+
		"\3\2\2\2#\u00e8\3\2\2\2%\u00ea\3\2\2\2\'\u00f1\3\2\2\2)\u00fb\3\2\2\2"+
		"+\u0100\3\2\2\2-\u0102\3\2\2\2/\u0104\3\2\2\2\61\u0106\3\2\2\2\63\u0108"+
		"\3\2\2\2\65\u010a\3\2\2\2\67\u010c\3\2\2\29\u010e\3\2\2\2;\u0110\3\2\2"+
		"\2=\u0112\3\2\2\2?\u0114\3\2\2\2A\u0116\3\2\2\2C\u0118\3\2\2\2E\u011a"+
		"\3\2\2\2G\u011c\3\2\2\2I\u011e\3\2\2\2K\u0120\3\2\2\2M\u0123\3\2\2\2O"+
		"\u0126\3\2\2\2Q\u0129\3\2\2\2S\u012c\3\2\2\2U\u012f\3\2\2\2W\u0132\3\2"+
		"\2\2Y\u0135\3\2\2\2[\u0138\3\2\2\2]\u013a\3\2\2\2_\u013c\3\2\2\2a\u013e"+
		"\3\2\2\2c\u0140\3\2\2\2e\u0142\3\2\2\2g\u0144\3\2\2\2i\u0146\3\2\2\2k"+
		"\u0148\3\2\2\2m\u014b\3\2\2\2o\u014f\3\2\2\2q\u0155\3\2\2\2s\u0160\3\2"+
		"\2\2u\u0171\3\2\2\2w\u0173\3\2\2\2y\u017e\3\2\2\2{\u0180\3\2\2\2}~\7d"+
		"\2\2~\177\7q\2\2\177\u0080\7q\2\2\u0080\u0081\7n\2\2\u0081\4\3\2\2\2\u0082"+
		"\u0083\7d\2\2\u0083\u0084\7t\2\2\u0084\u0085\7g\2\2\u0085\u0086\7c\2\2"+
		"\u0086\u0087\7m\2\2\u0087\6\3\2\2\2\u0088\u0089\7e\2\2\u0089\u008a\7j"+
		"\2\2\u008a\u008b\7c\2\2\u008b\u008c\7t\2\2\u008c\b\3\2\2\2\u008d\u008e"+
		"\7e\2\2\u008e\u008f\7n\2\2\u008f\u0090\7c\2\2\u0090\u0091\7u\2\2\u0091"+
		"\u0092\7u\2\2\u0092\n\3\2\2\2\u0093\u0094\7e\2\2\u0094\u0095\7q\2\2\u0095"+
		"\u0096\7p\2\2\u0096\u0097\7u\2\2\u0097\u0098\7v\2\2\u0098\f\3\2\2\2\u0099"+
		"\u009a\7e\2\2\u009a\u009b\7q\2\2\u009b\u009c\7p\2\2\u009c\u009d\7v\2\2"+
		"\u009d\u009e\7k\2\2\u009e\u009f\7p\2\2\u009f\u00a0\7w\2\2\u00a0\u00a1"+
		"\7g\2\2\u00a1\16\3\2\2\2\u00a2\u00a3\7g\2\2\u00a3\u00a4\7n\2\2\u00a4\u00a5"+
		"\7u\2\2\u00a5\u00a6\7g\2\2\u00a6\20\3\2\2\2\u00a7\u00a8\7h\2\2\u00a8\u00a9"+
		"\7q\2\2\u00a9\u00aa\7t\2\2\u00aa\22\3\2\2\2\u00ab\u00ac\7k\2\2\u00ac\u00ad"+
		"\7h\2\2\u00ad\24\3\2\2\2\u00ae\u00af\7k\2\2\u00af\u00b0\7p\2\2\u00b0\u00b1"+
		"\7v\2\2\u00b1\26\3\2\2\2\u00b2\u00b3\7p\2\2\u00b3\u00b4\7g\2\2\u00b4\u00b5"+
		"\7y\2\2\u00b5\30\3\2\2\2\u00b6\u00b7\7t\2\2\u00b7\u00b8\7g\2\2\u00b8\u00b9"+
		"\7v\2\2\u00b9\u00ba\7w\2\2\u00ba\u00bb\7t\2\2\u00bb\u00bc\7p\2\2\u00bc"+
		"\32\3\2\2\2\u00bd\u00be\7v\2\2\u00be\u00bf\7j\2\2\u00bf\u00c0\7k\2\2\u00c0"+
		"\u00c1\7u\2\2\u00c1\34\3\2\2\2\u00c2\u00c3\7x\2\2\u00c3\u00c4\7q\2\2\u00c4"+
		"\u00c5\7k\2\2\u00c5\u00c6\7f\2\2\u00c6\36\3\2\2\2\u00c7\u00c8\7y\2\2\u00c8"+
		"\u00c9\7j\2\2\u00c9\u00ca\7k\2\2\u00ca\u00cb\7n\2\2\u00cb\u00cc\7g\2\2"+
		"\u00cc \3\2\2\2\u00cd\u00db\7\62\2\2\u00ce\u00d8\t\2\2\2\u00cf\u00d1\5"+
		"w<\2\u00d0\u00cf\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d9\3\2\2\2\u00d2"+
		"\u00d4\7a\2\2\u00d3\u00d2\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d3\3\2"+
		"\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d9\5w<\2\u00d8\u00d0"+
		"\3\2\2\2\u00d8\u00d3\3\2\2\2\u00d9\u00db\3\2\2\2\u00da\u00cd\3\2\2\2\u00da"+
		"\u00ce\3\2\2\2\u00db\u00dd\3\2\2\2\u00dc\u00de\t\3\2\2\u00dd\u00dc\3\2"+
		"\2\2\u00dd\u00de\3\2\2\2\u00de\"\3\2\2\2\u00df\u00e0\7v\2\2\u00e0\u00e1"+
		"\7t\2\2\u00e1\u00e2\7w\2\2\u00e2\u00e9\7g\2\2\u00e3\u00e4\7h\2\2\u00e4"+
		"\u00e5\7c\2\2\u00e5\u00e6\7n\2\2\u00e6\u00e7\7u\2\2\u00e7\u00e9\7g\2\2"+
		"\u00e8\u00df\3\2\2\2\u00e8\u00e3\3\2\2\2\u00e9$\3\2\2\2\u00ea\u00ed\7"+
		")\2\2\u00eb\u00ee\n\4\2\2\u00ec\u00ee\5u;\2\u00ed\u00eb\3\2\2\2\u00ed"+
		"\u00ec\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00f0\7)\2\2\u00f0&\3\2\2\2\u00f1"+
		"\u00f6\7$\2\2\u00f2\u00f5\n\5\2\2\u00f3\u00f5\5u;\2\u00f4\u00f2\3\2\2"+
		"\2\u00f4\u00f3\3\2\2\2\u00f5\u00f8\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f6\u00f7"+
		"\3\2\2\2\u00f7\u00f9\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f9\u00fa\7$\2\2\u00fa"+
		"(\3\2\2\2\u00fb\u00fc\7p\2\2\u00fc\u00fd\7w\2\2\u00fd\u00fe\7n\2\2\u00fe"+
		"\u00ff\7n\2\2\u00ff*\3\2\2\2\u0100\u0101\7*\2\2\u0101,\3\2\2\2\u0102\u0103"+
		"\7+\2\2\u0103.\3\2\2\2\u0104\u0105\7}\2\2\u0105\60\3\2\2\2\u0106\u0107"+
		"\7\177\2\2\u0107\62\3\2\2\2\u0108\u0109\7]\2\2\u0109\64\3\2\2\2\u010a"+
		"\u010b\7_\2\2\u010b\66\3\2\2\2\u010c\u010d\7=\2\2\u010d8\3\2\2\2\u010e"+
		"\u010f\7.\2\2\u010f:\3\2\2\2\u0110\u0111\7\60\2\2\u0111<\3\2\2\2\u0112"+
		"\u0113\7?\2\2\u0113>\3\2\2\2\u0114\u0115\7@\2\2\u0115@\3\2\2\2\u0116\u0117"+
		"\7>\2\2\u0117B\3\2\2\2\u0118\u0119\7#\2\2\u0119D\3\2\2\2\u011a\u011b\7"+
		"\u0080\2\2\u011bF\3\2\2\2\u011c\u011d\7A\2\2\u011dH\3\2\2\2\u011e\u011f"+
		"\7<\2\2\u011fJ\3\2\2\2\u0120\u0121\7?\2\2\u0121\u0122\7?\2\2\u0122L\3"+
		"\2\2\2\u0123\u0124\7>\2\2\u0124\u0125\7?\2\2\u0125N\3\2\2\2\u0126\u0127"+
		"\7@\2\2\u0127\u0128\7?\2\2\u0128P\3\2\2\2\u0129\u012a\7#\2\2\u012a\u012b"+
		"\7?\2\2\u012bR\3\2\2\2\u012c\u012d\7(\2\2\u012d\u012e\7(\2\2\u012eT\3"+
		"\2\2\2\u012f\u0130\7~\2\2\u0130\u0131\7~\2\2\u0131V\3\2\2\2\u0132\u0133"+
		"\7-\2\2\u0133\u0134\7-\2\2\u0134X\3\2\2\2\u0135\u0136\7/\2\2\u0136\u0137"+
		"\7/\2\2\u0137Z\3\2\2\2\u0138\u0139\7-\2\2\u0139\\\3\2\2\2\u013a\u013b"+
		"\7/\2\2\u013b^\3\2\2\2\u013c\u013d\7,\2\2\u013d`\3\2\2\2\u013e\u013f\7"+
		"\61\2\2\u013fb\3\2\2\2\u0140\u0141\7(\2\2\u0141d\3\2\2\2\u0142\u0143\7"+
		"~\2\2\u0143f\3\2\2\2\u0144\u0145\7`\2\2\u0145h\3\2\2\2\u0146\u0147\7\'"+
		"\2\2\u0147j\3\2\2\2\u0148\u0149\7>\2\2\u0149\u014a\7>\2\2\u014al\3\2\2"+
		"\2\u014b\u014c\7@\2\2\u014c\u014d\7@\2\2\u014dn\3\2\2\2\u014e\u0150\t"+
		"\6\2\2\u014f\u014e\3\2\2\2\u0150\u0151\3\2\2\2\u0151\u014f\3\2\2\2\u0151"+
		"\u0152\3\2\2\2\u0152\u0153\3\2\2\2\u0153\u0154\b8\2\2\u0154p\3\2\2\2\u0155"+
		"\u0156\7\61\2\2\u0156\u0157\7\61\2\2\u0157\u015b\3\2\2\2\u0158\u015a\n"+
		"\7\2\2\u0159\u0158\3\2\2\2\u015a\u015d\3\2\2\2\u015b\u0159\3\2\2\2\u015b"+
		"\u015c\3\2\2\2\u015c\u015e\3\2\2\2\u015d\u015b\3\2\2\2\u015e\u015f\b9"+
		"\2\2\u015fr\3\2\2\2\u0160\u0164\5{>\2\u0161\u0163\5y=\2\u0162\u0161\3"+
		"\2\2\2\u0163\u0166\3\2\2\2\u0164\u0162\3\2\2\2\u0164\u0165\3\2\2\2\u0165"+
		"t\3\2\2\2\u0166\u0164\3\2\2\2\u0167\u0168\7^\2\2\u0168\u0172\t\b\2\2\u0169"+
		"\u016e\7^\2\2\u016a\u016c\t\t\2\2\u016b\u016a\3\2\2\2\u016b\u016c\3\2"+
		"\2\2\u016c\u016d\3\2\2\2\u016d\u016f\t\n\2\2\u016e\u016b\3\2\2\2\u016e"+
		"\u016f\3\2\2\2\u016f\u0170\3\2\2\2\u0170\u0172\t\n\2\2\u0171\u0167\3\2"+
		"\2\2\u0171\u0169\3\2\2\2\u0172v\3\2\2\2\u0173\u017a\t\13\2\2\u0174\u0176"+
		"\t\13\2\2\u0175\u0174\3\2\2\2\u0176\u0179\3\2\2\2\u0177\u0175\3\2\2\2"+
		"\u0177\u0178\3\2\2\2\u0178\u017b\3\2\2\2\u0179\u0177\3\2\2\2\u017a\u0177"+
		"\3\2\2\2\u017a\u017b\3\2\2\2\u017bx\3\2\2\2\u017c\u017f\5{>\2\u017d\u017f"+
		"\t\13\2\2\u017e\u017c\3\2\2\2\u017e\u017d\3\2\2\2\u017fz\3\2\2\2\u0180"+
		"\u0181\t\f\2\2\u0181|\3\2\2\2\25\2\u00d0\u00d5\u00d8\u00da\u00dd\u00e8"+
		"\u00ed\u00f4\u00f6\u0151\u015b\u0164\u016b\u016e\u0171\u0177\u017a\u017e"+
		"\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}