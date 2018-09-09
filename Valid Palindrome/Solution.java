// Problem link: https://leetcode.com/problems/valid-palindrome/description/
// Status: Accepted

class Solution {
    private boolean isAlphanumeric(char c) {
        return c >= 'a' && c <= 'z' || c >= '0' && c <= '9';
    }
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int i = 0, j = s.length() - 1;
        while(i < j) {
            while(i < j && !isAlphanumeric(s.charAt(i))) i++;
            while(i < j && !isAlphanumeric(s.charAt(j))) j--;
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
