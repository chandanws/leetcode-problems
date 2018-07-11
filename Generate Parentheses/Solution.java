// Problem link: https://leetcode.com/problems/generate-parentheses/description/
// Status: Accepted

class Solution {
    private List<String> res;
    private void helper(int n, int m, String s) {
        if(n == 0 && m == 0) {
            res.add(s);
        } else {
            if(n < m) {
                if(n - 1 >=0) helper(n - 1, m, s + "(");
                if(m - 1 >=0) helper(n, m - 1, s + ")");
            } else if(n == m) {
                helper(n - 1, m, s + "(");
            }
        }
    }
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<String>();
        helper(n, n, "");
        return res;
    }
}
