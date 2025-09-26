// Generated from /home/aditya/Documents/Coding/projects/logging-notification-system/query-processor/src/main/java/tech/thedumbdev/antlr4/Query.g4 by ANTLR 4.13.2
package tech.thedumbdev.gen;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link QueryParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface QueryVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link QueryParser#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuery(QueryParser.QueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link QueryParser#selectStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectStatement(QueryParser.SelectStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link QueryParser#findStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFindStatement(QueryParser.FindStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link QueryParser#selectList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectList(QueryParser.SelectListContext ctx);
	/**
	 * Visit a parse tree produced by {@link QueryParser#tableName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableName(QueryParser.TableNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link QueryParser#timeStamp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimeStamp(QueryParser.TimeStampContext ctx);
}