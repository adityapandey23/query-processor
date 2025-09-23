package tech.thedumbdev.queryprocessor;

import tech.thedumbdev.reader.Reader;

public class FindQueryProcessor implements QueryProcessor {
    Reader reader;

    public FindQueryProcessor(Reader reader) {
        this.reader = reader;
    }

    @Override
    public void process(String query, Object source) {}
}
