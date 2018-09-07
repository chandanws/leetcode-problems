// Problem link: https://leetcode.com/problems/path-sum/description/
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
    private boolean helper(TreeNode root, int sum) {
        if(root.left == null && root.right == null) {
            if(sum == 0) return true;
            return false;
        }
        boolean left = false, right = false;
        if(root.left != null) left = helper(root.left, sum - root.left.val);
        if(root.right != null) right = helper(root.right, sum - root.right.val);
        return left || right; 
    }
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        return helper(root, sum - root.val);
    }
}
