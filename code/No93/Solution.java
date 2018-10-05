package No93;

import java.util.ArrayList;
import java.util.List;

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

    public static void main(String[] args) {
        String str = "25525511135";
        new Solution().restoreIpAddresses(str);
    }
}
