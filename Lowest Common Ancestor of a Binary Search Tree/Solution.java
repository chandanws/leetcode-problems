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
    private TreeNode ans;
    private void helper(TreeNode root, TreeNode p, TreeNode q) {
        if(root == p || root == q || (p.val < root.val && root.val < q.val) || (q.val < root.val && root.val < p.val)) {
            ans = root;
        } else if(p.val > root.val && q.val > root.val) {
            helper(root.right, p, q);
        } else if(p.val < root.val && q.val < root.val) {
            helper(root.left, p, q);
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ans = null;
        helper(root, p, q);
        return ans;
    }
}
