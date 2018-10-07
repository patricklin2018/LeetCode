package No221;

/**
 * @Author: patrick-mac
 * @Date: 2018/10/7 20:40
 * @Description:
 */
public class Solution {

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int[][] dp = new int[matrix.length][matrix[0].length];
        int res = 0;
        for (int i = 0; i < matrix.length; ++i) {
            dp[i][0] = (matrix[i][0] == '1' ? 1 : 0);
            res = Math.max(res, dp[i][0]);
        }
        for (int j = 0; j < matrix[0].length; ++j) {
            dp[0][j] = (matrix[0][j] == '1' ? 1 : 0);
            res = Math.max(res, dp[0][j]);
        }

        for (int i = 1; i < matrix.length; ++i) {
            for (int j = 1; j < matrix[0].length; ++j) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }

        return res * res;
    }

    public static void main(String[] args) {
        char[][] c = {{'0','0','0','1'},
                      {'1','1','0','1'},
                      {'1','1','1','1'},
                      {'0','1','1','1'},
                      {'0','1','1','1'}};
        new Solution().maximalSquare(c);
    }
}
