// Problem link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
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
    private void helper(TreeNode root, TreeNode p, TreeNode q) {
        if(root == p ||
           root == q ||
           p.val < root.val && root.val < q.val ||
           q.val < root.val && root.val < p.val) {
            node = root;
            return;
        } else if(p.val < root.val && q.val < root.val) {
            if(root.left != null) helper(root.left, p, q);
        }
        if(root.right != null) helper(root.right, p, q);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        node = null;
        helper(root, p, q);
        return node;
    }
}
