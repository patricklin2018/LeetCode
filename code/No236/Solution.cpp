//
//  Created by Patrick-Lin on 15/12/4.
//  Copyright © 2015年 Patrick-Lin. All rights reserved.
//

class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if(!root||root==p||root==q)
            return root;
        TreeNode* left=lowestCommonAncestor(root->left,p,q);
        TreeNode* right=lowestCommonAncestor(root->right,p,q);
        return !left?right:!right?left:root;
};