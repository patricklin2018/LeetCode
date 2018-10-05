package No3;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Patrick-lenovo
 * @create 2018/6/16 22:25
 *
 * lengthOfLongestSubstring - 无重复字符的最长子串
 *
 **/

class Solution {

    public int lengthOfLongestSubstring(String s) {
        int sz = s.length();
        Map<Character, Integer> map = new HashMap<>();

        int res = 0;
        for (int i = 0, j = 0; j < sz; ++j) {
            // 重复且重复处位于 i 和 j 之间
            if (map.containsKey(s.charAt(j)) && map.get(s.charAt(j)) + 1 > i) {
                i = map.get(s.charAt(j)) + 1;
            }

            map.put(s.charAt(j), j);

            res = Math.max(j - i + 1, res);
        }

        return res;
    }

    public static void main(String[] args) {
        String s = new String("abcabcbb");
        new Solution().lengthOfLongestSubstring(s);
    }
}
