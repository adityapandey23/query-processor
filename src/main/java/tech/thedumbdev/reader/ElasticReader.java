package tech.thedumbdev.reader;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import tech.thedumbdev.pojo.Log;

import java.util.ArrayList;
import java.util.List;

public class ElasticReader implements Reader{
    ElasticsearchClient client;

    public ElasticReader(String url, String apiKey) {
        this.client = ElasticsearchClient.of(b -> b.host(url).apiKey(apiKey));
    }

    @Override
    public List<Log> read(String logFile) {
        return new ArrayList<>();
    }
}
