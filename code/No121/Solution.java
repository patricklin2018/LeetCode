package No121;

/**
 * @Author: patrick-mac
 * @Date: 2018/10/18 08:16
 * @Description:
 */
public class Solution {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int dp = 0;
        int max = 0;
        for (int i = 1; i < prices.length; ++i) {
            dp = Math.max(0, dp + prices[i] - prices[i - 1]);
            if (dp > max) {
                max = dp;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] ary = {7, 1, 5, 3, 6, 4};
        new Solution().maxProfit(ary);
    }
}
