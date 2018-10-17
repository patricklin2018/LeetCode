package No112;

/**
 * @Author: patrick-mac
 * @Date: 2018/10/18 00:25
 * @Description:
 */
public class Solution {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {val = x;}
    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && root.val == sum) {
            return true;
        }

        int residue = sum - root.val;
        return hasPathSum(root.left, residue) || hasPathSum(root.right, residue);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        hasPathSum(root, 1);
    }
}
