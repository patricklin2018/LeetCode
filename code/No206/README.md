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

#### 思路1 - 原地翻转，递归

递归的时候，传递当前的指针节点到下一节点。

#### 思路2 - 原地翻转，非递归

非递归的方式，即采用两个指针，一个指向前一个节点，一个指向当前节点。

#### 思路3 - 非原地翻转，采用栈

采用栈记住遍历顺序，再一一取出建立连接。

## 实现

[代码 - Java](Solution.java)

#### 思路1 - Cpp

```java
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

#### 思路1 - Java

```java
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
```

#### 思路2 - Cpp

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

#### 思路2 - Java

```java
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
```

#### 思路3 - CPP

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
