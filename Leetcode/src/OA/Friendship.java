package OA;

import java.util.*;

public class Friendship {
    /*input（int numOfNodes, List<Integer> from, List<Integer> to, List<Integer> weights）*/
    public static int maxInterests(int friends_nodes, int[] friends_from, int[] friends_to, int[] friends_weight) {


        HashMap<Integer, HashSet<Integer>> friends_interests = new HashMap();
        HashMap<Integer, HashSet<Integer>> interests_friends = new HashMap();

        HashMap<Map.Entry<Integer, Integer>, Integer> pairsInterestCount = new HashMap();


        for (int i = 0; i < friends_from.length; i++) {
            HashSet<Integer> from_friends = friends_interests.get(friends_from[i]);
            if (from_friends == null)
                from_friends = new HashSet<Integer>();
            from_friends.add(friends_weight[i]);
            HashSet<Integer> to_friends = friends_interests.get(friends_to[i]);
            if (to_friends == null)
                to_friends = new HashSet<Integer>();
            to_friends.add(friends_weight[i]);

            friends_interests.put(friends_from[i], from_friends);
            friends_interests.put(friends_to[i], to_friends);

            HashSet<Integer> interests = interests_friends.get(friends_weight[i]);
            if (interests == null)
                interests = new HashSet<Integer>();
            interests.add(friends_from[i]);
            interests.add(friends_to[i]);
            interests_friends.put(friends_weight[i], interests);
        }

        for (int i = 1; i <= friends_nodes; i++) {
            for (int j = i + 1; j <= friends_nodes; j++) {
                if (i == j)
                    continue;
                if (friends_interests.containsKey(i)) {
                    int numInterestPair = 0;
                    for (Integer token : friends_interests.get(i)) {
                        if (interests_friends.containsKey(token)) {
                            if (interests_friends.get(token).contains(j))
                                numInterestPair++;
                        }
                    }
                    pairsInterestCount.put(new AbstractMap.SimpleEntry(i, j), numInterestPair);
                }
            }
        }

        int maxInterests = 0;
        int maxProduct = 0;

        for (Map.Entry<Map.Entry<Integer, Integer>, Integer> entry : pairsInterestCount.entrySet()) {
            if (entry.getValue() >= maxInterests) {
                maxInterests = entry.getValue();
                Map.Entry<Integer, Integer> pair = entry.getKey();
                int product = pair.getKey() * pair.getValue();
                if (product >= maxProduct) {
//                    System.out.println("maxProduct " + maxProduct + ". Pair (" + pair.getKey() + ", " + pair.getValue() + ") shares " +
//                            entry.getValue() + " interests. Product " + product);
                    maxProduct = product;
                }
            }
        }

//        System.out.println("return maxProduct: " + maxProduct);
        return maxProduct;
    }
}
