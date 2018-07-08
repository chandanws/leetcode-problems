// Problem link: https://leetcode.com/contest/weekly-contest-92/problems/smallest-subtree-with-all-the-deepest-nodes/
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
    private int deepestLevel;
    private TreeNode subtreeRoot;
    private int helper(TreeNode root, int level) {
        if(root.left == null && root.right == null) return level;
        int left = 0, right = 0;
        if(root.left != null) left = helper(root.left, level + 1);
        if(root.right != null) right = helper(root.right, level + 1);
        if(left == right && right >= deepestLevel) {
            deepestLevel = right;
            subtreeRoot = root;
        } else if(right > deepestLevel) {
            deepestLevel = right;
            subtreeRoot = root.right;
        } else if(left > deepestLevel) {
            deepestLevel = left;
            subtreeRoot = root.left;
        }
        return Math.max(left, right);
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if(root == null || (root.right == null && root.left == null)) return root;
        subtreeRoot = null;
        deepestLevel = 0;
        helper(root, 0);
        return subtreeRoot;
    }
}
