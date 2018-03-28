// Problem link: https://leetcode.com/problems/sum-of-left-leaves/description/
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
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int sum = 0;
        while(!q.isEmpty()) {
            TreeNode current = q.poll();
            if(current.left != null) {
                q.add(current.left);
                q.add(null);
            }
            if(current.right != null) q.add(current.right);
            if(q.peek() == null && !q.isEmpty()) {
                q.poll();
                if(current.right == null && current.left == null) sum += current.val;
            }
        }
        return sum;
    }
}
