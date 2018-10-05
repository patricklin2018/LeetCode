package No547;

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

    public static void main(String[] args) {
        int[][] num = {{ 1, 1, 0}, { 1, 1, 0}, { 0, 0, 1}};
        new Solution().findCircleNum(num);
    }

}
