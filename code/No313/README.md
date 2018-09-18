# 313. 超级丑数

## 问题

编写一段程序来查找第 `*n*` 个超级丑数。

超级丑数是指其所有质因数都是长度为 `k` 的质数列表 `primes` 中的正整数。

**示例:**

```
输入: n = 12, primes = [2,7,13,19]
输出: 32 
解释: 给定长度为 4 的质数列表 primes = [2,7,13,19]，前 12 个超级丑数序列为：[1,2,4,7,8,13,14,16,19,26,28,32] 。
```

**说明:**

- `1` 是任何给定 `primes` 的超级丑数。
-  给定 `primes` 中的数字以升序排列。
- 0 < `k` ≤ 100, 0 < `n` ≤ 106, 0 < `primes[i]` < 1000 。
- 第 `n` 个超级丑数确保在 32 位有符整数范围内。

## 思路

思路与 [LINK  - 264. 丑数 II](https://github.com/patricklin2018/LeetCode/tree/master/code/No264) 神似，利用两个特性，不同的是，丑数II 只需要考虑 2、3、5三个因子，而本题考虑给定的 prime 数组因子。

初始化 `ugly[0] = 1` ，并用其枚举下一轮的超级丑数，

`ugly[1] = min( ugly[0] * prime[0], ugly[0] * prime[1], ..., ugly[0] * prime[prime.length - 1])`

同样采用 `int[] t = new int[prime.length - 1]` 记住下标来计算丑数池中的数。

## 实现

[代码 - Java](Solution.java)

### 1. Java

```java
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] t = new int[primes.length];
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; ++i) {
            dp[i] = Integer.MAX_VALUE;
            for (int k = 0; k < primes.length; ++k) {
                dp[i] = Math.min(dp[i], dp[t[k]] * primes[k]);
            }
            for (int k = 0; k < primes.length; ++k) {
                if (dp[i] == dp[t[k]] * primes[k]) {
                    t[k]++;
                }
            }
        }
        return dp[n - 1];
    }
}
```

