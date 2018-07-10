package src;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author PatrickLin
 * @date 2018/7/10 20:04
 * @description 781. Rabbits in Forest
 **/
public class Solution {

    public int numRabbits(int[] answers) {

        if (answers == null || answers.length == 0) {
            return 0;
        }

        int counter = 0;
        int[] hash = new int[1000];
        for (int i = 0; i < answers.length; ++i) {

            if (answers[i] == 0) {
                counter += 1;
                continue;
            }

            hash[answers[i]] ++;

            if (hash[answers[i]] == 1) {
                counter += answers[i] + 1;
            }
            else if (hash[answers[i]] > answers[i] + 1) {
                hash[answers[i]] = 1;
                counter += answers[i] + 1;
            }
        }

        return counter;
    }

    public static void main(String[] args) {
        int[] ary = {0,0,1,1,1};
        System.out.println(new Solution().numRabbits(ary));
    }

}
