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
    private int largestSubtreeCount;
    private List<Integer> dfs(TreeNode root) {
        if(root.left == null && root.right == null) return new ArrayList<>(Arrays.asList(root.val, root.val, 1));
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        if(root.left != null) left = dfs(root.left);
        if(root.right != null) right = dfs(root.right);
        if(left.size() > 0 && right.size() > 0) {
            if(left.get(1) < root.val && root.val < right.get(0)) {
                largestSubtreeCount = Math.max(largestSubtreeCount, 1 + left.get(2) + right.get(2));
                return new ArrayList<>(Arrays.asList(left.get(0), right.get(1), 1 + left.get(2) + right.get(2)));
            }
        } else {
            if(left.size() > 0 && left.get(1) < root.val && root.right == null) {
                largestSubtreeCount = Math.max(largestSubtreeCount, 1 + left.get(2));
                return new ArrayList<>(Arrays.asList(left.get(0), root.val, 1 + left.get(2)));
            } else if(right.size() > 0 && root.val < right.get(0) && root.left == null) {
                largestSubtreeCount = Math.max(largestSubtreeCount, 1 + right.get(2));
                return new ArrayList<>(Arrays.asList(root.val, right.get(1), 1 + right.get(2)));
            }
        }
        return new ArrayList<>();
    }
    public int largestBSTSubtree(TreeNode root) {
        largestSubtreeCount = 1;
        if(root == null) return 0;
        dfs(root);
        return largestSubtreeCount;
    }
}
