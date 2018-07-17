// Problem link: https://leetcode.com/problems/longest-palindromic-substring/description/
// Status: Accepted

class Solution {
    private String longestPalindromeStr;
    private void dp(String s, int i, int j) {
        if(i < 0 || j < 0 || i >= s.length() || j >= s.length() || s.charAt(i) != s.charAt(j)) return;
        if((j - i + 1) > longestPalindromeStr.length()) longestPalindromeStr = s.substring(i, j + 1);
        dp(s, i - 1, j + 1);
        if(i == j) dp(s, i, j + 1);
    }
    public String longestPalindrome(String s) {
        longestPalindromeStr = "";
        for(int i = 0; i < s.length(); i++) dp(s, i, i);
        return longestPalindromeStr;
    }
}
