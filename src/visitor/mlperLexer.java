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
		BOOLEAN=1, BREAK=2, CHAR=3, CLASS=4, CONTINUE=5, ELSE=6, FOR=7, IF=8, 
		INT=9, NEW=10, RETURN=11, THIS=12, VOID=13, WHILE=14, DECIMAL_LITERAL=15, 
		BOOL_LITERAL=16, CHAR_LITERAL=17, STRING_LITERAL=18, NULL_LITERAL=19, 
		LPAREN=20, RPAREN=21, LBRACE=22, RBRACE=23, LBRACK=24, RBRACK=25, SEMI=26, 
		COMMA=27, DOT=28, ASSIGN=29, GT=30, LT=31, BANG=32, TILDE=33, QUESTION=34, 
		COLON=35, EQUAL=36, LE=37, GE=38, NOTEQUAL=39, AND=40, OR=41, INC=42, 
		DEC=43, ADD=44, SUB=45, MUL=46, DIV=47, BITAND=48, BITOR=49, CARET=50, 
		MOD=51, LSHIFT=52, URSHIFT=53, WS=54, LINE_COMMENT=55, IDENTIFIER=56;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"BOOLEAN", "BREAK", "CHAR", "CLASS", "CONTINUE", "ELSE", "FOR", "IF", 
		"INT", "NEW", "RETURN", "THIS", "VOID", "WHILE", "DECIMAL_LITERAL", "BOOL_LITERAL", 
		"CHAR_LITERAL", "STRING_LITERAL", "NULL_LITERAL", "LPAREN", "RPAREN", 
		"LBRACE", "RBRACE", "LBRACK", "RBRACK", "SEMI", "COMMA", "DOT", "ASSIGN", 
		"GT", "LT", "BANG", "TILDE", "QUESTION", "COLON", "EQUAL", "LE", "GE", 
		"NOTEQUAL", "AND", "OR", "INC", "DEC", "ADD", "SUB", "MUL", "DIV", "BITAND", 
		"BITOR", "CARET", "MOD", "LSHIFT", "URSHIFT", "WS", "LINE_COMMENT", "IDENTIFIER", 
		"EscapeSequence", "Digits", "LetterOrDigit", "Letter"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'bool'", "'break'", "'char'", "'class'", "'continue'", "'else'", 
		"'for'", "'if'", "'int'", "'new'", "'return'", "'this'", "'void'", "'while'", 
		null, null, null, null, "'null'", "'('", "')'", "'{'", "'}'", "'['", "']'", 
		"';'", "','", "'.'", "'='", "'>'", "'<'", "'!'", "'~'", "'?'", "':'", 
		"'=='", "'<='", "'>='", "'!='", "'&&'", "'||'", "'++'", "'--'", "'+'", 
		"'-'", "'*'", "'/'", "'&'", "'|'", "'^'", "'%'", "'<<'", "'>>'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "BOOLEAN", "BREAK", "CHAR", "CLASS", "CONTINUE", "ELSE", "FOR", 
		"IF", "INT", "NEW", "RETURN", "THIS", "VOID", "WHILE", "DECIMAL_LITERAL", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2:\u017a\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7"+
		"\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\5\20\u00c9\n\20\3\20\6\20"+
		"\u00cc\n\20\r\20\16\20\u00cd\3\20\5\20\u00d1\n\20\5\20\u00d3\n\20\3\20"+
		"\5\20\u00d6\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u00e1"+
		"\n\21\3\22\3\22\3\22\5\22\u00e6\n\22\3\22\3\22\3\23\3\23\3\23\7\23\u00ed"+
		"\n\23\f\23\16\23\u00f0\13\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3"+
		"\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3"+
		"\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3"+
		"%\3%\3&\3&\3&\3\'\3\'\3\'\3(\3(\3(\3)\3)\3)\3*\3*\3*\3+\3+\3+\3,\3,\3"+
		",\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64"+
		"\3\65\3\65\3\65\3\66\3\66\3\66\3\67\6\67\u0148\n\67\r\67\16\67\u0149\3"+
		"\67\3\67\38\38\38\38\78\u0152\n8\f8\168\u0155\138\38\38\39\39\79\u015b"+
		"\n9\f9\169\u015e\139\3:\3:\3:\3:\5:\u0164\n:\3:\5:\u0167\n:\3:\5:\u016a"+
		"\n:\3;\3;\7;\u016e\n;\f;\16;\u0171\13;\5;\u0173\n;\3<\3<\5<\u0177\n<\3"+
		"=\3=\2\2>\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33"+
		"\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67"+
		"\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65"+
		"i\66k\67m8o9q:s\2u\2w\2y\2\3\2\r\3\2\63;\4\2NNnn\6\2\f\f\17\17))^^\6\2"+
		"\f\f\17\17$$^^\5\2\13\f\16\17\"\"\4\2\f\f\17\17\n\2$$))^^ddhhppttvv\3"+
		"\2\62\65\3\2\629\3\2\62;\5\2C\\aac|\2\u0187\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2"+
		"\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2"+
		"\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2"+
		"\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2"+
		"M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3"+
		"\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2"+
		"\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\3"+
		"{\3\2\2\2\5\u0080\3\2\2\2\7\u0086\3\2\2\2\t\u008b\3\2\2\2\13\u0091\3\2"+
		"\2\2\r\u009a\3\2\2\2\17\u009f\3\2\2\2\21\u00a3\3\2\2\2\23\u00a6\3\2\2"+
		"\2\25\u00aa\3\2\2\2\27\u00ae\3\2\2\2\31\u00b5\3\2\2\2\33\u00ba\3\2\2\2"+
		"\35\u00bf\3\2\2\2\37\u00d2\3\2\2\2!\u00e0\3\2\2\2#\u00e2\3\2\2\2%\u00e9"+
		"\3\2\2\2\'\u00f3\3\2\2\2)\u00f8\3\2\2\2+\u00fa\3\2\2\2-\u00fc\3\2\2\2"+
		"/\u00fe\3\2\2\2\61\u0100\3\2\2\2\63\u0102\3\2\2\2\65\u0104\3\2\2\2\67"+
		"\u0106\3\2\2\29\u0108\3\2\2\2;\u010a\3\2\2\2=\u010c\3\2\2\2?\u010e\3\2"+
		"\2\2A\u0110\3\2\2\2C\u0112\3\2\2\2E\u0114\3\2\2\2G\u0116\3\2\2\2I\u0118"+
		"\3\2\2\2K\u011b\3\2\2\2M\u011e\3\2\2\2O\u0121\3\2\2\2Q\u0124\3\2\2\2S"+
		"\u0127\3\2\2\2U\u012a\3\2\2\2W\u012d\3\2\2\2Y\u0130\3\2\2\2[\u0132\3\2"+
		"\2\2]\u0134\3\2\2\2_\u0136\3\2\2\2a\u0138\3\2\2\2c\u013a\3\2\2\2e\u013c"+
		"\3\2\2\2g\u013e\3\2\2\2i\u0140\3\2\2\2k\u0143\3\2\2\2m\u0147\3\2\2\2o"+
		"\u014d\3\2\2\2q\u0158\3\2\2\2s\u0169\3\2\2\2u\u016b\3\2\2\2w\u0176\3\2"+
		"\2\2y\u0178\3\2\2\2{|\7d\2\2|}\7q\2\2}~\7q\2\2~\177\7n\2\2\177\4\3\2\2"+
		"\2\u0080\u0081\7d\2\2\u0081\u0082\7t\2\2\u0082\u0083\7g\2\2\u0083\u0084"+
		"\7c\2\2\u0084\u0085\7m\2\2\u0085\6\3\2\2\2\u0086\u0087\7e\2\2\u0087\u0088"+
		"\7j\2\2\u0088\u0089\7c\2\2\u0089\u008a\7t\2\2\u008a\b\3\2\2\2\u008b\u008c"+
		"\7e\2\2\u008c\u008d\7n\2\2\u008d\u008e\7c\2\2\u008e\u008f\7u\2\2\u008f"+
		"\u0090\7u\2\2\u0090\n\3\2\2\2\u0091\u0092\7e\2\2\u0092\u0093\7q\2\2\u0093"+
		"\u0094\7p\2\2\u0094\u0095\7v\2\2\u0095\u0096\7k\2\2\u0096\u0097\7p\2\2"+
		"\u0097\u0098\7w\2\2\u0098\u0099\7g\2\2\u0099\f\3\2\2\2\u009a\u009b\7g"+
		"\2\2\u009b\u009c\7n\2\2\u009c\u009d\7u\2\2\u009d\u009e\7g\2\2\u009e\16"+
		"\3\2\2\2\u009f\u00a0\7h\2\2\u00a0\u00a1\7q\2\2\u00a1\u00a2\7t\2\2\u00a2"+
		"\20\3\2\2\2\u00a3\u00a4\7k\2\2\u00a4\u00a5\7h\2\2\u00a5\22\3\2\2\2\u00a6"+
		"\u00a7\7k\2\2\u00a7\u00a8\7p\2\2\u00a8\u00a9\7v\2\2\u00a9\24\3\2\2\2\u00aa"+
		"\u00ab\7p\2\2\u00ab\u00ac\7g\2\2\u00ac\u00ad\7y\2\2\u00ad\26\3\2\2\2\u00ae"+
		"\u00af\7t\2\2\u00af\u00b0\7g\2\2\u00b0\u00b1\7v\2\2\u00b1\u00b2\7w\2\2"+
		"\u00b2\u00b3\7t\2\2\u00b3\u00b4\7p\2\2\u00b4\30\3\2\2\2\u00b5\u00b6\7"+
		"v\2\2\u00b6\u00b7\7j\2\2\u00b7\u00b8\7k\2\2\u00b8\u00b9\7u\2\2\u00b9\32"+
		"\3\2\2\2\u00ba\u00bb\7x\2\2\u00bb\u00bc\7q\2\2\u00bc\u00bd\7k\2\2\u00bd"+
		"\u00be\7f\2\2\u00be\34\3\2\2\2\u00bf\u00c0\7y\2\2\u00c0\u00c1\7j\2\2\u00c1"+
		"\u00c2\7k\2\2\u00c2\u00c3\7n\2\2\u00c3\u00c4\7g\2\2\u00c4\36\3\2\2\2\u00c5"+
		"\u00d3\7\62\2\2\u00c6\u00d0\t\2\2\2\u00c7\u00c9\5u;\2\u00c8\u00c7\3\2"+
		"\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00d1\3\2\2\2\u00ca\u00cc\7a\2\2\u00cb"+
		"\u00ca\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00cb\3\2\2\2\u00cd\u00ce\3\2"+
		"\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d1\5u;\2\u00d0\u00c8\3\2\2\2\u00d0\u00cb"+
		"\3\2\2\2\u00d1\u00d3\3\2\2\2\u00d2\u00c5\3\2\2\2\u00d2\u00c6\3\2\2\2\u00d3"+
		"\u00d5\3\2\2\2\u00d4\u00d6\t\3\2\2\u00d5\u00d4\3\2\2\2\u00d5\u00d6\3\2"+
		"\2\2\u00d6 \3\2\2\2\u00d7\u00d8\7v\2\2\u00d8\u00d9\7t\2\2\u00d9\u00da"+
		"\7w\2\2\u00da\u00e1\7g\2\2\u00db\u00dc\7h\2\2\u00dc\u00dd\7c\2\2\u00dd"+
		"\u00de\7n\2\2\u00de\u00df\7u\2\2\u00df\u00e1\7g\2\2\u00e0\u00d7\3\2\2"+
		"\2\u00e0\u00db\3\2\2\2\u00e1\"\3\2\2\2\u00e2\u00e5\7)\2\2\u00e3\u00e6"+
		"\n\4\2\2\u00e4\u00e6\5s:\2\u00e5\u00e3\3\2\2\2\u00e5\u00e4\3\2\2\2\u00e6"+
		"\u00e7\3\2\2\2\u00e7\u00e8\7)\2\2\u00e8$\3\2\2\2\u00e9\u00ee\7$\2\2\u00ea"+
		"\u00ed\n\5\2\2\u00eb\u00ed\5s:\2\u00ec\u00ea\3\2\2\2\u00ec\u00eb\3\2\2"+
		"\2\u00ed\u00f0\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00f1"+
		"\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f1\u00f2\7$\2\2\u00f2&\3\2\2\2\u00f3\u00f4"+
		"\7p\2\2\u00f4\u00f5\7w\2\2\u00f5\u00f6\7n\2\2\u00f6\u00f7\7n\2\2\u00f7"+
		"(\3\2\2\2\u00f8\u00f9\7*\2\2\u00f9*\3\2\2\2\u00fa\u00fb\7+\2\2\u00fb,"+
		"\3\2\2\2\u00fc\u00fd\7}\2\2\u00fd.\3\2\2\2\u00fe\u00ff\7\177\2\2\u00ff"+
		"\60\3\2\2\2\u0100\u0101\7]\2\2\u0101\62\3\2\2\2\u0102\u0103\7_\2\2\u0103"+
		"\64\3\2\2\2\u0104\u0105\7=\2\2\u0105\66\3\2\2\2\u0106\u0107\7.\2\2\u0107"+
		"8\3\2\2\2\u0108\u0109\7\60\2\2\u0109:\3\2\2\2\u010a\u010b\7?\2\2\u010b"+
		"<\3\2\2\2\u010c\u010d\7@\2\2\u010d>\3\2\2\2\u010e\u010f\7>\2\2\u010f@"+
		"\3\2\2\2\u0110\u0111\7#\2\2\u0111B\3\2\2\2\u0112\u0113\7\u0080\2\2\u0113"+
		"D\3\2\2\2\u0114\u0115\7A\2\2\u0115F\3\2\2\2\u0116\u0117\7<\2\2\u0117H"+
		"\3\2\2\2\u0118\u0119\7?\2\2\u0119\u011a\7?\2\2\u011aJ\3\2\2\2\u011b\u011c"+
		"\7>\2\2\u011c\u011d\7?\2\2\u011dL\3\2\2\2\u011e\u011f\7@\2\2\u011f\u0120"+
		"\7?\2\2\u0120N\3\2\2\2\u0121\u0122\7#\2\2\u0122\u0123\7?\2\2\u0123P\3"+
		"\2\2\2\u0124\u0125\7(\2\2\u0125\u0126\7(\2\2\u0126R\3\2\2\2\u0127\u0128"+
		"\7~\2\2\u0128\u0129\7~\2\2\u0129T\3\2\2\2\u012a\u012b\7-\2\2\u012b\u012c"+
		"\7-\2\2\u012cV\3\2\2\2\u012d\u012e\7/\2\2\u012e\u012f\7/\2\2\u012fX\3"+
		"\2\2\2\u0130\u0131\7-\2\2\u0131Z\3\2\2\2\u0132\u0133\7/\2\2\u0133\\\3"+
		"\2\2\2\u0134\u0135\7,\2\2\u0135^\3\2\2\2\u0136\u0137\7\61\2\2\u0137`\3"+
		"\2\2\2\u0138\u0139\7(\2\2\u0139b\3\2\2\2\u013a\u013b\7~\2\2\u013bd\3\2"+
		"\2\2\u013c\u013d\7`\2\2\u013df\3\2\2\2\u013e\u013f\7\'\2\2\u013fh\3\2"+
		"\2\2\u0140\u0141\7>\2\2\u0141\u0142\7>\2\2\u0142j\3\2\2\2\u0143\u0144"+
		"\7@\2\2\u0144\u0145\7@\2\2\u0145l\3\2\2\2\u0146\u0148\t\6\2\2\u0147\u0146"+
		"\3\2\2\2\u0148\u0149\3\2\2\2\u0149\u0147\3\2\2\2\u0149\u014a\3\2\2\2\u014a"+
		"\u014b\3\2\2\2\u014b\u014c\b\67\2\2\u014cn\3\2\2\2\u014d\u014e\7\61\2"+
		"\2\u014e\u014f\7\61\2\2\u014f\u0153\3\2\2\2\u0150\u0152\n\7\2\2\u0151"+
		"\u0150\3\2\2\2\u0152\u0155\3\2\2\2\u0153\u0151\3\2\2\2\u0153\u0154\3\2"+
		"\2\2\u0154\u0156\3\2\2\2\u0155\u0153\3\2\2\2\u0156\u0157\b8\2\2\u0157"+
		"p\3\2\2\2\u0158\u015c\5y=\2\u0159\u015b\5w<\2\u015a\u0159\3\2\2\2\u015b"+
		"\u015e\3\2\2\2\u015c\u015a\3\2\2\2\u015c\u015d\3\2\2\2\u015dr\3\2\2\2"+
		"\u015e\u015c\3\2\2\2\u015f\u0160\7^\2\2\u0160\u016a\t\b\2\2\u0161\u0166"+
		"\7^\2\2\u0162\u0164\t\t\2\2\u0163\u0162\3\2\2\2\u0163\u0164\3\2\2\2\u0164"+
		"\u0165\3\2\2\2\u0165\u0167\t\n\2\2\u0166\u0163\3\2\2\2\u0166\u0167\3\2"+
		"\2\2\u0167\u0168\3\2\2\2\u0168\u016a\t\n\2\2\u0169\u015f\3\2\2\2\u0169"+
		"\u0161\3\2\2\2\u016at\3\2\2\2\u016b\u0172\t\13\2\2\u016c\u016e\t\13\2"+
		"\2\u016d\u016c\3\2\2\2\u016e\u0171\3\2\2\2\u016f\u016d\3\2\2\2\u016f\u0170"+
		"\3\2\2\2\u0170\u0173\3\2\2\2\u0171\u016f\3\2\2\2\u0172\u016f\3\2\2\2\u0172"+
		"\u0173\3\2\2\2\u0173v\3\2\2\2\u0174\u0177\5y=\2\u0175\u0177\t\13\2\2\u0176"+
		"\u0174\3\2\2\2\u0176\u0175\3\2\2\2\u0177x\3\2\2\2\u0178\u0179\t\f\2\2"+
		"\u0179z\3\2\2\2\25\2\u00c8\u00cd\u00d0\u00d2\u00d5\u00e0\u00e5\u00ec\u00ee"+
		"\u0149\u0153\u015c\u0163\u0166\u0169\u016f\u0172\u0176\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}