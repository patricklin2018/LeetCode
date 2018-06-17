import java.util.HashMap;
import java.util.Map;

/**
 * @author Patrick-lenovo
 * @create 2018/6/16 22:25
 *
 * lengthOfLongestSubstring - 无重复字符的最长子串
 *
 **/

class lengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int size = s.length();
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; j < size; ) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)) + 1, i);
            }
            map.put(s.charAt(j), j);
            j++;
            res = Math.max(res, j - i);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = new String("abba");
        new lengthOfLongestSubstring().lengthOfLongestSubstring(s);
    }
}
