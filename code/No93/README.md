# 93. 复原 IP 地址

## 问题

给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。

**示例:**

```
输入: "25525511135"
输出: ["255.255.11.135", "255.255.111.35"]
```

## 思路

通过 3 个 for 循环定格第一、二、三个子串，剩下的自然为第四个子串。接着验证这个子串的有效性。

有效性的验证主要三点：

* 长度为 1 - 3
* 长度大于 1 时，charAt(0) 不能为 0
* 转换为 int，大小为 0 - 255

## 实现

[代码 - Java](Solution.java)

```java
/**
 * @Author: patrick-mac
 * @Date: 2018/9/11 09:14
 * @Description:
 */
public class Solution {

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();

        int sz = s.length();
        for (int i = 1; i < sz && i <= 3; ++i) {
            for (int j = i + 1; j < sz && j <= i + 3; ++j) {
                for (int k = j + 1; k < sz && k <= j + 3; ++k) {
                    String a = s.substring(0, i);
                    String b = s.substring(i, j);
                    String c = s.substring(j, k);
                    String d = s.substring(k, sz);
                    if (isValid(a) && isValid(b) && isValid(c) && isValid(d)) {
                        res.add(a + "." + b + "." + c + "." + d);
                    }
                }
            }
        }

        return res;
    }

    public boolean isValid(String n) {
        if (n.length() == 0 || n.length() > 3 || (n.length() > 1 && n.charAt(0) == '0') || Integer.parseInt(n) > 255) {
            return false;
        }
        return true;
    }
}
```

