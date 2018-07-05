// Problem link: https://leetcode.com/problems/find-bottom-left-tree-value/description/
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
    private TreeNode ans;
    private int foundLevel;
    public int findBottomLeftValue(TreeNode root) {
        ans = null;
        foundLevel = -1;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        int level = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if(ans == null || level > foundLevel) {
                    ans = node;
                    foundLevel = level;
                }
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            level++;
        }
        return ans.val;
    }
}
