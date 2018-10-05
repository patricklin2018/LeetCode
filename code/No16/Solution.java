package No16;

import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // 1. 排序
        Arrays.sort(nums);

        int gap = Integer.MAX_VALUE;
        int sum = 0;
        // 2. 固定 i
        for (int i = 0; i <= nums.length - 3; ++i) {
            // 3. 设定双指针
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int tmp = nums[i] + nums[j] + nums[k];
                // 4. 更新 gap
                int tGap = target - tmp;
                if (Math.abs(tGap) < gap) {
                    gap = Math.abs(tGap);
                    sum = tmp;
                }
                // 4. 调整指针
                if (tmp < target)
                    j++;
                else
                    k--;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] num = {0,2,1,-3};
        new Solution().threeSumClosest(num, 1);
    }
}