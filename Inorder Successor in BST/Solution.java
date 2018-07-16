// Problem link: https://leetcode.com/problems/inorder-successor-in-bst/description/
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
    private boolean found;
    private TreeNode nextNode;
    private void helper(TreeNode root, TreeNode target) {
        if(root == null) return;
        helper(root.left, target);
        if(found) {
            nextNode = root;
            found = false;
            return;
        }
        if(root.val == target.val) found = true;
        helper(root.right, target);
    }
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        found = false;
        nextNode = null;
        if(root.val <= p.val) {
            if(root.val == p.val) found = true;
            helper(root.right, p);
        } else {
            helper(root.left, p);
            if(nextNode == null) return root;
        }
        return nextNode;
    }
}
