// Problem link: https://leetcode.com/problems/find-bottom-left-tree-value/description/
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
    List<List<Integer>> res;
    private void helper(TreeNode root, int level) {
        if(root == null) return;
        if(res.size() == level) res.add(new ArrayList<>());
        res.get(level).add(root.val);
        helper(root.left, level + 1);
        helper(root.right, level + 1);
    }
    public int findBottomLeftValue(TreeNode root) {
        res = new ArrayList<>();
        helper(root, 0);
        return res.get(res.size() - 1).get(0);
    }
}
