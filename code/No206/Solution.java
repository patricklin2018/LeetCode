package No206;

import java.util.Stack;

/**
 * @Author: patrick-mac
 * @Date: 2018/10/6 19:22
 * @Description: 翻转链表
 */
public class Solution {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 递归，原地翻转
     */
    public ListNode reverseList1(ListNode head) {
        return reverseList1(null, head);
    }

    public ListNode reverseList1(ListNode pre, ListNode cur) {
        if (cur == null) {
            return pre;
        }
        ListNode first = reverseList1(cur, cur.next);
        cur.next = pre;

        return first;
    }

    /**
     * 非递归，原地翻转，采用双指针
     */
    public ListNode reverseList2(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 非原地翻转，采用栈
     */
    public ListNode reverseList3(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        ListNode fakeHead = new ListNode(0);
        ListNode p = fakeHead;
        while (!stack.isEmpty()) {
            ListNode tmp = stack.pop();
            p.next = tmp;
            p = p.next;
        }
        p.next = null;
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
        Solution s = new Solution();
        s.reverseList3(first);
    }
}
