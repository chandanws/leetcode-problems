// Problem link: https://leetcode.com/problems/rectangle-area/description/
// Status: Accepted

class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int bottom = Math.max(B, F), top = Math.max(Math.min(D, H), bottom);
        int left = Math.max(A, E), right = Math.max(Math.min(C, G), left);
        return (C - A) * (D - B) - (right - left) * (top - bottom) + (G - E) * (H - F);
    }
}
