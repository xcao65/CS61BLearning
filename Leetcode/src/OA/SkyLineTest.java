package OA;

import org.junit.Test;

import java.util.List;

public class SkyLineTest {
    @Test
    public void test1() {
        SkyLine tester = new SkyLine();
        List<int[]> res = tester.getSkyline(new int[][] {{2,9,10}, {3,7,15}, {5,12,12},{15,20,10},{19,24,8}});
    }
}
