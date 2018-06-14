## Two Sum

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

```
利用哈希表的 O(1) 查找优势，将数组逐个插入到表中，知道找到 target - num[i] 的目标
```
| 方法 | C++ | Java |
|---|---|---|
| solution1 | [c++](https://github.com/PatrickLin1993/LeetCode/blob/master/Algorithmn/Two%20Sum/resolution2.cpp)  | 
| solution2 | [c++](https://github.com/PatrickLin1993/LeetCode/blob/master/Algorithmn/Two%20Sum/resolution2.cpp)  | [java](https://github.com/patricklin2018/LeetCode/tree/master/code/1%20-%20Two%20Sum/java/TwoSum.java) 




