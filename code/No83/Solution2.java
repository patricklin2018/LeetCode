/**
 * @Author: patrick-mac
 * @Date: 2018/10/4 18:51
 * @Description:
 */

public class Solution2 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {

        ListNode first = new ListNode(0);
        ListNode pre = first;
        ListNode cur = head;
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }
            pre.next = cur;
            pre = cur;
            cur = cur.next;
        }
        return first.next;
    }

    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(1);
        ListNode third = new ListNode(2);
        first.next = second;
        second.next = third;
        deleteDuplicates(first);
    }
}
