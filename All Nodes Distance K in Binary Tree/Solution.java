// Problem link: https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/
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
    List<Integer> res;
    private int dfs(TreeNode root, TreeNode target, int k) {
        if(root == null) return -1;
        if(k < 0) return -1;
        if(root == target) {
            findBelow(root, k, true, true);
            findBelow(root.left, k - 1, false, false);
            findBelow(root.right, k - 1, false, false);
            return k - 1;
        } else {
            int res1 = dfs(root.left, target, k);
            int res2 = dfs(root.right, target, k);
            if(res1 != -1) {
                findBelow(root, res1, true, false);
                return res1 - 1;
            }
            if(res2 != -1) {
                findBelow(root, res2, false, true);
                return res2 - 1;
            }
        }
        return -1;
    }
    private void findBelow(TreeNode root, int k, boolean skipLeft, boolean skipRight) {
        if(root == null) return;
        if(k < 0) return;
        if(k == 0) {
            res.add(root.val);
        } else {
            if(!skipLeft) findBelow(root.left, k - 1,  false, false);
            if(!skipRight) findBelow(root.right, k - 1,  false, false);
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        res = new ArrayList<>();
        dfs(root, target, K);
        return res;
    }
}
