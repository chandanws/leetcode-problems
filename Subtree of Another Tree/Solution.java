// Problem link: https://leetcode.com/problems/subtree-of-another-tree/description/
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
    private HashSet<String> hs;
    private String helper(TreeNode root, TreeNode target, boolean shouldAdd) {
        if(root == null) return "";
        String paths = root.val + "";
        paths += "(" + helper(root.left, target, shouldAdd) + ")";
        paths += "(" + helper(root.right, target, shouldAdd) + ")";
        if(root.val == target.val && shouldAdd) hs.add(paths);
        return paths;
    }
    public boolean isSubtree(TreeNode s, TreeNode t) {
        hs = new HashSet<String>();
        helper(s, t, true);
        String tPath = helper(t, s, false);
        Iterator itr = hs.iterator();
        while(itr.hasNext()) if(itr.next().equals(tPath)) return true;
        return false;
    }
}
