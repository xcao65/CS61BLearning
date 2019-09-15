package OA;

import static org.junit.Assert.*;
import org.junit.Test;

public class LongestValidSubstringTest {
    @Test
    public void test1() {
        LongestValidSubstring cal = new LongestValidSubstring();
        assertEquals(2, cal.getLongest("a0Ba"));
    }

    @Test
    public void test2() {
        LongestValidSubstring cal = new LongestValidSubstring();
        assertEquals(5, cal.getLongest("aBaac1B"));
    }

    @Test
    public void test3() {
        LongestValidSubstring cal = new LongestValidSubstring();
        assertEquals(4, cal.getLongest("Babc2a2aaaaa"));
    }

    @Test
    public void test4() {
        LongestValidSubstring cal = new LongestValidSubstring();
        assertEquals(5, cal.getLongest("BaBcB2a2aa1Baaaa2A"));
    }


}
