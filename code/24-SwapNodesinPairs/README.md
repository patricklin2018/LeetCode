## 24. Swap Nodes in Pairs

### Problem

Given a linked list, swap every two adjacent nodes and return its head.

**Example:**

Given `1->2->3->4`, you should return the list as `2->1->4->3`.

**Note:**

* Your algorithm should use only constant extra space.
* You may not modify the values in the list's nodes, only nodes itself may be changed.

### Solution

```
假设现在要交换第 i 个元素 和 第 i + 1 个元素
那么 pre 指向第 i - 1 个元素，而 a 和 b 分别指向 i 和 i + 1
交换过后， pre 指向 a， a 指向 pre.next， b指向 a.next
直到 a 或 b 为空。
```

#### 递归方法

| 方法 | 备注 | C++ | Java |
|---|---|---|---|
| swapPairs | 递归 |[cpp](swapPairs.cpp)||
| swapPairs2 | 非递归 |[cpp](swapPairs2.cpp)|[java](swapPairs2.java)| 