# 206. 反转链表

## 问题

反转一个单链表。

**示例:**

```
输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
```

**进阶:**
你可以迭代或递归地反转链表。你能否用两种方法解决这道题？

## 思路

主要思路：

使用一个指针，初始化为 null，随着遍历一直指向遍历的上一个节点，如此，每次遍历时，当前节点不为空时，皆将当前节点指向上一个节点。

## 实现

### 方法 1:
利用栈读取链，然后再逐一取出，建立一条新的链接表。

```cpp
ListNode* reverseList(ListNode* head) {
    if(head == nullptr || head->next == nullptr){
        return head;
    }
    stack<ListNode*> st;
    while (head != nullptr){
        st.push(head);
        head = head->next;
    }
    ListNode *first, *ptr;
    first = ptr = st.top();
    st.pop();
    while (!st.empty()) {
        ptr->next = st.top();
        st.pop();
        ptr = ptr->next;
    }
    ptr->next = nullptr;
    return first;
}
```

### 方法 2:
设置左右两个指针，`head`指向要改变的节点，左右指针则分别记录该节点的前后节点。

```cpp
ListNode* reverseList(ListNode* head) {
    ListNode *left = nullptr;
    while (head != nullptr){
        ListNode* right = head->next;
        head->next = left;
        left = head;
        head = right;
    }
    return left;
}
```

JAVA:

```java
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode lst = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = lst;
            lst = head;
            head = tmp;
        }
        return lst;
    }
}
```

### 方法 3:

递归方法，思路与 `solution 2` 一致。

```cpp
ListNode* reverseList(ListNode* left, ListNode* head){
    if (!head)
        return left;
    auto right = head->next;
    head->next = left;
    return reverseList(head, right);
}

ListNode* reverseList(ListNode* head) {
    return reverseList(nullptr, head);
}
```

JAVA:

```java
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        return reverseList(null, head);
    }
    public ListNode reverseList(ListNode lst, ListNode ptr) {
        if (ptr.next == null) {
            ptr.next = lst;
            return ptr;
        }
        else {
            ListNode res = reverseList(ptr, ptr.next);
            ptr.next = lst;
            return res;
        }
    }
}
```

