package OA;

import org.junit.Test;

public class LongestPathTest {
    @Test
    public void test1() {
        LongestPath cal = new LongestPath();
        int res = cal.lengthLongestPath("root!n!tdir1!n!t!tdir2!n!t!t!tdir3!n!t!t!t!tfile.ext");
    }
}
