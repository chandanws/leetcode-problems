// Problem link: https://leetcode.com/problems/univalued-binary-tree/description/
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
    public boolean isUnivalTree(TreeNode root) {
        int rootValue = root.val;
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        boolean ans = true;
        while(!s.isEmpty() && ans) {
            TreeNode next = s.pop();
            if(next.val != rootValue) ans = false;
            if(next.left != null) s.push(next.left);
            if(next.right != null) s.push(next.right);
        }
        return ans;
    }
}
