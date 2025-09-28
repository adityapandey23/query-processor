package tech.thedumbdev.util;

import tech.thedumbdev.pojo.Log;

import java.util.List;

public class Occurrence {
    public static int lowerBound(int n, long timestamp, List<Log> logs) {
        int low = 0, high = n - 1, mid;
        int result = n;

        while (low <= high) {
            mid = (low + high) / 2;
            if(logs.get(mid).getTimestamp() >= timestamp) {
                result = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return result;
    }

    public static int upperBound(int n, long timestamp, List<Log> logs) {
        int low = 0, high = n - 1, mid;
        int result = n;

        while(low <= high) {
            mid = (low + high) / 2;
            if(logs.get(mid).getTimestamp() > timestamp) {
                result = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return result;
    }
}
