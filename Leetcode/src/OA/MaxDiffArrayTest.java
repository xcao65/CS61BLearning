package OA;

import org.junit.Test;
import static org.junit.Assert.*;

public class MaxDiffArrayTest {
    @Test
    public void test1() {
        int[] input = {2, -6, 2, -1, 3};
        assertEquals(9, MaxDiffArray.getMaxDiff(input));
    }
    @Test
    public void test2() {
        int[] input = {-6};
        assertEquals(-1, MaxDiffArray.getMaxDiff(input));
    }
}
