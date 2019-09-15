package OA;

public class MaxJumpArr {
    public static int getRes(int[] input) {
        if (input == null || input.length == 0) return 0;
        int n = input.length;
        if (n == 1) return Math.max(0, input[0]);
        //two pointer to store prev two dp value

        int dpA = input[0];
        int dpB = input[1] + Math.max(0, dpA);

        for (int i = 2; i < n; i++) {
            int tmp = dpB;
            dpB = Math.max(dpB, dpA) + input[i];
            dpA = tmp;
        }
        return Math.max(dpA, dpB);
    }
}
