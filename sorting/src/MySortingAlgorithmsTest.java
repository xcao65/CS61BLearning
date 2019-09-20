import org.junit.Test;
import junit.textui.TestRunner;
import static org.junit.Assert.*;

/** FIXME
 *  @author Josh Hug
 */

public class MySortingAlgorithmsTest {

    @Test
    public void javaSortTest() {
        int numInts = 22;
        int maxValue = 1000;
        int[] original = BenchmarkUtility.randomInts(numInts, maxValue);
        int[] correct = BenchmarkUtility.copy(original);
        SortingAlgorithm javaSort = new MySortingAlgorithms.JavaSort();
        javaSort.sort(correct, correct.length);
        int[] input = BenchmarkUtility.copy(original);
        javaSort.sort(input, input.length);
        assertArrayEquals("Result for javaSort" + " incorrect: ",
                correct, input);

    }

    @Test
    public void insertionSortTest() {
        int numInts = 22;
        int maxValue = 1000;
        int[] original = BenchmarkUtility.randomInts(numInts, maxValue);
        int[] correct = BenchmarkUtility.copy(original);
        SortingAlgorithm javaSort = new MySortingAlgorithms.JavaSort();
        SortingAlgorithm insertionSort = new MySortingAlgorithms.InsertionSort();
        javaSort.sort(correct, correct.length);
        int[] input = BenchmarkUtility.copy(original);
        insertionSort.sort(input, input.length);
        assertArrayEquals("Result for javaSort" + " incorrect: ",
                correct, input);
        System.out.println();
        System.out.println("Insersion: ");
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
    }

    @Test
    public void selectionSortTest() {
        int numInts = 22;
        int maxValue = 1000;
        int[] original = BenchmarkUtility.randomInts(numInts, maxValue);
        int[] correct = BenchmarkUtility.copy(original);
        SortingAlgorithm javaSort = new MySortingAlgorithms.JavaSort();
        SortingAlgorithm selectionSort = new MySortingAlgorithms.SelectionSort();
        javaSort.sort(correct, correct.length);
        int[] input = BenchmarkUtility.copy(original);
        selectionSort.sort(input, input.length);
        assertArrayEquals("Result for javaSort" + " incorrect: ",
                correct, input);
        System.out.println();
        System.out.println("Selection: ");
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
    }

    @Test
    public void heapSortTest() {
        int numInts = 22;
        int maxValue = 1000;
        int[] original = BenchmarkUtility.randomInts(numInts, maxValue);
        int[] correct = BenchmarkUtility.copy(original);
        SortingAlgorithm javaSort = new MySortingAlgorithms.JavaSort();
        SortingAlgorithm heapSort = new MySortingAlgorithmsPrac.HeapSort();
        javaSort.sort(correct, correct.length);
        int[] input = BenchmarkUtility.copy(original);
        heapSort.sort(input, input.length);
        assertArrayEquals("Result for javaSort" + " incorrect: ",
                correct, input);
        System.out.println();
        System.out.println("Heap: ");
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
    }

    @Test
    public void heapSortInplaceTest() {
        int numInts = 22;
        int maxValue = 300;
        int[] original = BenchmarkUtility.randomInts(numInts, maxValue);
        int[] correct = BenchmarkUtility.copy(original);
        SortingAlgorithm javaSort = new MySortingAlgorithms.JavaSort();
        SortingAlgorithm heapSortInplace = new MySortingAlgorithmsPrac.HeapSortInplace();
        javaSort.sort(correct, correct.length);
        int[] input = BenchmarkUtility.copy(original);
        heapSortInplace.sort(input, input.length);
        assertArrayEquals("Result for HeapSortInplace" + " incorrect: ",
                correct, input);
        System.out.println();
        System.out.println("Heap Inplace: ");
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
    }

//    @Test
//    public void correctnessTest() {
//        /* Don't set maxValue too high or Distribution Sort will use
//           up all available memory and your program will crash. */
//        int numInts = 22;
//        int maxValue = 1000;
//        int[] original = BenchmarkUtility.randomInts(numInts, maxValue);
//        int[] correct = BenchmarkUtility.copy(original);
//        SortingAlgorithm javaSort = new MySortingAlgorithms.JavaSort();
//        javaSort.sort(correct, correct.length);
//
//        SortingAlgorithm[] algorithms = {
//                 new MySortingAlgorithms.InsertionSort(),
//                 new MySortingAlgorithms.SelectionSort(),
//                 new MySortingAlgorithms.MergeSort(),
//                 new MySortingAlgorithms.DistributionSort(),
//                 new MySortingAlgorithms.HeapSort(),
//                 new MySortingAlgorithms.QuickSort(),
//                 new MySortingAlgorithms.LSDSort(),
//                 new MySortingAlgorithms.MSDSort()};
//
//        for (SortingAlgorithm sa : algorithms) {
//            int[] input = BenchmarkUtility.copy(original);
//            sa.sort(input, input.length);
//            assertArrayEquals("Result for " + sa + " correct: ",
//                              correct, input);
//        }
//
//        int k = 20;
//
//        correct = BenchmarkUtility.copy(original);
//        javaSort.sort(correct, k);
//
//        for (SortingAlgorithm sa : algorithms) {
//            int[] input = BenchmarkUtility.copy(original);
//            sa.sort(input, k);
//            assertArrayEquals("Result for " + sa + " incorrect: ",
//                              correct, input);
//        }
//    }


//    public static void main(String[] args) {
//        System.exit(org.junit.textui.runClasses(MySortingAlgorithmsTest.class));
//    }
} 