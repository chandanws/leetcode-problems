// Problem link: https://leetcode.com/problems/invert-binary-tree/description/
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
    private void traversal(TreeNode root) {
        if(root == null) return;
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        traversal(root.right);
        traversal(root.left);
    }
    public TreeNode invertTree(TreeNode root) {
        traversal(root);
        return root;
    }
}
