class Solution {
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        ListNode *ptr, *first;
        first = ptr = new ListNode(0);
        while (true){
            if (l1 == nullptr) {
                ptr->next = l2;
                return first->next;
            }
            else if (l2 == nullptr){
                ptr->next = l1;
                return first->next;
            }
            else if(l1->val <= l2->val){
                ptr->next = new ListNode(l1->val);
                ptr = ptr->next;
                l1 = l1->next;
            }
            else{
                ptr->next = new ListNode(l2->val);
                ptr = ptr->next;
                l2 = l2->next;
            }
        }
    }
}