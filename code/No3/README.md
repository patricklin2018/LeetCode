# 3. 无重复字符的最长子串

## 问题

给定一个字符串，找出不含有重复字符的**最长子串**的长度。

**示例 1:**

```
输入: "abcabcbb"
输出: 3 
解释: 无重复字符的最长子串是 "abc"，其长度为 3。
```

**示例 2:**

```
输入: "bbbbb"
输出: 1
解释: 无重复字符的最长子串是 "b"，其长度为 1。
```

**示例 3:**

```
输入: "pwwkew"
输出: 3
解释: 无重复字符的最长子串是 "wke"，其长度为 3。
     请注意，答案必须是一个子串，"pwke" 是一个子序列 而不是子串。
```

## 思路

利用 HashMap 存储所遍历过的字符，用 i 和 j 分别指向无重复子串的前后， j 向后移动的过程如果遇到与子串中字符重复的，即 HashMap 中检测到重复，则将 i 移动至重复字符处之后。

## 实现

[代码 - Java](Solution.java)

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int sz = s.length();
        Map<Character, Integer> map = new HashMap<>();

        int res = 0;
        for (int i = 0, j = 0; j < sz; ++j) {
            // 重复且重复处位于 i 和 j 之间
            if (map.containsKey(s.charAt(j)) && map.get(s.charAt(j)) + 1 > i) {
                i = map.get(s.charAt(j)) + 1;
            }

            map.put(s.charAt(j), j);

            res = Math.max(j - i + 1, res);
        }

        return res;
        
    }
}
```

