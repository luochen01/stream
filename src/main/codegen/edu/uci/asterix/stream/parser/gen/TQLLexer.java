// Generated from TQL.g4 by ANTLR 4.4

	package edu.uci.asterix.stream.parser.gen;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TQLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__18=1, T__17=2, T__16=3, T__15=4, T__14=5, T__13=6, T__12=7, T__11=8, 
		T__10=9, T__9=10, T__8=11, T__7=12, T__6=13, T__5=14, T__4=15, T__3=16, 
		T__2=17, T__1=18, T__0=19, DEFINE=20, SENSOR_COLLECTION=21, OBSERVATION_STREAM=22, 
		SENSORS_TO_OBSERVATION_STREAM=23, SELECT=24, FROM=25, WHERE=26, GROUP=27, 
		BY=28, HAVING=29, DISTINCT=30, AS=31, AND=32, OR=33, NOT=34, NOT_NULL=35, 
		IS_NULL=36, IN=37, ORDER=38, LIMIT=39, OFFSET=40, ASC=41, DESC=42, RANGE=43, 
		SLIDE=44, SECONDS=45, MINUTES=46, HOURS=47, AVG=48, MIN=49, SUM=50, MAX=51, 
		COUNT=52, CAST=53, INT=54, REAL=55, BOOLEAN=56, STRING=57, LIKE=58, IDENTIFIER=59, 
		STRING_LITERAL=60, BOOLEAN_LITERAL=61, INT_LITERAL=62, REAL_LITERAL=63, 
		SINGLE_LINE_COMMENT=64, MULTILINE_COMMENT=65, SPACES=66;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'", 
		"'\\u0019'", "'\\u001A'", "'\\u001B'", "'\\u001C'", "'\\u001D'", "'\\u001E'", 
		"'\\u001F'", "' '", "'!'", "'\"'", "'#'", "'$'", "'%'", "'&'", "'''", 
		"'('", "')'", "'*'", "'+'", "','", "'-'", "'.'", "'/'", "'0'", "'1'", 
		"'2'", "'3'", "'4'", "'5'", "'6'", "'7'", "'8'", "'9'", "':'", "';'", 
		"'<'", "'='", "'>'", "'?'", "'@'", "'A'", "'B'"
	};
	public static final String[] ruleNames = {
		"T__18", "T__17", "T__16", "T__15", "T__14", "T__13", "T__12", "T__11", 
		"T__10", "T__9", "T__8", "T__7", "T__6", "T__5", "T__4", "T__3", "T__2", 
		"T__1", "T__0", "DEFINE", "SENSOR_COLLECTION", "OBSERVATION_STREAM", "SENSORS_TO_OBSERVATION_STREAM", 
		"SELECT", "FROM", "WHERE", "GROUP", "BY", "HAVING", "DISTINCT", "AS", 
		"AND", "OR", "NOT", "NOT_NULL", "IS_NULL", "IN", "ORDER", "LIMIT", "OFFSET", 
		"ASC", "DESC", "RANGE", "SLIDE", "SECONDS", "MINUTES", "HOURS", "AVG", 
		"MIN", "SUM", "MAX", "COUNT", "CAST", "INT", "REAL", "BOOLEAN", "STRING", 
		"LIKE", "IDENTIFIER", "STRING_LITERAL", "BOOLEAN_LITERAL", "INT_LITERAL", 
		"REAL_LITERAL", "SINGLE_LINE_COMMENT", "MULTILINE_COMMENT", "SPACES", 
		"DIGIT", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", 
		"N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
	};


	public TQLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "TQL.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2D\u02a1\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\3\2\3\2"+
		"\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3"+
		"\n\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3"+
		"\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3"+
		"\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3"+
		"\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3"+
		"\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3"+
		"\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3"+
		"\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3"+
		"\31\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3"+
		"\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3"+
		"\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3!\3!\3!\3!"+
		"\3\"\3\"\3\"\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3%"+
		"\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3)\3)\3)\3)\3)\3)"+
		"\3)\3*\3*\3*\3*\3+\3+\3+\3+\3+\3,\3,\3,\3,\3,\3,\3-\3-\3-\3-\3-\3-\3."+
		"\3.\3.\3.\3.\3.\3.\3.\3/\3/\3/\3/\3/\3/\3/\3/\3\60\3\60\3\60\3\60\3\60"+
		"\3\60\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3\63\3\64"+
		"\3\64\3\64\3\64\3\65\3\65\3\65\3\65\3\65\3\65\3\66\3\66\3\66\3\66\3\66"+
		"\3\67\3\67\3\67\3\67\38\38\38\38\38\39\39\39\39\39\39\39\39\3:\3:\3:\3"+
		":\3:\3:\3:\3;\3;\3;\3;\3;\3<\3<\3<\3<\7<\u01f4\n<\f<\16<\u01f7\13<\3<"+
		"\3<\3<\7<\u01fc\n<\f<\16<\u01ff\13<\5<\u0201\n<\3=\3=\7=\u0205\n=\f=\16"+
		"=\u0208\13=\3=\3=\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\5>\u0217\n>\3?\5?\u021a"+
		"\n?\3?\6?\u021d\n?\r?\16?\u021e\3@\6@\u0222\n@\r@\16@\u0223\3@\3@\7@\u0228"+
		"\n@\f@\16@\u022b\13@\5@\u022d\n@\3@\3@\5@\u0231\n@\3@\6@\u0234\n@\r@\16"+
		"@\u0235\5@\u0238\n@\3@\3@\6@\u023c\n@\r@\16@\u023d\3@\3@\5@\u0242\n@\3"+
		"@\6@\u0245\n@\r@\16@\u0246\5@\u0249\n@\5@\u024b\n@\3A\3A\3A\3A\7A\u0251"+
		"\nA\fA\16A\u0254\13A\3A\3A\3B\3B\3B\3B\7B\u025c\nB\fB\16B\u025f\13B\3"+
		"B\3B\3B\5B\u0264\nB\3B\3B\3C\3C\3C\3C\3D\3D\3E\3E\3F\3F\3G\3G\3H\3H\3"+
		"I\3I\3J\3J\3K\3K\3L\3L\3M\3M\3N\3N\3O\3O\3P\3P\3Q\3Q\3R\3R\3S\3S\3T\3"+
		"T\3U\3U\3V\3V\3W\3W\3X\3X\3Y\3Y\3Z\3Z\3[\3[\3\\\3\\\3]\3]\3^\3^\3\u025d"+
		"\2_\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36"+
		";\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67"+
		"m8o9q:s;u<w=y>{?}@\177A\u0081B\u0083C\u0085D\u0087\2\u0089\2\u008b\2\u008d"+
		"\2\u008f\2\u0091\2\u0093\2\u0095\2\u0097\2\u0099\2\u009b\2\u009d\2\u009f"+
		"\2\u00a1\2\u00a3\2\u00a5\2\u00a7\2\u00a9\2\u00ab\2\u00ad\2\u00af\2\u00b1"+
		"\2\u00b3\2\u00b5\2\u00b7\2\u00b9\2\u00bb\2\3\2$\3\2bb\5\2C\\aac|\6\2\62"+
		";C\\aac|\3\2$$\4\2--//\4\2\f\f\17\17\5\2\13\r\17\17\"\"\3\2\62;\4\2CC"+
		"cc\4\2DDdd\4\2EEee\4\2FFff\4\2GGgg\4\2HHhh\4\2IIii\4\2JJjj\4\2KKkk\4\2"+
		"LLll\4\2MMmm\4\2NNnn\4\2OOoo\4\2PPpp\4\2QQqq\4\2RRrr\4\2SSss\4\2TTtt\4"+
		"\2UUuu\4\2VVvv\4\2WWww\4\2XXxx\4\2YYyy\4\2ZZzz\4\2[[{{\4\2\\\\||\u029b"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2"+
		"\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2"+
		"U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3"+
		"\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2"+
		"\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2"+
		"{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085"+
		"\3\2\2\2\3\u00bd\3\2\2\2\5\u00bf\3\2\2\2\7\u00c2\3\2\2\2\t\u00c5\3\2\2"+
		"\2\13\u00c7\3\2\2\2\r\u00c9\3\2\2\2\17\u00cb\3\2\2\2\21\u00cd\3\2\2\2"+
		"\23\u00cf\3\2\2\2\25\u00d1\3\2\2\2\27\u00d4\3\2\2\2\31\u00d6\3\2\2\2\33"+
		"\u00d8\3\2\2\2\35\u00da\3\2\2\2\37\u00dc\3\2\2\2!\u00de\3\2\2\2#\u00e0"+
		"\3\2\2\2%\u00e2\3\2\2\2\'\u00e4\3\2\2\2)\u00e6\3\2\2\2+\u00ed\3\2\2\2"+
		"-\u00fe\3\2\2\2/\u0110\3\2\2\2\61\u012e\3\2\2\2\63\u0135\3\2\2\2\65\u013a"+
		"\3\2\2\2\67\u0140\3\2\2\29\u0146\3\2\2\2;\u0149\3\2\2\2=\u0150\3\2\2\2"+
		"?\u0159\3\2\2\2A\u015c\3\2\2\2C\u0160\3\2\2\2E\u0163\3\2\2\2G\u0167\3"+
		"\2\2\2I\u016f\3\2\2\2K\u0176\3\2\2\2M\u0179\3\2\2\2O\u017f\3\2\2\2Q\u0185"+
		"\3\2\2\2S\u018c\3\2\2\2U\u0190\3\2\2\2W\u0195\3\2\2\2Y\u019b\3\2\2\2["+
		"\u01a1\3\2\2\2]\u01a9\3\2\2\2_\u01b1\3\2\2\2a\u01b7\3\2\2\2c\u01bb\3\2"+
		"\2\2e\u01bf\3\2\2\2g\u01c3\3\2\2\2i\u01c7\3\2\2\2k\u01cd\3\2\2\2m\u01d2"+
		"\3\2\2\2o\u01d6\3\2\2\2q\u01db\3\2\2\2s\u01e3\3\2\2\2u\u01ea\3\2\2\2w"+
		"\u0200\3\2\2\2y\u0202\3\2\2\2{\u0216\3\2\2\2}\u0219\3\2\2\2\177\u024a"+
		"\3\2\2\2\u0081\u024c\3\2\2\2\u0083\u0257\3\2\2\2\u0085\u0267\3\2\2\2\u0087"+
		"\u026b\3\2\2\2\u0089\u026d\3\2\2\2\u008b\u026f\3\2\2\2\u008d\u0271\3\2"+
		"\2\2\u008f\u0273\3\2\2\2\u0091\u0275\3\2\2\2\u0093\u0277\3\2\2\2\u0095"+
		"\u0279\3\2\2\2\u0097\u027b\3\2\2\2\u0099\u027d\3\2\2\2\u009b\u027f\3\2"+
		"\2\2\u009d\u0281\3\2\2\2\u009f\u0283\3\2\2\2\u00a1\u0285\3\2\2\2\u00a3"+
		"\u0287\3\2\2\2\u00a5\u0289\3\2\2\2\u00a7\u028b\3\2\2\2\u00a9\u028d\3\2"+
		"\2\2\u00ab\u028f\3\2\2\2\u00ad\u0291\3\2\2\2\u00af\u0293\3\2\2\2\u00b1"+
		"\u0295\3\2\2\2\u00b3\u0297\3\2\2\2\u00b5\u0299\3\2\2\2\u00b7\u029b\3\2"+
		"\2\2\u00b9\u029d\3\2\2\2\u00bb\u029f\3\2\2\2\u00bd\u00be\7\61\2\2\u00be"+
		"\4\3\2\2\2\u00bf\u00c0\7#\2\2\u00c0\u00c1\7?\2\2\u00c1\6\3\2\2\2\u00c2"+
		"\u00c3\7@\2\2\u00c3\u00c4\7?\2\2\u00c4\b\3\2\2\2\u00c5\u00c6\7]\2\2\u00c6"+
		"\n\3\2\2\2\u00c7\u00c8\7=\2\2\u00c8\f\3\2\2\2\u00c9\u00ca\7>\2\2\u00ca"+
		"\16\3\2\2\2\u00cb\u00cc\7_\2\2\u00cc\20\3\2\2\2\u00cd\u00ce\7?\2\2\u00ce"+
		"\22\3\2\2\2\u00cf\u00d0\7@\2\2\u00d0\24\3\2\2\2\u00d1\u00d2\7>\2\2\u00d2"+
		"\u00d3\7?\2\2\u00d3\26\3\2\2\2\u00d4\u00d5\7\'\2\2\u00d5\30\3\2\2\2\u00d6"+
		"\u00d7\7)\2\2\u00d7\32\3\2\2\2\u00d8\u00d9\7*\2\2\u00d9\34\3\2\2\2\u00da"+
		"\u00db\7+\2\2\u00db\36\3\2\2\2\u00dc\u00dd\7,\2\2\u00dd \3\2\2\2\u00de"+
		"\u00df\7-\2\2\u00df\"\3\2\2\2\u00e0\u00e1\7.\2\2\u00e1$\3\2\2\2\u00e2"+
		"\u00e3\7/\2\2\u00e3&\3\2\2\2\u00e4\u00e5\7\60\2\2\u00e5(\3\2\2\2\u00e6"+
		"\u00e7\5\u008fH\2\u00e7\u00e8\5\u0091I\2\u00e8\u00e9\5\u0093J\2\u00e9"+
		"\u00ea\5\u0099M\2\u00ea\u00eb\5\u00a3R\2\u00eb\u00ec\5\u0091I\2\u00ec"+
		"*\3\2\2\2\u00ed\u00ee\5\u00adW\2\u00ee\u00ef\5\u0091I\2\u00ef\u00f0\5"+
		"\u00a3R\2\u00f0\u00f1\5\u00adW\2\u00f1\u00f2\5\u00a5S\2\u00f2\u00f3\5"+
		"\u00abV\2\u00f3\u00f4\5\u008dG\2\u00f4\u00f5\5\u00a5S\2\u00f5\u00f6\5"+
		"\u009fP\2\u00f6\u00f7\5\u009fP\2\u00f7\u00f8\5\u0091I\2\u00f8\u00f9\5"+
		"\u008dG\2\u00f9\u00fa\5\u00afX\2\u00fa\u00fb\5\u0099M\2\u00fb\u00fc\5"+
		"\u00a5S\2\u00fc\u00fd\5\u00a3R\2\u00fd,\3\2\2\2\u00fe\u00ff\5\u00a5S\2"+
		"\u00ff\u0100\5\u008bF\2\u0100\u0101\5\u00adW\2\u0101\u0102\5\u0091I\2"+
		"\u0102\u0103\5\u00abV\2\u0103\u0104\5\u00b3Z\2\u0104\u0105\5\u0089E\2"+
		"\u0105\u0106\5\u00afX\2\u0106\u0107\5\u0099M\2\u0107\u0108\5\u00a5S\2"+
		"\u0108\u0109\5\u00a3R\2\u0109\u010a\5\u00adW\2\u010a\u010b\5\u00afX\2"+
		"\u010b\u010c\5\u00abV\2\u010c\u010d\5\u0091I\2\u010d\u010e\5\u0089E\2"+
		"\u010e\u010f\5\u00a1Q\2\u010f.\3\2\2\2\u0110\u0111\5\u00adW\2\u0111\u0112"+
		"\5\u0091I\2\u0112\u0113\5\u00a3R\2\u0113\u0114\5\u00adW\2\u0114\u0115"+
		"\5\u00a5S\2\u0115\u0116\5\u00abV\2\u0116\u0117\5\u00adW\2\u0117\u0118"+
		"\7a\2\2\u0118\u0119\5\u00afX\2\u0119\u011a\5\u00a5S\2\u011a\u011b\7a\2"+
		"\2\u011b\u011c\5\u00a5S\2\u011c\u011d\5\u008bF\2\u011d\u011e\5\u00adW"+
		"\2\u011e\u011f\5\u0091I\2\u011f\u0120\5\u00abV\2\u0120\u0121\5\u00b3Z"+
		"\2\u0121\u0122\5\u0089E\2\u0122\u0123\5\u00afX\2\u0123\u0124\5\u0099M"+
		"\2\u0124\u0125\5\u00a5S\2\u0125\u0126\5\u00a3R\2\u0126\u0127\7a\2\2\u0127"+
		"\u0128\5\u00adW\2\u0128\u0129\5\u00afX\2\u0129\u012a\5\u00abV\2\u012a"+
		"\u012b\5\u0091I\2\u012b\u012c\5\u0089E\2\u012c\u012d\5\u00a1Q\2\u012d"+
		"\60\3\2\2\2\u012e\u012f\5\u00adW\2\u012f\u0130\5\u0091I\2\u0130\u0131"+
		"\5\u009fP\2\u0131\u0132\5\u0091I\2\u0132\u0133\5\u008dG\2\u0133\u0134"+
		"\5\u00afX\2\u0134\62\3\2\2\2\u0135\u0136\5\u0093J\2\u0136\u0137\5\u00ab"+
		"V\2\u0137\u0138\5\u00a5S\2\u0138\u0139\5\u00a1Q\2\u0139\64\3\2\2\2\u013a"+
		"\u013b\5\u00b5[\2\u013b\u013c\5\u0097L\2\u013c\u013d\5\u0091I\2\u013d"+
		"\u013e\5\u00abV\2\u013e\u013f\5\u0091I\2\u013f\66\3\2\2\2\u0140\u0141"+
		"\5\u0095K\2\u0141\u0142\5\u00abV\2\u0142\u0143\5\u00a5S\2\u0143\u0144"+
		"\5\u00b1Y\2\u0144\u0145\5\u00a7T\2\u01458\3\2\2\2\u0146\u0147\5\u008b"+
		"F\2\u0147\u0148\5\u00b9]\2\u0148:\3\2\2\2\u0149\u014a\5\u0097L\2\u014a"+
		"\u014b\5\u0089E\2\u014b\u014c\5\u00b3Z\2\u014c\u014d\5\u0099M\2\u014d"+
		"\u014e\5\u00a3R\2\u014e\u014f\5\u0095K\2\u014f<\3\2\2\2\u0150\u0151\5"+
		"\u008fH\2\u0151\u0152\5\u0099M\2\u0152\u0153\5\u00adW\2\u0153\u0154\5"+
		"\u00afX\2\u0154\u0155\5\u0099M\2\u0155\u0156\5\u00a3R\2\u0156\u0157\5"+
		"\u008dG\2\u0157\u0158\5\u00afX\2\u0158>\3\2\2\2\u0159\u015a\5\u0089E\2"+
		"\u015a\u015b\5\u00adW\2\u015b@\3\2\2\2\u015c\u015d\5\u0089E\2\u015d\u015e"+
		"\5\u00a3R\2\u015e\u015f\5\u008fH\2\u015fB\3\2\2\2\u0160\u0161\5\u00a5"+
		"S\2\u0161\u0162\5\u00abV\2\u0162D\3\2\2\2\u0163\u0164\5\u00a3R\2\u0164"+
		"\u0165\5\u00a5S\2\u0165\u0166\5\u00afX\2\u0166F\3\2\2\2\u0167\u0168\5"+
		"\u00a3R\2\u0168\u0169\5\u00a5S\2\u0169\u016a\5\u00afX\2\u016a\u016b\5"+
		"\u00a3R\2\u016b\u016c\5\u00b1Y\2\u016c\u016d\5\u009fP\2\u016d\u016e\5"+
		"\u009fP\2\u016eH\3\2\2\2\u016f\u0170\5\u0099M\2\u0170\u0171\5\u00adW\2"+
		"\u0171\u0172\5\u00a3R\2\u0172\u0173\5\u00b1Y\2\u0173\u0174\5\u009fP\2"+
		"\u0174\u0175\5\u009fP\2\u0175J\3\2\2\2\u0176\u0177\5\u0099M\2\u0177\u0178"+
		"\5\u00a3R\2\u0178L\3\2\2\2\u0179\u017a\5\u00a5S\2\u017a\u017b\5\u00ab"+
		"V\2\u017b\u017c\5\u008fH\2\u017c\u017d\5\u0091I\2\u017d\u017e\5\u00ab"+
		"V\2\u017eN\3\2\2\2\u017f\u0180\5\u009fP\2\u0180\u0181\5\u0099M\2\u0181"+
		"\u0182\5\u00a1Q\2\u0182\u0183\5\u0099M\2\u0183\u0184\5\u00afX\2\u0184"+
		"P\3\2\2\2\u0185\u0186\5\u00a5S\2\u0186\u0187\5\u0093J\2\u0187\u0188\5"+
		"\u0093J\2\u0188\u0189\5\u00adW\2\u0189\u018a\5\u0091I\2\u018a\u018b\5"+
		"\u00afX\2\u018bR\3\2\2\2\u018c\u018d\5\u0089E\2\u018d\u018e\5\u00adW\2"+
		"\u018e\u018f\5\u008dG\2\u018fT\3\2\2\2\u0190\u0191\5\u008fH\2\u0191\u0192"+
		"\5\u0091I\2\u0192\u0193\5\u00adW\2\u0193\u0194\5\u008dG\2\u0194V\3\2\2"+
		"\2\u0195\u0196\5\u00abV\2\u0196\u0197\5\u0089E\2\u0197\u0198\5\u00a3R"+
		"\2\u0198\u0199\5\u0095K\2\u0199\u019a\5\u0091I\2\u019aX\3\2\2\2\u019b"+
		"\u019c\5\u00adW\2\u019c\u019d\5\u009fP\2\u019d\u019e\5\u0099M\2\u019e"+
		"\u019f\5\u008fH\2\u019f\u01a0\5\u0091I\2\u01a0Z\3\2\2\2\u01a1\u01a2\5"+
		"\u00adW\2\u01a2\u01a3\5\u0091I\2\u01a3\u01a4\5\u008dG\2\u01a4\u01a5\5"+
		"\u00a5S\2\u01a5\u01a6\5\u00a3R\2\u01a6\u01a7\5\u008fH\2\u01a7\u01a8\5"+
		"\u00adW\2\u01a8\\\3\2\2\2\u01a9\u01aa\5\u00a1Q\2\u01aa\u01ab\5\u0099M"+
		"\2\u01ab\u01ac\5\u00a3R\2\u01ac\u01ad\5\u00b1Y\2\u01ad\u01ae\5\u00afX"+
		"\2\u01ae\u01af\5\u0091I\2\u01af\u01b0\5\u00adW\2\u01b0^\3\2\2\2\u01b1"+
		"\u01b2\5\u0097L\2\u01b2\u01b3\5\u00a5S\2\u01b3\u01b4\5\u00b1Y\2\u01b4"+
		"\u01b5\5\u00abV\2\u01b5\u01b6\5\u00adW\2\u01b6`\3\2\2\2\u01b7\u01b8\5"+
		"\u0089E\2\u01b8\u01b9\5\u00b3Z\2\u01b9\u01ba\5\u0095K\2\u01bab\3\2\2\2"+
		"\u01bb\u01bc\5\u00a1Q\2\u01bc\u01bd\5\u0099M\2\u01bd\u01be\5\u00a3R\2"+
		"\u01bed\3\2\2\2\u01bf\u01c0\5\u00adW\2\u01c0\u01c1\5\u00b1Y\2\u01c1\u01c2"+
		"\5\u00a1Q\2\u01c2f\3\2\2\2\u01c3\u01c4\5\u00a1Q\2\u01c4\u01c5\5\u0089"+
		"E\2\u01c5\u01c6\5\u00b7\\\2\u01c6h\3\2\2\2\u01c7\u01c8\5\u008dG\2\u01c8"+
		"\u01c9\5\u00a5S\2\u01c9\u01ca\5\u00b1Y\2\u01ca\u01cb\5\u00a3R\2\u01cb"+
		"\u01cc\5\u00afX\2\u01ccj\3\2\2\2\u01cd\u01ce\5\u008dG\2\u01ce\u01cf\5"+
		"\u0089E\2\u01cf\u01d0\5\u00adW\2\u01d0\u01d1\5\u00afX\2\u01d1l\3\2\2\2"+
		"\u01d2\u01d3\5\u0099M\2\u01d3\u01d4\5\u00a3R\2\u01d4\u01d5\5\u00afX\2"+
		"\u01d5n\3\2\2\2\u01d6\u01d7\5\u00abV\2\u01d7\u01d8\5\u0091I\2\u01d8\u01d9"+
		"\5\u0089E\2\u01d9\u01da\5\u009fP\2\u01dap\3\2\2\2\u01db\u01dc\5\u008b"+
		"F\2\u01dc\u01dd\5\u00a5S\2\u01dd\u01de\5\u00a5S\2\u01de\u01df\5\u009f"+
		"P\2\u01df\u01e0\5\u0091I\2\u01e0\u01e1\5\u0089E\2\u01e1\u01e2\5\u00a3"+
		"R\2\u01e2r\3\2\2\2\u01e3\u01e4\5\u00adW\2\u01e4\u01e5\5\u00afX\2\u01e5"+
		"\u01e6\5\u00abV\2\u01e6\u01e7\5\u0099M\2\u01e7\u01e8\5\u00a3R\2\u01e8"+
		"\u01e9\5\u0095K\2\u01e9t\3\2\2\2\u01ea\u01eb\5\u009fP\2\u01eb\u01ec\5"+
		"\u0099M\2\u01ec\u01ed\5\u009dO\2\u01ed\u01ee\5\u0091I\2\u01eev\3\2\2\2"+
		"\u01ef\u01f5\7b\2\2\u01f0\u01f4\n\2\2\2\u01f1\u01f2\7b\2\2\u01f2\u01f4"+
		"\7b\2\2\u01f3\u01f0\3\2\2\2\u01f3\u01f1\3\2\2\2\u01f4\u01f7\3\2\2\2\u01f5"+
		"\u01f3\3\2\2\2\u01f5\u01f6\3\2\2\2\u01f6\u01f8\3\2\2\2\u01f7\u01f5\3\2"+
		"\2\2\u01f8\u0201\7b\2\2\u01f9\u01fd\t\3\2\2\u01fa\u01fc\t\4\2\2\u01fb"+
		"\u01fa\3\2\2\2\u01fc\u01ff\3\2\2\2\u01fd\u01fb\3\2\2\2\u01fd\u01fe\3\2"+
		"\2\2\u01fe\u0201\3\2\2\2\u01ff\u01fd\3\2\2\2\u0200\u01ef\3\2\2\2\u0200"+
		"\u01f9\3\2\2\2\u0201x\3\2\2\2\u0202\u0206\7$\2\2\u0203\u0205\n\5\2\2\u0204"+
		"\u0203\3\2\2\2\u0205\u0208\3\2\2\2\u0206\u0204\3\2\2\2\u0206\u0207\3\2"+
		"\2\2\u0207\u0209\3\2\2\2\u0208\u0206\3\2\2\2\u0209\u020a\7$\2\2\u020a"+
		"z\3\2\2\2\u020b\u020c\5\u00afX\2\u020c\u020d\5\u00abV\2\u020d\u020e\5"+
		"\u00b1Y\2\u020e\u020f\5\u0091I\2\u020f\u0217\3\2\2\2\u0210\u0211\5\u0093"+
		"J\2\u0211\u0212\5\u0089E\2\u0212\u0213\5\u009fP\2\u0213\u0214\5\u00ad"+
		"W\2\u0214\u0215\5\u0091I\2\u0215\u0217\3\2\2\2\u0216\u020b\3\2\2\2\u0216"+
		"\u0210\3\2\2\2\u0217|\3\2\2\2\u0218\u021a\7/\2\2\u0219\u0218\3\2\2\2\u0219"+
		"\u021a\3\2\2\2\u021a\u021c\3\2\2\2\u021b\u021d\5\u0087D\2\u021c\u021b"+
		"\3\2\2\2\u021d\u021e\3\2\2\2\u021e\u021c\3\2\2\2\u021e\u021f\3\2\2\2\u021f"+
		"~\3\2\2\2\u0220\u0222\5\u0087D\2\u0221\u0220\3\2\2\2\u0222\u0223\3\2\2"+
		"\2\u0223\u0221\3\2\2\2\u0223\u0224\3\2\2\2\u0224\u022c\3\2\2\2\u0225\u0229"+
		"\7\60\2\2\u0226\u0228\5\u0087D\2\u0227\u0226\3\2\2\2\u0228\u022b\3\2\2"+
		"\2\u0229\u0227\3\2\2\2\u0229\u022a\3\2\2\2\u022a\u022d\3\2\2\2\u022b\u0229"+
		"\3\2\2\2\u022c\u0225\3\2\2\2\u022c\u022d\3\2\2\2\u022d\u0237\3\2\2\2\u022e"+
		"\u0230\5\u0091I\2\u022f\u0231\t\6\2\2\u0230\u022f\3\2\2\2\u0230\u0231"+
		"\3\2\2\2\u0231\u0233\3\2\2\2\u0232\u0234\5\u0087D\2\u0233\u0232\3\2\2"+
		"\2\u0234\u0235\3\2\2\2\u0235\u0233\3\2\2\2\u0235\u0236\3\2\2\2\u0236\u0238"+
		"\3\2\2\2\u0237\u022e\3\2\2\2\u0237\u0238\3\2\2\2\u0238\u024b\3\2\2\2\u0239"+
		"\u023b\7\60\2\2\u023a\u023c\5\u0087D\2\u023b\u023a\3\2\2\2\u023c\u023d"+
		"\3\2\2\2\u023d\u023b\3\2\2\2\u023d\u023e\3\2\2\2\u023e\u0248\3\2\2\2\u023f"+
		"\u0241\5\u0091I\2\u0240\u0242\t\6\2\2\u0241\u0240\3\2\2\2\u0241\u0242"+
		"\3\2\2\2\u0242\u0244\3\2\2\2\u0243\u0245\5\u0087D\2\u0244\u0243\3\2\2"+
		"\2\u0245\u0246\3\2\2\2\u0246\u0244\3\2\2\2\u0246\u0247\3\2\2\2\u0247\u0249"+
		"\3\2\2\2\u0248\u023f\3\2\2\2\u0248\u0249\3\2\2\2\u0249\u024b\3\2\2\2\u024a"+
		"\u0221\3\2\2\2\u024a\u0239\3\2\2\2\u024b\u0080\3\2\2\2\u024c\u024d\7\61"+
		"\2\2\u024d\u024e\7\61\2\2\u024e\u0252\3\2\2\2\u024f\u0251\n\7\2\2\u0250"+
		"\u024f\3\2\2\2\u0251\u0254\3\2\2\2\u0252\u0250\3\2\2\2\u0252\u0253\3\2"+
		"\2\2\u0253\u0255\3\2\2\2\u0254\u0252\3\2\2\2\u0255\u0256\bA\2\2\u0256"+
		"\u0082\3\2\2\2\u0257\u0258\7\61\2\2\u0258\u0259\7,\2\2\u0259\u025d\3\2"+
		"\2\2\u025a\u025c\13\2\2\2\u025b\u025a\3\2\2\2\u025c\u025f\3\2\2\2\u025d"+
		"\u025e\3\2\2\2\u025d\u025b\3\2\2\2\u025e\u0263\3\2\2\2\u025f\u025d\3\2"+
		"\2\2\u0260\u0261\7,\2\2\u0261\u0264\7\61\2\2\u0262\u0264\7\2\2\3\u0263"+
		"\u0260\3\2\2\2\u0263\u0262\3\2\2\2\u0264\u0265\3\2\2\2\u0265\u0266\bB"+
		"\2\2\u0266\u0084\3\2\2\2\u0267\u0268\t\b\2\2\u0268\u0269\3\2\2\2\u0269"+
		"\u026a\bC\2\2\u026a\u0086\3\2\2\2\u026b\u026c\t\t\2\2\u026c\u0088\3\2"+
		"\2\2\u026d\u026e\t\n\2\2\u026e\u008a\3\2\2\2\u026f\u0270\t\13\2\2\u0270"+
		"\u008c\3\2\2\2\u0271\u0272\t\f\2\2\u0272\u008e\3\2\2\2\u0273\u0274\t\r"+
		"\2\2\u0274\u0090\3\2\2\2\u0275\u0276\t\16\2\2\u0276\u0092\3\2\2\2\u0277"+
		"\u0278\t\17\2\2\u0278\u0094\3\2\2\2\u0279\u027a\t\20\2\2\u027a\u0096\3"+
		"\2\2\2\u027b\u027c\t\21\2\2\u027c\u0098\3\2\2\2\u027d\u027e\t\22\2\2\u027e"+
		"\u009a\3\2\2\2\u027f\u0280\t\23\2\2\u0280\u009c\3\2\2\2\u0281\u0282\t"+
		"\24\2\2\u0282\u009e\3\2\2\2\u0283\u0284\t\25\2\2\u0284\u00a0\3\2\2\2\u0285"+
		"\u0286\t\26\2\2\u0286\u00a2\3\2\2\2\u0287\u0288\t\27\2\2\u0288\u00a4\3"+
		"\2\2\2\u0289\u028a\t\30\2\2\u028a\u00a6\3\2\2\2\u028b\u028c\t\31\2\2\u028c"+
		"\u00a8\3\2\2\2\u028d\u028e\t\32\2\2\u028e\u00aa\3\2\2\2\u028f\u0290\t"+
		"\33\2\2\u0290\u00ac\3\2\2\2\u0291\u0292\t\34\2\2\u0292\u00ae\3\2\2\2\u0293"+
		"\u0294\t\35\2\2\u0294\u00b0\3\2\2\2\u0295\u0296\t\36\2\2\u0296\u00b2\3"+
		"\2\2\2\u0297\u0298\t\37\2\2\u0298\u00b4\3\2\2\2\u0299\u029a\t \2\2\u029a"+
		"\u00b6\3\2\2\2\u029b\u029c\t!\2\2\u029c\u00b8\3\2\2\2\u029d\u029e\t\""+
		"\2\2\u029e\u00ba\3\2\2\2\u029f\u02a0\t#\2\2\u02a0\u00bc\3\2\2\2\31\2\u01f3"+
		"\u01f5\u01fd\u0200\u0206\u0216\u0219\u021e\u0223\u0229\u022c\u0230\u0235"+
		"\u0237\u023d\u0241\u0246\u0248\u024a\u0252\u025d\u0263\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}