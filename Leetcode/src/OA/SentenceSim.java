package OA;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SentenceSim {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) return false;
        Map<String, Set<String>> map = new HashMap<>();
        //Construct graph as a map
        for (int i = 0; i < pairs.length; i++) {
            String node1 = pairs[i][0];
            String node2 = pairs[i][1];
            if (node1.equals(node2)) continue;
            Set<String> node1Set = (map.containsKey(node1)) ? map.get(node1) : new HashSet<>();
            Set<String> node2Set = (map.containsKey(node2)) ? map.get(node2) : new HashSet<>();
            node1Set.add(node2);
            node2Set.add(node1);
            map.put(node1, node1Set);
            map.put(node2, node2Set);
        }
        //compare one by one
        for (int i = 0; i < words1.length; i++) {
            if (words1[i].equals(words2[i])) continue;
            //this pair has to be connected in graph
            if (!map.containsKey(words1[i]) && !map.containsKey(words2[i])) return false;   //not in graph
            Set<String> visited = new HashSet<>();
            if (!dfsFind(words1[i], words2[i], map, visited)) return false;
        }
        return true;
    }
    private boolean dfsFind(String word1, String word2, Map<String, Set<String>> map, Set<String> visited) {
        visited.add(word1);
        Set<String> nextNodes = map.get(word1);
        if (nextNodes.contains(word2)) {
            return true;
        }
        for (String next : nextNodes) {
            if (!visited.contains(next)) {
                if (dfsFind(next, word2, map, visited)) return true;
            }
        }
        return false;
    }
}
