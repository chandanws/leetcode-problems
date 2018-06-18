// Problem link: https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/
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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        helper(root, res, 1);
        return res;
    }
    private void helper(TreeNode root, List<Integer> res, int level) {
        if(root == null) return;
        if(res.size() < level) res.add(Integer.MIN_VALUE);
        if(res.get(level - 1) < root.val) res.set(level - 1, root.val);
        helper(root.left, res, level + 1);
        helper(root.right, res, level + 1);
    }
}
