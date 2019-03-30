// Problem link: https://leetcode.com/problems/increasing-order-search-tree/description/
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
    public TreeNode newRoot, prevNode;
    public void setRightChildren(TreeNode root) {
        if(newRoot == null) {
            newRoot = root;
            prevNode = root;
        } else {
            prevNode.right = root;
            root.left = null;
            prevNode = root;
        }
    }
    public TreeNode increasingBST(TreeNode root) {
        if(root.left == null && root.right == null) setRightChildren(root);
        else {
            if(root.left != null) increasingBST(root.left);
            setRightChildren(root);
            if(root.right != null) increasingBST(root.right);
        }
        return newRoot;
    }
}
