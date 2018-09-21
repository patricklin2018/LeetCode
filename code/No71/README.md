# 71. 简化路径

## 问题

给定一个文档 (Unix-style) 的完全路径，请进行路径简化。

例如，
**path** = `"/home/"`, => `"/home"`
**path** = `"/a/./b/../../c/"`, => `"/c"`

**边界情况:**

- 你是否考虑了 路径 = `"/../"` 的情况？
  在这种情况下，你需返回 `"/"` 。
- 此外，路径中也可能包含多个斜杠 `'/'` ，如 `"/home//foo/"` 。
  在这种情况下，你可忽略多余的斜杠，返回 `"/home/foo"` 。

## 思路

先将路径根据 "/" 进行切割。摘取有效路径入栈，若遇见 ".." 上一级则出栈。

## 实现

[代码 - Java](Solution.java)

### 1. Java
```java
class Solution {
    public String simplifyPath(String path) {
        String[] pathes = path.split("/");

        Stack<String> stack = new Stack<>();
        for (int i = 0; i < pathes.length; ++i) {
            if (!pathes[i].equals("/") && !pathes[i].equals(".") && !pathes[i].equals("") && !pathes[i].equals("..")) {
                stack.push(pathes[i]);
            }
            else if (pathes[i].equals("..") && !stack.isEmpty()) {
                stack.pop();
            }
        }

        return "/" + String.join("/", stack);
    }
}
```