// Problem link: https://leetcode.com/problems/shortest-distance-to-a-character/description/
// Status: Accepted

class Solution {
    public int[] shortestToChar(String S, char C) {
        int [] res = new int[S.length()];
        int prev = -S.length() * 2;
        for(int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == C) prev = i;
            res[i] = i - prev;
        }
        prev = S.length() * 2;
        for(int i = S.length() - 1; i >= 0; i--) {
            if(S.charAt(i) == C) prev = i;
            res[i] = Math.min(res[i], prev - i);
        }
        return res;
    }
}
