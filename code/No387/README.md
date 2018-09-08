## 387. First Unique Character in a String

## 问题

给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

**案例:**

```
s = "leetcode"
返回 0.

s = "loveleetcode",
返回 2.
```

## 思路

利用无序容器建立字母hash表，再根据该字符串顺序，逐一进行查询，是否为 `Unique`。

## 实现

```cpp
int firstUniqChar(string s) {
    unordered_map<char, int> um;
    int index = 0;
    for (auto e : s){
        um[e]++;
    }
    for (auto e : s){
        if (um[e] < 2){
            return index;
        }
        index++;
    }
    return -1;
}
```