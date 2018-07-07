// Problem link: https://leetcode.com/problems/construct-binary-tree-from-string/description/
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
    private List<String> parse(String s) {
        List<String> res = new ArrayList<String>();
        int i = 0;
        int firstParentheses = -1, opening = 0, leftTreeEnd = -1, rightTreeEnd = -1;
        while(i < s.length()) {
            if(s.charAt(i) == '(') {
                if(firstParentheses == -1) firstParentheses = i;
                opening++;
            } else if(s.charAt(i) == ')') {
                opening--;
                if(opening == 0) {
                    if(leftTreeEnd == -1) leftTreeEnd = i;
                    else rightTreeEnd = i;
                }
            }
            i++;
        }
        if(firstParentheses == -1 && leftTreeEnd == -1 && rightTreeEnd == -1) {
            res.add(s);
            res.add("null");
            res.add("null");
        } else {
            res.add(s.substring(0, firstParentheses));
            res.add(s.substring(firstParentheses + 1, leftTreeEnd));
            if(rightTreeEnd == - 1) res.add("null");
            else res.add(s.substring(leftTreeEnd + 2, rightTreeEnd));
        }
        return res;
    }
    private TreeNode helper(String parent, String left, String right) {
        TreeNode p = new TreeNode(Integer.parseInt(parent));
        try {
            p.left = left != "null" ? new TreeNode(Integer.parseInt(left)) : null;
            p.right = right != "null" ? new TreeNode(Integer.parseInt(right)) : null;
        } catch (NumberFormatException ex) {
            if(left.equals("null")) {
                p.left = null;
            } else {
                List<String> leftL = parse(left);
                p.left = helper(leftL.get(0), leftL.get(1), leftL.get(2));
            }
            if(right.equals("null")) {
                p.right = null;
            } else {
                List<String> rightL = parse(right);
                p.right = helper(rightL.get(0), rightL.get(1), rightL.get(2));
            }
        }
        return p;
    }
    public TreeNode str2tree(String s) {
        if(s.equals("")) return null;
        List<String> l = parse(s);
        return helper(l.get(0), l.get(1), l.get(2));
    }
}
