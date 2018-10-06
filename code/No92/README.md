# 92. 反转链表 II

## 问题

反转从位置 *m* 到 *n* 的链表。请使用一趟扫描完成反转。

**说明:**
1 ≤ *m* ≤ *n* ≤ 链表长度。

**示例:**

```
输入: 1->2->3->4->5->NULL, m = 2, n = 4
输出: 1->4->3->2->5->NULL
```

## 思路

用 `left` 标记第 m 个节点的前一个节点，用 `right` 标记第 n 个节点的后一个节点。

用 `begin` 标记第 m 个节点，用 `end` 标记第 n 个节点。并遍历的过程中，直接把该区间的链表原地翻转。

最后 `left.next = end;   begin.next = right`。

## 实现

[代码 -  Java](Solution.java)

#### 1. Java


```java
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode left = fakeHead;
        for (int i = 1; i < m; ++i) {
            left = left.next;
        }
        ListNode begin = left.next;
        ListNode end = begin;
        ListNode right = begin.next;
        int len = n - m;
        for (int i = 0; i < len && right != null; ++i) {
            ListNode tmp = right.next;
            right.next = end;
            end = right;
            right = tmp;
        }
        left.next = end;
        begin.next = right;

        return fakeHead.next;
    }
}
```