// Problem link: https://leetcode.com/problems/sum-root-to-leaf-numbers/description/
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
    private int sum;
    private void helper(TreeNode root, String num) {
        if(root.left == null && root.right == null) {
            num += root.val;
            sum += Integer.parseInt(num);
            return;
        }
        num += root.val;
        if(root.left != null) helper(root.left, num);
        if(root.right != null) helper(root.right, num);
    }
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        sum = 0;
        helper(root, "");
        return sum;
    }
}
