## 101. Symmetric Tree

------

给定一个二叉树，检查它是否是镜像对称的。

例如，二叉树 `[1,2,2,3,4,4,3]` 是对称的。

```
    1
   / \
  2   2
 / \ / \
3  4 4  3
```

但是下面这个 `[1,2,2,null,3,null,3]` 则不是镜像对称的:

```
    1
   / \
  2   2
   \   \
   3    3
```

**说明:**

如果你可以运用递归和迭代两种方法解决这个问题，会很加分。

## 思路

递归版本：

思路很简单，实现起来也很简单，类似 DFS 的递归过程。

非递归版本：

利用 BFS 遍历，每一层都借用一个数组或 Vector 等之类的数据结构验证对称性，需要注意键值为 `null`  的情况。

## 实现

### 1. CPP

Iteratively, 非递归。

```cpp
bool isSymmetric(TreeNode* root) {
	if (root == nullptr)
	    return true;
	    
	queue<TreeNode*> que;
	que.push(root);
	while (!que.empty()){
		int sizeQue = que.size();
		vector<int> vals;
		while (sizeQue--){
			TreeNode* node = que.front();
			que.pop();
			if (node->left){
				que.push(node->left);
				vals.push_back(node->left->val);
			}
			else{
				vals.push_back(NULL);
			}
			if (node->right){
				que.push(node->right);
				vals.push_back(node->right->val);
			}
			else{
				vals.push_back(NULL);
			}
		}
		int sizeVec = vals.size();
		if (sizeVec & 1 == 1){
			return false;
		}
		for (int i = 0, j = sizeVec - 1; i < j; ++i, --j){
			if (vals[i] != vals[j]){
				return false;
			}
		}
	}
	return true;
```

Recursively， 递归
```cpp
bool isSymmetric(TreeNode* left, TreeNode* right){
	if (!left || !right) return left == right;
	if (left->val != right->val) return false;
	return isSymmetric(left->left, right->right) && isSymmetric(left->right, right->left);
}

bool isSymmetric(TreeNode* root) {
	return root == nullptr || isSymmetric(root->left, root->right);
}
```
这里 `if (!left || !right) return left == right;` 语句中，如果左右均为空，则其值皆为 `NULL` ，所以返回 `true` ，如果左右仅一者为空，则返回 `false`

### 2. Java

```java
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetric(root.left, root.right);
    }
    
    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }
        else if (left.val != right.val) {
            return false;
        }
        else {
            return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
        }
    }
}
```

