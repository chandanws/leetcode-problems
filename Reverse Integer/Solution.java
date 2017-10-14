// Problem link: https://leetcode.com/problems/reverse-integer/description/
// Live example link: https://repl.it/McVU
// Status: Accepted

import java.util.*;

class Solution {
  public int reverse(int x) {
    String reverseNums = "";
    if (x < 0) {
      reverseNums += "-";
      x *= -1;
    }
    while (x != 0) {
      reverseNums += Integer.toString(x % 10);
      x /= 10;
    }
    try {
      return Integer.parseInt(reverseNums);
    } catch (NumberFormatException ex) {
      return 0;
    }
  }
}
