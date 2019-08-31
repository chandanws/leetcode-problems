// Problem link: https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/description/
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
    public int maxLevelSum(TreeNode root) {
        LinkedList<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 0;
        int [] ans = new int[]{-1, -1};
        while(!q.isEmpty()) {
            int size = q.size(), sum = 0;
            level++;
            for(int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                sum += node.val;
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            if(ans[0] == -1 || sum > ans[1]) {
                ans = new int[]{level, sum};
            }
        }
        return ans[0];
    }
}
