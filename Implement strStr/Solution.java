// Problem link: https://leetcode.com/problems/implement-strstr/description/
// Status: Accepted

class Solution {
    public int strStr(String haystack, String needle) {
        int needleLen = needle.length(), haystackLen = haystack.length();
        if(needleLen == 0) return 0;
        if(haystackLen == 0 || needleLen > haystackLen) return -1;
        int i = 0;
        while(i < haystackLen) {
            if(haystack.charAt(i) == needle.charAt(0) &&
               i + needleLen <= haystackLen &&
               haystack.substring(i, i + needleLen).equals(needle)) return i;
            i++;
        }
        return -1;
    }
}
