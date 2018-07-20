// Problem link: https://leetcode.com/problems/most-frequent-subtree-sum/description/
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
    private int mostFreqCount;
    private HashMap<Integer, Integer> hm;
    private int helper(TreeNode root, int sum) {
        if(root.left == null && root.right == null) return root.val;
        int left = 0;
        if(root.left != null) {
            left = helper(root.left, sum);
            hm.put(left, hm.getOrDefault(left, 0) + 1);
            mostFreqCount = Math.max(mostFreqCount, hm.get(left));
        }
        int right = 0;
        if(root.right != null) {
            right = helper(root.right, sum);
            hm.put(right, hm.getOrDefault(right, 0) + 1);
            mostFreqCount = Math.max(mostFreqCount, hm.get(right));
        }
        return left + right + root.val;
    }
    public int[] findFrequentTreeSum(TreeNode root) {
        if(root == null) return new int[0];
        mostFreqCount = 0;
        hm = new HashMap<Integer, Integer>();
        int totalSum = helper(root, 0);
        hm.put(totalSum, hm.getOrDefault(totalSum, 0) + 1);
        mostFreqCount = Math.max(mostFreqCount, hm.get(totalSum));
        List<Integer> l = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            if(entry.getValue() == mostFreqCount) l.add(entry.getKey());
        }
        return l.stream().mapToInt(Integer::intValue).toArray();
    }
}
