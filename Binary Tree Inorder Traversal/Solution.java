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
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode currentNode = root;
        while(currentNode != null || !s.isEmpty()) {
            while(currentNode != null) {
                s.push(currentNode);
                currentNode = currentNode.left;
            }
            currentNode = s.pop();
            res.add(currentNode.val);
            currentNode = currentNode.right;
        }
        return res;
    }
}
