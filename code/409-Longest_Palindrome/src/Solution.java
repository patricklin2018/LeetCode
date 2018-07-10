package src;

import java.util.HashMap;
import java.util.Map;

/**
 * @author PatrickLin
 * @date 2018/7/10 20:41
 * @description
 *
 * 409. 最长回文串
 * https://leetcode-cn.com/problems/longest-palindrome/description/
 *
 **/
public class Solution {

    public int longestPalindrome(String s) {

        int[] recorded = new int[58];
        char[] cs = s.toCharArray();

        for (char c : cs) {
            recorded[c - 'A'] ++;
        }

        boolean odd = false;
        int counter = 0;
        for (int val : recorded) {
            counter += (val / 2) * 2;
            if (odd == false && val % 2 != 0) {
                odd = true;
            }
        }

        return odd == true ? counter + 1 : counter;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("abccccdd"));
    }

}
