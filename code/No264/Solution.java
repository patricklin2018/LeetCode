package No264;

/**
 * @Author: patrick-mac
 * @Date: 2018/9/18 16:48
 * @Description:
 */
public class Solution {
    public int nthUglyNumber(int n) {
        if (n < 7) {
            return n;
        }

        int[] ugly = new int[n];
        ugly[0] = 1;
        int t2 = 0, t3 = 0, t5 = 0;
        for (int i = 1; i < n; ++i) {
            ugly[i] = Math.min(ugly[t2] * 2, Math.min(ugly[t3] * 3, ugly[t5] * 5));
            if (ugly[i] == ugly[t2] * 2) {
                t2++;
            }
            if (ugly[i] == ugly[t3] * 3) {
                t3++;
            }
            if (ugly[i] == ugly[t5] * 5) {
                t5++;
            }
        }

        return ugly[n - 1];
    }
}
