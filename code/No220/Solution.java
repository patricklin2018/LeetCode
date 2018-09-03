package No220;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: patrick-mac
 * @Date: 2018/9/3 08:48
 * @Description:
 */
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || t < 0 || k < 1) {
            return false;
        }

        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            long remappedNum = (long)nums[i] - Integer.MIN_VALUE;
            long bucket = getBucket(remappedNum, (long)t + 1);
            // 检测同一个桶
            if (map.containsKey(bucket)) {
                return true;
            }
            // 检测邻桶
            if (map.containsKey(bucket - 1) && Math.abs(map.get(bucket - 1) - remappedNum) <= t) {
                return true;
            }
            if (map.containsKey(bucket + 1) && Math.abs(map.get(bucket + 1) - remappedNum) <= t) {
                return true;
            }
            map.put(bucket, remappedNum);
            if (i >= k) {
                map.remove(getBucket((long)nums[i - k] - Integer.MIN_VALUE, t + 1));
            }
        }
        return false;
    }

    public long getBucket(long i, long t) {
        // i >= 0
        return i / t;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2};
        int k = 1, t = 1;
        new Solution().containsNearbyAlmostDuplicate(nums, k, t);
    }
}