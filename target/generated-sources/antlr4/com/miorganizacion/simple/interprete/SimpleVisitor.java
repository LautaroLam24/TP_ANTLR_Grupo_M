// Generated from com/miorganizacion/simple/interprete/Simple.g4 by ANTLR 4.13.1
package com.miorganizacion.simple.interprete;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SimpleParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SimpleVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SimpleParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(SimpleParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(SimpleParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#varDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecl(SimpleParser.VarDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(SimpleParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#printStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStmt(SimpleParser.PrintStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#ifStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(SimpleParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#whileStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmt(SimpleParser.WhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(SimpleParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tipoInt}
	 * labeled alternative in {@link SimpleParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipoInt(SimpleParser.TipoIntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tipoReal}
	 * labeled alternative in {@link SimpleParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipoReal(SimpleParser.TipoRealContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tipoString}
	 * labeled alternative in {@link SimpleParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipoString(SimpleParser.TipoStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tipoBool}
	 * labeled alternative in {@link SimpleParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipoBool(SimpleParser.TipoBoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addSubExpr}
	 * labeled alternative in {@link SimpleParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSubExpr(SimpleParser.AddSubExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link SimpleParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpr(SimpleParser.OrExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link SimpleParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpr(SimpleParser.ParenExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code realLit}
	 * labeled alternative in {@link SimpleParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRealLit(SimpleParser.RealLitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringLit}
	 * labeled alternative in {@link SimpleParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLit(SimpleParser.StringLitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code eqExpr}
	 * labeled alternative in {@link SimpleParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqExpr(SimpleParser.EqExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryExpr}
	 * labeled alternative in {@link SimpleParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpr(SimpleParser.UnaryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolLit}
	 * labeled alternative in {@link SimpleParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolLit(SimpleParser.BoolLitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intLit}
	 * labeled alternative in {@link SimpleParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntLit(SimpleParser.IntLitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code relExpr}
	 * labeled alternative in {@link SimpleParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelExpr(SimpleParser.RelExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mulDivExpr}
	 * labeled alternative in {@link SimpleParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDivExpr(SimpleParser.MulDivExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link SimpleParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdExpr(SimpleParser.IdExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link SimpleParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpr(SimpleParser.AndExprContext ctx);
}