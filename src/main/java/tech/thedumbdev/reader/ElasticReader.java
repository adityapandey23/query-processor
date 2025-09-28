package tech.thedumbdev.reader;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
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
        String idx = logFile.split("\\.")[0];
        List<Log> logs = new ArrayList<>();
        try {
            SearchResponse<Log> response = this.client.search(s -> s
                            .index(idx)
                            .query(q -> q.matchAll(m -> m))
                            .size(1000),
                    Log.class
            );

            for(Hit<Log> hit : response.hits().hits()) {
                Log log = hit.source();
                logs.add(log);
            }

            return logs;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
