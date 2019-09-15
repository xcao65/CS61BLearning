import java.util.Arrays;

/**
 * Class containing all the sorting algorithms from 61B to date.
 *
 * You may add any number instance variables and instance methods
 * to your Sorting Algorithm classes.
 *
 * You may also override the empty no-argument constructor, but please
 * only use the no-argument constructor for each of the Sorting
 * Algorithms, as that is what will be used for testing.
 *
 * Feel free to use any resources out there to write each sort,
 * including existing implementations on the web or from DSIJ.
 *
 * All implementations except Distribution Sort adopted from Algorithms, 
 * a textbook by Kevin Wayne and Bob Sedgewick. Their code does not
 * obey our style conventions.
 */
public class MySortingAlgorithms {

    /**
     * Java's Sorting Algorithm. Java uses Quicksort for ints.
     */
    public static class JavaSort implements SortingAlgorithm {
        @Override
        public void sort(int[] array, int k) {
            Arrays.sort(array, 0, k);
        }

        @Override
        public String toString() {
            return "Built-In Sort (uses quicksort for ints)";
        }        
    }

    /** Insertion sorts the provided data. */
    public static class InsertionSort implements SortingAlgorithm {
        @Override
        public void sort(int[] array, int k) {
            for (int i = 0; i < k; i++) {
                mvForward(array, i);
            }
        }

        public void mvForward(int[] array, int start) {
            if (start - 1 < 0 || array[start] >= array[start - 1]) {return;}
            swap(array, start, start - 1);
            mvForward(array, start - 1);
        }

        public void swap(int[] array, int a, int b) {
            int tmp = array[a];
            array[a] = array[b];
            array[b] = tmp;
        }

        @Override
        public String toString() {
            return "Insertion Sort";
        }
    }

    /**
     * Selection Sort for small K should be more efficient
     * than for larger K. You do not need to use a heap,
     * though if you want an extra challenge, feel free to
     * implement a heap based selection sort (i.e. heapsort).
     */
    public static class SelectionSort implements SortingAlgorithm {
        @Override
        public void sort(int[] array, int k) {
            for (int i = 0; i < k; i++) {
                int minIndex = findMinIndex(array, i);
                swap(array, i, minIndex);
            }
        }

        public int findMinIndex(int[] array, int start) {
            int index = start;
            for (int i = start; i < array.length; i++) {
                if (array[i] < array[index]) {
                    index = i;
                }
            }
            return index;
        }

        public void swap(int[] array, int a, int b) {
            int tmp = array[a];
            array[a] = array[b];
            array[b] = tmp;
        }

        @Override
        public String toString() {
            return "Selection Sort";
        }
    }

    /** Your mergesort implementation. An iterative merge
      * method is easier to write than a recursive merge method.
      * Note: I'm only talking about the merge operation here,
      * not the entire algorithm, which is easier to do recursively.
      */
    public static class MergeSort implements SortingAlgorithm {
        @Override
        public void sort(int[] array, int k) {            
            // TO-DO
        }

        // may want to add additional methods

        @Override
        public String toString() {
            return "Merge Sort";
        }
    }

    /**
     * Your Distribution Sort implementation.
     * You should create a count array that is the
     * same size as the value of the max digit in the array.
     */
    public static class DistributionSort implements SortingAlgorithm {
        @Override
        public void sort(int[] array, int k) {
            // TODO: to be implemented
        }

        // may want to add additional methods

        @Override
        public String toString() {
            return "Distribution Sort";
        }


    }

    /** Your Heapsort implementation.
     */
    public static class HeapSortInplace implements  SortingAlgorithm {
        private int[] contents;
        int size;
        @Override
        public void sort(int[] array, int k) {
            contents = array;
            size = k;
            heapify();
            for (int i = 0; i < contents.length; i++) {
                removeRoot();
            }
        }

        private void removeRoot() {
            swap(0, size - 1);
            size--;
            sink(0);
        }

