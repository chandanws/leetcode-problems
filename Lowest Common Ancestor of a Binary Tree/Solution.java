// Problem link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if((left == p || right == p) && (left == q || right == q)) return root;
        if(left == p || right == p) return p;
        if(left == q || right == q) return q;
        return left == null ? right : left;
    }
}
