## 106. 从中序与后序遍历序列构造二叉树

### 问题

根据一棵树的中序遍历与后序遍历构造二叉树。

**注意:**
你可以假设树中没有重复的元素。

例如，给出

```
中序遍历 inorder = [9,3,15,20,7]
后序遍历 postorder = [9,15,7,20,3]
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

中序 + 后序 构建二叉树：

与前序 + 中序思路相似。由于中序总是会先访问左子树，再访问根节点和右子树，而后序总是先访问左子树，再访问右子树，最后才访问根节点。
因此，结合两者，通过后序确认根节点，随后根据中序顺序，先于该根节点必为该节点的左子树，而后于该节点的必为该节点的右子树。如此循环，最终确定整科树。

以中序遍历序列 `[9,3,15,20,7]` 和后序遍历序列`[9,15,7,20,3]`为例子。

```java
1，通过后序最后一个数值 3，即根节点为 3，在中序查找 3 对应位置
2，中序 3 的左边 {9} 为左子树部分，与对应数量的后序序列 {9} 进入递归，构建该子树
3，中序 3 的右边 {15, 20, 7} 为右子树部分，与对应数量的前序序列 {15, 7, 20} 进入递归，构建该子树
```

**注意：**

与 前序 + 中序 [105 - 从前序与中序遍历序列构造二叉树](../105/) 不同的是，for 循环添加了一个 `sz != 1` 控制条件，避免传入 `inorder = {9}, postorder = {9}` 陷入死循环。

### 代码

[代码 - JAVA](Solution.java)

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
}
```

