package OA;

import static org.junit.Assert.*;
import org.junit.Test;

public class LongestConIntTest {
    @Test
    public void longestConsecutiveTest() {
        int len = LongestConInt.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1});
        assertEquals(9, len);
    }

    @Test
    public void long2() {
        int len = LongestConInt.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2});
        assertEquals(4, len);
    }
}
