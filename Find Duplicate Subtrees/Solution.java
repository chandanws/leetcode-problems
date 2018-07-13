// Problem link: https://leetcode.com/problems/find-duplicate-subtrees/description/
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
    private HashMap<String, TreeNode> hm;
    private HashSet<String> duplHs;
    private StringBuilder helper(TreeNode root) {
        if(root == null) return new StringBuilder();
        StringBuilder paths = new StringBuilder();
        paths.append(root.val);
        paths.append("(" + helper(root.left) + ")");
        paths.append("(" + helper(root.right) + ")");
        if(!hm.containsKey(paths.toString())) hm.put(paths.toString(), root);
        else duplHs.add(paths.toString());
        return paths;
    }
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        hm = new HashMap<String, TreeNode>();
        duplHs = new HashSet<String>();
        helper(root);
        List<TreeNode> res = new ArrayList<TreeNode>();
        Iterator itr = duplHs.iterator();
        while(itr.hasNext()) res.add(hm.get(itr.next()));
        return res;
    }
}
