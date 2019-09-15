package OA;

import java.util.TreeMap;

public class FindLeastGreater {
    public static int[] findLeastGreaterEle(int[] nums1, int[] nums2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num2: nums2) {
            map.put(num2, 0);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            Integer key = map.higherKey(nums1[i]);
            res[i] = (key == null) ? -1 : key;
        }
        return res;
    }
}
