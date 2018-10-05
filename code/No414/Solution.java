package No414;

/**
 * @Author: patrick-mac
 * @Date: 2018/9/18 08:20
 * @Description:
 */
public class Solution {
    public int thirdMax(int[] nums) {
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;
        for (Integer e : nums) {
            if (e.equals(max1) || e.equals(max2) || e.equals(max3)) {
                continue;
            }

            if (max1 == null || e > max1) {
                max3 = max2;
                max2 = max1;
                max1 = e;
            }
            else if (max2 == null || e > max2) {
                max3 = max2;
                max2 = e;
            }
            else if (max3 == null || e > max3) {
                max3 = e;
            }
        }

        return max3 != null ? max3 : max1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2};
        new Solution().thirdMax(nums);
    }
}
