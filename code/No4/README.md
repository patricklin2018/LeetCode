# 4. 两个排序数组的中位数

## 问题

给定两个大小为 m 和 n 的有序数组 **nums1** 和 **nums2** 。

请找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n)) 。

你可以假设 **nums1** 和 **nums2** 不同时为空。

**示例 1:**

```
nums1 = [1, 3]
nums2 = [2]

中位数是 2.0
```

**示例 2:**

```
nums1 = [1, 2]
nums2 = [3, 4]

中位数是 (2 + 3)/2 = 2.5
```

## 思路

[思路详解](https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/)

假设 i、j 分别为 nums1、nums2 的割点，首先理清 i 和 j 的关系，求的中位数，也就是说：

`(nums1.length + nums2.length + 1) / 2 = i + j`

接下来，寻找中位数的思路为寻找到一个合适的 i、j 点，使得

`maxLeft < minRight`

其中，在不考虑临界值的情况下，`maxLeft = max(nums1[i - 1], nums2[j - 1])` ，`minRight = min(nums1[i], nums2[j])` 。

最后，若两个数组长度之和为奇数，则中位数为 `maxLeft` ，否则，中位数为 `(maxLeft + minRight) / 2`。

至于临界值情况等细节，详见以上链接。

## 实现

[代码 - Java](Solution.java)


```java
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
}
```