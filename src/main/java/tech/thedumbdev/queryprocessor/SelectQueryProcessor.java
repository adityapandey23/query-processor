package tech.thedumbdev.queryprocessor;

import tech.thedumbdev.reader.Reader;

public class SelectQueryProcessor implements QueryProcessor {
    Reader reader;

    public SelectQueryProcessor(Reader reader) {
        this.reader = reader;
    }

    @Override
    public void process(String query, Object source) {}
}
