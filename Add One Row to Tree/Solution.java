// Problem link: https://leetcode.com/problems/add-one-row-to-tree/description/
// Status: Accepted

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
void helper(struct TreeNode* root, int v, int d, int level) {
    if(root == NULL) return;
    if(level + 1 == d) {
        struct TreeNode *rootLeft = (struct TreeNode *) malloc(sizeof(struct TreeNode) * 1);
        rootLeft->val = v;
        rootLeft->left = root->left;
        rootLeft->right = NULL;
        struct TreeNode *rootRight = (struct TreeNode *) malloc(sizeof(struct TreeNode) * 1);
        rootRight->val = v;
        rootRight->left = NULL;
        rootRight->right = root->right;
        root->left = rootLeft;
        root->right = rootRight;
        return;
    } else {
        helper(root->left, v, d, level + 1);
        helper(root->right, v, d, level + 1);
    }
}

struct TreeNode* addOneRow(struct TreeNode* root, int v, int d) {
    if(root == NULL) return NULL;
    else if(d == 1) {
        struct TreeNode *newRoot = (struct TreeNode *) malloc(sizeof(struct TreeNode) * 1);
        newRoot->val = v;
        newRoot->left = root;
        newRoot->right = NULL;
        return newRoot;
    }
    helper(root, v, d, 1);
    return root;
}
