// Problem link: https://leetcode.com/problems/longest-palindromic-substring/description/
// Status: Accepted

class Solution {
    private String longestPalindrome;
    private void helper(String s, int i, int j) {
        if(i < 0 || j < 0 || i >= s.length() || j >= s.length() || s.charAt(i) != s.charAt(j)) return;
        if(j - i + 1 > longestPalindrome.length()) longestPalindrome = s.substring(i, j + 1);
        helper(s, i - 1, j + 1);
    }
    public String longestPalindrome(String s) {
        longestPalindrome = "";
        for(int i = 0; i < s.length(); i++) {
            helper(s, i, i);
            helper(s, i, i + 1);
        }
        return longestPalindrome;
    }
}
