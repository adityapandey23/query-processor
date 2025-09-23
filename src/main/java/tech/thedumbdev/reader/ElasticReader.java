package tech.thedumbdev.reader;

import tech.thedumbdev.entity.Log;

import java.util.ArrayList;
import java.util.Collection;

public class ElasticReader implements Reader{
    public ElasticReader elasticReader;

    public ElasticReader(String url, String apiKey) {

    }

    @Override
    public Collection<Log> read(Object source) {
        return new ArrayList<>();
    }
}
