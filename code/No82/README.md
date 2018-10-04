# 82. 删除排序链表中的重复元素 II

## 问题

给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 *没有重复出现* 的数字。

**示例 1:**

```
输入: 1->2->3->3->4->4->5
输出: 1->2->5
```

**示例 2:**

```
输入: 1->1->1->2->3
输出: 2->3
```

## 思路

1. 采用 `ListNode first = new ListNode(0); first.next = head;` 作为链表头。
2. 遍历链表的时候，采用循环，将 `cur.val == cur.next.val` 的值遍历过去，直到相邻的两个值不想等时停下，并将 `pre` 连接至不同的节点。 

## 实现

[代码 - Java](Solution.java)

### 1. Java

```java
public static ListNode deleteDuplicates(ListNode head) {
    ListNode first = new ListNode(0);
    first.next = head;
    ListNode pre = first;
    ListNode cur = head;
    while (cur != null) {
        while (cur.next != null && cur.val == cur.next.val) {
            cur = cur.next;
        }
        // 如果第一个节点就不同
        if (pre.next == cur) {
            pre = pre.next;
        }
        // 否则，将 pre 连接至 cur.next
        else {
            pre.next = cur.next;
        }
        cur = pre.next;
    }

    return first.next;
}
```

