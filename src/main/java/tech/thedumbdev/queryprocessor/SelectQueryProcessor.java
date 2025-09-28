package tech.thedumbdev.queryprocessor;

import tech.thedumbdev.ast.ASTQuery;
import tech.thedumbdev.ast.SelectBetween;
import tech.thedumbdev.pojo.Log;
import tech.thedumbdev.reader.Reader;
import tech.thedumbdev.util.Occurrence;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.*;

public class SelectQueryProcessor implements QueryProcessor {
    Reader reader;

    public SelectQueryProcessor(Reader reader) {
        this.reader = reader;
    }

    @Override
    public void process(ASTQuery query) {
        process((SelectBetween) query);
    }

    private void process(SelectBetween query) {
        long startTime = Long.parseLong(query.fromTs());
        long endTime = Long.parseLong(query.toTs());

        if(startTime > endTime) {
            throw new  IllegalArgumentException(String.format("Invalid start time %s, end time %s", Timestamp.from(Instant.ofEpochSecond(startTime)), Timestamp.from(Instant.ofEpochSecond(endTime))));
        }

        List<String> elements = query.search();
        Map<String, List<Log>> results = new HashMap<>();

        for(String element : elements) {
            results.put(element, new ArrayList<>());
        }

        String source = query.logfile();
        List<Log> rawData = reader.read(source);

        for(Log log : rawData) {
            for(String element : elements) {
                if(log.getData().contains(element)) {
                    results.get(element).add(log);
                }
            }
        }

        for(String resultsElement : results.keySet()) {
            results.get(resultsElement).sort(Comparator.comparing(Log::getTimestamp));
        }

        for(String resultsElement : results.keySet()) {
            int n =  results.get(resultsElement).size();
            int startIndex = Occurrence.lowerBound(n, startTime, results.get(resultsElement));
            int endIndex = Occurrence.upperBound(n, endTime, results.get(resultsElement));

            if(startIndex == n || endIndex == n) {
                throw new IllegalArgumentException("Can't find logs between this time frame");
            }


            System.out.println("-------------------------ELEMENT: " + resultsElement +  "-------------------------");

            for(int it = startIndex; it <= endIndex; it ++) {
                Log log = results.get(resultsElement).get(it);
                System.out.println(log.getThreadId());
                System.out.println(log.getThreadName());
                System.out.println(log.getData());
                System.out.println(Timestamp.from(Instant.ofEpochSecond(log.getTimestamp())));
                System.out.println(log.getStackTrace());
            }

        }
    }

}
