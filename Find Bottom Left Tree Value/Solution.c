// Problem link: https://leetcode.com/problems/find-bottom-left-tree-value/description/
// Status: Accepted

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
struct TreeNode* node;
int foundLevel;

void dfs(struct TreeNode* root, int level) {
    if(root == NULL) return;
    dfs(root->left, level + 1);
    if(node == NULL || level > foundLevel) {
        node = root;
        foundLevel = level;
    }
    dfs(root->right, level + 1);
}
int findBottomLeftValue(struct TreeNode* root) {
    node = NULL;
    foundLevel = -1;
    dfs(root, 0);
    return node->val;
}
