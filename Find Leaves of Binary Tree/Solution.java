// Problem link: https://leetcode.com/problems/find-leaves-of-binary-tree/description/
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
    private int helper(TreeNode root, List<List<Integer>> res) {
        if(root == null) return -1;
        if(root.left == null && root.right == null) {
            if(res.size() == 0) res.add(new ArrayList<>());
            res.get(0).add(root.val);
            return 2;
        }
        int left = -1, right = -1;
        if(root.left != null) left = helper(root.left, res);
        if(root.right != null) right = helper(root.right, res);
        left = Math.max(left, right);
        if(left > res.size()) res.add(new ArrayList<>());
        res.get(left - 1).add(root.val);
        return left + 1;
    }
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, res);
        return res;
    }
}
