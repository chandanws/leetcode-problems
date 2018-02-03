// Problem link: https://leetcode.com/problems/binary-tree-level-order-traversal/description/
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> l = new ArrayList<List<Integer>>();
        if(root == null) { return l; }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        q.add(null);
        for(int i = 0; !q.isEmpty() && q.peek() != null; i++) {
          l.add(new ArrayList<Integer>());
          while(q.peek() != null) {
            TreeNode node = q.poll();
            if(node.left != null) q.add(node.left);
            if(node.right != null) q.add(node.right);
            l.get(i).add(node.val);
          }
          q.add(q.poll()); // letting queue know this is the end of the level
        }
        return l;
    }
}
