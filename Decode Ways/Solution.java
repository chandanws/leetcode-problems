// Problem link: https://leetcode.com/problems/decode-ways/description/
// Live example link: https://repl.it/repls/NocturnalSeveralPerch
// Status: Accepted

import java.util.*;

class Solution {
  public static int numDecodings(String s) {
    if(s == null || s.length() == 0) { return 0; }
    int n = s.length();
    int [] dp = new int[n+1];
    dp[0] = 1;
    dp[1] = s.charAt(0) == '0' ? 0 : 1;
    for(int i = 2; i <= n; i++) {
      int first = Integer.valueOf(s.substring(i-1, i));
      int second = Integer.valueOf(s.substring(i-2, i));
      if(first >= 1 && first <= 9) {
        dp[i] = dp[i-1];
      }
      if(second >= 10 && second <= 26) {
        dp[i] += dp[i-2];
      }
    }
    return dp[n];
  }
  public static void main(String[] args) {
    System.out.println(numDecodings("") == 0);
    System.out.println(numDecodings(null) == 0);
    System.out.println(numDecodings("0") == 0);
    System.out.println(numDecodings("5") == 1);
    System.out.println(numDecodings("24") == 2);
    System.out.println(numDecodings("99") == 1);
    System.out.println(numDecodings("241515") == 8);
    System.out.println(numDecodings("240006") == 0);
  }
}
