/**
 * @author Patrick-lenovo
 * @create 2018/6/16 21:57
 **/
public class Solution2 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, 0);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry) {

        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }

        int val = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
        ListNode p = new ListNode(val % 10);
        p.next = addTwoNumbers(l1 == null ? l1 : l1.next, l2 == null ? l2 : l2.next, val / 10);
        return p;
    }
}
