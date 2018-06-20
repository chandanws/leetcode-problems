// Problem link: https://leetcode.com/problems/path-sum-ii/description/
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
    private void helper(TreeNode root, int sum, List<Integer> currentResult, List<List<Integer>> result) {
        if(root == null) return;
        sum -= root.val;
        currentResult.add(new Integer(root.val));
        if(root.left == null && root.right == null && sum == 0) {
            result.add(new ArrayList<>(currentResult));
            currentResult.remove(currentResult.size() - 1);
            return;
        } else {
            helper(root.left, sum, currentResult, result);
            helper(root.right, sum, currentResult, result);
        }
        currentResult.remove(currentResult.size() - 1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentResult = new ArrayList<>();
        helper(root, sum, currentResult, result);
        return result;
    }
}
