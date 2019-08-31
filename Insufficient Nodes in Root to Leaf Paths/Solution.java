// Problem link: https://leetcode.com/problems/insufficient-nodes-in-root-to-leaf-paths/description/
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
    private int dfs(TreeNode root, int limit, int sum) {
        if(root.left == null && root.right == null) return sum + root.val;
        int max = Integer.MIN_VALUE;
        if(root.left != null) {
            int left = dfs(root.left, limit, sum + root.val);
            max = Math.max(max, left);
            if(left < limit) root.left = null;
        }
        if(root.right != null) {
            int right = dfs(root.right, limit, sum + root.val);
            max = Math.max(max, right);
            if(right < limit) root.right = null;
        }
        return max;
    }
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        if(dfs(root, limit, 0) < limit) return null;
        else return root;
    }
}
