## 1. Two Sum

### Problem
**Quiestion:**

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution.

**Example:**

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].

**UPDATE (2016/2/13):**

The return format had been changed to zero-based indices. Please read the above updated description carefully.
***

### 思路

利用哈希表的 O(1) 查找优势，将数组逐个插入到表中，知道找到 target - num[i] 的目标。

| 方法 | 备注 | C++ | Java |
|---|---|---|---|
| solution1 | 前后两个指针标定，慢慢移动 | [c++](cpp/resolution1.cpp)  | 
| solution2 | 哈希 |[c++](cpp/resolution2.cpp)  | [java](java/TwoSum.java) |