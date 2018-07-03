// Problem link: https://leetcode.com/problems/distinct-subsequences/description/
// Status: Accepted

class Solution {
    private int [][] cache;
    private int helper(String s, int subSLen, String t, int subTLen) {
        if(cache[subSLen][subTLen] != -1) return cache[subSLen][subTLen];
        if(subTLen == 0) return 1;
        else if(subSLen == 0) return 0;
        int sLen = s.length(), tLen = t.length();
        if(s.charAt(sLen - subSLen) == t.charAt(tLen - subTLen)){
            cache[subSLen - 1][subTLen - 1] = helper(s, subSLen - 1, t, subTLen - 1);
            cache[subSLen - 1][subTLen] = helper(s, subSLen - 1, t, subTLen);
            return cache[subSLen - 1][subTLen - 1] + cache[subSLen - 1][subTLen];
        }
        cache[subSLen - 1][subTLen] = helper(s, subSLen - 1, t, subTLen);
        return cache[subSLen - 1][subTLen];
    }
    public int numDistinct(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        cache = new int[sLen + 1][tLen + 1];
        for(int i = 0; i < sLen + 1; i++) {
            for(int j = 0; j < tLen + 1; j++) cache[i][j] = -1;
        }
        return helper(s, sLen, t, tLen);
    }
}
