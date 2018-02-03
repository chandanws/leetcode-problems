// Problem link: https://leetcode.com/problems/average-of-levels-in-binary-tree/description/
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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> l = new ArrayList<Double>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        q.add(null);
        for(int i = 0; !q.isEmpty() && q.peek() != null; i++) {
          Double sum = 0.0, numberOfElements = 0.0;
          while(q.peek() != null) {
            TreeNode node = q.poll();
            if(node.left != null) q.add(node.left);
            if(node.right != null) q.add(node.right);
            sum += node.val;
            numberOfElements++;
          }
          l.add(sum/numberOfElements);
          q.add(q.poll()); // letting queue know this is the end of the level
        }
        return l;
    }
}
