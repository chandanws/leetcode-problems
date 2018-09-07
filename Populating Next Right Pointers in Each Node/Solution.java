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
    private void populateRightPointers(TreeLinkNode left, TreeLinkNode right) {
        if(left == null && right == null) return;
        left.next = right;
        populateRightPointers(left.right, right.left);
    }
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        connect(root.left);
        populateRightPointers(root.left, root.right);
        connect(root.right);
    }
}
