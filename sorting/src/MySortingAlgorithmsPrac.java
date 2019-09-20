import java.util.Arrays;

public class MySortingAlgorithmsPrac {

    public static class HeapSort implements SortingAlgorithm {
        private int[] content;
        private int size;

        @Override
        public String toString() {
            return "Heap Sort";
        }

        @Override
        public void sort(int[] array, int k) {
            content = new int[k];
            // build up min-heap in extra array: insert -> heapify: swim
            size = -1;
            for (int ele : array) {
                content[++size] = ele;
                swim(size);
            }

            // remove from top to form ascending array -> remove from heap -> sink
            for (int i = 0; size >= 0; i++) {
                array[i] = content[0];
                swap(0, size);
                size--;
                sink(0);
            }
            return;
        }

        // swim
        private void swim(int current) {
            int parent = (current - 1) / 2;
            if (parent >= 0 && content[parent] > content[current]) {
                swap(parent, current);
                swim(parent);
            }
            return;
        }

        // sink
        private void sink(int current) {
            int minIdx = current;
            int leftIdx = current * 2 + 1;
            if (leftIdx <= size && content[leftIdx] < content[minIdx]) {
                minIdx = leftIdx;
            }
            int rightIdx = current * 2 + 2;
            if (rightIdx <= size && content[rightIdx] < content[minIdx]) {
                minIdx = rightIdx;
            }
            if (minIdx != current) {
                swap(minIdx, current);
                sink(minIdx);
            }
            return;
        }

        // swap
        private void swap(int left, int right) {
            int tmp = content[left];
            content[left] = content[right];
            content[right] = tmp;
            return;
        }
    }

    public static class HeapSortInplace implements SortingAlgorithm {
        private int size;
        private int[] content;

        @Override
        public String toString() {
            return "Heap Sort In-place";
        }

        @Override
        public void sort(int[] array, int k) {
            size = 0;
            content = array;

            // in-place heapify to max-heap -> swim to top
            for (int i = 0; i < k; i++) {
                swim(i);
                size++;
            }

            // swap root with end of array -> sink root & decrease array size
            while (size > 0) {
                swap(size - 1, 0);
                size--;
                sink(0);
            }
        }

        private void swim(int cur) {
            int parent = (cur - 1) / 2;
            if (parent >= 0 && content[parent] < content[cur]) {
                swap(parent, cur);
                swim(parent);
            }
            return;
        }

        private void sink(int root) {
            int max = root;
            int left = root * 2 + 1;
            int right = root * 2 + 2;

            if (left < size && content[left] > content[root]) {
                max = left;
            }

            if (right < size && content[right] > content[max]) {
                max = right;
            }

            if (max != root) {
                swap(max, root);
                sink(max);
            }
            return;
        }

        private void swap(int left, int right) {
            int tempVal = content[left];
            content[left] = content[right];
            content[right] = tempVal;
            return;
        }
    }
}
