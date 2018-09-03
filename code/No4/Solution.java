/**
 * @Author: patrick-mac
 * @Date: 2018/9/3 16:18
 * @Description:
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        // 确保 nums2 比 nums1 大
        if (m > n) {
            int[] tmp = nums1; nums1 = nums2; nums2 = tmp;
            int temp = m; m = n; n = temp;
        }
        int iMin = 0, iMax = m;
        int halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && nums2[j - 1] > nums1[i]) {
                iMin = i + 1;
            }
            else if (i > iMin && nums1[i - 1] > nums2[j]) {
                iMax = i - 1;
            }
            else {
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = nums2[j - 1];
                }
                else if (j == 0) {
                    maxLeft = nums1[i - 1];
                }
                else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }

                // 如果两个数组的长度和是奇数，那么 maxLeft 即为中位数
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }

                // 否则中位数为 (maxLeft + minRight) / 2
                int minRight =  0;
                if (i == m) {
                    minRight = nums2[j];
                }
                else if (j == n) {
                    minRight = nums1[i];
                }
                else {
                    minRight = Math.min(nums1[i], nums2[j]);
                }

                return (minRight + maxLeft) / 2.0;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        new Solution().findMedianSortedArrays(nums1, nums2);
    }
}