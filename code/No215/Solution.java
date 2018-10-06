package No215;

/**
 * @Author: patrick-mac
 * @Date: 2018/10/6 14:15
 * @Description:
 */
public class Solution {

    public static int findKthLargest(int[] nums, int k) {
        assert nums != null && nums.length != 0 && k <= nums.length;

        return partition(nums, 0, nums.length - 1, k - 1);
    }

    public static int partition(int[] nums, int left, int right, int k) {
        // 随机标定
        swap (nums, (int)(Math.random() * (right - left + 1)) + left, left);
        int e = nums[left];
        int p = left;
        for (int i = left + 1; i <= right; ++i) {
            if (nums[i] > e) {
                p++;
                swap(nums, i, p);
            }
        }
        swap(nums, p, left);
        if (k == p) {
            return nums[k];
        }
        else if (k < p) {
            return partition(nums, left, p - 1, k);
        }
        else {
            return partition(nums, p + 1, right, k);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] ary = {3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargest(ary, 4));
    }
}
