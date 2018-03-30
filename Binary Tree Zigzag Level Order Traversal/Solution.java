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
