// Problem link: https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
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
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        int depth = 1;
        while(!q.isEmpty()) {
            TreeNode current = q.poll();
            if(q.isEmpty()) break; // at the end
            if(current == null) {
                depth++;
                q.add(null);
            } else {
                if(current.left != null) q.add(current.left);
                if(current.right != null) q.add(current.right);
            }
        }
        return depth;
    }
}
