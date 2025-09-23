package tech.thedumbdev.reader;

import tech.thedumbdev.entity.Log;

import java.util.Collection;

public interface Reader {
    public Collection<Log> read(Object source); // Object -> file path or DB url
}
