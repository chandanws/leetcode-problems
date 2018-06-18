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
    public List<Integer> largestValuesRecursiveWay(TreeNode root) {
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
    public List<Integer> largestValuesInterativeWay(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size(), max = Integer.MIN_VALUE;
            for(int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if(node.val > max) max = node.val;
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            res.add(max);
        }
        return res;
    }
}
