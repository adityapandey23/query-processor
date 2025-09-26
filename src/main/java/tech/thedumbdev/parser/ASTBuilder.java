package tech.thedumbdev.parser;

import org.antlr.v4.runtime.tree.TerminalNode;
import tech.thedumbdev.ast.ASTQuery;
import tech.thedumbdev.ast.FindIn;
import tech.thedumbdev.ast.SelectBetween;
import tech.thedumbdev.gen.QueryBaseVisitor;
import tech.thedumbdev.gen.QueryParser;

import java.util.ArrayList;
import java.util.List;

public class ASTBuilder extends QueryBaseVisitor<ASTQuery> {
    @Override
    public ASTQuery visitQuery(QueryParser.QueryContext ctx) {
        if (ctx.selectStatement() != null) {
            return visit(ctx.selectStatement());
        } else if (ctx.findStatement() != null) {
            return visit(ctx.findStatement());
        }
        return null;
    }

    @Override
    public ASTQuery visitSelectStatement(QueryParser.SelectStatementContext ctx) {
        List<String> selectedColumns = new ArrayList<>();
        for(TerminalNode selectedColumn : ctx.selectList().IDENTIFIER()) {
            selectedColumns.add(selectedColumn.getText());
        }
        String logfile = ctx.tableName().getText();
        // Very bad way, but it works so no need to touch it!
        String fromTs = ctx.timeStamp(0).getText();
        String toTs = ctx.timeStamp(1).getText();
        return new SelectBetween(selectedColumns, logfile, fromTs, toTs);
    }

    @Override
    public ASTQuery visitFindStatement(QueryParser.FindStatementContext ctx) {
        List<String> selectedColumns = new ArrayList<>();
        for(TerminalNode selectedColumn : ctx.selectList().IDENTIFIER()) {
            selectedColumns.add(selectedColumn.getText());
        }
        String logfile = ctx.tableName().getText();
        return new FindIn(selectedColumns, logfile);
    }
}
