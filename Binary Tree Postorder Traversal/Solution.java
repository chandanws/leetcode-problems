// Problem link: https://leetcode.com/problems/binary-tree-postorder-traversal/description/
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        while(!s.isEmpty()) {
            TreeNode node = s.pop();
            if(node.right == null && node.left == null) {
                res.add(node.val);
            } else {
                TreeNode right = node.right;
                TreeNode left = node.left;
                node.right = null;
                node.left = null;
                s.push(node);
                if(right != null) s.push(right);
                if(left != null) s.push(left);
            }
        }
        return res;
    }
}
