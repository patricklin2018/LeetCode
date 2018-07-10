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
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < answers.length; ++i) {

            if (answers[i] == 0) {
                counter += 1;
                continue;
            }
            else if (! hash.containsKey(answers[i])) {
                hash.put(answers[i], 1);
                counter += answers[i] + 1;
            }
            else {
                if (hash.get(answers[i]) < (answers[i] + 1)) {
                    hash.put(answers[i], hash.get(answers[i]) + 1);
                }
                else {
                    hash.put(answers[i], 1);
                    counter += answers[i] + 1;
                }
            }
        }

        return counter;
    }

}
