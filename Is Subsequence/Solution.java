// Problem link: https://leetcode.com/problems/is-subsequence/description/
// Status: Accepted

class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0, n = s.length(), m = t.length();
        while(n > 0 && j < m) {
            if(s.charAt(i) == t.charAt(j++)) {
                i++;
                if(i == n) return true;
            }
        }
        return n == 0 ? true : false;
    }
}
