package rmn;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CommonFreeDuration {
    public static int[] getTimeFrame(List<List<int[]>> times, int d) {
        TreeMap<Integer, Integer> timeline = new TreeMap<>();
        int size = times.size();
        for (List<int[]> time : times) {
            for (int[] duration : time) {
                timeline.put(duration[0], timeline.getOrDefault(duration[0], 0) + 1);
                timeline.put(duration[1], timeline.getOrDefault(duration[1], 0) - 1);
            }
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : timeline.entrySet()) {
            count += entry.getValue();
            if (count == size) {
                int start = entry.getKey();
                int end = timeline.higherKey(start);
                if (end - start >= d) return new int[] {start, end};
            }
        }
        return new int[] {-1, -1};
    }
}
