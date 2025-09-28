package tech.thedumbdev.queryprocessor;

import tech.thedumbdev.ast.ASTQuery;
import tech.thedumbdev.ast.FindIn;
import tech.thedumbdev.pojo.Log;
import tech.thedumbdev.reader.Reader;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.*;

public class FindQueryProcessor implements QueryProcessor {
    Reader reader;

    public FindQueryProcessor(Reader reader) {
        this.reader = reader;
    }

    @Override
    public void process(ASTQuery query) {
        process((FindIn) query);
    }

    private void process(FindIn query) { // Let's make this search in the occurrences of a word in the data thing

        // Maybe push this a little bit down
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

        // And do this here
        // Probably add some print property to the log class so that we can directly print stuff
        for(String element : results.keySet()) {
            System.out.println("-------------------------ELEMENT: " + element +  "-------------------------");
            results.get(element).sort(Comparator.comparingLong(Log::getTimestamp));
            if(results.get(element).isEmpty()) {
                System.out.println("-------------------------" + "Couldn't Find" +  "-------------------------");
            }
            for(Log log : results.get(element)) {
                System.out.println(log.getThreadId());
                System.out.println(log.getThreadName());
                System.out.println(log.getData());
                System.out.println(Timestamp.from(Instant.ofEpochSecond(log.getTimestamp())));
                System.out.println(log.getStackTrace());
            }
        }
    }
}
