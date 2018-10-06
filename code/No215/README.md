# 215. 数组中的第K个最大元素

## 问题

在未排序的数组中找到第 **k** 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

**示例 1:**

```
输入: [3,2,1,5,6,4] 和 k = 2
输出: 5
```

**示例 2:**

```
输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
输出: 4
```

**说明:**

你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。

## 思路

利用快排的 partition，

若该 partition 刚好位置在 k，那么则该数就是 top k，

若该 partition 小于 k，即该 top k 在右边，那么对右边区间继续执行 partition 操作。

若该 partition 大于 k，即该 top k 在左边，那么对左边区间继续执行 partition 操作。

## 实现

[代码 - Java](Solution.java)

### 1. Java

```java
class Solution {
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
}
```