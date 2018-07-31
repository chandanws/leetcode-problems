// Problem link: https://leetcode.com/problems/integer-break/description/
// Status: Accepted

class Solution {
    private int dp(int current, int target, int[] dp) {
        if(current > target) return dp[target];
        int i = 1, j = current - 1, max = Integer.MIN_VALUE;
        while(i <= j) {
            int currentMax = 1;
            if(dp[i] > i) currentMax *= dp[i];
            else currentMax *= i;
            if(dp[j] > j) currentMax *= dp[j];
            else currentMax *= j;
            max = Math.max(max, currentMax);
            i++;
            j--;
        }
        dp[current] = max;
        return dp(current + 1, target, dp);
    }
    public int integerBreak(int n) {
        int [] dp = new int[n + 1];
        dp[1] = 1;
        return dp(2, n, dp);
    }
}
