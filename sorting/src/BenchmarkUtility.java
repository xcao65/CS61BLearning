import java.util.Random;

import org.junit.rules.Stopwatch;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/** 
 *  @author Josh Hug
 *  Provides utility methods for timing sorting algorithms.
 */
public class BenchmarkUtility {
    private static final long RANDOM_SEED = 12345654321L;
    private static Random r = new Random(RANDOM_SEED);

    public static double time(SortingAlgorithm sa, int[] array, int k) {
        Stopwatch sw = new Stopwatch() {};
        sa.sort(array, k);
        return sw.runtime(TimeUnit.MILLISECONDS);
    }

    public static double time(SortingAlgorithm sa, int[] array) {
        return time(sa, array, array.length);
    }

    /** Returns an array of N integers between [0, MAXINT). */
    public static int[] randomInts(int N, int maxInt) {
        int[] ints = new int[N];
        for (int i = 0; i < N; i += 1) {
            ints[i] = r.nextInt(maxInt);
        }
        return ints;
    }

    /** Returns a copy of X. */
    public static int[] copy(int[] x) {
        int[] copy = new int[x.length];
        System.arraycopy(x, 0, copy, 0, x.length);
        return copy;
    }


    /** Returns a partially sorted array of N integers between 
      * [0, MAXINT). */
    public static int[] randomNearlySortedInts(int N, int maxInt) {
        int[] ints = new int[N];
        for (int i = 0; i < N; i += 1) {
            ints[i] = r.nextInt(maxInt);
        }
        Arrays.sort(ints);

        for (int i = 0; i < N; i += 1) {
            int swapIndex = r.nextInt(N - 1);
            swap(ints, swapIndex, swapIndex + 1);
        }

        return ints;
    }

    private static void swap(int[] ints, int i, int j) {
        int temp = ints[i];
        ints[i] = ints[j];
        ints[j] = temp;
    }

} 