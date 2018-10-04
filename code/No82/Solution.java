/**
 * @Author: patrick-mac
 * @Date: 2018/10/4 16:55
 * @Description:
 */
public class Solution {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {

        ListNode first = new ListNode(0);
        first.next = head;
        ListNode pre = first;
        ListNode cur = head;
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }
            // 如果第一个节点就不同
            if (pre.next == cur) {
                pre = pre.next;
            }
            // 否则，将 pre 连接至 cur.next
            else {
                pre.next = cur.next;
            }
            cur = pre.next;
        }

        return first.next;
    }

    public static void main(String[] args) {
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(3);
        ListNode p4 = new ListNode(3);
        ListNode p5 = new ListNode(4);
        ListNode p6 = new ListNode(4);
        ListNode p7 = new ListNode(5);
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;
        p5.next = p6;
        p6.next = p7;
        deleteDuplicates(p1);
    }

}
