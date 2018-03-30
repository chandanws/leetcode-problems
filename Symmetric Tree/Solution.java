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
    public boolean isSymmetric(TreeNode root) {
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
}
