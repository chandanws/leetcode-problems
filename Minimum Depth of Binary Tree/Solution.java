// Problem link: https://leetcode.com/problems/minimum-depth-of-binary-tree/description/
// Status: Accepted

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        return helper(root, 1);
    }
    private int helper(TreeNode root, int level) {
        if(root.left == null && root.right == null) return level; // leaves
        if(root.left == null) return helper(root.right, level + 1); // sub-tree with only right children
        if(root.right == null) return helper(root.left, level + 1); // sub-tree with only left children
        return Math.min(helper(root.left, level + 1), helper(root.right, level + 1));
    }
}
