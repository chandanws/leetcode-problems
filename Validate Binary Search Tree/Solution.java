// Problem link: https://leetcode.com/problems/validate-binary-search-tree/description/
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
    private int prevNum;
    private boolean neverSet;
    private boolean helper(TreeNode root) {
        boolean res1 = true, res2 = true;
        if(root.left != null) res1 = helper(root.left);
        if(neverSet) {
            prevNum = root.val;
            neverSet = false;
        } else if(prevNum >= root.val) return false;
        else prevNum = root.val;
        if(root.right != null) res2 = helper(root.right);
        return res1 && res2;
    }
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        prevNum = 0;
        neverSet = true;
        return helper(root);
    }
}
