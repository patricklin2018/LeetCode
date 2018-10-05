package No235;

/**
 * @Author: patrick-mac
 * @Date: 2018/10/6 00:28
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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            }
            else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            }
            else {
                return root;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode fir = new TreeNode(6);
        TreeNode sec = new TreeNode(2);
        TreeNode thir = new TreeNode(8);
        fir.left = sec;
        fir.right = thir;
        TreeNode p4 = new TreeNode(0);
        TreeNode p5 = new TreeNode(4);
        sec.left = p4;
        sec.right = p5;
        TreeNode p6 = new TreeNode(7);
        TreeNode p7 = new TreeNode(9);
        thir.left = p6;
        thir.right = p7;
        TreeNode p8 = new TreeNode(3);
        TreeNode p9 = new TreeNode(5);
        p5.left = p8;
        p5.right = p9;
        new Solution().lowestCommonAncestor(fir, p8, p9);
    }

}
