// Generated from /home/aditya/Documents/Coding/projects/logging-notification-system/query-processor/src/main/java/tech/thedumbdev/antlr4/Query.g4 by ANTLR 4.13.2
package tech.thedumbdev.gen;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class QueryParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, SELECT=4, FIND=5, FROM=6, IN=7, BETWEEN=8, AND=9, 
		TIMESTAMP=10, STRING=11, IDENTIFIER=12, WS=13;
	public static final int
		RULE_query = 0, RULE_selectStatement = 1, RULE_findStatement = 2, RULE_selectList = 3, 
		RULE_tableName = 4, RULE_timeStamp = 5;
	private static String[] makeRuleNames() {
		return new String[] {
			"query", "selectStatement", "findStatement", "selectList", "tableName", 
			"timeStamp"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "','", "'.log'", "'SELECT'", "'FIND'", "'FROM'", "'IN'", 
			"'BETWEEN'", "'AND'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "SELECT", "FIND", "FROM", "IN", "BETWEEN", "AND", 
			"TIMESTAMP", "STRING", "IDENTIFIER", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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
	public String getGrammarFileName() { return "Query.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public QueryParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class QueryContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(QueryParser.EOF, 0); }
		public SelectStatementContext selectStatement() {
			return getRuleContext(SelectStatementContext.class,0);
		}
		public FindStatementContext findStatement() {
			return getRuleContext(FindStatementContext.class,0);
		}
		public QueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QueryListener ) ((QueryListener)listener).enterQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QueryListener ) ((QueryListener)listener).exitQuery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QueryVisitor ) return ((QueryVisitor<? extends T>)visitor).visitQuery(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryContext query() throws RecognitionException {
		QueryContext _localctx = new QueryContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_query);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(14);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SELECT:
				{
				setState(12);
				selectStatement();
				}
				break;
			case FIND:
				{
				setState(13);
				findStatement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(16);
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

	@SuppressWarnings("CheckReturnValue")
	public static class SelectStatementContext extends ParserRuleContext {
		public TerminalNode SELECT() { return getToken(QueryParser.SELECT, 0); }
		public SelectListContext selectList() {
			return getRuleContext(SelectListContext.class,0);
		}
		public TerminalNode FROM() { return getToken(QueryParser.FROM, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public TerminalNode BETWEEN() { return getToken(QueryParser.BETWEEN, 0); }
		public List<TimeStampContext> timeStamp() {
			return getRuleContexts(TimeStampContext.class);
		}
		public TimeStampContext timeStamp(int i) {
			return getRuleContext(TimeStampContext.class,i);
		}
		public TerminalNode AND() { return getToken(QueryParser.AND, 0); }
		public SelectStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QueryListener ) ((QueryListener)listener).enterSelectStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QueryListener ) ((QueryListener)listener).exitSelectStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QueryVisitor ) return ((QueryVisitor<? extends T>)visitor).visitSelectStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectStatementContext selectStatement() throws RecognitionException {
		SelectStatementContext _localctx = new SelectStatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_selectStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(18);
			match(SELECT);
			setState(19);
			selectList();
			setState(20);
			match(FROM);
			setState(21);
			tableName();
			setState(22);
			match(BETWEEN);
			setState(23);
			timeStamp();
			setState(24);
			match(AND);
			setState(25);
			timeStamp();
			setState(26);
			match(T__0);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FindStatementContext extends ParserRuleContext {
		public TerminalNode FIND() { return getToken(QueryParser.FIND, 0); }
		public SelectListContext selectList() {
			return getRuleContext(SelectListContext.class,0);
		}
		public TerminalNode IN() { return getToken(QueryParser.IN, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public FindStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_findStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QueryListener ) ((QueryListener)listener).enterFindStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QueryListener ) ((QueryListener)listener).exitFindStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QueryVisitor ) return ((QueryVisitor<? extends T>)visitor).visitFindStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FindStatementContext findStatement() throws RecognitionException {
		FindStatementContext _localctx = new FindStatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_findStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			match(FIND);
			setState(29);
			selectList();
			setState(30);
			match(IN);
			setState(31);
			tableName();
			setState(32);
			match(T__0);
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

	@SuppressWarnings("CheckReturnValue")
	public static class SelectListContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(QueryParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(QueryParser.IDENTIFIER, i);
		}
		public SelectListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QueryListener ) ((QueryListener)listener).enterSelectList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QueryListener ) ((QueryListener)listener).exitSelectList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QueryVisitor ) return ((QueryVisitor<? extends T>)visitor).visitSelectList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectListContext selectList() throws RecognitionException {
		SelectListContext _localctx = new SelectListContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_selectList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			match(IDENTIFIER);
			setState(39);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(35);
				match(T__1);
				setState(36);
				match(IDENTIFIER);
				}
				}
				setState(41);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TableNameContext extends ParserRuleContext {
		public TerminalNode TIMESTAMP() { return getToken(QueryParser.TIMESTAMP, 0); }
		public TableNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QueryListener ) ((QueryListener)listener).enterTableName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QueryListener ) ((QueryListener)listener).exitTableName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QueryVisitor ) return ((QueryVisitor<? extends T>)visitor).visitTableName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableNameContext tableName() throws RecognitionException {
		TableNameContext _localctx = new TableNameContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_tableName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			match(TIMESTAMP);
			setState(43);
			match(T__2);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TimeStampContext extends ParserRuleContext {
		public TerminalNode TIMESTAMP() { return getToken(QueryParser.TIMESTAMP, 0); }
		public TimeStampContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_timeStamp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QueryListener ) ((QueryListener)listener).enterTimeStamp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QueryListener ) ((QueryListener)listener).exitTimeStamp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QueryVisitor ) return ((QueryVisitor<? extends T>)visitor).visitTimeStamp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TimeStampContext timeStamp() throws RecognitionException {
		TimeStampContext _localctx = new TimeStampContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_timeStamp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			match(TIMESTAMP);
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

	public static final String _serializedATN =
		"\u0004\u0001\r0\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0001\u0000\u0001\u0000\u0003\u0000\u000f\b\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0005\u0003&\b\u0003\n\u0003\f\u0003)\t"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0000\u0000\u0006\u0000\u0002\u0004\u0006\b\n\u0000\u0000+\u0000"+
		"\u000e\u0001\u0000\u0000\u0000\u0002\u0012\u0001\u0000\u0000\u0000\u0004"+
		"\u001c\u0001\u0000\u0000\u0000\u0006\"\u0001\u0000\u0000\u0000\b*\u0001"+
		"\u0000\u0000\u0000\n-\u0001\u0000\u0000\u0000\f\u000f\u0003\u0002\u0001"+
		"\u0000\r\u000f\u0003\u0004\u0002\u0000\u000e\f\u0001\u0000\u0000\u0000"+
		"\u000e\r\u0001\u0000\u0000\u0000\u000f\u0010\u0001\u0000\u0000\u0000\u0010"+
		"\u0011\u0005\u0000\u0000\u0001\u0011\u0001\u0001\u0000\u0000\u0000\u0012"+
		"\u0013\u0005\u0004\u0000\u0000\u0013\u0014\u0003\u0006\u0003\u0000\u0014"+
		"\u0015\u0005\u0006\u0000\u0000\u0015\u0016\u0003\b\u0004\u0000\u0016\u0017"+
		"\u0005\b\u0000\u0000\u0017\u0018\u0003\n\u0005\u0000\u0018\u0019\u0005"+
		"\t\u0000\u0000\u0019\u001a\u0003\n\u0005\u0000\u001a\u001b\u0005\u0001"+
		"\u0000\u0000\u001b\u0003\u0001\u0000\u0000\u0000\u001c\u001d\u0005\u0005"+
		"\u0000\u0000\u001d\u001e\u0003\u0006\u0003\u0000\u001e\u001f\u0005\u0007"+
		"\u0000\u0000\u001f \u0003\b\u0004\u0000 !\u0005\u0001\u0000\u0000!\u0005"+
		"\u0001\u0000\u0000\u0000\"\'\u0005\f\u0000\u0000#$\u0005\u0002\u0000\u0000"+
		"$&\u0005\f\u0000\u0000%#\u0001\u0000\u0000\u0000&)\u0001\u0000\u0000\u0000"+
		"\'%\u0001\u0000\u0000\u0000\'(\u0001\u0000\u0000\u0000(\u0007\u0001\u0000"+
		"\u0000\u0000)\'\u0001\u0000\u0000\u0000*+\u0005\n\u0000\u0000+,\u0005"+
		"\u0003\u0000\u0000,\t\u0001\u0000\u0000\u0000-.\u0005\n\u0000\u0000.\u000b"+
		"\u0001\u0000\u0000\u0000\u0002\u000e\'";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}