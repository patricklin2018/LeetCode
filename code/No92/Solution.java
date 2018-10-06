package No92;

/**
 * @Author: patrick-mac
 * @Date: 2018/10/6 19:53
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

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode left = fakeHead;
        for (int i = 1; i < m; ++i) {
            left = left.next;
        }
        ListNode begin = left.next;
        ListNode end = begin;
        ListNode right = begin.next;
        int len = n - m;
        for (int i = 0; i < len && right != null; ++i) {
            ListNode tmp = right.next;
            right.next = end;
            end = right;
            right = tmp;
        }
        left.next = end;
        begin.next = right;

        return fakeHead.next;
    }

    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        ListNode p = first;
        p.next = new ListNode(2);
        p = p.next;
        p.next = new ListNode(3);
        p = p.next;
        p.next = new ListNode(4);
        p = p.next;
        p.next = new ListNode(5);
        new Solution().reverseBetween(first, 2, 4);
    }
}
