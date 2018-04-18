// Problem link: https://leetcode.com/problems/reverse-string/description/
// Status: Accepted

class Solution {
    public String reverseString(String s) {
        int len = s.length();
        if(s == null || len == 0) return s;
        int i = 0, j = len - 1;
        char [] sChars = s.toCharArray();
        while(i != j) {
            char c = sChars[i];
            sChars[i] = sChars[j];
            sChars[j] = c;
            if(i + 1 == j) break;
            i++;
            j--;
        }
        return String.valueOf(sChars);
    }
}
