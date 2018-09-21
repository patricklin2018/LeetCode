# 14. 最长公共前缀

## 问题

编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 `""`。

**示例 1:**

```
输入: ["flower","flow","flight"]
输出: "fl"
```

**示例 2:**

```
输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。
```

**说明:**

所有输入只包含小写字母 `a-z` 。

## 思路

利用如下语句，即验证 indexOf 的结果是否为 0，若不为零就将该前缀缩短一个字符，直到结果为 0.

```java
while (strs[i].indexOf(res) != 0) {
	res = res.substring(0, res.length() - 1);
}
```

## 实现

```java
class Solution {
    public String longestCommonPrefix(String[] strs) {
        String res = "";

        if (strs == null || strs.length == 0) {
            return res;
        }

        res = strs[0];

         for (int i = 1; i < strs.length; ++i) {
            while (strs[i].indexOf(res) != 0) {
                res = res.substring(0, res.length() - 1);
            }
        }

        return res;
    }
}
```