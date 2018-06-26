// Problem link: https://leetcode.com/problems/path-sum/description/
// Status: Accepted

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
bool helper(struct TreeNode* root, int sum) {
    sum -= root->val;
    if(root->right == NULL && root->left == NULL) return sum == 0;
    bool left = 0, right = 0;
    if(root->right != NULL) right = helper(root->right, sum);
    if(root->left != NULL) left = helper(root->left, sum);
    return left || right;
}

bool hasPathSum(struct TreeNode* root, int sum) {
    if(root == NULL) return false;
    return helper(root, sum);
}
