package OA.GoogleOA;
import java.util.Arrays;
import java.util.regex.Pattern;

public class StrictSmaller {

    public int[] getNumOfSSForArray(String arrA, String arrB) {
        // calculate SS value for two arrays
        int[] arrAVal = this.calSSVal(arrA);
        int[] arrBVal = this.calSSVal(arrB);

        // sort arrAVal
        Arrays.sort(arrAVal);

        // for entry in arrBVal, do binary search, for the largest smaller item, the resIndex + 1 will be answer
        // MLog(N) + Nlog(N)
        int[] res = new int[arrBVal.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = this.binarySearchForLargestSmaller(arrAVal, arrBVal[i]);
        }
        return res;
    }

    public int[] getNumOfSSForArrayBucketSort(String arrA, String arrB) {
        // calculate SS value for both string O(M + N)
        int[] arrAVal = this.calSSVal(arrA);
        int[] arrBVal = this.calSSVal(arrB);

        // compute array of 10 buckets for arrA,
        // with index = ssValue, value = freq. O(M)
        // do a prefix sum of 10 buckets. O(1)
        int[] prefixSumBuckets = this.calPrefixSumBuckets(arrAVal);

        // for each arrB, get value from prefixSum Bucket
        return Arrays.stream(arrBVal)
                .map(curBVal -> prefixSumBuckets[curBVal - 1])
                .toArray();
    }

    private int[] calPrefixSumBuckets(int[] array) {
        int[] res = new int[11];
        for (int ssVal : array) {
            res[ssVal]++;
        }
        Arrays.parallelPrefix(res, Integer::sum);
        return res;
    }

    public int binarySearchForLargestSmaller(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left)/2;
            if (array[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (array[right] < target) {
            return right + 1;
        } else if (array[left] < target) {
            return left + 1;
        }
        return left;
    }

    private int[] calSSVal(String input) {
        return Pattern.compile(",").splitAsStream(input)
                .mapToInt(str -> {
                    int minChar = str.chars().min().getAsInt();
                    return (int)str.chars()
                            .filter(curChar -> curChar == minChar)
                            .count();
                }).toArray();
    }
}
