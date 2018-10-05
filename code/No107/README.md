# 107. 二叉树的层次遍历 II

## 问题

给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）

例如：
给定二叉树 `[3,9,20,null,null,15,7]`,

```
    3
   / \
  9  20
    /  \
   15   7
```

返回其自底向上的层次遍历为：

```
[
  [15,7],
  [9,20],
  [3]
]
```

## 思路

### 思路1

同样采用队列构建 BFS 过程，不同的是，每次循环将该层的序列插入到最前面。

### 思路2

用递归实现 DFS，根据该 level 插入不同位置。

## 实现

| 思路  | 代码 | 链接                  |
| ----- | ---- | --------------------- |
| 思路1 | Cpp  | N/A                   |
| 思路2 | Java | [link](Solution.java) |

### 思路1 - Cpp

```cpp
vector<vector<int>> levelOrderBottom(TreeNode* root) {
	vector<vector<int>> res;
	if (root == nullptr)
		return res;

	queue<TreeNode*> que;
	que.push(root);
	vector<int> elm(1, root->val);
	res.push_back(elm);
	while (!que.empty()){
		int sizeCurLevel = que.size();
		vector<int> elm;
		while (sizeCurLevel--){
			auto node = que.front();
			que.pop();
			if (node->left){
				que.push(node->left);
				elm.push_back(node->left->val);
			}
			if (node->right){
				que.push(node->right);
				elm.push_back(node->right->val);
			}
		}
		if (!elm.empty())
			res.insert(res.begin(), elm);
	}
	return res;
}
```

### 思路2 - Java

```java
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
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
```