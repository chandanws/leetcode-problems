// Problem link: https://leetcode.com/problems/same-tree/description/
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
    private boolean preOrderTraversal(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val != q.val) return false;
        return preOrderTraversal(p.left, q.left) && preOrderTraversal(p.right, q.right);
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return preOrderTraversal(p, q);
    }
}
