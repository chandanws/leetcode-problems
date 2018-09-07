// Problem link: https://leetcode.com/problems/symmetric-tree/description/
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
    private void helper1(TreeNode root, int level, List<List<Integer>> res) {
        if(res.size() < level) res.add(new ArrayList<>());
        if(root != null) res.get(level - 1).add(root.val);
        else {
            res.get(level - 1).add(null);
            return;
        }
        helper1(root.left, level + 1, res);
        helper1(root.right, level + 1, res);
    }
    public boolean isSymmetricRecur(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return true;
        helper1(root.left, 1, res);
        helper1(root.right, 1, res);
        for(int i = 0; i < res.size(); i++) {
            if(res.get(i).size() % 2 == 1) return false;
            int start = 0, end = res.get(i).size() - 1;
            while(start < end) {
                if(res.get(i).get(start++) != res.get(i).get(end--)) return false;
            }
        }
        return true;
    }
    private void helper2(TreeNode root, List<List<Integer>> res) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            if(res.size() < level) res.add(new ArrayList<>());
            for(int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if(node != null) {
                    res.get(level - 1).add(node.val);
                    q.offer(node.left);
                    q.offer(node.right);
                }
                else res.get(level - 1).add(null);
            }
            level++;
        }
    }
    public boolean isSymmetricUsingStackIteratively(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return true;
        helper2(root.left, res);
        helper2(root.right, res);
        for(int i = 0; i < res.size(); i++) {
            if(res.get(i).size() % 2 == 1) return false;
            int start = 0, end = res.get(i).size() - 1;
            while(start < end) {
                if(res.get(i).get(start++) != res.get(i).get(end--)) return false;
            }
        }
        return true;
    }
}
