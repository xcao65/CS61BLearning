package rmn;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class CommonFreeDurationTest {
    @Test
    public void test1() {
        List<int[]> p1 = new ArrayList<>();
        p1.add(new int[] {2, 6});
        p1.add(new int[] {10, 14});
        p1.add(new int[] {16, 18});
        List<int[]> p2 = new ArrayList<>();
        p2.add(new int[] {1, 4});
        p2.add(new int[] {8, 16});
        p2.add(new int[] {18, 20});
        List<List<int[]>> times = new ArrayList<>();
        times.add(p1);
        times.add(p2);
        int[] res1 = CommonFreeDuration.getTimeFrame(times, 2);
        int[] res2 = CommonFreeDuration.getTimeFrame(times, 4);
        assertArrayEquals(new int[] {2, 4}, res1);
        assertArrayEquals(new int[] {10, 14}, res2);
    }
}
