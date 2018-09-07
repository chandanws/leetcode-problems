// Problem link: https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/description/
// Status: Accepted

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
        q.offer(root);
        TreeLinkNode prevNode = null;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeLinkNode node = q.poll();
                if(prevNode == null) prevNode = node;
                else {
                    prevNode.next = node;
                    prevNode = node;
                }
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            prevNode = null;
        }
    }
}
