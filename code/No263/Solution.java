package No263;

/**
 * @Author: patrick-mac
 * @Date: 2018/9/18 16:33
 * @Description:
 */
public class Solution {

    public boolean isUgly(int num) {
        if (num == 0) {
            return false;
        }
        if (num == 1) {
            return true;
        }
        while (num % 2 == 0) {
            num = num >> 1;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        return num == 1;
    }

    public static void main(String[] args) {
        new Solution().isUgly(8);
    }
}