        private void heapify() {
            for (int i = contents.length - 1; i >= 0; i--) {
                sink(i);
            }
        }

        private void sink(int curIndex) {
            int lChildIndex = curIndex * 2 + 1;
            int rChildIndex = curIndex * 2 + 2;
            if (lChildIndex > size - 1) {
                return;
            }
            int maxIndex = lChildIndex;
            if (rChildIndex < size) {
                maxIndex = (contents[rChildIndex] > contents[lChildIndex]) ?
                        rChildIndex : lChildIndex;
            }
            if (contents[maxIndex] > contents[curIndex]) {
                swap(maxIndex, curIndex);
                sink(maxIndex);
            }
            return;
        }

        private void swap(int a, int b) {
            int tmp = contents[a];
            contents[a] = contents[b];
            contents[b] = tmp;
        }

        @Override
        public String toString() {
            return "HeapSort In place";
        }
    }

    public static class HeapSort implements SortingAlgorithm {
        private int[] content;
        private int size;
        @Override
        public void sort(int[] array, int k) {
            content = new int[k + 1];
            size = 0;
            for (int i = 0; i < k; i++) {
                insert(array[i]);
            }
            for (int i = 0; i < k; i++) {
                array[i] = removeRoot();
            }
        }

        private int removeRoot() {
            if (size < 1) {throw new RuntimeException("Heap is empty");}
            int res = content[1];
            swap(1, size);
            content[size] = 0;
            size--;
            sink(1);
            return res;
        }

        private void sink(int curIndex) {
            int lchildIndex = curIndex * 2;
            int rchildIndex = curIndex * 2 + 1;
            //no child
            if (lchildIndex > size) {return;}
            int minIndex = lchildIndex;
            if (rchildIndex <= size) {
                minIndex = (content[lchildIndex] <= content[rchildIndex]) ? lchildIndex : rchildIndex;
            }
            if (content[minIndex] < content[curIndex]) {
                swap(curIndex, minIndex);
                sink(minIndex);
            }
            return;
        }

        private void insert(int value) {
            size++;
            content[size] = value;
            swim(size);
        }

        private void swim(int curIndex) {
            int parentIndex = curIndex / 2;
            if (parentIndex > 0 && content[parentIndex] > content[curIndex]) {
                swap(parentIndex, curIndex);
                swim(parentIndex);
            }
            return;
        }

        private void swap(int a, int b) {
            int tmp = content[a];
            content[a] = content[b];
            content[b] = tmp;
        }

        @Override
        public String toString() {
            return "Heap Sort";
        }        
    }

    /** Your Quicksort implementation.
     */
    public static class QuickSort implements SortingAlgorithm {
        @Override
        public void sort(int[] array, int k) {
            // TODO   
        }

        @Override
        public String toString() {
            return "Quicksort";
        }        
    }

    /*
     * Your LSD Sort implementation, treating ints
     * as a sequence of 8 bit characters. Or if you want 
     * to do less bit-hacking, you can treat them as strings
     * of decimal digits.
     */
    public static class LSDSort implements SortingAlgorithm {
        @Override
        /** For an example implementation, see Kevin Wayne and 
          * Bob Sedgewick's Algorithms textbook.
          *
          * http://algs4.cs.princeton.edu/51radix/LSD.java.html
          */
        public void sort(int[] a, int k) {
            // TODO
        }

        @Override
        public String toString() {
            return "LSD Sort";
        }
    }

    /**
     * Tricky: Your MSD Sort implementation, treating ints
     * as a string of 8 bit characters.
     */
    public static class MSDSort implements SortingAlgorithm {
        @Override
        /** For an example implementation, see Kevin Wayne and 
          * Bob Sedgewick's Algorithms textbook.
          *
          * http://algs4.cs.princeton.edu/51radix/MSD.java.html
          */
        public void sort(int[] a, int k) {
            // TODO
        }

        @Override
        public String toString() {
            return "MSD Sort";
        }
    }

    // swap a[i] and a[j]
    private static void swap(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

}


