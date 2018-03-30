// Problem link: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> l = new ArrayList<List<Integer>>();
        if(root == null) return l;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        int level = 0;
        s1.push(root);
        while(!s1.isEmpty() || !s2.isEmpty()) {
            Stack<TreeNode> popS = level % 2 == 0 ? s1 : s2;
            Stack<TreeNode> pushS = level % 2 == 0 ? s2 : s1;
            TreeNode current = popS.pop();
            if(l.size() < level + 1) l.add(new ArrayList<Integer>(Arrays.asList(current.val)));
            else l.get(level).add(current.val);
            if((level + 1) % 2 == 0) {
                if(current.right != null) pushS.push(current.right);
                if(current.left != null) pushS.push(current.left);
            } else {
                if(current.left != null) pushS.push(current.left);
                if(current.right != null) pushS.push(current.right);
            }
            if(popS.isEmpty()) level++;
        }
        return l;
    }
}
