// Problem link: https://leetcode.com/problems/sum-root-to-leaf-numbers/description/
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
    private List<String> l;
    private void helper(TreeNode root, String num) {
        if(root.left == null && root.right == null) {
            num += root.val;
            l.add(num);
            return;
        }
        num += root.val;
        if(root.left != null) helper(root.left, num);
        if(root.right != null) helper(root.right, num);
    }
    private int sum() {
        int sum = 0;
        for(String num : l) sum += Integer.parseInt(num);
        return sum;
    }
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        l = new ArrayList<>();
        helper(root, "");
        return sum();
    }
}
