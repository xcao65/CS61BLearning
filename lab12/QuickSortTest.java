import static org.junit.Assert.*;

import org.junit.Test;
import edu.princeton.cs.algs4.Queue;

public class QuickSortTest {
    @Test
    public void quickSortTest() {
        Queue<Integer> input = new Queue<>();
        for (int i = 9; i >= 0; i--) {
            input.enqueue(i);
            input.enqueue(i);
        }
        Queue<Integer> res = QuickSort.quickSort(input);
        for (int i = 0; i < 10; i++) {
            assertEquals(i, (int)res.dequeue());
            assertEquals(i, (int)res.dequeue());
        }
    }
}
