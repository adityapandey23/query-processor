package tech.thedumbdev.reader;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import tech.thedumbdev.entity.Log;

import java.util.ArrayList;
import java.util.Collection;

public class ElasticReader implements Reader{
    ElasticsearchClient client;

    public ElasticReader(String url, String apiKey) {
        this.client = ElasticsearchClient.of(b -> b.host(url).apiKey(apiKey));
    }

    @Override
    public Collection<Log> read(Object source) {
        return new ArrayList<>();
    }
}
