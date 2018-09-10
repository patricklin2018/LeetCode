# 547. 朋友圈

## 问题

班上有 **N** 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。

给定一个 **N \* N** 的矩阵 **M**，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生**互为**朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。

**示例 1:**

```
输入: 
[[1,1,0],
 [1,1,0],
 [0,0,1]]
输出: 2 
说明：已知学生0和学生1互为朋友，他们在一个朋友圈。
第2个学生自己在一个朋友圈。所以返回2。
```

**示例 2:**

```
输入: 
[[1,1,0],
 [1,1,1],
 [0,1,1]]
输出: 1
说明：已知学生0和学生1互为朋友，学生1和学生2互为朋友，所以学生0和学生2也是朋友，所以他们三个在一个朋友圈，返回1。
```

**注意：**

1. N 在[1,200]的范围内。
2. 对于所有学生，有M[i][i] = 1。
3. 如果有M[i][j] = 1，则有M[j][i] = 1。

## 思路

DFS:

利用一个 isVisited[M] 数组记录是否访问过该行。采用递归方式实现 DFS 遍历，即，第 i 个人，若与 j 为好友，则遍历 j 的好友，将其的所有好友也标记为访问。

## 实现

[代码 - Java](Solution.java)

```java
/**
 * @Author: patrick-mac
 * @Date: 2018/9/10 11:56
 * @Description:
 */
public class Solution {

    public int findCircleNum(int[][] M) {

        if (M == null || M.length == 0) {
            return 0;
        }

        int n = M.length;
        boolean[] isVisited = new boolean[n];

        int counter = 0;
        for (int i = 0; i < n; ++i) {
            if (isVisited[i] == false) {
                isVisited[i] = true;
                dfs(M, isVisited, i);
                counter++;
            }
        }

        return counter;
    }

    public void dfs(int[][] M, boolean[] isVisited, int i) {

        for (int j = 0; j < M.length; ++j) {
            if (M[i][j] == 1 && isVisited[j] == false) {
                isVisited[j] = true;
                dfs(M, isVisited, j);
            }
        }

    }

}
```

