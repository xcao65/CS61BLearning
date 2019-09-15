package OA;

import org.junit.Test;
import static org.junit.Assert.*;

public class MaxJumpArrTest {
    @Test
    public void test1() {
        int[] input = {2, -6, 2, -1, 3};
        assertEquals(7, MaxJumpArr.getRes(input));
    }
    @Test
    public void test2() {
        int[] input = {-6};
        assertEquals(0, MaxJumpArr.getRes(input));
    }
    @Test
    public void test3() {
        int[] input = {-6, -1};
        assertEquals(-1, MaxJumpArr.getRes(input));
    }
    @Test
    public void test4() {
        int[] input = {3, -3, -3};
        assertEquals(0, MaxJumpArr.getRes(input));
    }
    @Test
    public void test5() {
        int[] input = {2, -6, -1, 3};
        assertEquals(4, MaxJumpArr.getRes(input));
    }
}
