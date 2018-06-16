# include <iostream>
using namespace std;

class Solution{

    ListNode* Solution(ListNode* l1, ListNode* l2) {
        ListNode first(0), *end = &first;
        int carry = 0;
        
        while (l1 || l2 || carry){
            int value = (l1 ? l1->val : 0) + (l2 ? l2->val : 0) + carry;
            end->next = new ListNode(value % 10);
            end = end->next;
            carry = value / 10;
            if(l1 != nullptr)
                l1 = l1->next;
            if(l2 != nullptr)
                l2 = l2->next;
        }
        return first.next;
    }
}

