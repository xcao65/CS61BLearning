package OA.GoogleOA;
import java.util.Arrays;

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
        int[] res = new int[arrBVal.length];
        for (int i = 0; i < arrBVal.length; i++) {
            res[i] = prefixSumBuckets[arrBVal[i] - 1];
        }
        return res;
    }

    private int[] calPrefixSumBuckets(int[] array) {
        int[] res = new int[11];
        for (int ssVal : array) {
            res[ssVal]++;
        }
        for (int i = 1; i < 11; i++) {
            res[i] += res[i - 1];
        }
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
        String[] arr = input.split(",");
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            String cur = arr[i];
            char minChar = cur.charAt(0);
            int count = 1;
            for (int j = 1; j < cur.length(); j++) {
                char curChar = cur.charAt(j);
                if (curChar - minChar < 0) {
                    minChar = curChar;
                    count = 1;
                } else if (curChar - minChar == 0) {
                    count++;
                }
            }
            res[i] = count;
        }
        return res;
    }
}
