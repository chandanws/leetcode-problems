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
    public List<List<Integer>> zigzagLevelOrderUsingStack(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        s1.push(root);
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        int level = 1;
        while(!s1.isEmpty() || !s2.isEmpty()) {
            Stack<TreeNode> pushS = level % 2 == 0 ? s1 : s2;
            Stack<TreeNode> popS = level % 2 == 0 ? s2 : s1;
            List<Integer> l = new ArrayList<>();
            while(!popS.isEmpty()) {
                TreeNode node = popS.pop();
                if(level % 2 != 0) {
                    if(node.left != null) pushS.push(node.left);
                    if(node.right != null) pushS.push(node.right);
                } else {
                    if(node.right != null) pushS.push(node.right);
                    if(node.left != null) pushS.push(node.left);
                }
                l.add(node.val);
            }
            res.add(l);
            level++;
        }
        return res;
    }
    public List<List<Integer>> zigzagLevelOrderUsingArrayListAsStack(TreeNode root) {
        List<List<Integer>> l = new ArrayList<List<Integer>>();
        if(root == null) return l;
        ArrayList<TreeNode> s1 = new ArrayList<>(Arrays.asList(root));
        ArrayList<TreeNode> s2 = new ArrayList<>();
        int s1Top = 0, s2Top = -1;
        int level = 0;
        while(s1Top != -1 || s2Top != -1) {
            ArrayList<TreeNode> popS = level % 2 == 0 ? s1 : s2;
            ArrayList<TreeNode> pushS = level % 2 == 0 ? s2 : s1;
            int popSTop = level % 2 == 0 ? s1Top : s2Top;
            int pushSTop = level % 2 == 0 ? s2Top : s1Top;
            TreeNode current = popS.get(popSTop);
            popS.remove(popSTop--);
            if(l.size() < level + 1) l.add(new ArrayList<Integer>(Arrays.asList(current.val)));
            else l.get(level).add(current.val);
            if((level + 1) % 2 == 0) {
                if(current.right != null) pushS.add(++pushSTop, current.right);
                if(current.left != null) pushS.add(++pushSTop, current.left);
            } else {
                if(current.left != null) pushS.add(++pushSTop, current.left);
                if(current.right != null) pushS.add(++pushSTop, current.right);
            }
            if(level % 2 == 0) {
                s1Top = popSTop;
                s2Top = pushSTop;
            } else {
                s1Top = pushSTop;
                s2Top = popSTop;
            }
            if(popSTop == -1) level++;
        }
        return l;
    }
}
