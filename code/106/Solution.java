import javax.swing.tree.TreeNode;
import java.util.Arrays;

/**
 * @author PatrickLin
 * @date 2018/7/25 23:19
 * @description
 **/
public class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length ||
                inorder.length == 0 || postorder.length == 0) {
            return null;
        }

        int sz = postorder.length;
        TreeNode root = new TreeNode(postorder[sz - 1]);
        for (int i = 0; i < sz && sz != 1; ++i) {
            if (inorder[i] == postorder[sz - 1]) {
                root.left = buildTree(Arrays.copyOfRange(inorder, 0, i), Arrays.copyOfRange(postorder, 0, i));
                root.right = buildTree(Arrays.copyOfRange(inorder, i + 1, sz), Arrays.copyOfRange(postorder, i, sz - 1));
                break;
            }
        }

        return root;
    }

    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};

        new Solution().buildTree(inorder, postorder);
    }

}
