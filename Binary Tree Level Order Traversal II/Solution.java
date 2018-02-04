// Problem link: https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> l = new ArrayList<List<Integer>>();
        if(root == null) return l;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        q.add(null);
        for(int i = 0; q.peek() != null; i++) {
          l.add(new ArrayList<Integer>());
          while(q.peek() != null) {
            TreeNode node = q.poll();
            if(node.left != null) q.add(node.left);
            if(node.right != null) q.add(node.right);
            l.get(i).add(node.val);
          }
          q.add(q.poll());
        }
        int i = 0, j = l.size() - 1;
        while(i < j) {
          List<Integer> tempList = l.get(i);
          l.set(i, l.get(j));
          l.set(j, tempList);
          i++;
          j--;
        }
        return l;
    }
}
