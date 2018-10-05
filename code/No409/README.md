## 409. 最长回文串

### 问题

给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。

在构造过程中，请注意区分大小写。比如 `"Aa"` 不能当做一个回文字符串。

注意:
假设字符串的长度不会超过 1010。

**示例 1:**
```
输入:
"abccccdd"

输出:
7

解释:
我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
```

### 思路

通过记录各个字母的出现字数，计算最长回文长度。需要注意的是，从 `ASCII 表` 可以查到，`A` 字符为 `65`，`z` 字符则为 `122`，

因此，只需要定义一个 `122 - 65 = 58` 大小的数组便可记录该字符串的字符出现次数。

步骤为：
```
1. 统计各个字母出现次数
2. 遍历统计表，计算该数可取的最大偶数，并判断是否为奇数，若奇数则 odd = true
3. 返回结果，若 odd = true， 则结果 +1
```

### 实现

[代码-JAVA](Solution.java)

```java
public int longestPalindrome(String s) {

    int[] recorded = new int[58];
    char[] cs = s.toCharArray();

    for (char c : cs) {
        recorded[c - 'A'] ++;
    }

    boolean odd = false;
    int counter = 0;
    for (int val : recorded) {
        counter += (val / 2) * 2;
        if (odd == false && val % 2 != 0) {
            odd = true;
        }
    }

    return odd == true ? counter + 1 : counter;
}
```