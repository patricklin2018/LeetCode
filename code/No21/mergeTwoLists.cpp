class Solution {
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        if (l1 == nullptr) return l2;
        if (l2 == nullptr) return l1;

        ListNode* res;
        if (l1->val <= l2->val){
            res = new ListNode(l1->val);
            res->next = mergeTwoLists(l1->next, l2);
        }
        else{
            res = new ListNode(l2->val);
            res->next = mergeTwoLists(l1, l2->next);
        }
        return res;
    }
}