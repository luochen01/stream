// Generated from TQL.g4 by ANTLR 4.4

	package edu.uci.asterix.stream.parser.gen;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TQLParser extends Parser {
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
		COUNT=52, IDENTIFIER=53, STRING_LITERAL=54, BOOLEAN_LITERAL=55, INT_LITERAL=56, 
		REAL_LITERAL=57, SINGLE_LINE_COMMENT=58, MULTILINE_COMMENT=59, SPACES=60;
	public static final String[] tokenNames = {
		"<INVALID>", "'/'", "'!='", "'>='", "'['", "';'", "'<'", "']'", "'='", 
		"'>'", "'<='", "'%'", "'''", "'('", "')'", "'*'", "'+'", "','", "'-'", 
		"'.'", "DEFINE", "SENSOR_COLLECTION", "OBSERVATION_STREAM", "SENSORS_TO_OBSERVATION_STREAM", 
		"SELECT", "FROM", "WHERE", "GROUP", "BY", "HAVING", "DISTINCT", "AS", 
		"AND", "OR", "NOT", "NOT_NULL", "IS_NULL", "IN", "ORDER", "LIMIT", "OFFSET", 
		"ASC", "DESC", "RANGE", "SLIDE", "SECONDS", "MINUTES", "HOURS", "AVG", 
		"MIN", "SUM", "MAX", "COUNT", "IDENTIFIER", "STRING_LITERAL", "BOOLEAN_LITERAL", 
		"INT_LITERAL", "REAL_LITERAL", "SINGLE_LINE_COMMENT", "MULTILINE_COMMENT", 
		"SPACES"
	};
	public static final int
		RULE_parse = 0, RULE_define_sensor_collections = 1, RULE_define_observation_streams = 2, 
		RULE_define_sensor_collection = 3, RULE_define_observation_stream = 4, 
		RULE_select_stmt = 5, RULE_select_stream_stmt = 6, RULE_select = 7, RULE_column_list = 8, 
		RULE_from = 9, RULE_table = 10, RULE_from_stream = 11, RULE_stream_window = 12, 
		RULE_where = 13, RULE_group_by = 14, RULE_having = 15, RULE_order_by = 16, 
		RULE_limit = 17, RULE_time_interval = 18, RULE_time_unit = 19, RULE_alias_name = 20, 
		RULE_sensor_collection_name = 21, RULE_observation_stream_name = 22, RULE_table_name = 23, 
		RULE_field_name = 24, RULE_column_name = 25, RULE_function_name = 26, 
		RULE_any_name = 27, RULE_result_column = 28, RULE_column_alias = 29, RULE_expr = 30, 
		RULE_field_access = 31, RULE_term_expr = 32, RULE_logic_expr = 33, RULE_literal_value = 34, 
		RULE_agg_func = 35, RULE_parameter_list = 36;
	public static final String[] ruleNames = {
		"parse", "define_sensor_collections", "define_observation_streams", "define_sensor_collection", 
		"define_observation_stream", "select_stmt", "select_stream_stmt", "select", 
		"column_list", "from", "table", "from_stream", "stream_window", "where", 
		"group_by", "having", "order_by", "limit", "time_interval", "time_unit", 
		"alias_name", "sensor_collection_name", "observation_stream_name", "table_name", 
		"field_name", "column_name", "function_name", "any_name", "result_column", 
		"column_alias", "expr", "field_access", "term_expr", "logic_expr", "literal_value", 
		"agg_func", "parameter_list"
	};

	@Override
	public String getGrammarFileName() { return "TQL.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TQLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ParseContext extends ParserRuleContext {
		public Define_observation_streamContext define_observation_stream(int i) {
			return getRuleContext(Define_observation_streamContext.class,i);
		}
		public Define_observation_streamsContext define_observation_streams() {
			return getRuleContext(Define_observation_streamsContext.class,0);
		}
		public Define_sensor_collectionContext define_sensor_collection(int i) {
			return getRuleContext(Define_sensor_collectionContext.class,i);
		}
		public Select_stream_stmtContext select_stream_stmt() {
			return getRuleContext(Select_stream_stmtContext.class,0);
		}
		public List<Define_sensor_collectionContext> define_sensor_collection() {
			return getRuleContexts(Define_sensor_collectionContext.class);
		}
		public List<Define_observation_streamContext> define_observation_stream() {
			return getRuleContexts(Define_observation_streamContext.class);
		}
		public Define_sensor_collectionsContext define_sensor_collections() {
			return getRuleContext(Define_sensor_collectionsContext.class,0);
		}
		public ParseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).enterParse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).exitParse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TQLVisitor ) return ((TQLVisitor<? extends T>)visitor).visitParse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParseContext parse() throws RecognitionException {
		ParseContext _localctx = new ParseContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_parse);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(74); define_sensor_collections();
			setState(75); define_observation_streams();
			setState(77); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(76); define_sensor_collection();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(79); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(82); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(81); define_observation_stream();
				}
				}
				setState(84); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==IDENTIFIER || _la==STRING_LITERAL );
			setState(86); select_stream_stmt();
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

	public static class Define_sensor_collectionsContext extends ParserRuleContext {
		public TerminalNode SENSOR_COLLECTION() { return getToken(TQLParser.SENSOR_COLLECTION, 0); }
		public TerminalNode DEFINE() { return getToken(TQLParser.DEFINE, 0); }
		public List<Sensor_collection_nameContext> sensor_collection_name() {
			return getRuleContexts(Sensor_collection_nameContext.class);
		}
		public Sensor_collection_nameContext sensor_collection_name(int i) {
			return getRuleContext(Sensor_collection_nameContext.class,i);
		}
		public Define_sensor_collectionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_define_sensor_collections; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).enterDefine_sensor_collections(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).exitDefine_sensor_collections(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TQLVisitor ) return ((TQLVisitor<? extends T>)visitor).visitDefine_sensor_collections(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Define_sensor_collectionsContext define_sensor_collections() throws RecognitionException {
		Define_sensor_collectionsContext _localctx = new Define_sensor_collectionsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_define_sensor_collections);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88); match(DEFINE);
			setState(89); match(SENSOR_COLLECTION);
			setState(90); sensor_collection_name();
			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(91); match(T__2);
				setState(92); sensor_collection_name();
				}
				}
				setState(97);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(98); match(T__14);
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

	public static class Define_observation_streamsContext extends ParserRuleContext {
		public Observation_stream_nameContext observation_stream_name(int i) {
			return getRuleContext(Observation_stream_nameContext.class,i);
		}
		public TerminalNode OBSERVATION_STREAM() { return getToken(TQLParser.OBSERVATION_STREAM, 0); }
		public TerminalNode DEFINE() { return getToken(TQLParser.DEFINE, 0); }
		public List<Observation_stream_nameContext> observation_stream_name() {
			return getRuleContexts(Observation_stream_nameContext.class);
		}
		public Define_observation_streamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_define_observation_streams; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).enterDefine_observation_streams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).exitDefine_observation_streams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TQLVisitor ) return ((TQLVisitor<? extends T>)visitor).visitDefine_observation_streams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Define_observation_streamsContext define_observation_streams() throws RecognitionException {
		Define_observation_streamsContext _localctx = new Define_observation_streamsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_define_observation_streams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100); match(DEFINE);
			setState(101); match(OBSERVATION_STREAM);
			setState(102); observation_stream_name();
			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(103); match(T__2);
				setState(104); observation_stream_name();
				}
				}
				setState(109);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(110); match(T__14);
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

	public static class Define_sensor_collectionContext extends ParserRuleContext {
		public Sensor_collection_nameContext sensor_collection_name() {
			return getRuleContext(Sensor_collection_nameContext.class,0);
		}
		public Select_stmtContext select_stmt() {
			return getRuleContext(Select_stmtContext.class,0);
		}
		public Define_sensor_collectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_define_sensor_collection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).enterDefine_sensor_collection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).exitDefine_sensor_collection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TQLVisitor ) return ((TQLVisitor<? extends T>)visitor).visitDefine_sensor_collection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Define_sensor_collectionContext define_sensor_collection() throws RecognitionException {
		Define_sensor_collectionContext _localctx = new Define_sensor_collectionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_define_sensor_collection);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112); sensor_collection_name();
			setState(113); match(T__11);
			setState(114); select_stmt();
			setState(115); match(T__14);
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

	public static class Define_observation_streamContext extends ParserRuleContext {
		public Observation_stream_nameContext observation_stream_name() {
			return getRuleContext(Observation_stream_nameContext.class,0);
		}
		public Sensor_collection_nameContext sensor_collection_name() {
			return getRuleContext(Sensor_collection_nameContext.class,0);
		}
		public TerminalNode SENSORS_TO_OBSERVATION_STREAM() { return getToken(TQLParser.SENSORS_TO_OBSERVATION_STREAM, 0); }
		public Define_observation_streamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_define_observation_stream; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).enterDefine_observation_stream(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).exitDefine_observation_stream(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TQLVisitor ) return ((TQLVisitor<? extends T>)visitor).visitDefine_observation_stream(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Define_observation_streamContext define_observation_stream() throws RecognitionException {
		Define_observation_streamContext _localctx = new Define_observation_streamContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_define_observation_stream);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117); observation_stream_name();
			setState(118); match(T__11);
			setState(119); match(SENSORS_TO_OBSERVATION_STREAM);
			setState(120); match(T__6);
			setState(121); sensor_collection_name();
			setState(122); match(T__5);
			setState(123); match(T__14);
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

	public static class Select_stmtContext extends ParserRuleContext {
		public WhereContext where() {
			return getRuleContext(WhereContext.class,0);
		}
		public FromContext from() {
			return getRuleContext(FromContext.class,0);
		}
		public SelectContext select() {
			return getRuleContext(SelectContext.class,0);
		}
		public Select_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_select_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).enterSelect_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).exitSelect_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TQLVisitor ) return ((TQLVisitor<? extends T>)visitor).visitSelect_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Select_stmtContext select_stmt() throws RecognitionException {
		Select_stmtContext _localctx = new Select_stmtContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_select_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125); select();
			setState(126); from();
			setState(128);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(127); where();
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

	public static class Select_stream_stmtContext extends ParserRuleContext {
		public Group_byContext group_by() {
			return getRuleContext(Group_byContext.class,0);
		}
		public From_streamContext from_stream() {
			return getRuleContext(From_streamContext.class,0);
		}
		public WhereContext where() {
			return getRuleContext(WhereContext.class,0);
		}
		public Order_byContext order_by() {
			return getRuleContext(Order_byContext.class,0);
		}
		public SelectContext select() {
			return getRuleContext(SelectContext.class,0);
		}
		public LimitContext limit() {
			return getRuleContext(LimitContext.class,0);
		}
		public Select_stream_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_select_stream_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).enterSelect_stream_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).exitSelect_stream_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TQLVisitor ) return ((TQLVisitor<? extends T>)visitor).visitSelect_stream_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Select_stream_stmtContext select_stream_stmt() throws RecognitionException {
		Select_stream_stmtContext _localctx = new Select_stream_stmtContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_select_stream_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130); select();
			setState(131); from_stream();
			setState(133);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(132); where();
				}
			}

			setState(136);
			_la = _input.LA(1);
			if (_la==GROUP) {
				{
				setState(135); group_by();
				}
			}

			setState(139);
			_la = _input.LA(1);
			if (_la==ORDER) {
				{
				setState(138); order_by();
				}
			}

			setState(142);
			_la = _input.LA(1);
			if (_la==LIMIT) {
				{
				setState(141); limit();
				}
			}

			setState(144); match(T__14);
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

	public static class SelectContext extends ParserRuleContext {
		public TerminalNode SELECT() { return getToken(TQLParser.SELECT, 0); }
		public Column_listContext column_list() {
			return getRuleContext(Column_listContext.class,0);
		}
		public SelectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_select; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).enterSelect(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).exitSelect(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TQLVisitor ) return ((TQLVisitor<? extends T>)visitor).visitSelect(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectContext select() throws RecognitionException {
		SelectContext _localctx = new SelectContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_select);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146); match(SELECT);
			setState(147); column_list();
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

	public static class Column_listContext extends ParserRuleContext {
		public List<Result_columnContext> result_column() {
			return getRuleContexts(Result_columnContext.class);
		}
		public Result_columnContext result_column(int i) {
			return getRuleContext(Result_columnContext.class,i);
		}
		public Column_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).enterColumn_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).exitColumn_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TQLVisitor ) return ((TQLVisitor<? extends T>)visitor).visitColumn_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Column_listContext column_list() throws RecognitionException {
		Column_listContext _localctx = new Column_listContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_column_list);
		int _la;
		try {
			setState(158);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(149); match(T__4);
				}
				break;
			case T__6:
			case T__1:
			case AVG:
			case MIN:
			case SUM:
			case MAX:
			case COUNT:
			case IDENTIFIER:
			case STRING_LITERAL:
			case INT_LITERAL:
			case REAL_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(150); result_column();
				setState(155);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(151); match(T__2);
					setState(152); result_column();
					}
					}
					setState(157);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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

	public static class FromContext extends ParserRuleContext {
		public List<TableContext> table() {
			return getRuleContexts(TableContext.class);
		}
		public TableContext table(int i) {
			return getRuleContext(TableContext.class,i);
		}
		public TerminalNode FROM() { return getToken(TQLParser.FROM, 0); }
		public FromContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_from; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).enterFrom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).exitFrom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TQLVisitor ) return ((TQLVisitor<? extends T>)visitor).visitFrom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FromContext from() throws RecognitionException {
		FromContext _localctx = new FromContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_from);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160); match(FROM);
			setState(161); table();
			setState(166);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(162); match(T__2);
				setState(163); table();
				}
				}
				setState(168);
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

	public static class TableContext extends ParserRuleContext {
		public Alias_nameContext alias_name() {
			return getRuleContext(Alias_nameContext.class,0);
		}
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public TableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).enterTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).exitTable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TQLVisitor ) return ((TQLVisitor<? extends T>)visitor).visitTable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableContext table() throws RecognitionException {
		TableContext _localctx = new TableContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_table);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169); table_name();
			setState(171);
			_la = _input.LA(1);
			if (_la==IDENTIFIER || _la==STRING_LITERAL) {
				{
				setState(170); alias_name();
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

	public static class From_streamContext extends ParserRuleContext {
		public List<Stream_windowContext> stream_window() {
			return getRuleContexts(Stream_windowContext.class);
		}
		public Stream_windowContext stream_window(int i) {
			return getRuleContext(Stream_windowContext.class,i);
		}
		public TerminalNode FROM() { return getToken(TQLParser.FROM, 0); }
		public From_streamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_from_stream; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).enterFrom_stream(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).exitFrom_stream(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TQLVisitor ) return ((TQLVisitor<? extends T>)visitor).visitFrom_stream(this);
			else return visitor.visitChildren(this);
		}
	}

	public final From_streamContext from_stream() throws RecognitionException {
		From_streamContext _localctx = new From_streamContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_from_stream);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173); match(FROM);
			setState(174); stream_window();
			setState(179);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(175); match(T__2);
				setState(176); stream_window();
				}
				}
				setState(181);
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

	public static class Stream_windowContext extends ParserRuleContext {
		public TerminalNode RANGE() { return getToken(TQLParser.RANGE, 0); }
		public List<Time_intervalContext> time_interval() {
			return getRuleContexts(Time_intervalContext.class);
		}
		public TerminalNode SLIDE() { return getToken(TQLParser.SLIDE, 0); }
		public Alias_nameContext alias_name() {
			return getRuleContext(Alias_nameContext.class,0);
		}
		public Observation_stream_nameContext observation_stream_name() {
			return getRuleContext(Observation_stream_nameContext.class,0);
		}
		public Time_intervalContext time_interval(int i) {
			return getRuleContext(Time_intervalContext.class,i);
		}
		public Stream_windowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stream_window; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).enterStream_window(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).exitStream_window(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TQLVisitor ) return ((TQLVisitor<? extends T>)visitor).visitStream_window(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Stream_windowContext stream_window() throws RecognitionException {
		Stream_windowContext _localctx = new Stream_windowContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_stream_window);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182); observation_stream_name();
			setState(184);
			_la = _input.LA(1);
			if (_la==IDENTIFIER || _la==STRING_LITERAL) {
				{
				setState(183); alias_name();
				}
			}

			setState(186); match(RANGE);
			setState(187); time_interval();
			setState(188); match(SLIDE);
			setState(189); time_interval();
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

	public static class WhereContext extends ParserRuleContext {
		public Logic_exprContext logic_expr() {
			return getRuleContext(Logic_exprContext.class,0);
		}
		public TerminalNode WHERE() { return getToken(TQLParser.WHERE, 0); }
		public WhereContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_where; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).enterWhere(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).exitWhere(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TQLVisitor ) return ((TQLVisitor<? extends T>)visitor).visitWhere(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhereContext where() throws RecognitionException {
		WhereContext _localctx = new WhereContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_where);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191); match(WHERE);
			setState(192); logic_expr(0);
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

	public static class Group_byContext extends ParserRuleContext {
		public HavingContext having() {
			return getRuleContext(HavingContext.class,0);
		}
		public Field_accessContext field_access(int i) {
			return getRuleContext(Field_accessContext.class,i);
		}
		public TerminalNode GROUP() { return getToken(TQLParser.GROUP, 0); }
		public List<Field_accessContext> field_access() {
			return getRuleContexts(Field_accessContext.class);
		}
		public TerminalNode BY() { return getToken(TQLParser.BY, 0); }
		public Group_byContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_group_by; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).enterGroup_by(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).exitGroup_by(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TQLVisitor ) return ((TQLVisitor<? extends T>)visitor).visitGroup_by(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Group_byContext group_by() throws RecognitionException {
		Group_byContext _localctx = new Group_byContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_group_by);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194); match(GROUP);
			setState(195); match(BY);
			setState(196); field_access();
			setState(201);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(197); match(T__2);
				setState(198); field_access();
				}
				}
				setState(203);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(205);
			_la = _input.LA(1);
			if (_la==HAVING) {
				{
				setState(204); having();
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

	public static class HavingContext extends ParserRuleContext {
		public Logic_exprContext logic_expr() {
			return getRuleContext(Logic_exprContext.class,0);
		}
		public TerminalNode HAVING() { return getToken(TQLParser.HAVING, 0); }
		public HavingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_having; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).enterHaving(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).exitHaving(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TQLVisitor ) return ((TQLVisitor<? extends T>)visitor).visitHaving(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HavingContext having() throws RecognitionException {
		HavingContext _localctx = new HavingContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_having);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207); match(HAVING);
			setState(208); logic_expr(0);
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

	public static class Order_byContext extends ParserRuleContext {
		public TerminalNode ASC() { return getToken(TQLParser.ASC, 0); }
		public Field_accessContext field_access(int i) {
			return getRuleContext(Field_accessContext.class,i);
		}
		public TerminalNode ORDER() { return getToken(TQLParser.ORDER, 0); }
		public List<Field_accessContext> field_access() {
			return getRuleContexts(Field_accessContext.class);
		}
		public TerminalNode DESC() { return getToken(TQLParser.DESC, 0); }
		public TerminalNode BY() { return getToken(TQLParser.BY, 0); }
		public Order_byContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_order_by; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).enterOrder_by(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).exitOrder_by(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TQLVisitor ) return ((TQLVisitor<? extends T>)visitor).visitOrder_by(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Order_byContext order_by() throws RecognitionException {
		Order_byContext _localctx = new Order_byContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_order_by);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210); match(ORDER);
			setState(211); match(BY);
			setState(212); field_access();
			setState(217);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(213); match(T__2);
				setState(214); field_access();
				}
				}
				setState(219);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(221);
			_la = _input.LA(1);
			if (_la==ASC || _la==DESC) {
				{
				setState(220);
				_la = _input.LA(1);
				if ( !(_la==ASC || _la==DESC) ) {
				_errHandler.recoverInline(this);
				}
				consume();
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

	public static class LimitContext extends ParserRuleContext {
		public TerminalNode OFFSET() { return getToken(TQLParser.OFFSET, 0); }
		public TerminalNode LIMIT() { return getToken(TQLParser.LIMIT, 0); }
		public TerminalNode INT_LITERAL(int i) {
			return getToken(TQLParser.INT_LITERAL, i);
		}
		public List<TerminalNode> INT_LITERAL() { return getTokens(TQLParser.INT_LITERAL); }
		public LimitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_limit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).enterLimit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).exitLimit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TQLVisitor ) return ((TQLVisitor<? extends T>)visitor).visitLimit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LimitContext limit() throws RecognitionException {
		LimitContext _localctx = new LimitContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_limit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223); match(LIMIT);
			setState(224); match(INT_LITERAL);
			setState(227);
			_la = _input.LA(1);
			if (_la==OFFSET) {
				{
				setState(225); match(OFFSET);
				setState(226); match(INT_LITERAL);
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

	public static class Time_intervalContext extends ParserRuleContext {
		public Time_unitContext time_unit() {
			return getRuleContext(Time_unitContext.class,0);
		}
		public TerminalNode INT_LITERAL() { return getToken(TQLParser.INT_LITERAL, 0); }
		public Time_intervalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_time_interval; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).enterTime_interval(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).exitTime_interval(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TQLVisitor ) return ((TQLVisitor<? extends T>)visitor).visitTime_interval(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Time_intervalContext time_interval() throws RecognitionException {
		Time_intervalContext _localctx = new Time_intervalContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_time_interval);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229); match(T__7);
			setState(230); match(INT_LITERAL);
			setState(231); time_unit();
			setState(232); match(T__7);
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

	public static class Time_unitContext extends ParserRuleContext {
		public TerminalNode HOURS() { return getToken(TQLParser.HOURS, 0); }
		public TerminalNode SECONDS() { return getToken(TQLParser.SECONDS, 0); }
		public TerminalNode MINUTES() { return getToken(TQLParser.MINUTES, 0); }
		public Time_unitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_time_unit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).enterTime_unit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).exitTime_unit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TQLVisitor ) return ((TQLVisitor<? extends T>)visitor).visitTime_unit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Time_unitContext time_unit() throws RecognitionException {
		Time_unitContext _localctx = new Time_unitContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_time_unit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SECONDS) | (1L << MINUTES) | (1L << HOURS))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class Alias_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Alias_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alias_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).enterAlias_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).exitAlias_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TQLVisitor ) return ((TQLVisitor<? extends T>)visitor).visitAlias_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Alias_nameContext alias_name() throws RecognitionException {
		Alias_nameContext _localctx = new Alias_nameContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_alias_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236); any_name();
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

	public static class Sensor_collection_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Sensor_collection_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sensor_collection_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).enterSensor_collection_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).exitSensor_collection_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TQLVisitor ) return ((TQLVisitor<? extends T>)visitor).visitSensor_collection_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sensor_collection_nameContext sensor_collection_name() throws RecognitionException {
		Sensor_collection_nameContext _localctx = new Sensor_collection_nameContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_sensor_collection_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238); any_name();
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

	public static class Observation_stream_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Observation_stream_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_observation_stream_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).enterObservation_stream_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).exitObservation_stream_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TQLVisitor ) return ((TQLVisitor<? extends T>)visitor).visitObservation_stream_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Observation_stream_nameContext observation_stream_name() throws RecognitionException {
		Observation_stream_nameContext _localctx = new Observation_stream_nameContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_observation_stream_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240); any_name();
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

	public static class Table_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Table_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).enterTable_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).exitTable_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TQLVisitor ) return ((TQLVisitor<? extends T>)visitor).visitTable_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Table_nameContext table_name() throws RecognitionException {
		Table_nameContext _localctx = new Table_nameContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_table_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242); any_name();
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

	public static class Field_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Field_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).enterField_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).exitField_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TQLVisitor ) return ((TQLVisitor<? extends T>)visitor).visitField_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Field_nameContext field_name() throws RecognitionException {
		Field_nameContext _localctx = new Field_nameContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_field_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244); any_name();
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

	public static class Column_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Column_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).enterColumn_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).exitColumn_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TQLVisitor ) return ((TQLVisitor<? extends T>)visitor).visitColumn_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Column_nameContext column_name() throws RecognitionException {
		Column_nameContext _localctx = new Column_nameContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_column_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246); any_name();
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

	public static class Function_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Function_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).enterFunction_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).exitFunction_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TQLVisitor ) return ((TQLVisitor<? extends T>)visitor).visitFunction_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_nameContext function_name() throws RecognitionException {
		Function_nameContext _localctx = new Function_nameContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_function_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248); any_name();
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

	public static class Any_nameContext extends ParserRuleContext {
		public TerminalNode STRING_LITERAL() { return getToken(TQLParser.STRING_LITERAL, 0); }
		public TerminalNode IDENTIFIER() { return getToken(TQLParser.IDENTIFIER, 0); }
		public Any_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_any_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).enterAny_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).exitAny_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TQLVisitor ) return ((TQLVisitor<? extends T>)visitor).visitAny_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Any_nameContext any_name() throws RecognitionException {
		Any_nameContext _localctx = new Any_nameContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_any_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			_la = _input.LA(1);
			if ( !(_la==IDENTIFIER || _la==STRING_LITERAL) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class Result_columnContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Column_aliasContext column_alias() {
			return getRuleContext(Column_aliasContext.class,0);
		}
		public TerminalNode AS() { return getToken(TQLParser.AS, 0); }
		public Result_columnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_result_column; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).enterResult_column(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).exitResult_column(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TQLVisitor ) return ((TQLVisitor<? extends T>)visitor).visitResult_column(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Result_columnContext result_column() throws RecognitionException {
		Result_columnContext _localctx = new Result_columnContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_result_column);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252); expr(0);
			setState(257);
			_la = _input.LA(1);
			if (_la==AS || _la==IDENTIFIER) {
				{
				setState(254);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(253); match(AS);
					}
				}

				setState(256); column_alias();
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

	public static class Column_aliasContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(TQLParser.IDENTIFIER, 0); }
		public Column_aliasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column_alias; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).enterColumn_alias(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).exitColumn_alias(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TQLVisitor ) return ((TQLVisitor<? extends T>)visitor).visitColumn_alias(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Column_aliasContext column_alias() throws RecognitionException {
		Column_aliasContext _localctx = new Column_aliasContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_column_alias);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259); match(IDENTIFIER);
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

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ParenthesesContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParenthesesContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).enterParentheses(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).exitParentheses(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TQLVisitor ) return ((TQLVisitor<? extends T>)visitor).visitParentheses(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NegativeContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NegativeContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).enterNegative(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).exitNegative(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TQLVisitor ) return ((TQLVisitor<? extends T>)visitor).visitNegative(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunctionContext extends ExprContext {
		public Parameter_listContext parameter_list() {
			return getRuleContext(Parameter_listContext.class,0);
		}
		public Function_nameContext function_name() {
			return getRuleContext(Function_nameContext.class,0);
		}
		public FunctionContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).exitFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TQLVisitor ) return ((TQLVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CountContext extends ExprContext {
		public TerminalNode COUNT() { return getToken(TQLParser.COUNT, 0); }
		public CountContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).enterCount(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).exitCount(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TQLVisitor ) return ((TQLVisitor<? extends T>)visitor).visitCount(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArithmeticContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ArithmeticContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).enterArithmetic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).exitArithmetic(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TQLVisitor ) return ((TQLVisitor<? extends T>)visitor).visitArithmetic(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FieldsContext extends ExprContext {
		public Field_accessContext field_access() {
			return getRuleContext(Field_accessContext.class,0);
		}
		public FieldsContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).enterFields(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).exitFields(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TQLVisitor ) return ((TQLVisitor<? extends T>)visitor).visitFields(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AggrContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Agg_funcContext agg_func() {
			return getRuleContext(Agg_funcContext.class,0);
		}
		public AggrContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).enterAggr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).exitAggr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TQLVisitor ) return ((TQLVisitor<? extends T>)visitor).visitAggr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Array_get_itemContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Array_get_itemContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).enterArray_get_item(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).exitArray_get_item(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TQLVisitor ) return ((TQLVisitor<? extends T>)visitor).visitArray_get_item(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LiteralContext extends ExprContext {
		public Literal_valueContext literal_value() {
			return getRuleContext(Literal_valueContext.class,0);
		}
		public LiteralContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TQLVisitor ) return ((TQLVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 60;
		enterRecursionRule(_localctx, 60, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(286);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				_localctx = new NegativeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(262); match(T__1);
				setState(263); expr(7);
				}
				break;
			case 2:
				{
				_localctx = new LiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(264); literal_value();
				}
				break;
			case 3:
				{
				_localctx = new FieldsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(265); field_access();
				}
				break;
			case 4:
				{
				_localctx = new CountContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(266); match(COUNT);
				setState(267); match(T__6);
				setState(268); match(T__4);
				setState(269); match(T__5);
				}
				break;
			case 5:
				{
				_localctx = new AggrContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(270); agg_func();
				setState(271); match(T__6);
				setState(272); expr(0);
				setState(273); match(T__5);
				}
				break;
			case 6:
				{
				_localctx = new FunctionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(275); function_name();
				setState(276); match(T__6);
				setState(278);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__1) | (1L << AVG) | (1L << MIN) | (1L << SUM) | (1L << MAX) | (1L << COUNT) | (1L << IDENTIFIER) | (1L << STRING_LITERAL) | (1L << INT_LITERAL) | (1L << REAL_LITERAL))) != 0)) {
					{
					setState(277); parameter_list();
					}
				}

				setState(280); match(T__5);
				}
				break;
			case 7:
				{
				_localctx = new ParenthesesContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(282); match(T__6);
				setState(283); expr(0);
				setState(284); match(T__5);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(301);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(299);
					switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
					case 1:
						{
						_localctx = new ArithmeticContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(288);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(289);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__18) | (1L << T__8) | (1L << T__4))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(290); expr(7);
						}
						break;
					case 2:
						{
						_localctx = new ArithmeticContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(291);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(292);
						_la = _input.LA(1);
						if ( !(_la==T__3 || _la==T__1) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(293); expr(6);
						}
						break;
					case 3:
						{
						_localctx = new Array_get_itemContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(294);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(295); match(T__15);
						setState(296); expr(0);
						setState(297); match(T__12);
						}
						break;
					}
					} 
				}
				setState(303);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
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

	public static class Field_accessContext extends ParserRuleContext {
		public Any_nameContext any_name(int i) {
			return getRuleContext(Any_nameContext.class,i);
		}
		public List<Any_nameContext> any_name() {
			return getRuleContexts(Any_nameContext.class);
		}
		public Field_accessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field_access; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).enterField_access(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).exitField_access(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TQLVisitor ) return ((TQLVisitor<? extends T>)visitor).visitField_access(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Field_accessContext field_access() throws RecognitionException {
		Field_accessContext _localctx = new Field_accessContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_field_access);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(304); any_name();
			setState(309);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(305); match(T__0);
					setState(306); any_name();
					}
					} 
				}
				setState(311);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
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

	public static class Term_exprContext extends ParserRuleContext {
		public Term_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term_expr; }
	 
		public Term_exprContext() { }
		public void copyFrom(Term_exprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ComparisonContext extends Term_exprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ComparisonContext(Term_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).enterComparison(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).exitComparison(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TQLVisitor ) return ((TQLVisitor<? extends T>)visitor).visitComparison(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BooleanContext extends Term_exprContext {
		public TerminalNode BOOLEAN_LITERAL() { return getToken(TQLParser.BOOLEAN_LITERAL, 0); }
		public BooleanContext(Term_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).enterBoolean(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).exitBoolean(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TQLVisitor ) return ((TQLVisitor<? extends T>)visitor).visitBoolean(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InContext extends Term_exprContext {
		public TerminalNode NOT() { return getToken(TQLParser.NOT, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode IN() { return getToken(TQLParser.IN, 0); }
		public InContext(Term_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).enterIn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).exitIn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TQLVisitor ) return ((TQLVisitor<? extends T>)visitor).visitIn(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Not_nullContext extends Term_exprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode NOT_NULL() { return getToken(TQLParser.NOT_NULL, 0); }
		public Not_nullContext(Term_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).enterNot_null(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).exitNot_null(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TQLVisitor ) return ((TQLVisitor<? extends T>)visitor).visitNot_null(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Is_nullContext extends Term_exprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode IS_NULL() { return getToken(TQLParser.IS_NULL, 0); }
		public Is_nullContext(Term_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).enterIs_null(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).exitIs_null(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TQLVisitor ) return ((TQLVisitor<? extends T>)visitor).visitIs_null(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Term_exprContext term_expr() throws RecognitionException {
		Term_exprContext _localctx = new Term_exprContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_term_expr);
		int _la;
		try {
			setState(330);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				_localctx = new ComparisonContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(312); expr(0);
				setState(313);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__17) | (1L << T__16) | (1L << T__13) | (1L << T__11) | (1L << T__10) | (1L << T__9))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(314); expr(0);
				}
				break;
			case 2:
				_localctx = new InContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(316); expr(0);
				setState(318);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(317); match(NOT);
					}
				}

				setState(320); match(IN);
				setState(321); expr(0);
				}
				break;
			case 3:
				_localctx = new Not_nullContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(323); expr(0);
				setState(324); match(NOT_NULL);
				}
				break;
			case 4:
				_localctx = new Is_nullContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(326); expr(0);
				setState(327); match(IS_NULL);
				}
				break;
			case 5:
				_localctx = new BooleanContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(329); match(BOOLEAN_LITERAL);
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

	public static class Logic_exprContext extends ParserRuleContext {
		public Logic_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logic_expr; }
	 
		public Logic_exprContext() { }
		public void copyFrom(Logic_exprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NotContext extends Logic_exprContext {
		public TerminalNode NOT() { return getToken(TQLParser.NOT, 0); }
		public Logic_exprContext logic_expr() {
			return getRuleContext(Logic_exprContext.class,0);
		}
		public NotContext(Logic_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).enterNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).exitNot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TQLVisitor ) return ((TQLVisitor<? extends T>)visitor).visitNot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Logic_parenthesesContext extends Logic_exprContext {
		public Logic_exprContext logic_expr() {
			return getRuleContext(Logic_exprContext.class,0);
		}
		public Logic_parenthesesContext(Logic_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).enterLogic_parentheses(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).exitLogic_parentheses(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TQLVisitor ) return ((TQLVisitor<? extends T>)visitor).visitLogic_parentheses(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrContext extends Logic_exprContext {
		public List<Logic_exprContext> logic_expr() {
			return getRuleContexts(Logic_exprContext.class);
		}
		public TerminalNode OR() { return getToken(TQLParser.OR, 0); }
		public Logic_exprContext logic_expr(int i) {
			return getRuleContext(Logic_exprContext.class,i);
		}
		public OrContext(Logic_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).enterOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).exitOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TQLVisitor ) return ((TQLVisitor<? extends T>)visitor).visitOr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndContext extends Logic_exprContext {
		public List<Logic_exprContext> logic_expr() {
			return getRuleContexts(Logic_exprContext.class);
		}
		public TerminalNode AND() { return getToken(TQLParser.AND, 0); }
		public Logic_exprContext logic_expr(int i) {
			return getRuleContext(Logic_exprContext.class,i);
		}
		public AndContext(Logic_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).enterAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).exitAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TQLVisitor ) return ((TQLVisitor<? extends T>)visitor).visitAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TermContext extends Logic_exprContext {
		public Term_exprContext term_expr() {
			return getRuleContext(Term_exprContext.class,0);
		}
		public TermContext(Logic_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TQLVisitor ) return ((TQLVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Logic_exprContext logic_expr() throws RecognitionException {
		return logic_expr(0);
	}

	private Logic_exprContext logic_expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Logic_exprContext _localctx = new Logic_exprContext(_ctx, _parentState);
		Logic_exprContext _prevctx = _localctx;
		int _startState = 66;
		enterRecursionRule(_localctx, 66, RULE_logic_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(340);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(333); match(NOT);
				setState(334); logic_expr(4);
				}
				break;
			case 2:
				{
				_localctx = new TermContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(335); term_expr();
				}
				break;
			case 3:
				{
				_localctx = new Logic_parenthesesContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(336); match(T__6);
				setState(337); logic_expr(0);
				setState(338); match(T__5);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(350);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(348);
					switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
					case 1:
						{
						_localctx = new AndContext(new Logic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_logic_expr);
						setState(342);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(343); match(AND);
						setState(344); logic_expr(4);
						}
						break;
					case 2:
						{
						_localctx = new OrContext(new Logic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_logic_expr);
						setState(345);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(346); match(OR);
						setState(347); logic_expr(3);
						}
						break;
					}
					} 
				}
				setState(352);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
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

	public static class Literal_valueContext extends ParserRuleContext {
		public TerminalNode STRING_LITERAL() { return getToken(TQLParser.STRING_LITERAL, 0); }
		public TerminalNode INT_LITERAL() { return getToken(TQLParser.INT_LITERAL, 0); }
		public TerminalNode REAL_LITERAL() { return getToken(TQLParser.REAL_LITERAL, 0); }
		public Literal_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).enterLiteral_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).exitLiteral_value(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TQLVisitor ) return ((TQLVisitor<? extends T>)visitor).visitLiteral_value(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Literal_valueContext literal_value() throws RecognitionException {
		Literal_valueContext _localctx = new Literal_valueContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_literal_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(353);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STRING_LITERAL) | (1L << INT_LITERAL) | (1L << REAL_LITERAL))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class Agg_funcContext extends ParserRuleContext {
		public TerminalNode MIN() { return getToken(TQLParser.MIN, 0); }
		public TerminalNode MAX() { return getToken(TQLParser.MAX, 0); }
		public TerminalNode AVG() { return getToken(TQLParser.AVG, 0); }
		public TerminalNode SUM() { return getToken(TQLParser.SUM, 0); }
		public Agg_funcContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_agg_func; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).enterAgg_func(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).exitAgg_func(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TQLVisitor ) return ((TQLVisitor<? extends T>)visitor).visitAgg_func(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Agg_funcContext agg_func() throws RecognitionException {
		Agg_funcContext _localctx = new Agg_funcContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_agg_func);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(355);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AVG) | (1L << MIN) | (1L << SUM) | (1L << MAX))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class Parameter_listContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Parameter_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).enterParameter_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).exitParameter_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TQLVisitor ) return ((TQLVisitor<? extends T>)visitor).visitParameter_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parameter_listContext parameter_list() throws RecognitionException {
		Parameter_listContext _localctx = new Parameter_listContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_parameter_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(357); expr(0);
			setState(362);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(358); match(T__2);
				setState(359); expr(0);
				}
				}
				setState(364);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 30: return expr_sempred((ExprContext)_localctx, predIndex);
		case 33: return logic_expr_sempred((Logic_exprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 6);
		case 1: return precpred(_ctx, 5);
		case 2: return precpred(_ctx, 8);
		}
		return true;
	}
	private boolean logic_expr_sempred(Logic_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3: return precpred(_ctx, 3);
		case 4: return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3>\u0170\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\3\2\3\2\3\2\6\2P\n\2\r\2\16\2Q\3\2"+
		"\6\2U\n\2\r\2\16\2V\3\2\3\2\3\3\3\3\3\3\3\3\3\3\7\3`\n\3\f\3\16\3c\13"+
		"\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\7\4l\n\4\f\4\16\4o\13\4\3\4\3\4\3\5\3\5"+
		"\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\5\7\u0083\n\7"+
		"\3\b\3\b\3\b\5\b\u0088\n\b\3\b\5\b\u008b\n\b\3\b\5\b\u008e\n\b\3\b\5\b"+
		"\u0091\n\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\7\n\u009c\n\n\f\n\16\n"+
		"\u009f\13\n\5\n\u00a1\n\n\3\13\3\13\3\13\3\13\7\13\u00a7\n\13\f\13\16"+
		"\13\u00aa\13\13\3\f\3\f\5\f\u00ae\n\f\3\r\3\r\3\r\3\r\7\r\u00b4\n\r\f"+
		"\r\16\r\u00b7\13\r\3\16\3\16\5\16\u00bb\n\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\7\20\u00ca\n\20\f\20\16\20\u00cd"+
		"\13\20\3\20\5\20\u00d0\n\20\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\7"+
		"\22\u00da\n\22\f\22\16\22\u00dd\13\22\3\22\5\22\u00e0\n\22\3\23\3\23\3"+
		"\23\3\23\5\23\u00e6\n\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\26\3\26"+
		"\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35"+
		"\3\36\3\36\5\36\u0101\n\36\3\36\5\36\u0104\n\36\3\37\3\37\3 \3 \3 \3 "+
		"\3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \5 \u0119\n \3 \3 \3 \3 \3 \3 "+
		"\5 \u0121\n \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \7 \u012e\n \f \16 \u0131"+
		"\13 \3!\3!\3!\7!\u0136\n!\f!\16!\u0139\13!\3\"\3\"\3\"\3\"\3\"\3\"\5\""+
		"\u0141\n\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u014d\n\"\3#\3"+
		"#\3#\3#\3#\3#\3#\3#\5#\u0157\n#\3#\3#\3#\3#\3#\3#\7#\u015f\n#\f#\16#\u0162"+
		"\13#\3$\3$\3%\3%\3&\3&\3&\7&\u016b\n&\f&\16&\u016e\13&\3&\2\4>D\'\2\4"+
		"\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJ\2\n"+
		"\3\2+,\3\2/\61\3\2\678\5\2\3\3\r\r\21\21\4\2\22\22\24\24\5\2\4\5\b\b\n"+
		"\f\4\288:;\3\2\62\65\u0175\2L\3\2\2\2\4Z\3\2\2\2\6f\3\2\2\2\br\3\2\2\2"+
		"\nw\3\2\2\2\f\177\3\2\2\2\16\u0084\3\2\2\2\20\u0094\3\2\2\2\22\u00a0\3"+
		"\2\2\2\24\u00a2\3\2\2\2\26\u00ab\3\2\2\2\30\u00af\3\2\2\2\32\u00b8\3\2"+
		"\2\2\34\u00c1\3\2\2\2\36\u00c4\3\2\2\2 \u00d1\3\2\2\2\"\u00d4\3\2\2\2"+
		"$\u00e1\3\2\2\2&\u00e7\3\2\2\2(\u00ec\3\2\2\2*\u00ee\3\2\2\2,\u00f0\3"+
		"\2\2\2.\u00f2\3\2\2\2\60\u00f4\3\2\2\2\62\u00f6\3\2\2\2\64\u00f8\3\2\2"+
		"\2\66\u00fa\3\2\2\28\u00fc\3\2\2\2:\u00fe\3\2\2\2<\u0105\3\2\2\2>\u0120"+
		"\3\2\2\2@\u0132\3\2\2\2B\u014c\3\2\2\2D\u0156\3\2\2\2F\u0163\3\2\2\2H"+
		"\u0165\3\2\2\2J\u0167\3\2\2\2LM\5\4\3\2MO\5\6\4\2NP\5\b\5\2ON\3\2\2\2"+
		"PQ\3\2\2\2QO\3\2\2\2QR\3\2\2\2RT\3\2\2\2SU\5\n\6\2TS\3\2\2\2UV\3\2\2\2"+
		"VT\3\2\2\2VW\3\2\2\2WX\3\2\2\2XY\5\16\b\2Y\3\3\2\2\2Z[\7\26\2\2[\\\7\27"+
		"\2\2\\a\5,\27\2]^\7\23\2\2^`\5,\27\2_]\3\2\2\2`c\3\2\2\2a_\3\2\2\2ab\3"+
		"\2\2\2bd\3\2\2\2ca\3\2\2\2de\7\7\2\2e\5\3\2\2\2fg\7\26\2\2gh\7\30\2\2"+
		"hm\5.\30\2ij\7\23\2\2jl\5.\30\2ki\3\2\2\2lo\3\2\2\2mk\3\2\2\2mn\3\2\2"+
		"\2np\3\2\2\2om\3\2\2\2pq\7\7\2\2q\7\3\2\2\2rs\5,\27\2st\7\n\2\2tu\5\f"+
		"\7\2uv\7\7\2\2v\t\3\2\2\2wx\5.\30\2xy\7\n\2\2yz\7\31\2\2z{\7\17\2\2{|"+
		"\5,\27\2|}\7\20\2\2}~\7\7\2\2~\13\3\2\2\2\177\u0080\5\20\t\2\u0080\u0082"+
		"\5\24\13\2\u0081\u0083\5\34\17\2\u0082\u0081\3\2\2\2\u0082\u0083\3\2\2"+
		"\2\u0083\r\3\2\2\2\u0084\u0085\5\20\t\2\u0085\u0087\5\30\r\2\u0086\u0088"+
		"\5\34\17\2\u0087\u0086\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u008a\3\2\2\2"+
		"\u0089\u008b\5\36\20\2\u008a\u0089\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008d"+
		"\3\2\2\2\u008c\u008e\5\"\22\2\u008d\u008c\3\2\2\2\u008d\u008e\3\2\2\2"+
		"\u008e\u0090\3\2\2\2\u008f\u0091\5$\23\2\u0090\u008f\3\2\2\2\u0090\u0091"+
		"\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0093\7\7\2\2\u0093\17\3\2\2\2\u0094"+
		"\u0095\7\32\2\2\u0095\u0096\5\22\n\2\u0096\21\3\2\2\2\u0097\u00a1\7\21"+
		"\2\2\u0098\u009d\5:\36\2\u0099\u009a\7\23\2\2\u009a\u009c\5:\36\2\u009b"+
		"\u0099\3\2\2\2\u009c\u009f\3\2\2\2\u009d\u009b\3\2\2\2\u009d\u009e\3\2"+
		"\2\2\u009e\u00a1\3\2\2\2\u009f\u009d\3\2\2\2\u00a0\u0097\3\2\2\2\u00a0"+
		"\u0098\3\2\2\2\u00a1\23\3\2\2\2\u00a2\u00a3\7\33\2\2\u00a3\u00a8\5\26"+
		"\f\2\u00a4\u00a5\7\23\2\2\u00a5\u00a7\5\26\f\2\u00a6\u00a4\3\2\2\2\u00a7"+
		"\u00aa\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\25\3\2\2"+
		"\2\u00aa\u00a8\3\2\2\2\u00ab\u00ad\5\60\31\2\u00ac\u00ae\5*\26\2\u00ad"+
		"\u00ac\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\27\3\2\2\2\u00af\u00b0\7\33\2"+
		"\2\u00b0\u00b5\5\32\16\2\u00b1\u00b2\7\23\2\2\u00b2\u00b4\5\32\16\2\u00b3"+
		"\u00b1\3\2\2\2\u00b4\u00b7\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b6\3\2"+
		"\2\2\u00b6\31\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b8\u00ba\5.\30\2\u00b9\u00bb"+
		"\5*\26\2\u00ba\u00b9\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc"+
		"\u00bd\7-\2\2\u00bd\u00be\5&\24\2\u00be\u00bf\7.\2\2\u00bf\u00c0\5&\24"+
		"\2\u00c0\33\3\2\2\2\u00c1\u00c2\7\34\2\2\u00c2\u00c3\5D#\2\u00c3\35\3"+
		"\2\2\2\u00c4\u00c5\7\35\2\2\u00c5\u00c6\7\36\2\2\u00c6\u00cb\5@!\2\u00c7"+
		"\u00c8\7\23\2\2\u00c8\u00ca\5@!\2\u00c9\u00c7\3\2\2\2\u00ca\u00cd\3\2"+
		"\2\2\u00cb\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00cf\3\2\2\2\u00cd"+
		"\u00cb\3\2\2\2\u00ce\u00d0\5 \21\2\u00cf\u00ce\3\2\2\2\u00cf\u00d0\3\2"+
		"\2\2\u00d0\37\3\2\2\2\u00d1\u00d2\7\37\2\2\u00d2\u00d3\5D#\2\u00d3!\3"+
		"\2\2\2\u00d4\u00d5\7(\2\2\u00d5\u00d6\7\36\2\2\u00d6\u00db\5@!\2\u00d7"+
		"\u00d8\7\23\2\2\u00d8\u00da\5@!\2\u00d9\u00d7\3\2\2\2\u00da\u00dd\3\2"+
		"\2\2\u00db\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00df\3\2\2\2\u00dd"+
		"\u00db\3\2\2\2\u00de\u00e0\t\2\2\2\u00df\u00de\3\2\2\2\u00df\u00e0\3\2"+
		"\2\2\u00e0#\3\2\2\2\u00e1\u00e2\7)\2\2\u00e2\u00e5\7:\2\2\u00e3\u00e4"+
		"\7*\2\2\u00e4\u00e6\7:\2\2\u00e5\u00e3\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6"+
		"%\3\2\2\2\u00e7\u00e8\7\16\2\2\u00e8\u00e9\7:\2\2\u00e9\u00ea\5(\25\2"+
		"\u00ea\u00eb\7\16\2\2\u00eb\'\3\2\2\2\u00ec\u00ed\t\3\2\2\u00ed)\3\2\2"+
		"\2\u00ee\u00ef\58\35\2\u00ef+\3\2\2\2\u00f0\u00f1\58\35\2\u00f1-\3\2\2"+
		"\2\u00f2\u00f3\58\35\2\u00f3/\3\2\2\2\u00f4\u00f5\58\35\2\u00f5\61\3\2"+
		"\2\2\u00f6\u00f7\58\35\2\u00f7\63\3\2\2\2\u00f8\u00f9\58\35\2\u00f9\65"+
		"\3\2\2\2\u00fa\u00fb\58\35\2\u00fb\67\3\2\2\2\u00fc\u00fd\t\4\2\2\u00fd"+
		"9\3\2\2\2\u00fe\u0103\5> \2\u00ff\u0101\7!\2\2\u0100\u00ff\3\2\2\2\u0100"+
		"\u0101\3\2\2\2\u0101\u0102\3\2\2\2\u0102\u0104\5<\37\2\u0103\u0100\3\2"+
		"\2\2\u0103\u0104\3\2\2\2\u0104;\3\2\2\2\u0105\u0106\7\67\2\2\u0106=\3"+
		"\2\2\2\u0107\u0108\b \1\2\u0108\u0109\7\24\2\2\u0109\u0121\5> \t\u010a"+
		"\u0121\5F$\2\u010b\u0121\5@!\2\u010c\u010d\7\66\2\2\u010d\u010e\7\17\2"+
		"\2\u010e\u010f\7\21\2\2\u010f\u0121\7\20\2\2\u0110\u0111\5H%\2\u0111\u0112"+
		"\7\17\2\2\u0112\u0113\5> \2\u0113\u0114\7\20\2\2\u0114\u0121\3\2\2\2\u0115"+
		"\u0116\5\66\34\2\u0116\u0118\7\17\2\2\u0117\u0119\5J&\2\u0118\u0117\3"+
		"\2\2\2\u0118\u0119\3\2\2\2\u0119\u011a\3\2\2\2\u011a\u011b\7\20\2\2\u011b"+
		"\u0121\3\2\2\2\u011c\u011d\7\17\2\2\u011d\u011e\5> \2\u011e\u011f\7\20"+
		"\2\2\u011f\u0121\3\2\2\2\u0120\u0107\3\2\2\2\u0120\u010a\3\2\2\2\u0120"+
		"\u010b\3\2\2\2\u0120\u010c\3\2\2\2\u0120\u0110\3\2\2\2\u0120\u0115\3\2"+
		"\2\2\u0120\u011c\3\2\2\2\u0121\u012f\3\2\2\2\u0122\u0123\f\b\2\2\u0123"+
		"\u0124\t\5\2\2\u0124\u012e\5> \t\u0125\u0126\f\7\2\2\u0126\u0127\t\6\2"+
		"\2\u0127\u012e\5> \b\u0128\u0129\f\n\2\2\u0129\u012a\7\6\2\2\u012a\u012b"+
		"\5> \2\u012b\u012c\7\t\2\2\u012c\u012e\3\2\2\2\u012d\u0122\3\2\2\2\u012d"+
		"\u0125\3\2\2\2\u012d\u0128\3\2\2\2\u012e\u0131\3\2\2\2\u012f\u012d\3\2"+
		"\2\2\u012f\u0130\3\2\2\2\u0130?\3\2\2\2\u0131\u012f\3\2\2\2\u0132\u0137"+
		"\58\35\2\u0133\u0134\7\25\2\2\u0134\u0136\58\35\2\u0135\u0133\3\2\2\2"+
		"\u0136\u0139\3\2\2\2\u0137\u0135\3\2\2\2\u0137\u0138\3\2\2\2\u0138A\3"+
		"\2\2\2\u0139\u0137\3\2\2\2\u013a\u013b\5> \2\u013b\u013c\t\7\2\2\u013c"+
		"\u013d\5> \2\u013d\u014d\3\2\2\2\u013e\u0140\5> \2\u013f\u0141\7$\2\2"+
		"\u0140\u013f\3\2\2\2\u0140\u0141\3\2\2\2\u0141\u0142\3\2\2\2\u0142\u0143"+
		"\7\'\2\2\u0143\u0144\5> \2\u0144\u014d\3\2\2\2\u0145\u0146\5> \2\u0146"+
		"\u0147\7%\2\2\u0147\u014d\3\2\2\2\u0148\u0149\5> \2\u0149\u014a\7&\2\2"+
		"\u014a\u014d\3\2\2\2\u014b\u014d\79\2\2\u014c\u013a\3\2\2\2\u014c\u013e"+
		"\3\2\2\2\u014c\u0145\3\2\2\2\u014c\u0148\3\2\2\2\u014c\u014b\3\2\2\2\u014d"+
		"C\3\2\2\2\u014e\u014f\b#\1\2\u014f\u0150\7$\2\2\u0150\u0157\5D#\6\u0151"+
		"\u0157\5B\"\2\u0152\u0153\7\17\2\2\u0153\u0154\5D#\2\u0154\u0155\7\20"+
		"\2\2\u0155\u0157\3\2\2\2\u0156\u014e\3\2\2\2\u0156\u0151\3\2\2\2\u0156"+
		"\u0152\3\2\2\2\u0157\u0160\3\2\2\2\u0158\u0159\f\5\2\2\u0159\u015a\7\""+
		"\2\2\u015a\u015f\5D#\6\u015b\u015c\f\4\2\2\u015c\u015d\7#\2\2\u015d\u015f"+
		"\5D#\5\u015e\u0158\3\2\2\2\u015e\u015b\3\2\2\2\u015f\u0162\3\2\2\2\u0160"+
		"\u015e\3\2\2\2\u0160\u0161\3\2\2\2\u0161E\3\2\2\2\u0162\u0160\3\2\2\2"+
		"\u0163\u0164\t\b\2\2\u0164G\3\2\2\2\u0165\u0166\t\t\2\2\u0166I\3\2\2\2"+
		"\u0167\u016c\5> \2\u0168\u0169\7\23\2\2\u0169\u016b\5> \2\u016a\u0168"+
		"\3\2\2\2\u016b\u016e\3\2\2\2\u016c\u016a\3\2\2\2\u016c\u016d\3\2\2\2\u016d"+
		"K\3\2\2\2\u016e\u016c\3\2\2\2#QVam\u0082\u0087\u008a\u008d\u0090\u009d"+
		"\u00a0\u00a8\u00ad\u00b5\u00ba\u00cb\u00cf\u00db\u00df\u00e5\u0100\u0103"+
		"\u0118\u0120\u012d\u012f\u0137\u0140\u014c\u0156\u015e\u0160\u016c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}