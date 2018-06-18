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
    public int closestValue(TreeNode root, double target) {
        return helper(root, target, root, Double.MAX_VALUE).val;
    }
    private TreeNode helper(TreeNode root, double target, TreeNode closestNode, double differences) {
        if(root == null) return closestNode;
        double diff = Math.abs((double) root.val - target);
        if(diff < differences) {
            differences = diff;
            closestNode = root;
        }
        closestNode = helper(root.left, target, closestNode, differences);
        closestNode = helper(root.right, target, closestNode, differences);
        return closestNode;
    }
}
