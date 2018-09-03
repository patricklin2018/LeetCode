# 220. 存在重复的元素 III

## 问题

给定一个整数数组，判断数组中是否有两个不同的索引 *i* 和 *j*，使得 **nums [i]** 和 **nums [j]** 的差的绝对值最大为 *t*，并且 *i* 和 *j* 之间的差的绝对值最大为 *ķ*。

**示例 1:**

```
输入: nums = [1,2,3,1], k = 3, t = 0
输出: true
```

**示例 2:**

```
输入: nums = [1,0,1,1], k = 1, t = 2
输出: true
```

**示例 3:**

```
输入: nums = [1,5,9,1,5,9], k = 2, t = 3
输出: false
```

## 思路

首先，解决数值绝对值差的问题，采用桶排序（bucket sorting）的思想，将一个区间分布的放在同一个桶。比如 `t = 5` 时，将 `0 - 5` 、 `6 - 11` 、... 分别分桶。那么，如果两个数值绝对差在 `t` 内，那么这两个数值必定在**同一个桶或相邻桶**。因此，采用 `Map` 数据结构，记录每个桶的数值，方便验证邻桶的数值绝对差是否小于 `t`。

本题中，若不允许 `nums` 为负值的情况下，桶的 ID 为 `bucket = nums / (t + 1)` 。然而，本题 `nums` 存在负值情况，因此，可将所有值进行平移，即将 `nums - Integer.MIN_VALUE` ，使得所有数值从 `0` 开始，因此，本题中，桶的 ID 计算如下：

`long bucket = ((long) mums - Integer.MIN_VALUE) / ((long) t + 1)`

其次，解决下标绝对值差的问题，当遍历下标大于 `k` 时，对 `i - k` 的值计算桶 ID 并移出 `Map` 。

## 实现

[代码 - JAVA](Solution.java)

```java
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
```

