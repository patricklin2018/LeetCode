/**
 * @Author: patrick-mac
 * @Date: 2018/9/21 10:48
 * @Description:
 */
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
