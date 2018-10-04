# 83. 删除排序链表中的重复元素

## 问题

给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。

**示例 1:**

```
输入: 1->1->2
输出: 1->2
```

**示例 2:**

```
输入: 1->1->2->3->3
输出: 1->2->3
```

## 思路

### 思路1

采用 hashset 验证是否重复，若重复，做链表删除操作。

### 思路2

遍历链表的时候，采用循环判定 `cur.val == cur.next.val` 的方式跳过相邻节点相等的情况，直到相邻节点不等时，则将 `pre.next = cur`。

## 实现

[思路1 代码 - Java](Solution.java)

[思路2 代码 - Java](Solution2.java)

### 1. 思路1 - Java

```java
public static ListNode deleteDuplicates(ListNode head) {
    Set<Integer> set = new HashSet<>();
    ListNode p = head;
    ListNode lst = null;
    while (p != null) {
        if (set.contains(p.val)) {
            if (p.next != null) {
                ListNode next = p.next;
                p.next = null;
                p = next;
                lst.next = p;
            }
            else {
                lst.next = null;
                p = null;
            }
        }
        else {
            set.add(p.val);
            lst = p;
            p = p.next;
        }
    }

    return head;
}
```

### 2. 思路 2 - Java

```java
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode first = new ListNode(0);
        ListNode pre = first;
        ListNode cur = head;
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }
            pre.next = cur;
            pre = cur;
            cur = cur.next;
        }
        return first.next;
    }
}
```

