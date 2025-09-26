package tech.thedumbdev.queryprocessor;

import tech.thedumbdev.ast.ASTQuery;
import tech.thedumbdev.ast.FindIn;
import tech.thedumbdev.ast.SelectBetween;
import tech.thedumbdev.reader.Reader;

import java.util.HashMap;
import java.util.Map;

public class QueryProcessorFactory {
    private final Map<String, QueryProcessor> processors;

    public QueryProcessorFactory(Reader reader) {
        processors = new HashMap<>();
        processors.put("select", new SelectQueryProcessor(reader));
        processors.put("find", new FindQueryProcessor(reader));
    }

    public QueryProcessor getQueryProcessor(ASTQuery queryTree) throws Exception {
        if(queryTree instanceof SelectBetween) {
            System.out.println("SELECT hai");
            return processors.get("select");
        }
        else if(queryTree instanceof FindIn){
            System.out.println("FIND hai");
            return processors.get("find");
        }
        else {
            System.out.println("Kuch nahi hai");
            return null;
        }
    }
}
