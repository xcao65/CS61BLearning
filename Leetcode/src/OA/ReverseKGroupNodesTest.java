package OA;
import org.junit.Test;

public class ReverseKGroupNodesTest {
    @Test
    public void test1() {
        ReverseKGroupNodes.ListNode cur = new ReverseKGroupNodes.ListNode(1);
        cur.next = new ReverseKGroupNodes.ListNode(2);
        cur.next.next = new ReverseKGroupNodes.ListNode(3);
        cur.next.next.next = new ReverseKGroupNodes.ListNode(4);
        cur.next.next.next.next = new ReverseKGroupNodes.ListNode(5);
        cur.next.next.next.next.next = new ReverseKGroupNodes.ListNode(6);
        ReverseKGroupNodes.reverseKGroup(cur, 3);
    }
}
