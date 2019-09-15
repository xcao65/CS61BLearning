import static org.junit.Assert.*;
import org.junit.Test;
import edu.princeton.cs.algs4.Queue;

public class MergeSortTest {
    @Test
    public void getMinTest() {
        Queue<Integer> queueA = new Queue<>();
        for (int i = 0; i < 10; i++) {
            queueA.enqueue(i);
        }
        Queue<Integer> queueB = new Queue<>();
        for (int i = 1; i < 10; i+=2) {
            queueB.enqueue(i);
        }
        int res = MergeSort.getMin(queueA, queueB);
        int exp = 0;
        assertEquals(exp, res);
    }

    @Test
    public void mergeSortTest() {
        Queue<Integer> input = new Queue<>();
        for (int i = 9; i >= 0; i--) {
            input.enqueue(i);
        }
        input = MergeSort.mergeSort(input);
        for (int i = 0; i < 10; i++) {
            assertEquals(i, (int)input.dequeue());
        }
    }
}