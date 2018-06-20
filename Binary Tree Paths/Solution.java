// Problem link: https://leetcode.com/problems/binary-tree-paths/description/
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
    private void helper(TreeNode root, List<String> currentList, List<String> res) {
        if(root == null) return;
        currentList.add(Integer.toString(root.val));
        if(root.left == null && root.right == null) {
            res.add(String.join("->", currentList));
            currentList.remove(currentList.size() - 1);
            return;
        } else {
            helper(root.left, currentList, res);
            helper(root.right, currentList, res);
        }
        currentList.remove(currentList.size() - 1);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        List<String> currentList = new ArrayList<>();
        helper(root, currentList, res);
        return res;
    }
}
