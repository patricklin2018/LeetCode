#include <iostream>
using namespace std;

class Solution2{
    ListNode* Solution(ListNode* l1, ListNode* l2, int carry) {
        if( !l1 && !l2 && !carry)
            return nullptr;
        
        int value = (l1 ? l1->val : 0) + (l2 ? l2->val : 0) + carry;
        carry = value / 10;
        ListNode* ptr = new ListNode(value % 10);
        ptr->next = Solution(l1 ? l1->next : nullptr, l2 ? l2->next : nullptr, carry);
        return ptr;
    }

    ListNode* Solution(ListNode* l1, ListNode* l2) {
        return Solution(l1, l2, 0);
    }
}