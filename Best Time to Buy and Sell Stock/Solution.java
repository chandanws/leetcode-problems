// Problem link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
// Status: Accepted

class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) {
          return 0;
        }
        int maxProfit = 0, min = prices[0];
        for(int i = 0; i < prices.length; i++) {
          if(min > prices[i]) {
            min = prices[i];
          }
          if(prices[i] - min > maxProfit) {
            maxProfit = prices[i] - min;
          }
        }
        return maxProfit;
    }
}
