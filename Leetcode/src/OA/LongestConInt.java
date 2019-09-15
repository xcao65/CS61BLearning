package OA;

import java.util.HashMap;
import java.util.Map;

public class LongestConInt {
    public static int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = (nums.length > 0) ? 1 : 0;
        for (int num : nums) {
            //duplicate
            if (map.containsKey(num)) {
                continue;
            }
            //
            int leftLen = (map.containsKey(num - 1)) ? map.get(num - 1) : 0;
            int rightLen = (map.containsKey(num + 1)) ? map.get(num + 1) : 0;
            int total = leftLen + rightLen + 1;
            map.put(num, total);
            //update the boundary value: ex. [3,4,5 , 6 , 7,8,9]   3 = 6 - 3
            //only boundary value matters
            map.put(num - leftLen, total);
            map.put(num + rightLen, total);
            maxLen = Math.max(maxLen, total);
        }
        return maxLen;
    }
}
