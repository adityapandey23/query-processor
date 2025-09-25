package tech.thedumbdev.reader;

import java.util.List;

public class ReaderFactory {
    Reader reader;

    public ReaderFactory(List<String> path) {
        // Later if we want to add something new we can shove the logic over here
        if (path.size() == 2) {
            this.reader = new ElasticReader(path.get(0), path.get(1));
        }
        else {
            this.reader = new FileReader(path.get(0));
        }
    }

    public Reader getReader() {
        return this.reader;
    }
}
