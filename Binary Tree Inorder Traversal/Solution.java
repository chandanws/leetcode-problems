// Problem link: https://leetcode.com/problems/binary-tree-inorder-traversal/description/
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode current = root;
        while(current != null || !s.isEmpty()) {
            while(current != null) {
                s.push(current);
                current = current.left;
            }
            current = s.pop();
            res.add(current.val);
            current = current.right;
        }
        return res;
    }
}
