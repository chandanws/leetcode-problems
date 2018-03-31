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
    public boolean isSymmetricRecur(TreeNode root) {
        List<List<TreeNode>> res = new ArrayList<>();
        helper(res, root, 1);
        for(int i = 0; i < res.size(); i++) {
            int p1 = 0;
            int p2 = res.get(i).size() - 1;
            while(p1 != p2) {
                if(res.get(i).get(p1) == null || res.get(i).get(p2) == null) {
                    if(res.get(i).get(p1) != null && res.get(i).get(p2) == null) return false;
                    if(res.get(i).get(p1) == null && res.get(i).get(p2) != null) return false;
                } else if(res.get(i).get(p1).val != res.get(i).get(p2).val) return false;
                if(p1 + 1 == p2) break; // even case
                // odd case
                p1++;
                p2--;
            }
        }
        return true;
    }
    private void helper(List<List<TreeNode>> res, TreeNode root, int level) {
        if(res.size() < level) res.add(new ArrayList(Arrays.asList(root)));
        else res.get(level - 1).add(root);
        if(root == null) return;
        helper(res, root.left, level + 1);
        helper(res, root.right, level + 1);
    }
    public boolean isSymmetricUsingStackIteratively(TreeNode root) {
        List<List<TreeNode>> res = new ArrayList<>();
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s2.push(root);
        int level = 1;
        while(!s1.isEmpty() || !s2.isEmpty()) {
            Stack<TreeNode> popS = level % 2 == 0 ? s1 : s2;
            Stack<TreeNode> pushS = level % 2 == 0 ? s2 : s1;
            TreeNode current = popS.pop();
            if(res.size() < level) res.add(new ArrayList(Arrays.asList(current)));
            else res.get(level - 1).add(current);
            if(current != null) {
                pushS.push(current.left);
                pushS.push(current.right);
            }
            if(popS.isEmpty()) level++;
        }
        for(int i = 0; i < res.size(); i++) {
            int p1 = 0;
            int p2 = res.get(i).size() - 1;
            while(p1 != p2) {
                if(res.get(i).get(p1) == null || res.get(i).get(p2) == null) {
                    if(res.get(i).get(p1) != null && res.get(i).get(p2) == null) return false;
                    if(res.get(i).get(p1) == null && res.get(i).get(p2) != null) return false;
                } else if(res.get(i).get(p1).val != res.get(i).get(p2).val) return false;
                if(p1 + 1 == p2) break; // even case
                // odd case
                p1++;
                p2--;
            }
        }
        return true;
    }
}
