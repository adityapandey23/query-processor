// Generated from /home/aditya/Documents/Coding/projects/logging-notification-system/query-processor/src/main/java/tech/thedumbdev/antlr4/Query.g4 by ANTLR 4.13.2
package tech.thedumbdev.gen;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link QueryParser}.
 */
public interface QueryListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link QueryParser#query}.
	 * @param ctx the parse tree
	 */
	void enterQuery(QueryParser.QueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link QueryParser#query}.
	 * @param ctx the parse tree
	 */
	void exitQuery(QueryParser.QueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link QueryParser#selectStatement}.
	 * @param ctx the parse tree
	 */
	void enterSelectStatement(QueryParser.SelectStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link QueryParser#selectStatement}.
	 * @param ctx the parse tree
	 */
	void exitSelectStatement(QueryParser.SelectStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link QueryParser#findStatement}.
	 * @param ctx the parse tree
	 */
	void enterFindStatement(QueryParser.FindStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link QueryParser#findStatement}.
	 * @param ctx the parse tree
	 */
	void exitFindStatement(QueryParser.FindStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link QueryParser#selectList}.
	 * @param ctx the parse tree
	 */
	void enterSelectList(QueryParser.SelectListContext ctx);
	/**
	 * Exit a parse tree produced by {@link QueryParser#selectList}.
	 * @param ctx the parse tree
	 */
	void exitSelectList(QueryParser.SelectListContext ctx);
	/**
	 * Enter a parse tree produced by {@link QueryParser#tableName}.
	 * @param ctx the parse tree
	 */
	void enterTableName(QueryParser.TableNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link QueryParser#tableName}.
	 * @param ctx the parse tree
	 */
	void exitTableName(QueryParser.TableNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link QueryParser#timeStamp}.
	 * @param ctx the parse tree
	 */
	void enterTimeStamp(QueryParser.TimeStampContext ctx);
	/**
	 * Exit a parse tree produced by {@link QueryParser#timeStamp}.
	 * @param ctx the parse tree
	 */
	void exitTimeStamp(QueryParser.TimeStampContext ctx);
}