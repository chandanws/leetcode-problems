// Problem link: https://leetcode.com/problems/closest-binary-search-tree-value/description/
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
    private TreeNode node;
    private void helper(TreeNode root, double target) {
        if(root == null) return;
        if(node == null || Math.abs(target - (root.val * 1.0)) < Math.abs(target - (node.val * 1.0))) node = root;
        if(root.val < target) helper(root.right, target);
        else helper(root.left, target);
    }
    public int closestValue(TreeNode root, double target) {
        node = null;
        helper(root, target);
        return node.val;
    }
}
