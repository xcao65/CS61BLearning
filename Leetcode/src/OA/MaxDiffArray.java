package OA;

public class MaxDiffArray {
    public static int getMaxDiff(int[] input) {
        int maxDiff = -1;
        int min = input[0];
        for (int i = 1; i < input.length; i++) {
            if (input[i] > min) {
                maxDiff = Math.max(maxDiff, input[i] - min);
            }
            min = Math.min(min, input[i]);
        }
        return maxDiff;
    }
}
