## 105. 从前序与中序遍历序列构造二叉树

### 问题

根据一棵树的前序遍历与中序遍历构造二叉树。

**注意:**
你可以假设树中没有重复的元素。

例如，给出

```
前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
```

返回如下的二叉树：

```
    3
   / \
  9  20
    /  \
   15   7
```

### 思路

前序 + 中序 构建二叉树：

由于前序总是会先访问根节点再访问该根节点的左子树和右子树，而中序总是会先访问左子树，再访问根节点和右子树。
因此，结合两者，通过前序确认根节点，随后根据中序顺序，先于该根节点必为该节点的左子树，而后于该节点的必为该节点的右子树。如此循环，最终确定整科树。

以前序 `{1,2,4,7,3,5,6,8}` 和中序遍历序列 `{4,7,2,1,5,3,8,6}` 为例子。

```java
1，通过前序第一个数值，知根为 1，查找 1 在中序的位置
2，中序 1 的左边 {4, 7, 2} 为左子树部分，与对应数量的前序序列 {2, 4, 7} 进入递归，构建该子树
3，中序 1 的右边 {5, 3, 8, 6} 为右子树部分，与对应数量的前序序列 {3, 5, 6, 8} 进入递归，构建该子树
```

### 代码

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }

        // 1. 确定根节点
        TreeNode root = new TreeNode(preorder[0]);

        for (int i = 0; i < preorder.length; ++i) {
            if (preorder[0] == inorder[i]) {
                // 2. 中序根节点的左边为左子树，进入递归构建子树
                root.left = buildTree(Arrays.copyOfRange(preorder, 1, 1 + i), Arrays.copyOfRange(inorder, 0, i));
                // 3. 中序根节点的右边为右子树，进入递归构建子树
                root.right = buildTree(Arrays.copyOfRange(preorder, i + 1, preorder.length), Arrays.copyOfRange(inorder, i + 1, inorder.length));
                break;
            }
        }

        return root;
    }
}
```

