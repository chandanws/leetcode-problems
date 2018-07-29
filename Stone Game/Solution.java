// Problem link: https://leetcode.com/contest/weekly-contest-95/problems/stone-game/
// Status: Accepted

class Solution {
    private boolean couldWin;
    private boolean dp(int[] piles, int low, int high, int sum1, int sum2, boolean wasAlexTurn) {
        if(couldWin) return true;
        if(low == high) {
            couldWin = true;
            return sum1 > sum2;
        }
        if(wasAlexTurn) {
            return dp(piles, low + 1, high, sum1 + piles[low], sum2, false) || 
                dp(piles, low, high - 1, sum1 + piles[high], sum2, false);
        }
        return dp(piles, low + 1, high, sum1, sum2 + piles[low], true) || 
                dp(piles, low, high - 1, sum1, sum2 + piles[high], true);
    }
    public boolean stoneGame(int[] piles) {
        couldWin = false;
        return dp(piles, 0, piles.length - 1, 0, 0, true);
    }
}
