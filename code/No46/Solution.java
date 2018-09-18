import java.util.ArrayList;
import java.util.List;

/**
 * @Author: patrick-mac
 * @Date: 2018/9/18 08:50
 * @Description:
 */
public class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return res;
        }

        permute(nums, 0, res);

        return res;
    }

    public void permute(int[] nums, int idx, List<List<Integer>> res) {
        if (idx < nums.length) {
            for (int i = idx; i < nums.length; ++i) {
                if (idx >= 1 && nums[idx] == nums[idx - 1]) {
                    continue;
                }
                swap(nums, idx, i);
                permute(nums, idx + 1, res);
                swap(nums, idx, i);
            }
        }
        else {
            List<Integer> tmp = new ArrayList<>();
            for (int e : nums) {
                tmp.add(e);
            }
            res.add(tmp);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        new Solution().permute(nums);
    }
}
