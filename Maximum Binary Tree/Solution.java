// Problem link: https://leetcode.com/problems/maximum-binary-tree/description/
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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Stack<TreeNode> st = new Stack<TreeNode>();
        for(int num : nums) {
            TreeNode node = new TreeNode(num);
            while(!st.isEmpty() && st.peek().val < node.val) node.left = st.pop();
            if(st.isEmpty()) st.push(node);
            else {
                node.left = st.peek().right;
                st.peek().right = node;
                st.push(node);
            }
        }
        TreeNode lastNode = null;
        while(!st.isEmpty()) lastNode = st.pop();
        return lastNode;
    }
}
