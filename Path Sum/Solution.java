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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        return helper(root, sum, 0) == sum;
    }
    private int helper(TreeNode root, int target, int sum) {
        sum += root.val;
        if(root.right == null && root.left == null) return sum;
        int left = 0, right = 0;
        if(root.right != null) right = helper(root.right, target, sum);
        if(root.left != null) left = helper(root.left, target, sum);
        if(root.right != null && root.left != null) return left == target ? left : right;
        if(root.right != null) return right;
        else return left;
    }
}
