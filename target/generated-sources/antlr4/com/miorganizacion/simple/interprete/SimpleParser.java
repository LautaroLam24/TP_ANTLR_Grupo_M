// Generated from com/miorganizacion/simple/interprete/Simple.g4 by ANTLR 4.13.1
package com.miorganizacion.simple.interprete;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class SimpleParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PROGRAM=1, VAR=2, PRINT=3, IF=4, ELSE=5, WHILE=6, T_INT=7, T_REAL=8, T_STRING=9, 
		T_BOOL=10, BOOL_LIT=11, PLUS=12, MINUS=13, MULT=14, DIV=15, AND=16, OR=17, 
		NOT=18, GEQ=19, LEQ=20, EQ=21, NEQ=22, GT=23, LT=24, ASSIGN=25, LBRACE=26, 
		RBRACE=27, LPAREN=28, RPAREN=29, SEMI=30, COLON=31, REAL_LIT=32, INT_LIT=33, 
		STRING_LIT=34, ID=35, LINE_COMMENT=36, BLOCK_COMMENT=37, WS=38;
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_varDecl = 2, RULE_assignment = 3, 
		RULE_printStmt = 4, RULE_ifStmt = 5, RULE_whileStmt = 6, RULE_block = 7, 
		RULE_type = 8, RULE_expression = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statement", "varDecl", "assignment", "printStmt", "ifStmt", 
			"whileStmt", "block", "type", "expression"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'program'", "'var'", "'print'", "'if'", "'else'", "'while'", "'int'", 
			"'real'", "'string'", "'bool'", null, "'+'", "'-'", "'*'", "'/'", "'&&'", 
			"'||'", "'!'", "'>='", "'<='", "'=='", "'!='", "'>'", "'<'", "'='", "'{'", 
			"'}'", "'('", "')'", "';'", "':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PROGRAM", "VAR", "PRINT", "IF", "ELSE", "WHILE", "T_INT", "T_REAL", 
			"T_STRING", "T_BOOL", "BOOL_LIT", "PLUS", "MINUS", "MULT", "DIV", "AND", 
			"OR", "NOT", "GEQ", "LEQ", "EQ", "NEQ", "GT", "LT", "ASSIGN", "LBRACE", 
			"RBRACE", "LPAREN", "RPAREN", "SEMI", "COLON", "REAL_LIT", "INT_LIT", 
			"STRING_LIT", "ID", "LINE_COMMENT", "BLOCK_COMMENT", "WS"
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
	public String getGrammarFileName() { return "Simple.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SimpleParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode PROGRAM() { return getToken(SimpleParser.PROGRAM, 0); }
		public TerminalNode ID() { return getToken(SimpleParser.ID, 0); }
		public TerminalNode LBRACE() { return getToken(SimpleParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(SimpleParser.RBRACE, 0); }
		public TerminalNode EOF() { return getToken(SimpleParser.EOF, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(20);
			match(PROGRAM);
			setState(21);
			match(ID);
			setState(22);
			match(LBRACE);
			setState(26);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34359738460L) != 0)) {
				{
				{
				setState(23);
				statement();
				}
				}
				setState(28);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(29);
			match(RBRACE);
			setState(30);
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
	public static class StatementContext extends ParserRuleContext {
		public VarDeclContext varDecl() {
			return getRuleContext(VarDeclContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public PrintStmtContext printStmt() {
			return getRuleContext(PrintStmtContext.class,0);
		}
		public IfStmtContext ifStmt() {
			return getRuleContext(IfStmtContext.class,0);
		}
		public WhileStmtContext whileStmt() {
			return getRuleContext(WhileStmtContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(37);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(32);
				varDecl();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(33);
				assignment();
				}
				break;
			case PRINT:
				enterOuterAlt(_localctx, 3);
				{
				setState(34);
				printStmt();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 4);
				{
				setState(35);
				ifStmt();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 5);
				{
				setState(36);
				whileStmt();
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

	@SuppressWarnings("CheckReturnValue")
	public static class VarDeclContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(SimpleParser.VAR, 0); }
		public TerminalNode ID() { return getToken(SimpleParser.ID, 0); }
		public TerminalNode COLON() { return getToken(SimpleParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(SimpleParser.SEMI, 0); }
		public TerminalNode ASSIGN() { return getToken(SimpleParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitVarDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclContext varDecl() throws RecognitionException {
		VarDeclContext _localctx = new VarDeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_varDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			match(VAR);
			setState(40);
			match(ID);
			setState(41);
			match(COLON);
			setState(42);
			type();
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(43);
				match(ASSIGN);
				setState(44);
				expression(0);
				}
			}

			setState(47);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SimpleParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(SimpleParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(SimpleParser.SEMI, 0); }
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			match(ID);
			setState(50);
			match(ASSIGN);
			setState(51);
			expression(0);
			setState(52);
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

	@SuppressWarnings("CheckReturnValue")
	public static class PrintStmtContext extends ParserRuleContext {
		public TerminalNode PRINT() { return getToken(SimpleParser.PRINT, 0); }
		public TerminalNode LPAREN() { return getToken(SimpleParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(SimpleParser.RPAREN, 0); }
		public TerminalNode SEMI() { return getToken(SimpleParser.SEMI, 0); }
		public PrintStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitPrintStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintStmtContext printStmt() throws RecognitionException {
		PrintStmtContext _localctx = new PrintStmtContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_printStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			match(PRINT);
			setState(55);
			match(LPAREN);
			setState(56);
			expression(0);
			setState(57);
			match(RPAREN);
			setState(58);
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

	@SuppressWarnings("CheckReturnValue")
	public static class IfStmtContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(SimpleParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(SimpleParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(SimpleParser.RPAREN, 0); }
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(SimpleParser.ELSE, 0); }
		public IfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitIfStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_ifStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			match(IF);
			setState(61);
			match(LPAREN);
			setState(62);
			expression(0);
			setState(63);
			match(RPAREN);
			setState(64);
			block();
			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(65);
				match(ELSE);
				setState(66);
				block();
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

	@SuppressWarnings("CheckReturnValue")
	public static class WhileStmtContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(SimpleParser.WHILE, 0); }
		public TerminalNode LPAREN() { return getToken(SimpleParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(SimpleParser.RPAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public WhileStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitWhileStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStmtContext whileStmt() throws RecognitionException {
		WhileStmtContext _localctx = new WhileStmtContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_whileStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			match(WHILE);
			setState(70);
			match(LPAREN);
			setState(71);
			expression(0);
			setState(72);
			match(RPAREN);
			setState(73);
			block();
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
	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(SimpleParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(SimpleParser.RBRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			match(LBRACE);
			setState(79);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34359738460L) != 0)) {
				{
				{
				setState(76);
				statement();
				}
				}
				setState(81);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(82);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	 
		public TypeContext() { }
		public void copyFrom(TypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TipoIntContext extends TypeContext {
		public TerminalNode T_INT() { return getToken(SimpleParser.T_INT, 0); }
		public TipoIntContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitTipoInt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TipoRealContext extends TypeContext {
		public TerminalNode T_REAL() { return getToken(SimpleParser.T_REAL, 0); }
		public TipoRealContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitTipoReal(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TipoStringContext extends TypeContext {
		public TerminalNode T_STRING() { return getToken(SimpleParser.T_STRING, 0); }
		public TipoStringContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitTipoString(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TipoBoolContext extends TypeContext {
		public TerminalNode T_BOOL() { return getToken(SimpleParser.T_BOOL, 0); }
		public TipoBoolContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitTipoBool(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_type);
		try {
			setState(88);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T_INT:
				_localctx = new TipoIntContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(84);
				match(T_INT);
				}
				break;
			case T_REAL:
				_localctx = new TipoRealContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(85);
				match(T_REAL);
				}
				break;
			case T_STRING:
				_localctx = new TipoStringContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(86);
				match(T_STRING);
				}
				break;
			case T_BOOL:
				_localctx = new TipoBoolContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(87);
				match(T_BOOL);
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

	@SuppressWarnings("CheckReturnValue")
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
	@SuppressWarnings("CheckReturnValue")
	public static class AddSubExprContext extends ExpressionContext {
		public ExpressionContext left;
		public Token op;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(SimpleParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(SimpleParser.MINUS, 0); }
		public AddSubExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitAddSubExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OrExprContext extends ExpressionContext {
		public ExpressionContext left;
		public ExpressionContext right;
		public TerminalNode OR() { return getToken(SimpleParser.OR, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public OrExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitOrExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenExprContext extends ExpressionContext {
		public TerminalNode LPAREN() { return getToken(SimpleParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(SimpleParser.RPAREN, 0); }
		public ParenExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitParenExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RealLitContext extends ExpressionContext {
		public TerminalNode REAL_LIT() { return getToken(SimpleParser.REAL_LIT, 0); }
		public RealLitContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitRealLit(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringLitContext extends ExpressionContext {
		public TerminalNode STRING_LIT() { return getToken(SimpleParser.STRING_LIT, 0); }
		public StringLitContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitStringLit(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EqExprContext extends ExpressionContext {
		public ExpressionContext left;
		public Token op;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode EQ() { return getToken(SimpleParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(SimpleParser.NEQ, 0); }
		public EqExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitEqExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UnaryExprContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(SimpleParser.MINUS, 0); }
		public TerminalNode NOT() { return getToken(SimpleParser.NOT, 0); }
		public UnaryExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitUnaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BoolLitContext extends ExpressionContext {
		public TerminalNode BOOL_LIT() { return getToken(SimpleParser.BOOL_LIT, 0); }
		public BoolLitContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitBoolLit(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntLitContext extends ExpressionContext {
		public TerminalNode INT_LIT() { return getToken(SimpleParser.INT_LIT, 0); }
		public IntLitContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitIntLit(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RelExprContext extends ExpressionContext {
		public ExpressionContext left;
		public Token op;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode GT() { return getToken(SimpleParser.GT, 0); }
		public TerminalNode LT() { return getToken(SimpleParser.LT, 0); }
		public TerminalNode GEQ() { return getToken(SimpleParser.GEQ, 0); }
		public TerminalNode LEQ() { return getToken(SimpleParser.LEQ, 0); }
		public RelExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitRelExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MulDivExprContext extends ExpressionContext {
		public ExpressionContext left;
		public Token op;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode MULT() { return getToken(SimpleParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(SimpleParser.DIV, 0); }
		public MulDivExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitMulDivExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdExprContext extends ExpressionContext {
		public TerminalNode ID() { return getToken(SimpleParser.ID, 0); }
		public IdExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitIdExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AndExprContext extends ExpressionContext {
		public ExpressionContext left;
		public ExpressionContext right;
		public TerminalNode AND() { return getToken(SimpleParser.AND, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AndExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitAndExpr(this);
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
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				{
				_localctx = new ParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(91);
				match(LPAREN);
				setState(92);
				expression(0);
				setState(93);
				match(RPAREN);
				}
				break;
			case MINUS:
			case NOT:
				{
				_localctx = new UnaryExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(95);
				((UnaryExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==MINUS || _la==NOT) ) {
					((UnaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(96);
				expression(12);
				}
				break;
			case INT_LIT:
				{
				_localctx = new IntLitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(97);
				match(INT_LIT);
				}
				break;
			case REAL_LIT:
				{
				_localctx = new RealLitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(98);
				match(REAL_LIT);
				}
				break;
			case STRING_LIT:
				{
				_localctx = new StringLitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(99);
				match(STRING_LIT);
				}
				break;
			case BOOL_LIT:
				{
				_localctx = new BoolLitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(100);
				match(BOOL_LIT);
				}
				break;
			case ID:
				{
				_localctx = new IdExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(101);
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(124);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(122);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivExprContext(new ExpressionContext(_parentctx, _parentState));
						((MulDivExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(104);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(105);
						((MulDivExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MULT || _la==DIV) ) {
							((MulDivExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(106);
						((MulDivExprContext)_localctx).right = expression(12);
						}
						break;
					case 2:
						{
						_localctx = new AddSubExprContext(new ExpressionContext(_parentctx, _parentState));
						((AddSubExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(107);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(108);
						((AddSubExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
							((AddSubExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(109);
						((AddSubExprContext)_localctx).right = expression(11);
						}
						break;
					case 3:
						{
						_localctx = new RelExprContext(new ExpressionContext(_parentctx, _parentState));
						((RelExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(110);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(111);
						((RelExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 26738688L) != 0)) ) {
							((RelExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(112);
						((RelExprContext)_localctx).right = expression(10);
						}
						break;
					case 4:
						{
						_localctx = new EqExprContext(new ExpressionContext(_parentctx, _parentState));
						((EqExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(113);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(114);
						((EqExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQ || _la==NEQ) ) {
							((EqExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(115);
						((EqExprContext)_localctx).right = expression(9);
						}
						break;
					case 5:
						{
						_localctx = new AndExprContext(new ExpressionContext(_parentctx, _parentState));
						((AndExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(116);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(117);
						match(AND);
						setState(118);
						((AndExprContext)_localctx).right = expression(8);
						}
						break;
					case 6:
						{
						_localctx = new OrExprContext(new ExpressionContext(_parentctx, _parentState));
						((OrExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(119);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(120);
						match(OR);
						setState(121);
						((OrExprContext)_localctx).right = expression(7);
						}
						break;
					}
					} 
				}
				setState(126);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 9:
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
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001&\u0080\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0005\u0000\u0019\b\u0000\n\u0000\f\u0000\u001c\t\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0003\u0001&\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0003\u0002.\b\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0003\u0005D\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0005\u0007N\b"+
		"\u0007\n\u0007\f\u0007Q\t\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0003\bY\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\tg\b"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0005\t{\b\t\n\t\f\t~\t\t\u0001\t\u0000\u0001\u0012\n\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0012\u0000\u0005\u0002\u0000\r\r\u0012\u0012"+
		"\u0001\u0000\u000e\u000f\u0001\u0000\f\r\u0002\u0000\u0013\u0014\u0017"+
		"\u0018\u0001\u0000\u0015\u0016\u008c\u0000\u0014\u0001\u0000\u0000\u0000"+
		"\u0002%\u0001\u0000\u0000\u0000\u0004\'\u0001\u0000\u0000\u0000\u0006"+
		"1\u0001\u0000\u0000\u0000\b6\u0001\u0000\u0000\u0000\n<\u0001\u0000\u0000"+
		"\u0000\fE\u0001\u0000\u0000\u0000\u000eK\u0001\u0000\u0000\u0000\u0010"+
		"X\u0001\u0000\u0000\u0000\u0012f\u0001\u0000\u0000\u0000\u0014\u0015\u0005"+
		"\u0001\u0000\u0000\u0015\u0016\u0005#\u0000\u0000\u0016\u001a\u0005\u001a"+
		"\u0000\u0000\u0017\u0019\u0003\u0002\u0001\u0000\u0018\u0017\u0001\u0000"+
		"\u0000\u0000\u0019\u001c\u0001\u0000\u0000\u0000\u001a\u0018\u0001\u0000"+
		"\u0000\u0000\u001a\u001b\u0001\u0000\u0000\u0000\u001b\u001d\u0001\u0000"+
		"\u0000\u0000\u001c\u001a\u0001\u0000\u0000\u0000\u001d\u001e\u0005\u001b"+
		"\u0000\u0000\u001e\u001f\u0005\u0000\u0000\u0001\u001f\u0001\u0001\u0000"+
		"\u0000\u0000 &\u0003\u0004\u0002\u0000!&\u0003\u0006\u0003\u0000\"&\u0003"+
		"\b\u0004\u0000#&\u0003\n\u0005\u0000$&\u0003\f\u0006\u0000% \u0001\u0000"+
		"\u0000\u0000%!\u0001\u0000\u0000\u0000%\"\u0001\u0000\u0000\u0000%#\u0001"+
		"\u0000\u0000\u0000%$\u0001\u0000\u0000\u0000&\u0003\u0001\u0000\u0000"+
		"\u0000\'(\u0005\u0002\u0000\u0000()\u0005#\u0000\u0000)*\u0005\u001f\u0000"+
		"\u0000*-\u0003\u0010\b\u0000+,\u0005\u0019\u0000\u0000,.\u0003\u0012\t"+
		"\u0000-+\u0001\u0000\u0000\u0000-.\u0001\u0000\u0000\u0000./\u0001\u0000"+
		"\u0000\u0000/0\u0005\u001e\u0000\u00000\u0005\u0001\u0000\u0000\u0000"+
		"12\u0005#\u0000\u000023\u0005\u0019\u0000\u000034\u0003\u0012\t\u0000"+
		"45\u0005\u001e\u0000\u00005\u0007\u0001\u0000\u0000\u000067\u0005\u0003"+
		"\u0000\u000078\u0005\u001c\u0000\u000089\u0003\u0012\t\u00009:\u0005\u001d"+
		"\u0000\u0000:;\u0005\u001e\u0000\u0000;\t\u0001\u0000\u0000\u0000<=\u0005"+
		"\u0004\u0000\u0000=>\u0005\u001c\u0000\u0000>?\u0003\u0012\t\u0000?@\u0005"+
		"\u001d\u0000\u0000@C\u0003\u000e\u0007\u0000AB\u0005\u0005\u0000\u0000"+
		"BD\u0003\u000e\u0007\u0000CA\u0001\u0000\u0000\u0000CD\u0001\u0000\u0000"+
		"\u0000D\u000b\u0001\u0000\u0000\u0000EF\u0005\u0006\u0000\u0000FG\u0005"+
		"\u001c\u0000\u0000GH\u0003\u0012\t\u0000HI\u0005\u001d\u0000\u0000IJ\u0003"+
		"\u000e\u0007\u0000J\r\u0001\u0000\u0000\u0000KO\u0005\u001a\u0000\u0000"+
		"LN\u0003\u0002\u0001\u0000ML\u0001\u0000\u0000\u0000NQ\u0001\u0000\u0000"+
		"\u0000OM\u0001\u0000\u0000\u0000OP\u0001\u0000\u0000\u0000PR\u0001\u0000"+
		"\u0000\u0000QO\u0001\u0000\u0000\u0000RS\u0005\u001b\u0000\u0000S\u000f"+
		"\u0001\u0000\u0000\u0000TY\u0005\u0007\u0000\u0000UY\u0005\b\u0000\u0000"+
		"VY\u0005\t\u0000\u0000WY\u0005\n\u0000\u0000XT\u0001\u0000\u0000\u0000"+
		"XU\u0001\u0000\u0000\u0000XV\u0001\u0000\u0000\u0000XW\u0001\u0000\u0000"+
		"\u0000Y\u0011\u0001\u0000\u0000\u0000Z[\u0006\t\uffff\uffff\u0000[\\\u0005"+
		"\u001c\u0000\u0000\\]\u0003\u0012\t\u0000]^\u0005\u001d\u0000\u0000^g"+
		"\u0001\u0000\u0000\u0000_`\u0007\u0000\u0000\u0000`g\u0003\u0012\t\fa"+
		"g\u0005!\u0000\u0000bg\u0005 \u0000\u0000cg\u0005\"\u0000\u0000dg\u0005"+
		"\u000b\u0000\u0000eg\u0005#\u0000\u0000fZ\u0001\u0000\u0000\u0000f_\u0001"+
		"\u0000\u0000\u0000fa\u0001\u0000\u0000\u0000fb\u0001\u0000\u0000\u0000"+
		"fc\u0001\u0000\u0000\u0000fd\u0001\u0000\u0000\u0000fe\u0001\u0000\u0000"+
		"\u0000g|\u0001\u0000\u0000\u0000hi\n\u000b\u0000\u0000ij\u0007\u0001\u0000"+
		"\u0000j{\u0003\u0012\t\fkl\n\n\u0000\u0000lm\u0007\u0002\u0000\u0000m"+
		"{\u0003\u0012\t\u000bno\n\t\u0000\u0000op\u0007\u0003\u0000\u0000p{\u0003"+
		"\u0012\t\nqr\n\b\u0000\u0000rs\u0007\u0004\u0000\u0000s{\u0003\u0012\t"+
		"\ttu\n\u0007\u0000\u0000uv\u0005\u0010\u0000\u0000v{\u0003\u0012\t\bw"+
		"x\n\u0006\u0000\u0000xy\u0005\u0011\u0000\u0000y{\u0003\u0012\t\u0007"+
		"zh\u0001\u0000\u0000\u0000zk\u0001\u0000\u0000\u0000zn\u0001\u0000\u0000"+
		"\u0000zq\u0001\u0000\u0000\u0000zt\u0001\u0000\u0000\u0000zw\u0001\u0000"+
		"\u0000\u0000{~\u0001\u0000\u0000\u0000|z\u0001\u0000\u0000\u0000|}\u0001"+
		"\u0000\u0000\u0000}\u0013\u0001\u0000\u0000\u0000~|\u0001\u0000\u0000"+
		"\u0000\t\u001a%-COXfz|";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}