// Problem link: https://leetcode.com/problems/perfect-squares/description/
// Status: Accepted

class Solution {
    private int [] cache;
    private int dp(int n) {
        if(cache[n] != 0) return cache[n];
        int upper = (int) Math.sqrt(n);
        if(upper * upper == n) {
            cache[n] = 1;
            return cache[n];
        }
        int min = 0;
        for(int i = upper; i >= 1; i--) {
            int res = 1 + dp(n - i * i);
            if(min > 0) min = Math.min(min, res);
            else min = res;
        }
        if(cache[n] == 0) cache[n] = min;
        else cache[n] = Math.min(min, cache[n]);
        return cache[n];
    }
    public int numSquares(int n) {
        cache = new int[n + 1];
        return dp(n);
    }
}
