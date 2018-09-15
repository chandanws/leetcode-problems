// Problem link: https://leetcode.com/problems/trim-a-binary-search-tree/description/
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
    private TreeNode helper(TreeNode root, int L, int R) {
        if(root == null) return null;
        if(root.val <= L) {
            root.left = null;
            if(root.val < L) {
                root = helper(root.right, L, R);
            } else {
                root.right = helper(root.right, L, R);
            }
        } else if(root.val >= R) {
            root.right = null;
            if(root.val > R) {
                root = helper(root.left, L, R);
            } else {
                root.left = helper(root.left, L, R);
            }
        } else {
            root.left = helper(root.left, L, R);
            root.right = helper(root.right, L, R);
        }
        return root;
    }
    public TreeNode trimBST(TreeNode root, int L, int R) {
        return helper(root, L, R);
    }
}
