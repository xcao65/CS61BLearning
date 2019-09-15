package OA;

public class PlayGround {
    static class ListNode {
        int val;
        ListNode next;
        public ListNode(int value) {
            this.val = value;
            this.next = null;
        }
    }
    public void changeReferencePionter(ListNode cur) {
        if (cur != null) {
            cur = cur.next;
        }
        System.out.println(cur.val);
        return;
    }

    public void changeReferenceValue(ListNode cur) {
        if (cur != null) {
            cur.val = -cur.val;
        }
        System.out.println(cur.val);
        return;
    }
}
