// Problem link: https://leetcode.com/problems/cousins-in-binary-tree/description/
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
    private int [] find(TreeNode root, TreeNode parent, int target, int depth) {
        if(root == null) return new int[]{-1, -1};
        else if(root.val == target) return new int[]{depth, parent == null ? -1 : parent.val};
        int [] left = find(root.left, root, target, depth + 1);
        int [] right = find(root.right, root, target, depth + 1);
        return left[0] > 0 ? left : right;
    }
    public boolean isCousins(TreeNode root, int x, int y) {
        int [] arr1 = find(root, null, x, 0);
        int [] arr2 = find(root, null, y, 0);
        if(arr1[0] == arr2[0]) return arr1[1] != arr2[1];
        return false;
    }
}
