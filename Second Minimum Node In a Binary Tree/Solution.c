// Problem link: https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/description/
// Status: Accepted

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
int findMin(int a, int b, int smallestVal) {
    if(a == -1 && b == -1 || a == smallestVal && b == smallestVal) return -1;
    if(a == -1 || b == -1) return a == -1 ? b : a;
    if(a == smallestVal || b == smallestVal) return a == smallestVal ? b : a;
    return a < b ? a : b;
}

int helper(struct TreeNode* root, int smallestVal) {
    if(root->right != NULL && root->left != NULL) {
        return findMin(findMin(root->right->val, root->left->val, smallestVal),
               findMin(helper(root->right, smallestVal), helper(root->left, smallestVal), smallestVal),
               smallestVal);
    }
    return -1;
}

int findSecondMinimumValue(struct TreeNode* root) {
    return helper(root, root->val);
}
