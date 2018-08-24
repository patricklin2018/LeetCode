## 3. Longest Substring Without Repeating Characters

### Problem
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given `"abcabcbb"`, the answer is `"abc"`, which the length is 3.

Given `"bbbbb"`, the answer is `"b"`, with the length of 1.

Given `"pwwkew"`, the answer is `"wke"`, with the length of 3. Note that the answer must be a substring, `"pwke"` is a subsequence and not a substring.

### Solution

用 i 和 j 分别指向该子串的前后， j 向后移动的过程如果遇到与字串中字符一样，则将 i 移动至重复处之后。

| 方法 | 备注 | C++ | Java |
|---|---|---|---|
| solution | hash | |[java](lengthOfLongestSubstring.java) | 