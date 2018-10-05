package No14;
/**
 * @Author: patrick-mac
 * @Date: 2018/9/21 16:17
 * @Description:
 */
public class Solution {

    public static String longestCommonPrefix(String[] strs) {
        String res = "";

        if (strs == null || strs.length == 0) {
            return res;
        }

        res = strs[0];

        for (int i = 1; i < strs.length; ++i) {
            while (strs[i].indexOf(res) != 0) {
                res = res.substring(0, res.length() - 1);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String[] strs = {"a"};
        longestCommonPrefix(strs);
    }
}
