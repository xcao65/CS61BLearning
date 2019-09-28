package OA.GoogleOA;

import org.junit.Test;
import static org.junit.Assert.*;

public class StrictSmallerTest {
    @Test
    public void testGetNumOfSSForArray() {
        StrictSmaller comparator = new StrictSmaller();
        int[] res = comparator.getNumOfSSForArray("aa,bb,cc", "aaa,bb,c,ddd");
        int[] expected = {3, 0, 0, 3};
        assertArrayEquals("Matching result", expected, res);
    }

    @Test
    public void testBinarySearchForLargestSmaller() {
        StrictSmaller comparator = new StrictSmaller();
        int[] inputArr = {2,2,2};
        int res = comparator.binarySearchForLargestSmaller(inputArr,3);
        assertEquals("Matching result",3, res);
    }

    @Test
    public void testGetNumOfSSForArrayBucketSort() {
        StrictSmaller comparator = new StrictSmaller();
        int[] res = comparator.getNumOfSSForArrayBucketSort("a,bb,aaaaaaaaaa", "aaa,bb,c,dddd");
        int[] expected = {2, 1, 0, 2};
        assertArrayEquals("Matching result", expected, res);
    }
}
