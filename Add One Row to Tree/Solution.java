// Problem link: https://leetcode.com/problems/add-one-row-to-tree/description/
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
    private TreeNode helper(TreeNode root, int level, int v, int d) {
        if(root == null) return null;
        if(level + 1 == d) {
            TreeNode leftSubtree = root.left;
            TreeNode rightSubtree = root.right;
            root.left = new TreeNode(v);
            if(leftSubtree != null) root.left.left = leftSubtree;
            root.right = new TreeNode(v);
            if(rightSubtree != null) root.right.right = rightSubtree;
        } else {
            helper(root.left, level + 1, v, d);
            helper(root.right, level + 1, v, d);
        }
        return root;
    }
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }
        return helper(root, 1, v, d);
    }
}
