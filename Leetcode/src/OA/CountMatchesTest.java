package OA;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CountMatchesTest {
    @Test
    public void test1() {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list1.add("001");
        list1.add("011");
        list1.add("100");

                /*
                001
011
100

001
011
101
                 */
        list2.add("001");
        list2.add("011");
        list2.add("101");

        int res = CountMatches.countMatches(list1, list2);

        assertEquals(1, res);

    }
}
