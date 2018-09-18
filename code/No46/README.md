# 46. 全排列

## 问题

给定一个**没有重复**数字的序列，返回其所有可能的全排列。

**示例:**

```
输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
```

## 思路

回溯法，通过递归的方式，第一轮递归确定好第一个数字，第二轮递归确定好第二个数字，……，直到最后一个数字。

需要注意的是，需要验证当前位数字是否与前一位数字重复，若重复跳过，否则造成排列重复。

## 实现

[代码 - JAVA](Solution.java)

### 1. Java

```java
class Solution {
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
}
```

