# 79. 单词搜索

## 问题

给定一个二维网格和一个单词，找出该单词是否存在于网格中。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

**示例:**

```
board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

给定 word = "ABCCED", 返回 true.
给定 word = "SEE", 返回 true.
给定 word = "ABCB", 返回 false.
```

## 思路

回溯，搜索字母表四个方向。

## 实现


```java
public class Solution {

    public boolean exist(char[][] table, String words) {
        if (table == null || table.length == 0 || table[0] == null || table[0].length == 0) {
            return false;
        }

        int r = table.length;
        int c = table[0].length;

        boolean[][] isVisited = new boolean[r][c];

        boolean res = false;
        for (int i = 0; i < r && res == false; ++i) {
            for (int j = 0; j < c; ++j) {
                if (exist(table, words, i, j, 0, isVisited)) {
                    res = true;
                    break;
                }
            }
        }

        return res;
    }

    public static boolean exist(char[][] table, String word, int i, int j, int idx, boolean[][] isVisited) {
        if (idx == word.length()) {
            return true;
        }

        if (i < 0 || i >= table.length || j < 0 || j >= table[0].length ||
                isVisited[i][j] == true || word.charAt(idx) != table[i][j]) {
            return false;
        }

        isVisited[i][j] = true;

        boolean isExist =  exist(table, word, i - 1, j, idx + 1, isVisited) ||
                exist(table, word, i + 1, j, idx + 1, isVisited) ||
                exist(table, word, i, j - 1, idx + 1, isVisited) ||
                exist(table, word, i, j + 1, idx + 1, isVisited);

        isVisited[i][j] = false;

        return isExist;
    }
}
```