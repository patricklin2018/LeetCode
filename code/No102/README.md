# 102. 二叉树的层次遍历

## 问题

给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。

例如:
给定二叉树: `[3,9,20,null,null,15,7]`,

```
    3
   / \
  9  20
    /  \
   15   7
```

返回其层次遍历结果：

```
[
  [3],
  [9,20],
  [15,7]
]
```

## 思路

采用队列，每次循环时，从队列中取出当前队列的数量个数，即当前 level 的节点数。

## 实现

| 方法  | 代码 | 链接                  |
| ----- | ---- | --------------------- |
| 思路1 | CPP  | N/A                   |
| 思路1 | Java | [link](solution.java) |

### 1. CPP

```cpp
vector<vector<int>> levelOrder(TreeNode* root) {
	vector<vector<int>> res;
	if (!root)
		return res;
	queue<TreeNode*> que;
	que.push(root);
	while (!que.empty()){
		int curLevelSize = que.size();
		vector<int> curLevelRes;
		while (curLevelSize--){
			TreeNode* node = que.front();
			que.pop();
			curLevelRes.push_back(node->val);
			if (node->left)
				que.push(node->left);
			if (node->right)
				que.push(node->right);
		}
		res.push_back(curLevelRes);
	}
	return res;
}
```

### 2. Java

```java
class Solution {
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
```

