// Problem link: https://leetcode.com/problems/valid-palindrome-ii/description/
// Status: Accepted

class Solution {
    private boolean deleteOnce = true;
    private boolean helper(int i, int j, String s) {
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) {
                if((s.charAt(i + 1) == s.charAt(j) && helper(i + 1, j, s) || 
                   s.charAt(j - 1) == s.charAt(i) && helper(i, j - 1, s)) && deleteOnce) {
                    deleteOnce = false;
                    return true;
                }
                return false;
            }
            if(i + 1 == j) break;
            i++;
            j--;
        }
        return true;
    }
    public boolean validPalindrome(String s) {
        int len = s.length();
        int i = 0, j = len - 1;
        if(len < 3) return true;
        return helper(i, j, s);
    }
}
