## 16. 3Sum Closest

Given an array `nums` of n integers and an integer `target`, find three integers in `nums` such that the sum is closest to `target`. Return the sum of the three integers. You may assume that each input would have exactly one solution.

**Example:**
```
Given array nums = [-1, 2, 1, -4], and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
```

## Solution

固定第一个数，第二个数和第三个数用双指针去移动查找

```
1. 排序
2. i 从 0 遍历到 length - 3
3. 设置双指针，分别为 j = i + 1, k = size - 1
4. 如果三者之和，更新 gap，并且如果三者之和大于 target， 则 k--， 否则 j++
5. 回到 2. 固定的 i 继续右移 
```

| 方法 | 备注 | C++ | Java |
|---|---|---|---|
| solution | 双指针 |[cpp](threeSumClosest.cpp)|[java](threeSumClosest.java)| 