package OA;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Vote {
    public String getVote(String[] votes) {
        if (votes == null || votes.length == 0) return "";

        //Pq
        Queue<Map.Entry<String, Integer>> queue = new PriorityQueue<>((Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) -> {
            int com = b.getValue().compareTo(a.getValue());
            if (com == 0) com = b.getKey().compareTo(a.getKey());
            return com;
        });
        //Map
        Map<String, Integer> map = new HashMap<>();

        for (String vote : votes) {
            if (map.containsKey(vote)) {
                map.put(vote, map.get(vote) + 1);
            } else {
                map.put(vote, 1);
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            queue.add(entry);
        }
        return queue.peek().getKey();
    }
}
