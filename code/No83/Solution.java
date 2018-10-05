package No83;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: patrick-mac
 * @Date: 2018/10/4 16:29
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
        Set<Integer> set = new HashSet<>();
        ListNode p = head;
        ListNode lst = null;
        while (p != null) {
            if (set.contains(p.val)) {
                if (p.next != null) {
                    ListNode next = p.next;
                    p.next = null;
                    p = next;
                    lst.next = p;
                }
                else {
                    lst.next = null;
                    p = null;
                }
            }
            else {
                set.add(p.val);
                lst = p;
                p = p.next;
            }
        }

        return head;
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
