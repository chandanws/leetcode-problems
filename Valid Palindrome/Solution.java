// Problem link: https://leetcode.com/problems/valid-palindrome/description/
// Status: Accepted

class Solution {
    private boolean isAlphaOrNumeric(char chara) {
        return ((chara >= 'a' && chara <= 'z') ||
           (chara >= '0' && chara <= '9'));
    }
    public boolean isPalindrome(String s) {
        if(s.length() == 0) return true;
        s = s.toLowerCase();
        int len = s.length(), i = 0, j = len - 1;
        while(i != j) {
            while(!(isAlphaOrNumeric(s.charAt(i))) && i < j) i++;
            while(!(isAlphaOrNumeric(s.charAt(j))) && i < j) j--;
            if(s.charAt(i) != s.charAt(j)) return false;
            if(i + 1 == j || i == j) break;
            i++;
            j--;
        }
        return true;
    }
}
