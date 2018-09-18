package No233;

/**
 * @Author: patrick-mac
 * @Date: 2018/9/18 14:50
 * @Description:
 */
public class Solution {

    public int countDigitOne(int n) {
        if (n < 0) {
            return 0;
        }

        long i = 1;
        int counter = 0;
        while (n / i != 0) {
            int cur = (int) ((n / i) % 10);
            int pre = (int) (n / (i * 10));
            int aft = (int) (n - (n / i) * i);

            counter += pre * i + (cur == 0 ? 0 : cur == 1 ? aft + 1 : i);
            i *= 10;
        }
        return counter;
    }

}
