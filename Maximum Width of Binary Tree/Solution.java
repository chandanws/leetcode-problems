// Problem link: https://leetcode.com/problems/maximum-width-of-binary-tree/description/
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
public class SpecialTreeNode {
    int index;
    TreeNode node;
    SpecialTreeNode(TreeNode curr, int i) {
        node = curr;
        index = i;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Queue<SpecialTreeNode> q = new LinkedList<SpecialTreeNode>();
        q.offer(new SpecialTreeNode(root, 1));
        int max = 1;
        while(!q.isEmpty()) {
            int size = q.size(), left = 0, right = 0;
            for(int i = 0; i < size; i++) {
                SpecialTreeNode specialNode = q.poll();
                TreeNode node = specialNode.node;
                if(i == 0) left = specialNode.index;
                else if(i == size - 1) right = specialNode.index;
                if(node.left != null) q.offer(new SpecialTreeNode(node.left, specialNode.index * 2));
                if(node.right != null) q.offer(new SpecialTreeNode(node.right, specialNode.index * 2 + 1));
            }
            if(size > 1 && right - left + 1 > max) max = right - left + 1;
        }
        return max;
    }
}
