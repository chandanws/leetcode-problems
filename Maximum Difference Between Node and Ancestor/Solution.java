// Problem link: https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/description/
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
    public int max;
    public void dfs(TreeNode root, int [] arr) {
        if(root == null) return;
        if(arr[0] > root.val) arr[0] = root.val;
        if(arr[1] < root.val) arr[1] = root.val;
        if(Math.abs(arr[1] - arr[0]) > max) max = Math.abs(arr[1] - arr[0]);
        dfs(root.left, Arrays.copyOf(arr, arr.length));
        dfs(root.right, Arrays.copyOf(arr, arr.length));
    }
    public int maxAncestorDiff(TreeNode root) {
        if(root.left != null) max = Math.abs(root.val - root.left.val);
        else max = Math.abs(root.val - root.right.val);
        dfs(root, new int[]{root.val, root.val});
        return max;
    }
}
