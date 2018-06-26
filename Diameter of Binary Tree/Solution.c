// Problem link: https://leetcode.com/problems/diameter-of-binary-tree/description/
// Status: Accepted

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
struct LeafInfo {
    int deepest;
    int longestPathSize;
};

struct LeafInfo helper(struct TreeNode* root, int level, int longestPathSize, int deepest) {
    if(root == NULL) {
        struct LeafInfo s;
        s.deepest = level - 1;
        s.longestPathSize = longestPathSize;
        return s;
    }
    struct LeafInfo right = helper(root->right, level + 1, longestPathSize, deepest);
    if(right.longestPathSize > longestPathSize) longestPathSize = right.longestPathSize;
    struct LeafInfo left = helper(root->left, level + 1, longestPathSize, deepest);
    if(left.longestPathSize > longestPathSize) longestPathSize = left.longestPathSize;
    int currMax = right.deepest - level + left.deepest - level;
    if(currMax > longestPathSize) longestPathSize = currMax;
    struct LeafInfo res;
    res.longestPathSize = longestPathSize;
    res.deepest = right.deepest > left.deepest ? right.deepest : left.deepest;
    return res;
}

int diameterOfBinaryTree(struct TreeNode* root) {
    return helper(root, 0, 0, 0).longestPathSize;
}
