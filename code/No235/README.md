# 235. 二叉搜索树的最近公共祖先

## 问题

给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。

[百度百科](https://baike.baidu.com/item/%E6%9C%80%E8%BF%91%E5%85%AC%E5%85%B1%E7%A5%96%E5%85%88/8918834?fr=aladdin)中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（**一个节点也可以是它自己的祖先**）。”

例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]

```
        _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5
```

**示例 1:**

```
输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
输出: 6 
解释: 节点 2 和节点 8 的最近公共祖先是 6。
```

**示例 2:**

```
输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
输出: 2
解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
```

**说明:**

- 所有节点的值都是唯一的。
- p、q 为不同节点且均存在于给定的二叉搜索树中。

## 思路

充分利用二叉搜索树的特性，即其父亲节点大于其左子树，小于右子树。

因此，若有节点大于 p、q 节点，必然，该最近祖先必然在当前节点的左子树。

相应，若有节点小于 p、q 节点，必然，该最近祖先必然在当前节点的右子树。

否则，必然介于 p、q 节点之间，那么该节点必然为最近祖先。

## 实现

[代码 - Java](Solution.java)

### 1. Java


```java
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
```