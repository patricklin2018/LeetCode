package No123;

/**
 * @Author: patrick-mac
 * @Date: 2018/10/18 09:12
 * @Description:
 */
public class Solution {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int firstBuy = Integer.MIN_VALUE, secondBuy = Integer.MIN_VALUE;
        int firstSell = 0, secondSell = 0;

        for (int p : prices) {
            if (secondBuy + p > secondSell) {
                secondSell = secondBuy + p;
            }
            if (firstSell - p > secondBuy) {
                secondBuy = firstSell - p;
            }
            if (firstBuy + p > firstSell) {
                firstSell = firstBuy + p;
            }
            if (-p > firstBuy) {
                firstBuy = -p;
            }
        }

        return secondSell;
    }

    public static void main(String[] args) {
        int[] ary = {3,3,5,0,0,3,1,4};
        new Solution().maxProfit(ary);
    }
}
