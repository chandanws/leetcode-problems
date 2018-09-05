// Problem link: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
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
    private TreeNode create(int [] perorder, int [] inorder, int start, int end) {
        if(start > end) return null;
        TreeNode node = new TreeNode(perorder[index++]);
        if(start == end) return node;
        int pos = -1;
        for(int i = start; i <= end && pos == -1; i++) {
            if(inorder[i] == node.val) pos = i;
        }
        node.left = create(perorder, inorder, start, pos - 1);
        node.right = create(perorder, inorder, pos + 1, end);
        return node;
    }
    public TreeNode buildTree(int [] preorder, int [] inorder) {
        index = 0;
        return create(preorder, inorder, 0, inorder.length - 1);
    }
}
