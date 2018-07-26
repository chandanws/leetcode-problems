// Problem link: https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/
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
        if(root == null || root.left == null && root.right == null) return;
        if(root.left.next == null) root.left.next = root.right;
        connect(root.left);
        connect(root.right);
        if(root.left != null) {
            TreeLinkNode left = root.left.right;
            TreeLinkNode right = root.right.left;
            while(left != null && right != null) {
                left.next = right;
                left = left.right;
                right = right.left;
            }
        }
    }
}
