// Problem link: https://leetcode.com/problems/implement-strstr/description/
// Status: Accepted

class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) return 0;
        int haystackLen = haystack.length(), needleLen = needle.length();
        if(needleLen > haystackLen) return -1;
        for(int i = 0; i <= (haystackLen - needleLen); i++) {
            if(haystack.substring(i, i + needleLen).equals(needle)) return i;
        }
        return -1;
    }
}
