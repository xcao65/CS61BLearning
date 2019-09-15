package OA;

import static org.junit.Assert.*;
import org.junit.Test;


public class FriendShipTest {
    @Test
    public void test1() {
        /*
        1，2，1
1， 2，2
2， 3， 1
2， 3， 3. from: 1point3acres
2， 4，3 来源一亩.三分地论坛.
4，5， 1
4，5，2
         */
        int res = Friendship.maxInterests(3, new int[] {1, 1, 2}, new int[] {3, 3, 3}, new int[] {1, 2, 2});
        assertEquals(3, res);
    }
}
