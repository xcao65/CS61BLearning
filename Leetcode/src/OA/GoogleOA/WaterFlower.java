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
        // currentWater: water left in hand, start from capacity
        // totalSteps: steps counted, start from 0
        // if valid array, iterate through array, count steps for each iteration
        //  - enough water: step++, currentWater -= array[i]
        //  - not enough: step += 2 * i + 1, currentWater = capacity - array[i]
        int currentWater = capacity;
        int totalSteps = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > capacity) {
                return -1;
            }

            if (currentWater >= array[i]) {
                totalSteps++;
            } else {
                totalSteps += 2 * i + 1;
                currentWater = capacity;
            }
            currentWater -= array[i];
        }

        return totalSteps;
    }

    public int getNumOfStepsImpl(int[] array, int capacity) {
        // to be implemented
        return -1;
    }

    public int getNumOfRefillsBothEnds(int[] array, int capacity1, int capacity2) {
        // leftWater, rightWater
        // leftIndex, rightIndex
        // - enough: water -= array[index]
        // - not: water = cap, water -= array[index], totalRefills++
        int leftWater = capacity1;
        int rightWater = capacity2;
        int leftIndex = 0;
        int rightIndex = array.length - 1;
        int totalRefills = 2;

        while (leftIndex <= rightIndex) {
            if (leftIndex == rightIndex) {
                if (leftWater + rightWater < array[leftIndex]) {
                    totalRefills++;
                }
                break;
            }

            if (leftWater < array[leftIndex]) {
                leftWater = capacity1;
                totalRefills++;
            }
            if (rightWater < array[rightIndex]) {
                rightWater = capacity2;
                totalRefills++;
            }
            leftWater -= array[leftIndex];
            rightWater -= array[rightIndex];
            leftIndex++;
            rightIndex--;
        }
        return totalRefills;
    }

    public int getNumOfRefillsBothEndsImpl(int[] array, int capacity1, int capacity2) {
        // to be implemented
        return -1;
    }
}
