/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */

class Solution {
    ListNode* swapPairs(ListNode* head) {
        ListNode *a, *b;
        if ((a = head) && (b = a->next)){
            a->next = swapPairs(b->next);
            b->next = a;
            return b;
        }
        return head;
    }
}