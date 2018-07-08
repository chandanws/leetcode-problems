// Problem link: https://leetcode.com/problems/binary-tree-right-side-view/description/
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
    private ArrayList<ArrayList<Integer>> tree;
    private void helper(TreeNode root, int level) {
        if(root == null) return;
        if(tree.size() < level) tree.add(new ArrayList<>());
        tree.get(level - 1).add(root.val);
        helper(root.left, level + 1);
        helper(root.right, level + 1);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        tree = new ArrayList<>();
        helper(root, 1);
        for(int i = 0; i < tree.size(); i++) {
            for(int j = tree.get(i).size() - 1; j < tree.get(i).size(); j++) {
                res.add(tree.get(i).get(j));
            }
        }
        return res;
    }
}
