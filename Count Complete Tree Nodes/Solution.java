// Problem link: https://leetcode.com/problems/count-complete-tree-nodes/description/
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
    private int maxDepth(TreeNode root, int level) {
        if(root == null) return level - 1;
        return maxDepth(root.left, level + 1);
    }
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null || root.right == null) {
            if(root.left == null && root.right == null) return 1;
            return 2;
        }
        int left = 1, right = 1, depth = 0, maxDepth = 0, emptyNodes = 0;
        while((left != 0 && right != -1) || (left != 0 && right != 0)) {
            left = maxDepth(root.left, 0);
            right = maxDepth(root.right, 0);
            if(maxDepth == 0) maxDepth = Math.max(left, right) + 1;
            if(left == right) {
                root = root.right;
            } else {
                root = root.left;
                emptyNodes += Math.pow(2, maxDepth - depth) / 2;
            }
            depth++;
        }
        int sum = 0;
        for(int i = 0; i <= maxDepth; i++) sum += Math.pow(2, i);
        return sum - emptyNodes;
    }
}
