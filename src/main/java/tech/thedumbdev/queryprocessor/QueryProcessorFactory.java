package tech.thedumbdev.queryprocessor;

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

    public QueryProcessor getQueryProcessor(String query) throws Exception {
        String[] parts = query.split(" ");
        if(!processors.containsKey(parts[0])) {
            throw new IllegalArgumentException("Unknown query: " + parts[0]);
        }

        return processors.get(parts[0]);
    }
}
