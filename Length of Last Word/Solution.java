// Problem link: https://leetcode.com/problems/length-of-last-word/description/
// Status: Accepted

class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int len = s.length(), i = len - 1;
        if(len == 0) return 0;
        while(i >= 0 && s.charAt(i) != ' ') i--;
        if(i < 0) return len;
        return len - 1 - i;
    }
}
