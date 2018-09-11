// Problem link: https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
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
    private int max;
    private int helper(TreeNode root) {
        if(root.left == null && root.right == null) {
            max = Math.max(max, root.val);
            return root.val;
        }
        int left = 0, right = 0;
        if(root.left != null) left = helper(root.left);
        if(root.right != null) right = helper(root.right);
        if(root.left != null && root.right != null) {
            max = Math.max(max, left + right + root.val);
            max = Math.max(max, Math.max(left, right));
            return Math.max(root.val, Math.max(left + root.val, right + root.val));
        } else if(root.left != null) {
            max = Math.max(max, Math.max(left, left + root.val));
            return Math.max(root.val, left + root.val);
        }
        max = Math.max(max, Math.max(right, right + root.val));
        return Math.max(root.val, right + root.val);
    }
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        else max = root.val;
        int currentMax = helper(root);
        return Math.max(max, currentMax);
    }
}
