package tech.thedumbdev.queryprocessor;


import tech.thedumbdev.ast.ASTQuery;

public interface QueryProcessor {
    public void process(ASTQuery query);
}
