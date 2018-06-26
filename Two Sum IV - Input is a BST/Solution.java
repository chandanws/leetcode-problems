// Problem link: https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/
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
    private void helper(TreeNode root, HashMap<Integer, Integer> hm) {
        if(root == null) return;
        hm.put(root.val, hm.getOrDefault(root.val, 0) + 1);
        helper(root.left, hm);
        helper(root.right, hm);
    }
    public boolean findTarget(TreeNode root, int k) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        helper(root, hm);
        for(Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            int remain = k - (int) entry.getKey();
            if(hm.containsKey(remain)) {
                if(remain == (int) entry.getKey() && hm.get(remain) == 1) return false;
                return true;
            }
        }
        return false;
    }
}
