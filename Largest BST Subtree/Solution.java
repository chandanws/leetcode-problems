// Problem link: https://leetcode.com/problems/largest-bst-subtree/description/
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
    private int [] helper(TreeNode root) {
        if(root.left == null && root.right == null) return new int[]{root.val, root.val, 1};
        int [] left = new int[]{-1, -1, -1};
        int [] right = new int[]{-1, -1, -1};
        if(root.left != null) left = helper(root.left);
        if(root.right != null) right = helper(root.right);
        if(left[2] != -1 && right[2] != -1 && left[1] < root.val && root.val < right[0]) {
            max = Math.max(max, left[2] + right[2] + 1);
            return new int[]{left[0], right[1], left[2] + right[2] + 1};
        } else if(left[2] != -1 && root.right == null && left[1] < root.val) {
            max = Math.max(max, left[2] + 1);
            return new int[]{left[0], root.val, left[2] + 1};
        } else if(right[2] != -1 && root.left == null && root.val < right[0]) {
            max = Math.max(max, right[2] + 1);
            return new int[]{root.val, right[1], right[2] + 1};
        }
        return new int[]{-1, -1, -1};
    }
    public int largestBSTSubtree(TreeNode root) {
        max = 1;
        if(root == null) return 0;
        int [] res = helper(root);
        max = Math.max(max, res[2]);
        return max;
    }
}
