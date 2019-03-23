// Problem link: https://leetcode.com/problems/smallest-string-starting-from-leaf/description/
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
    public String ans;
    public void dfs(TreeNode root, StringBuilder sb) {
        if(root == null) return;
        sb.insert(0, ((char) ('a' + root.val)));
        if(root.left == null && root.right == null) {
            String s = sb.toString();
            if(ans == "") ans = s;
            else if(s.compareTo(ans) < 0) ans = s;
        }
        dfs(root.left, sb);
        dfs(root.right, sb);
        sb.deleteCharAt(0);
    }
    public String smallestFromLeaf(TreeNode root) {
        ans = "";
        dfs(root, new StringBuilder());
        return ans;
    }
}
