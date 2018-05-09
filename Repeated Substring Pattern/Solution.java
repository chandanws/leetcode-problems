// Problem link: https://leetcode.com/problems/repeated-substring-pattern/description/
// Status: Accepted

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        if(len < 2) return false;
        int slidingWindowSize = 1, i = 0;
        while(i < len && i + slidingWindowSize < len) {
            if(s.charAt(i) != s.charAt(i + slidingWindowSize)) {
                slidingWindowSize++;
                i = 0;
            } else i++;
        }
        return slidingWindowSize < len ? s.substring(len - slidingWindowSize, len).equals(s.substring(0, slidingWindowSize)) : false;
    }
}
