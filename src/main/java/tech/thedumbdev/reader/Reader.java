package tech.thedumbdev.reader;

import tech.thedumbdev.pojo.Log;

import java.util.List;

public interface Reader {
    // This is supposed to pull everything and the just upper layer would act as a filter
    public List<Log> read(String logFile);
}