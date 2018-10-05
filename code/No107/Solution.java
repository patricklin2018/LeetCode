package No107;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: patrick-mac
 * @Date: 2018/10/5 22:46
 * @Description:
 */
public class Solution {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelOrderBottom(res, root, 0);
        return res;
    }

    public void levelOrderBottom(List<List<Integer>> res, TreeNode p, int level) {
        if (p == null)
            return;
        if (level >= res.size()) {
            res.add(0, new LinkedList<Integer>());
        }
        levelOrderBottom(res, p.left, level + 1);
        levelOrderBottom(res, p.right, level + 1);
        res.get(res.size() - level - 1).add(p.val);
    }

}
