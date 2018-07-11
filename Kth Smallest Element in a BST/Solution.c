// Problem link: https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
// Status: Accepted

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
int ans, i;

void helper(struct TreeNode* root, int k) {
    if(root == NULL || i > k) return;
    helper(root->left, k);
    if(i == k) ans = root->val;
    i++;
    helper(root->right, k);
}

int kthSmallest(struct TreeNode* root, int k) {
    ans = 0;
    i = 1;
    helper(root, k);
    return ans;
}
