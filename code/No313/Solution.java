package No313;

/**
 * @Author: patrick-mac
 * @Date: 2018/9/18 20:12
 * @Description:
 */
public class Solution {

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

    public static void main(String[] args) {
        int[] p = {2,7,13,19};
        new Solution().nthSuperUglyNumber(12, p);
    }

}
