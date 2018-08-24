## 21. Merge Two Sorted Lists

Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

```cpp
// Definition for singly-linked list.
struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};
```

## Solution

```
1. 如果 l1 为空，将剩下的整条 l2 添加进 res 链表 
2. 如果 l2 为空，将剩下的整条 l1 添加进 res 链表 
3. 比较 l1 和 l2 的 val 大小，取小者添加进 res 链表
```

| 方法 | 备注 | C++ | Java |
|---|---|---|---|
| mergeTwoLists | 递归 |[cpp](mergeTwoLists.cpp)||
| mergeTwoLists2 | 非递归 |[cpp](mergeTwoLists2.cpp)|[java](mergeTwoLists2.java)| 