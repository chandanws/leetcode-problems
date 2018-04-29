// Problem link: https://leetcode.com/problems/construct-string-from-binary-tree/description/
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
    private String helper(TreeNode t) {
        if(t == null) return "";
        if(t.right == null && t.left == null) return t.val + "";
        if(t.right == null && t.left != null) return t.val + "(" + helper(t.left) + ")";
        if(t.left == null && t.right != null) return t.val + "()" + "(" + helper(t.right) + ")";
        return t.val + "(" + helper(t.left) + ")" + "(" + helper(t.right) + ")";
    }
    public String tree2str(TreeNode t) {
        return helper(t);
    }
}
