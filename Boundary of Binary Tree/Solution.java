// Problem link: https://leetcode.com/problems/boundary-of-binary-tree/description/
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
    private void getLeftBoundary(TreeNode root, List<TreeNode> leftBoundary) {
        if(root == null) return;
        leftBoundary.add(root);
        getLeftBoundary(root.left, leftBoundary);
        if(root.left == null) getLeftBoundary(root.right, leftBoundary);
    }
    private void getLeaves(TreeNode root, List<TreeNode> leaves) {
        if(root.left == null && root.right == null) leaves.add(root);
        if(root.left != null) getLeaves(root.left, leaves);
        if(root.right != null) getLeaves(root.right, leaves);
    }
    private void getRightBoundary(TreeNode root, List<TreeNode> rightBoundary) {
        if(root == null) return;
        rightBoundary.add(0, root);
        getRightBoundary(root.right, rightBoundary);
        if(root.right == null) getRightBoundary(root.left, rightBoundary);
    }
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<TreeNode> leftBoundary = new ArrayList<>();
        getLeftBoundary(root.left, leftBoundary);
        List<TreeNode> leaves = new ArrayList<>();
        getLeaves(root, leaves);
        List<TreeNode> rightBoundary = new ArrayList<>();
        getRightBoundary(root.right, rightBoundary);
        List<TreeNode> mergedWithDuplicate = new ArrayList<>();
        mergedWithDuplicate.addAll(leftBoundary);
        mergedWithDuplicate.addAll(leaves);
        mergedWithDuplicate.addAll(rightBoundary);
        HashSet<TreeNode> seen = new HashSet<TreeNode>();
        seen.add(root);
        List<Integer> res = new ArrayList<>();
        res.add(root.val);
        for(TreeNode node : mergedWithDuplicate) {
            if(!seen.contains(node)) {
                seen.add(node);
                res.add(node.val);
            }
        }
        return res;
    }
}
