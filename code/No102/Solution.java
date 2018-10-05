package No102;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: patrick-mac
 * @Date: 2018/10/5 22:12
 * @Description:
 */
public class Solution {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null)
            return res;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()) {
            int sz = que.size();
            List<Integer> curLevel = new LinkedList<>();
            while (sz-- > 0) {
                TreeNode tmp = que.poll();
                if (tmp.left != null)
                    que.offer(tmp.left);
                if (tmp.right != null)
                    que.offer(tmp.right);
                curLevel.add(tmp.val);
            }
            res.add(curLevel);
        }

        return res;
    }

}
