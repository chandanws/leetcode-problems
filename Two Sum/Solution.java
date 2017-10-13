// Problem link: https://leetcode.com/problems/two-sum/description/
// Live example link: https://repl.it/M9Cw
// Status: Accepted

import java.util.*;

class Solution {
  public int[] twoSum(int[] nums, int target) {
    boolean shouldBreak = false;
    int [] result = null;

    for (int i = 0; i < nums.length && !shouldBreak; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] + nums[j] == target) {
          result = new int[]{i, j};
          shouldBreak = true;
          break;
        }
      }
    }

    return result;
  }
}
