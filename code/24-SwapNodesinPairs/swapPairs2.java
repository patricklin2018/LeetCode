/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode first = new ListNode(0);
        first.next = head;
        
        ListNode pre = first;
        ListNode a;
        for (a = pre.next; a != null && a.next != null; pre = a, a = pre.next) {
            ListNode b = a.next;
            a.next = b.next;
            b.next = a;
            pre.next = b;
        }

        return first.next;
    }
}

class MainClass {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};

        ListNode pre = new ListNode(0);
        ListNode p = pre;

        for (int i = 0; i < nums.length; ++i) {
            p.next = new ListNode(nums[i]);
            p = p.next;
        }

        new Solution().swapPairs(pre.next);
    }
}