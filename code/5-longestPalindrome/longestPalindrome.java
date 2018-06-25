/**
 * @author PatrickLin
 * @date 2018/6/26 0:22
 * @description 最长回文子串 - 中心扩展
 *
 * 找到回文的中心，向外扩展
 * 时间复杂度 = O(n^2)
 * 空间复杂度 = O（1）
 **/
public class longestPalindrome {
    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        int sz = s.length();
        for (int i = 0; i < sz; ++i) {
            // 假如回文为奇数，那么中心从第 i 个展开
            int len1 = ExpandRange(s, i, i);
            // 假设回文为偶数，那么中心从第 i 和 i + 1 展开
            int len2 = ExpandRange(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > (end - start + 1)) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int ExpandRange(String str, int left, int right) {
        int l = left, r = right;
        int sz = str.length();
        while (l >=0 && r < sz && str.charAt(l) == str.charAt(r)) {
            l--;
            r++;
        }
        // 这里 r - l - 1 而不是 r - l + 1
        // 是因为循环的最后一次，l--和r++不符合条件，因此 r - l + 1 需要 -2，最后等于该结果
        return r - l - 1;
    }

    // 测试
    public static void main(String[] args) {
        System.out.println(new longestPalindrome().longestPalindrome("babad"));
    }
}