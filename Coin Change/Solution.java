// Problem link: https://leetcode.com/problems/coin-change/description/
// Status: Accepted

class Solution {
    private int dp(int [] coins, int remaining, int [] cache) {
        if(remaining < 0) return -1;
        if(remaining == 0) return 0;
        if(cache[remaining - 1] != 0) return cache[remaining - 1];
        int min = Integer.MAX_VALUE;
        for(int coin : coins) {
            int res = dp(coins, remaining - coin, cache);
            if(res >= 0 && res < min) {
                min = res + 1;
            }
        }
        cache[remaining - 1] = min == Integer.MAX_VALUE ? -1 : min;
        return cache[remaining - 1];
    }
    public int coinChange(int[] coins, int amount) {
        if(amount < 1) return 0;
        return dp(coins, amount, new int[amount]);
    }
}
