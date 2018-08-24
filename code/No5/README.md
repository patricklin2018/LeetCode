## 最长回文子串

### Problem

给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。

**示例 1：**
```
输入: "babad"
输出: "bab"
注意: "aba"也是一个有效答案。
```

**示例 2：**
```
输入: "cbbd"
输出: "bb"
```

### Solution

##### 1. 动态规划

转移方程为 `dp[i, j] = (dp[i + 1, j - 1] && str[i] == str[j])` 该方法需要 O(n^2) 的额外空间复杂度

##### 2. 中心展开法

同样利用动态规划思想,但是不用额外的 O(n^2) 存储空间：
```
a) 假设回文为奇数,那么中心为 i，则从 i 开始，尽量往外伸
b) 假设回文为偶数，那么中心为 i 和 i + 1，那么从 i 和 i + 1 开始，尽量往外伸
c) a) 和 b) 所获得的子串长度与记录进行比较，若最长则更新记录
```

##### 3. Manacher 算法
计算复杂度为 O(n) 的算法，[Manacher](https://articles.leetcode.com/longest-palindromic-substring-part-ii/)

| 方法 | 备注 | C++ | Java |
|---|---|---|---|
| 中心展开法 | dp | |[java](longestPalindrome.java) | 