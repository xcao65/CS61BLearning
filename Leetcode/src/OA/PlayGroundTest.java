package OA;

import org.junit.Test;

public class PlayGroundTest {
    @Test
    public void testChangeRef() {
        PlayGround pg = new PlayGround();
        PlayGround.ListNode cur1 = new PlayGround.ListNode(1);
        PlayGround.ListNode cur2 = new PlayGround.ListNode(2);
        cur1.next = cur2;
        pg.changeReferencePionter(cur1);
        System.out.println(cur1.val);
    }
    @Test
    public void testChangeVal() {
        PlayGround pg = new PlayGround();
        PlayGround.ListNode cur1 = new PlayGround.ListNode(1);
        PlayGround.ListNode cur2 = new PlayGround.ListNode(2);
        cur1.next = cur2;
        pg.changeReferenceValue(cur1);
        System.out.println(cur1.val);
    }

}
