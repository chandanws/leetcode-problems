// Problem link: https://leetcode.com/problems/palindrome-number/description/
// Live example link: https://repl.it/Mc3v
// Status: Accepted

import java.util.*;

class Solution {
  public boolean isPalindrome(int x) {
    int numOfD = Integer.toString(x).split("").length;
    if (numOfD == 1) {
      return true;
    } else if (x < 0) {
      return false;
    }
    int i = 0, j = numOfD - 1;
    while (true) {
      int left = (int) ( x / Math.pow(10, j)) % 10;
      int right = (int) ( x / Math.pow(10, i)) % 10;
      if (right != left) {
        return false;
      }
      if (i + 1 == j || i + 1 == j - 1) {
        break;
      }
      i++;
      j--;
    }
    return true;
  }
}
