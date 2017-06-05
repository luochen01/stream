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
		COUNT=52, CAST=53, INT=54, REAL=55, BOOLEAN=56, STRING=57, LIKE=58, IDENTIFIER=59, 
		STRING_LITERAL=60, BOOLEAN_LITERAL=61, INT_LITERAL=62, REAL_LITERAL=63, 
		SINGLE_LINE_COMMENT=64, MULTILINE_COMMENT=65, SPACES=66;
	public static final String[] tokenNames = {
		"<INVALID>", "'/'", "'!='", "'>='", "'['", "';'", "'<'", "']'", "'='", 
		"'>'", "'<='", "'%'", "'''", "'('", "')'", "'*'", "'+'", "','", "'-'", 
		"'.'", "DEFINE", "SENSOR_COLLECTION", "OBSERVATION_STREAM", "SENSORS_TO_OBSERVATION_STREAM", 
		"SELECT", "FROM", "WHERE", "GROUP", "BY", "HAVING", "DISTINCT", "AS", 
		"AND", "OR", "NOT", "NOT_NULL", "IS_NULL", "IN", "ORDER", "LIMIT", "OFFSET", 
		"ASC", "DESC", "RANGE", "SLIDE", "SECONDS", "MINUTES", "HOURS", "AVG", 
		"MIN", "SUM", "MAX", "COUNT", "CAST", "INT", "REAL", "BOOLEAN", "STRING", 
		"LIKE", "IDENTIFIER", "STRING_LITERAL", "BOOLEAN_LITERAL", "INT_LITERAL", 
		"REAL_LITERAL", "SINGLE_LINE_COMMENT", "MULTILINE_COMMENT", "SPACES"
	};
	public static final int
		RULE_parse = 0, RULE_define_sensor_collections = 1, RULE_define_observation_streams = 2, 
		RULE_define_sensor_collection = 3, RULE_define_observation_stream = 4, 
		RULE_select_stmt = 5, RULE_select_stream_stmt = 6, RULE_select = 7, RULE_column_list = 8, 
		RULE_from = 9, RULE_table = 10, RULE_from_stream = 11, RULE_stream_table = 12, 
		RULE_stream_window = 13, RULE_where = 14, RULE_group_by = 15, RULE_having = 16, 
		RULE_order_by = 17, RULE_limit = 18, RULE_time_interval = 19, RULE_time_unit = 20, 
		RULE_alias_name = 21, RULE_sensor_collection_name = 22, RULE_observation_stream_name = 23, 
		RULE_table_name = 24, RULE_field_name = 25, RULE_column_name = 26, RULE_function_name = 27, 
		RULE_any_name = 28, RULE_result_column = 29, RULE_column_alias = 30, RULE_expr = 31, 
		RULE_type = 32, RULE_field_access = 33, RULE_term_expr = 34, RULE_logic_expr = 35, 
		RULE_literal_value = 36, RULE_agg_func = 37, RULE_parameter_list = 38;
	public static final String[] ruleNames = {
		"parse", "define_sensor_collections", "define_observation_streams", "define_sensor_collection", 
		"define_observation_stream", "select_stmt", "select_stream_stmt", "select", 
		"column_list", "from", "table", "from_stream", "stream_table", "stream_window", 
		"where", "group_by", "having", "order_by", "limit", "time_interval", "time_unit", 
		"alias_name", "sensor_collection_name", "observation_stream_name", "table_name", 
		"field_name", "column_name", "function_name", "any_name", "result_column", 
		"column_alias", "expr", "type", "field_access", "term_expr", "logic_expr", 
		"literal_value", "agg_func", "parameter_list"
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
			setState(78); define_sensor_collections();
			setState(79); define_observation_streams();
			setState(81); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(80); define_sensor_collection();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(83); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(86); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(85); define_observation_stream();
				}
				}
				setState(88); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==IDENTIFIER || _la==STRING_LITERAL );
			setState(90); select_stream_stmt();
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
			setState(92); match(DEFINE);
			setState(93); match(SENSOR_COLLECTION);
			setState(94); sensor_collection_name();
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(95); match(T__2);
				setState(96); sensor_collection_name();
				}
				}
				setState(101);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(102); match(T__14);
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
			setState(104); match(DEFINE);
			setState(105); match(OBSERVATION_STREAM);
			setState(106); observation_stream_name();
			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(107); match(T__2);
				setState(108); observation_stream_name();
				}
				}
				setState(113);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(114); match(T__14);
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
			setState(116); sensor_collection_name();
			setState(117); match(T__11);
			setState(118); select_stmt();
			setState(119); match(T__14);
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
			setState(121); observation_stream_name();
			setState(122); match(T__11);
			setState(123); match(SENSORS_TO_OBSERVATION_STREAM);
			setState(124); match(T__6);
			setState(125); sensor_collection_name();
			setState(126); match(T__5);
			setState(127); match(T__14);
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
			setState(129); select();
			setState(130); from();
			setState(132);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(131); where();
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
			setState(134); select();
			setState(135); from_stream();
			setState(137);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(136); where();
				}
			}

			setState(140);
			_la = _input.LA(1);
			if (_la==GROUP) {
				{
				setState(139); group_by();
				}
			}

			setState(143);
			_la = _input.LA(1);
			if (_la==ORDER) {
				{
				setState(142); order_by();
				}
			}

			setState(146);
			_la = _input.LA(1);
			if (_la==LIMIT) {
				{
				setState(145); limit();
				}
			}

			setState(148); match(T__14);
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
			setState(150); match(SELECT);
			setState(151); column_list();
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
			setState(162);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(153); match(T__4);
				}
				break;
			case T__6:
			case T__1:
			case AVG:
			case MIN:
			case SUM:
			case MAX:
			case COUNT:
			case CAST:
			case IDENTIFIER:
			case STRING_LITERAL:
			case INT_LITERAL:
			case REAL_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(154); result_column();
				setState(159);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(155); match(T__2);
					setState(156); result_column();
					}
					}
					setState(161);
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
			setState(164); match(FROM);
			setState(165); table();
			setState(170);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(166); match(T__2);
				setState(167); table();
				}
				}
				setState(172);
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
			setState(173); table_name();
			setState(175);
			_la = _input.LA(1);
			if (_la==IDENTIFIER || _la==STRING_LITERAL) {
				{
				setState(174); alias_name();
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
		public TerminalNode FROM() { return getToken(TQLParser.FROM, 0); }
		public Stream_tableContext stream_table(int i) {
			return getRuleContext(Stream_tableContext.class,i);
		}
		public List<Stream_tableContext> stream_table() {
			return getRuleContexts(Stream_tableContext.class);
		}
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
			setState(177); match(FROM);
			setState(178); stream_table();
			setState(183);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(179); match(T__2);
				setState(180); stream_table();
				}
				}
				setState(185);
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

	public static class Stream_tableContext extends ParserRuleContext {
		public TableContext table() {
			return getRuleContext(TableContext.class,0);
		}
		public Stream_windowContext stream_window() {
			return getRuleContext(Stream_windowContext.class,0);
		}
		public Stream_tableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stream_table; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).enterStream_table(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).exitStream_table(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TQLVisitor ) return ((TQLVisitor<? extends T>)visitor).visitStream_table(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Stream_tableContext stream_table() throws RecognitionException {
		Stream_tableContext _localctx = new Stream_tableContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_stream_table);
		try {
			setState(188);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(186); stream_window();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(187); table();
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
		enterRule(_localctx, 26, RULE_stream_window);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190); observation_stream_name();
			setState(192);
			_la = _input.LA(1);
			if (_la==IDENTIFIER || _la==STRING_LITERAL) {
				{
				setState(191); alias_name();
				}
			}

			setState(194); match(RANGE);
			setState(195); time_interval();
			setState(196); match(SLIDE);
			setState(197); time_interval();
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
		enterRule(_localctx, 28, RULE_where);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199); match(WHERE);
			setState(200); logic_expr(0);
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
		enterRule(_localctx, 30, RULE_group_by);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202); match(GROUP);
			setState(203); match(BY);
			setState(204); field_access();
			setState(209);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(205); match(T__2);
				setState(206); field_access();
				}
				}
				setState(211);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(213);
			_la = _input.LA(1);
			if (_la==HAVING) {
				{
				setState(212); having();
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
		enterRule(_localctx, 32, RULE_having);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215); match(HAVING);
			setState(216); logic_expr(0);
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
		enterRule(_localctx, 34, RULE_order_by);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218); match(ORDER);
			setState(219); match(BY);
			setState(220); field_access();
			setState(225);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(221); match(T__2);
				setState(222); field_access();
				}
				}
				setState(227);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(229);
			_la = _input.LA(1);
			if (_la==ASC || _la==DESC) {
				{
				setState(228);
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
		enterRule(_localctx, 36, RULE_limit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231); match(LIMIT);
			setState(232); match(INT_LITERAL);
			setState(235);
			_la = _input.LA(1);
			if (_la==OFFSET) {
				{
				setState(233); match(OFFSET);
				setState(234); match(INT_LITERAL);
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
		enterRule(_localctx, 38, RULE_time_interval);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237); match(T__7);
			setState(238); match(INT_LITERAL);
			setState(239); time_unit();
			setState(240); match(T__7);
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
		enterRule(_localctx, 40, RULE_time_unit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
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
		enterRule(_localctx, 42, RULE_alias_name);
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
		enterRule(_localctx, 44, RULE_sensor_collection_name);
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
		enterRule(_localctx, 46, RULE_observation_stream_name);
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
		enterRule(_localctx, 48, RULE_table_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250); any_name();
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
		enterRule(_localctx, 50, RULE_field_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252); any_name();
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
		enterRule(_localctx, 52, RULE_column_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254); any_name();
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
		enterRule(_localctx, 54, RULE_function_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256); any_name();
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
		enterRule(_localctx, 56, RULE_any_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
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
		enterRule(_localctx, 58, RULE_result_column);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260); expr(0);
			setState(265);
			_la = _input.LA(1);
			if (_la==AS || _la==IDENTIFIER) {
				{
				setState(262);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(261); match(AS);
					}
				}

				setState(264); column_alias();
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
		enterRule(_localctx, 60, RULE_column_alias);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267); match(IDENTIFIER);
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
	public static class CastContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode CAST() { return getToken(TQLParser.CAST, 0); }
		public TerminalNode AS() { return getToken(TQLParser.AS, 0); }
		public CastContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).enterCast(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).exitCast(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TQLVisitor ) return ((TQLVisitor<? extends T>)visitor).visitCast(this);
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
		int _startState = 62;
		enterRecursionRule(_localctx, 62, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(301);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				_localctx = new NegativeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(270); match(T__1);
				setState(271); expr(8);
				}
				break;
			case 2:
				{
				_localctx = new LiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(272); literal_value();
				}
				break;
			case 3:
				{
				_localctx = new FieldsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(273); field_access();
				}
				break;
			case 4:
				{
				_localctx = new CountContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(274); match(COUNT);
				setState(275); match(T__6);
				setState(276); match(T__4);
				setState(277); match(T__5);
				}
				break;
			case 5:
				{
				_localctx = new AggrContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(278); agg_func();
				setState(279); match(T__6);
				setState(280); expr(0);
				setState(281); match(T__5);
				}
				break;
			case 6:
				{
				_localctx = new FunctionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(283); function_name();
				setState(284); match(T__6);
				setState(286);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__1) | (1L << AVG) | (1L << MIN) | (1L << SUM) | (1L << MAX) | (1L << COUNT) | (1L << CAST) | (1L << IDENTIFIER) | (1L << STRING_LITERAL) | (1L << INT_LITERAL) | (1L << REAL_LITERAL))) != 0)) {
					{
					setState(285); parameter_list();
					}
				}

				setState(288); match(T__5);
				}
				break;
			case 7:
				{
				_localctx = new ParenthesesContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(290); match(T__6);
				setState(291); expr(0);
				setState(292); match(T__5);
				}
				break;
			case 8:
				{
				_localctx = new CastContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(294); match(CAST);
				setState(295); match(T__6);
				setState(296); expr(0);
				setState(297); match(AS);
				setState(298); type();
				setState(299); match(T__5);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(316);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(314);
					switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
					case 1:
						{
						_localctx = new ArithmeticContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(303);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(304);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__18) | (1L << T__8) | (1L << T__4))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(305); expr(8);
						}
						break;
					case 2:
						{
						_localctx = new ArithmeticContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(306);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(307);
						_la = _input.LA(1);
						if ( !(_la==T__3 || _la==T__1) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(308); expr(7);
						}
						break;
					case 3:
						{
						_localctx = new Array_get_itemContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(309);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(310); match(T__15);
						setState(311); expr(0);
						setState(312); match(T__12);
						}
						break;
					}
					} 
				}
				setState(318);
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
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode REAL() { return getToken(TQLParser.REAL, 0); }
		public TerminalNode STRING() { return getToken(TQLParser.STRING, 0); }
		public TerminalNode BOOLEAN() { return getToken(TQLParser.BOOLEAN, 0); }
		public TerminalNode INT() { return getToken(TQLParser.INT, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TQLVisitor ) return ((TQLVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(319);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << REAL) | (1L << BOOLEAN) | (1L << STRING))) != 0)) ) {
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
		enterRule(_localctx, 66, RULE_field_access);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(321); any_name();
			setState(326);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(322); match(T__0);
					setState(323); any_name();
					}
					} 
				}
				setState(328);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
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
	public static class LikeContext extends Term_exprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode STRING_LITERAL() { return getToken(TQLParser.STRING_LITERAL, 0); }
		public TerminalNode LIKE() { return getToken(TQLParser.LIKE, 0); }
		public LikeContext(Term_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).enterLike(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TQLListener ) ((TQLListener)listener).exitLike(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TQLVisitor ) return ((TQLVisitor<? extends T>)visitor).visitLike(this);
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
		enterRule(_localctx, 68, RULE_term_expr);
		int _la;
		try {
			setState(351);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				_localctx = new ComparisonContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(329); expr(0);
				setState(330);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__17) | (1L << T__16) | (1L << T__13) | (1L << T__11) | (1L << T__10) | (1L << T__9))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(331); expr(0);
				}
				break;
			case 2:
				_localctx = new LikeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(333); expr(0);
				setState(334); match(LIKE);
				setState(335); match(STRING_LITERAL);
				}
				break;
			case 3:
				_localctx = new InContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(337); expr(0);
				setState(339);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(338); match(NOT);
					}
				}

				setState(341); match(IN);
				setState(342); expr(0);
				}
				break;
			case 4:
				_localctx = new Not_nullContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(344); expr(0);
				setState(345); match(NOT_NULL);
				}
				break;
			case 5:
				_localctx = new Is_nullContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(347); expr(0);
				setState(348); match(IS_NULL);
				}
				break;
			case 6:
				_localctx = new BooleanContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(350); match(BOOLEAN_LITERAL);
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
		int _startState = 70;
		enterRecursionRule(_localctx, 70, RULE_logic_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(361);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(354); match(NOT);
				setState(355); logic_expr(4);
				}
				break;
			case 2:
				{
				_localctx = new TermContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(356); term_expr();
				}
				break;
			case 3:
				{
				_localctx = new Logic_parenthesesContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(357); match(T__6);
				setState(358); logic_expr(0);
				setState(359); match(T__5);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(371);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(369);
					switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
					case 1:
						{
						_localctx = new AndContext(new Logic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_logic_expr);
						setState(363);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(364); match(AND);
						setState(365); logic_expr(4);
						}
						break;
					case 2:
						{
						_localctx = new OrContext(new Logic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_logic_expr);
						setState(366);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(367); match(OR);
						setState(368); logic_expr(3);
						}
						break;
					}
					} 
				}
				setState(373);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
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
		enterRule(_localctx, 72, RULE_literal_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(374);
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
		enterRule(_localctx, 74, RULE_agg_func);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(376);
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
		enterRule(_localctx, 76, RULE_parameter_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(378); expr(0);
			setState(383);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(379); match(T__2);
				setState(380); expr(0);
				}
				}
				setState(385);
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
		case 31: return expr_sempred((ExprContext)_localctx, predIndex);
		case 35: return logic_expr_sempred((Logic_exprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 7);
		case 1: return precpred(_ctx, 6);
		case 2: return precpred(_ctx, 9);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3D\u0185\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\3\2\3\2\3\2\6\2T\n\2"+
		"\r\2\16\2U\3\2\6\2Y\n\2\r\2\16\2Z\3\2\3\2\3\3\3\3\3\3\3\3\3\3\7\3d\n\3"+
		"\f\3\16\3g\13\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\7\4p\n\4\f\4\16\4s\13\4\3"+
		"\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7"+
		"\5\7\u0087\n\7\3\b\3\b\3\b\5\b\u008c\n\b\3\b\5\b\u008f\n\b\3\b\5\b\u0092"+
		"\n\b\3\b\5\b\u0095\n\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\7\n\u00a0\n"+
		"\n\f\n\16\n\u00a3\13\n\5\n\u00a5\n\n\3\13\3\13\3\13\3\13\7\13\u00ab\n"+
		"\13\f\13\16\13\u00ae\13\13\3\f\3\f\5\f\u00b2\n\f\3\r\3\r\3\r\3\r\7\r\u00b8"+
		"\n\r\f\r\16\r\u00bb\13\r\3\16\3\16\5\16\u00bf\n\16\3\17\3\17\5\17\u00c3"+
		"\n\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21"+
		"\7\21\u00d2\n\21\f\21\16\21\u00d5\13\21\3\21\5\21\u00d8\n\21\3\22\3\22"+
		"\3\22\3\23\3\23\3\23\3\23\3\23\7\23\u00e2\n\23\f\23\16\23\u00e5\13\23"+
		"\3\23\5\23\u00e8\n\23\3\24\3\24\3\24\3\24\5\24\u00ee\n\24\3\25\3\25\3"+
		"\25\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3"+
		"\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\5\37\u0109\n\37\3\37\5\37"+
		"\u010c\n\37\3 \3 \3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\5"+
		"!\u0121\n!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\5!\u0130\n!\3!\3!\3"+
		"!\3!\3!\3!\3!\3!\3!\3!\3!\7!\u013d\n!\f!\16!\u0140\13!\3\"\3\"\3#\3#\3"+
		"#\7#\u0147\n#\f#\16#\u014a\13#\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\5$\u0156"+
		"\n$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\5$\u0162\n$\3%\3%\3%\3%\3%\3%\3%\3%"+
		"\5%\u016c\n%\3%\3%\3%\3%\3%\3%\7%\u0174\n%\f%\16%\u0177\13%\3&\3&\3\'"+
		"\3\'\3(\3(\3(\7(\u0180\n(\f(\16(\u0183\13(\3(\2\4@H)\2\4\6\b\n\f\16\20"+
		"\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLN\2\13\3\2+,\3\2"+
		"/\61\3\2=>\5\2\3\3\r\r\21\21\4\2\22\22\24\24\3\28;\5\2\4\5\b\b\n\f\4\2"+
		">>@A\3\2\62\65\u018b\2P\3\2\2\2\4^\3\2\2\2\6j\3\2\2\2\bv\3\2\2\2\n{\3"+
		"\2\2\2\f\u0083\3\2\2\2\16\u0088\3\2\2\2\20\u0098\3\2\2\2\22\u00a4\3\2"+
		"\2\2\24\u00a6\3\2\2\2\26\u00af\3\2\2\2\30\u00b3\3\2\2\2\32\u00be\3\2\2"+
		"\2\34\u00c0\3\2\2\2\36\u00c9\3\2\2\2 \u00cc\3\2\2\2\"\u00d9\3\2\2\2$\u00dc"+
		"\3\2\2\2&\u00e9\3\2\2\2(\u00ef\3\2\2\2*\u00f4\3\2\2\2,\u00f6\3\2\2\2."+
		"\u00f8\3\2\2\2\60\u00fa\3\2\2\2\62\u00fc\3\2\2\2\64\u00fe\3\2\2\2\66\u0100"+
		"\3\2\2\28\u0102\3\2\2\2:\u0104\3\2\2\2<\u0106\3\2\2\2>\u010d\3\2\2\2@"+
		"\u012f\3\2\2\2B\u0141\3\2\2\2D\u0143\3\2\2\2F\u0161\3\2\2\2H\u016b\3\2"+
		"\2\2J\u0178\3\2\2\2L\u017a\3\2\2\2N\u017c\3\2\2\2PQ\5\4\3\2QS\5\6\4\2"+
		"RT\5\b\5\2SR\3\2\2\2TU\3\2\2\2US\3\2\2\2UV\3\2\2\2VX\3\2\2\2WY\5\n\6\2"+
		"XW\3\2\2\2YZ\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[\\\3\2\2\2\\]\5\16\b\2]\3\3\2"+
		"\2\2^_\7\26\2\2_`\7\27\2\2`e\5.\30\2ab\7\23\2\2bd\5.\30\2ca\3\2\2\2dg"+
		"\3\2\2\2ec\3\2\2\2ef\3\2\2\2fh\3\2\2\2ge\3\2\2\2hi\7\7\2\2i\5\3\2\2\2"+
		"jk\7\26\2\2kl\7\30\2\2lq\5\60\31\2mn\7\23\2\2np\5\60\31\2om\3\2\2\2ps"+
		"\3\2\2\2qo\3\2\2\2qr\3\2\2\2rt\3\2\2\2sq\3\2\2\2tu\7\7\2\2u\7\3\2\2\2"+
		"vw\5.\30\2wx\7\n\2\2xy\5\f\7\2yz\7\7\2\2z\t\3\2\2\2{|\5\60\31\2|}\7\n"+
		"\2\2}~\7\31\2\2~\177\7\17\2\2\177\u0080\5.\30\2\u0080\u0081\7\20\2\2\u0081"+
		"\u0082\7\7\2\2\u0082\13\3\2\2\2\u0083\u0084\5\20\t\2\u0084\u0086\5\24"+
		"\13\2\u0085\u0087\5\36\20\2\u0086\u0085\3\2\2\2\u0086\u0087\3\2\2\2\u0087"+
		"\r\3\2\2\2\u0088\u0089\5\20\t\2\u0089\u008b\5\30\r\2\u008a\u008c\5\36"+
		"\20\2\u008b\u008a\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008e\3\2\2\2\u008d"+
		"\u008f\5 \21\2\u008e\u008d\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0091\3\2"+
		"\2\2\u0090\u0092\5$\23\2\u0091\u0090\3\2\2\2\u0091\u0092\3\2\2\2\u0092"+
		"\u0094\3\2\2\2\u0093\u0095\5&\24\2\u0094\u0093\3\2\2\2\u0094\u0095\3\2"+
		"\2\2\u0095\u0096\3\2\2\2\u0096\u0097\7\7\2\2\u0097\17\3\2\2\2\u0098\u0099"+
		"\7\32\2\2\u0099\u009a\5\22\n\2\u009a\21\3\2\2\2\u009b\u00a5\7\21\2\2\u009c"+
		"\u00a1\5<\37\2\u009d\u009e\7\23\2\2\u009e\u00a0\5<\37\2\u009f\u009d\3"+
		"\2\2\2\u00a0\u00a3\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2"+
		"\u00a5\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a4\u009b\3\2\2\2\u00a4\u009c\3\2"+
		"\2\2\u00a5\23\3\2\2\2\u00a6\u00a7\7\33\2\2\u00a7\u00ac\5\26\f\2\u00a8"+
		"\u00a9\7\23\2\2\u00a9\u00ab\5\26\f\2\u00aa\u00a8\3\2\2\2\u00ab\u00ae\3"+
		"\2\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\25\3\2\2\2\u00ae"+
		"\u00ac\3\2\2\2\u00af\u00b1\5\62\32\2\u00b0\u00b2\5,\27\2\u00b1\u00b0\3"+
		"\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\27\3\2\2\2\u00b3\u00b4\7\33\2\2\u00b4"+
		"\u00b9\5\32\16\2\u00b5\u00b6\7\23\2\2\u00b6\u00b8\5\32\16\2\u00b7\u00b5"+
		"\3\2\2\2\u00b8\u00bb\3\2\2\2\u00b9\u00b7\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba"+
		"\31\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bc\u00bf\5\34\17\2\u00bd\u00bf\5\26"+
		"\f\2\u00be\u00bc\3\2\2\2\u00be\u00bd\3\2\2\2\u00bf\33\3\2\2\2\u00c0\u00c2"+
		"\5\60\31\2\u00c1\u00c3\5,\27\2\u00c2\u00c1\3\2\2\2\u00c2\u00c3\3\2\2\2"+
		"\u00c3\u00c4\3\2\2\2\u00c4\u00c5\7-\2\2\u00c5\u00c6\5(\25\2\u00c6\u00c7"+
		"\7.\2\2\u00c7\u00c8\5(\25\2\u00c8\35\3\2\2\2\u00c9\u00ca\7\34\2\2\u00ca"+
		"\u00cb\5H%\2\u00cb\37\3\2\2\2\u00cc\u00cd\7\35\2\2\u00cd\u00ce\7\36\2"+
		"\2\u00ce\u00d3\5D#\2\u00cf\u00d0\7\23\2\2\u00d0\u00d2\5D#\2\u00d1\u00cf"+
		"\3\2\2\2\u00d2\u00d5\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4"+
		"\u00d7\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d6\u00d8\5\"\22\2\u00d7\u00d6\3"+
		"\2\2\2\u00d7\u00d8\3\2\2\2\u00d8!\3\2\2\2\u00d9\u00da\7\37\2\2\u00da\u00db"+
		"\5H%\2\u00db#\3\2\2\2\u00dc\u00dd\7(\2\2\u00dd\u00de\7\36\2\2\u00de\u00e3"+
		"\5D#\2\u00df\u00e0\7\23\2\2\u00e0\u00e2\5D#\2\u00e1\u00df\3\2\2\2\u00e2"+
		"\u00e5\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e7\3\2"+
		"\2\2\u00e5\u00e3\3\2\2\2\u00e6\u00e8\t\2\2\2\u00e7\u00e6\3\2\2\2\u00e7"+
		"\u00e8\3\2\2\2\u00e8%\3\2\2\2\u00e9\u00ea\7)\2\2\u00ea\u00ed\7@\2\2\u00eb"+
		"\u00ec\7*\2\2\u00ec\u00ee\7@\2\2\u00ed\u00eb\3\2\2\2\u00ed\u00ee\3\2\2"+
		"\2\u00ee\'\3\2\2\2\u00ef\u00f0\7\16\2\2\u00f0\u00f1\7@\2\2\u00f1\u00f2"+
		"\5*\26\2\u00f2\u00f3\7\16\2\2\u00f3)\3\2\2\2\u00f4\u00f5\t\3\2\2\u00f5"+
		"+\3\2\2\2\u00f6\u00f7\5:\36\2\u00f7-\3\2\2\2\u00f8\u00f9\5:\36\2\u00f9"+
		"/\3\2\2\2\u00fa\u00fb\5:\36\2\u00fb\61\3\2\2\2\u00fc\u00fd\5:\36\2\u00fd"+
		"\63\3\2\2\2\u00fe\u00ff\5:\36\2\u00ff\65\3\2\2\2\u0100\u0101\5:\36\2\u0101"+
		"\67\3\2\2\2\u0102\u0103\5:\36\2\u01039\3\2\2\2\u0104\u0105\t\4\2\2\u0105"+
		";\3\2\2\2\u0106\u010b\5@!\2\u0107\u0109\7!\2\2\u0108\u0107\3\2\2\2\u0108"+
		"\u0109\3\2\2\2\u0109\u010a\3\2\2\2\u010a\u010c\5> \2\u010b\u0108\3\2\2"+
		"\2\u010b\u010c\3\2\2\2\u010c=\3\2\2\2\u010d\u010e\7=\2\2\u010e?\3\2\2"+
		"\2\u010f\u0110\b!\1\2\u0110\u0111\7\24\2\2\u0111\u0130\5@!\n\u0112\u0130"+
		"\5J&\2\u0113\u0130\5D#\2\u0114\u0115\7\66\2\2\u0115\u0116\7\17\2\2\u0116"+
		"\u0117\7\21\2\2\u0117\u0130\7\20\2\2\u0118\u0119\5L\'\2\u0119\u011a\7"+
		"\17\2\2\u011a\u011b\5@!\2\u011b\u011c\7\20\2\2\u011c\u0130\3\2\2\2\u011d"+
		"\u011e\58\35\2\u011e\u0120\7\17\2\2\u011f\u0121\5N(\2\u0120\u011f\3\2"+
		"\2\2\u0120\u0121\3\2\2\2\u0121\u0122\3\2\2\2\u0122\u0123\7\20\2\2\u0123"+
		"\u0130\3\2\2\2\u0124\u0125\7\17\2\2\u0125\u0126\5@!\2\u0126\u0127\7\20"+
		"\2\2\u0127\u0130\3\2\2\2\u0128\u0129\7\67\2\2\u0129\u012a\7\17\2\2\u012a"+
		"\u012b\5@!\2\u012b\u012c\7!\2\2\u012c\u012d\5B\"\2\u012d\u012e\7\20\2"+
		"\2\u012e\u0130\3\2\2\2\u012f\u010f\3\2\2\2\u012f\u0112\3\2\2\2\u012f\u0113"+
		"\3\2\2\2\u012f\u0114\3\2\2\2\u012f\u0118\3\2\2\2\u012f\u011d\3\2\2\2\u012f"+
		"\u0124\3\2\2\2\u012f\u0128\3\2\2\2\u0130\u013e\3\2\2\2\u0131\u0132\f\t"+
		"\2\2\u0132\u0133\t\5\2\2\u0133\u013d\5@!\n\u0134\u0135\f\b\2\2\u0135\u0136"+
		"\t\6\2\2\u0136\u013d\5@!\t\u0137\u0138\f\13\2\2\u0138\u0139\7\6\2\2\u0139"+
		"\u013a\5@!\2\u013a\u013b\7\t\2\2\u013b\u013d\3\2\2\2\u013c\u0131\3\2\2"+
		"\2\u013c\u0134\3\2\2\2\u013c\u0137\3\2\2\2\u013d\u0140\3\2\2\2\u013e\u013c"+
		"\3\2\2\2\u013e\u013f\3\2\2\2\u013fA\3\2\2\2\u0140\u013e\3\2\2\2\u0141"+
		"\u0142\t\7\2\2\u0142C\3\2\2\2\u0143\u0148\5:\36\2\u0144\u0145\7\25\2\2"+
		"\u0145\u0147\5:\36\2\u0146\u0144\3\2\2\2\u0147\u014a\3\2\2\2\u0148\u0146"+
		"\3\2\2\2\u0148\u0149\3\2\2\2\u0149E\3\2\2\2\u014a\u0148\3\2\2\2\u014b"+
		"\u014c\5@!\2\u014c\u014d\t\b\2\2\u014d\u014e\5@!\2\u014e\u0162\3\2\2\2"+
		"\u014f\u0150\5@!\2\u0150\u0151\7<\2\2\u0151\u0152\7>\2\2\u0152\u0162\3"+
		"\2\2\2\u0153\u0155\5@!\2\u0154\u0156\7$\2\2\u0155\u0154\3\2\2\2\u0155"+
		"\u0156\3\2\2\2\u0156\u0157\3\2\2\2\u0157\u0158\7\'\2\2\u0158\u0159\5@"+
		"!\2\u0159\u0162\3\2\2\2\u015a\u015b\5@!\2\u015b\u015c\7%\2\2\u015c\u0162"+
		"\3\2\2\2\u015d\u015e\5@!\2\u015e\u015f\7&\2\2\u015f\u0162\3\2\2\2\u0160"+
		"\u0162\7?\2\2\u0161\u014b\3\2\2\2\u0161\u014f\3\2\2\2\u0161\u0153\3\2"+
		"\2\2\u0161\u015a\3\2\2\2\u0161\u015d\3\2\2\2\u0161\u0160\3\2\2\2\u0162"+
		"G\3\2\2\2\u0163\u0164\b%\1\2\u0164\u0165\7$\2\2\u0165\u016c\5H%\6\u0166"+
		"\u016c\5F$\2\u0167\u0168\7\17\2\2\u0168\u0169\5H%\2\u0169\u016a\7\20\2"+
		"\2\u016a\u016c\3\2\2\2\u016b\u0163\3\2\2\2\u016b\u0166\3\2\2\2\u016b\u0167"+
		"\3\2\2\2\u016c\u0175\3\2\2\2\u016d\u016e\f\5\2\2\u016e\u016f\7\"\2\2\u016f"+
		"\u0174\5H%\6\u0170\u0171\f\4\2\2\u0171\u0172\7#\2\2\u0172\u0174\5H%\5"+
		"\u0173\u016d\3\2\2\2\u0173\u0170\3\2\2\2\u0174\u0177\3\2\2\2\u0175\u0173"+
		"\3\2\2\2\u0175\u0176\3\2\2\2\u0176I\3\2\2\2\u0177\u0175\3\2\2\2\u0178"+
		"\u0179\t\t\2\2\u0179K\3\2\2\2\u017a\u017b\t\n\2\2\u017bM\3\2\2\2\u017c"+
		"\u0181\5@!\2\u017d\u017e\7\23\2\2\u017e\u0180\5@!\2\u017f\u017d\3\2\2"+
		"\2\u0180\u0183\3\2\2\2\u0181\u017f\3\2\2\2\u0181\u0182\3\2\2\2\u0182O"+
		"\3\2\2\2\u0183\u0181\3\2\2\2$UZeq\u0086\u008b\u008e\u0091\u0094\u00a1"+
		"\u00a4\u00ac\u00b1\u00b9\u00be\u00c2\u00d3\u00d7\u00e3\u00e7\u00ed\u0108"+
		"\u010b\u0120\u012f\u013c\u013e\u0148\u0155\u0161\u016b\u0173\u0175\u0181";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}