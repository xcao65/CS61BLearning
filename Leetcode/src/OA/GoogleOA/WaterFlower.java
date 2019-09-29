package OA.GoogleOA;

/**
 * https://leetcode.com/discuss/interview-question/356449
 * It is not the optimal way to water flower
 * bc: water each plant if you have sufficient water for it, otherwise refill your watering can;
 */

public class WaterFlower {
    public int getNumOfSteps(int[] array, int capacity) {
        //input: 2 4 3 3 1, 4
        //res1:  len 5 +
        // 2 6 7 6 4
        //res2:  2 4 6
        // len of array + extra round trip
        // form prefix array:
        // 1. nextSum += next, cap >= nextSum, continue to next
        // 2. cap < nextSum, nextSum = next, rd += nextIdx * 2

        // corner case: ele of array > cap, -> 0
        for (int val : array) {
            if (val > capacity) return -1;
        }
        int res = array.length;
        int nextSum = 0;
        for (int i = -1; i < array.length - 1; i++) {
            nextSum += array[i + 1];
            if (nextSum > capacity) {
                nextSum = array[i + 1];
                res += (i + 1) * 2;
            }
        }
        return res;
    }

    public int getNumOfStepsV2(int[] array, int capacity) {
        //      2, 4, 3, 3, 1   == 4
        // cap: 2  0  1  1  0
        int cap = capacity;
        int steps = array.length;
        for (int i = 0; i < array.length; i++) {
            if (cap < array[i]) {
                steps += i * 2;
                cap = capacity;
            }
            cap -= array[i];
        }
        return steps;
    }
}
