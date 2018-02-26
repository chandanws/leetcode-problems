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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null) return t2;
        Queue<TreeNode[]> q = new LinkedList<>();
        q.add(new TreeNode[]{t1, t2});
        while(!q.isEmpty()) {
            TreeNode [] nodes = q.poll();
            if(nodes[1] == null) continue;
            nodes[0].val += nodes[1].val;
            if(nodes[0].left == null) {
                nodes[0].left = nodes[1].left;
            } else {
                q.add(new TreeNode[]{nodes[0].left, nodes[1].left});
            }
            if(nodes[0].right == null) {
                nodes[0].right = nodes[1].right;
            } else {
                q.add(new TreeNode[]{nodes[0].right, nodes[1].right});
            }
        }
        return t1;
    }
}
