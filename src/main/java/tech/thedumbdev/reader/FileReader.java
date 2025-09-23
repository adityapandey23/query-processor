package tech.thedumbdev.reader;

import tech.thedumbdev.entity.Log;

import java.util.ArrayList;
import java.util.Collection;

public class FileReader implements Reader{
    public String path;

    public FileReader(String path) {
        this.path = path;
    }

    @Override
    public Collection<Log> read(Object source) {
        return new ArrayList<>();
    }
}
