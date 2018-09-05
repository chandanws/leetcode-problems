// Problem link: https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
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
    private int index;
    private TreeNode create(int [] inorder, int [] postorder, int start, int end) {
        if(start > end) return null;
        TreeNode node = new TreeNode(postorder[index--]);
        if(start == end) return node;
        int pos = -1;
        for(int i = end; i >= start && pos == -1; i--) {
            if(inorder[i] == node.val) pos = i;
        }
        node.right = create(inorder, postorder, pos + 1, end);
        node.left = create(inorder, postorder, start, pos - 1);
        return node;
    }
    public TreeNode buildTree(int [] inorder, int [] postorder) {
        index = postorder.length - 1;
        return create(inorder, postorder, 0, index);
    }
}
