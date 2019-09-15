package OA;

import java.util.*;

public class MostFreqSubString {
    public static int getCount(String s, int K, int L, int m) {
        Map<String, Integer> map = new HashMap<>();


        for (int i = 0; i + K - 1 < s.length(); i++) {
            //i: start
            //t: end
            int t = i + K - 1;
            String sub = s.substring(i, t + 1);
            if (checkValid(m, sub)) {
                map.put(sub, map.getOrDefault(sub, 0) + 1);
            }
        }

        Queue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((
                Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) -> (b.getValue().compareTo(a.getValue())));
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.add(entry);
        }

        return pq.poll().getValue();
    }

    private static boolean checkValid(int m, String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
            if (set.size() > m) return false;
        }
        return true;
    }
}
