# 414. 第三大的数

## 问题

给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。

**示例 1:**

```
输入: [3, 2, 1]

输出: 1

解释: 第三大的数是 1.
```

**示例 2:**

```
输入: [1, 2]

输出: 2

解释: 第三大的数不存在, 所以返回最大的数 2 .
```

**示例 3:**

```
输入: [2, 2, 3, 1]

输出: 1

解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
存在两个值为2的数，它们都排第二。
```

## 思路

定义三个变量，分别保存最大、第二大、第三大的变量，分别为 `max1, max2, max3`，遍历数组过程中，若等于三个变量中任何一个，则 `continue` 否则，验证是否大于三个变量中的一个。

## 实现

[代码 - JAVA](Solution.java)

### 1. Java

```java
class Solution {
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
}
```



