// Problem link: https://leetcode.com/problems/convert-bst-to-greater-tree/description/
// Status: Accepted

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
int sum;

void helper(struct TreeNode* root) {
    if(root == NULL) return;
    helper(root->right);
    if(sum == 0) sum += root->val;
    else {
        sum += root->val;
        root->val = sum;
    }
    helper(root->left);
}

struct TreeNode* convertBST(struct TreeNode* root) {
    sum = 0;
    helper(root);
    return root;
}
