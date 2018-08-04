// Problem link: https://leetcode.com/problems/binary-tree-longest-consecutive-sequence/description/
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
    private int max;
    private int[] dfs(TreeNode root) {
        if(root == null) return new int[]{-1, 0};
        if(root.left == null && root.right == null) return new int[]{root.val, 1};
        int[] left = new int[]{};
        int[] right = new int[]{};
        if(root.left != null) left = dfs(root.left);
        if(root.right != null) right = dfs(root.right);
        if(left.length == 2 && right.length == 2) {
            if(left[0] - 1 == root.val && right[0] - 1 == root.val) {
                max = Math.max(max, Math.max(left[1], right[1]) + 1);
                return new int[]{root.val, Math.max(left[1], right[1]) + 1};
            } else if(left[0] - 1 == root.val) {
                max = Math.max(max, left[1] + 1);
                return new int[]{root.val, left[1] + 1};
            } else if(right[0] - 1 == root.val) {
                max = Math.max(max, right[1] + 1);
                return new int[]{root.val, right[1] + 1};
            }
        } else if(left.length == 2 && left[0] - 1 == root.val) {
            max = Math.max(max, left[1] + 1);
            return new int[]{root.val, left[1] + 1};
        } else if(right.length == 2 && right[0] - 1 == root.val) {
            max = Math.max(max, right[1] + 1);
            return new int[]{root.val, right[1] + 1};
        }
        return new int[]{root.val, 1};
    }
    public int longestConsecutive(TreeNode root) {
        max = Integer.MIN_VALUE;
        int [] res = dfs(root);
        return Math.max(max, res[1]);
    }
}
