// Problem link: https://leetcode.com/problems/shortest-distance-to-a-character/description/
// Status: Accepted

class Solution {
    public int[] shortestToChar(String S, char C) {
        int left = -1, right = -1;
        for(int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == C) {
                if(left == -1) left = i;
                else if(right == -1) right = i;
            }
        }
        if(right == -1) right = left;
        int [] res = new int[S.length()];
        for(int i = 0; i < S.length(); i++) {
            res[i] = Math.min(Math.abs(left - i), right < S.length() ? Math.abs(right - i) : Integer.MAX_VALUE);
            if(right == i) {
                left = right++;
                while(right < S.length() && S.charAt(right) != C) right++;
            }
        }
        return res;
    }
}
