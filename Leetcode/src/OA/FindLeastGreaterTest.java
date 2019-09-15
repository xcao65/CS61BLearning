package OA;

import static org.junit.Assert.*;
import org.junit.Test;

public class FindLeastGreaterTest {
    @Test
    public void test1() {
        int[] res = FindLeastGreater.findLeastGreaterEle(new int[] {1, 4, 6}, new int[] {1,6,3,4,5});
        assertArrayEquals(new int[] {3, 5, -1}, res);
    }
}
