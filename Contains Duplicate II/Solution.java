// Problem link: https://leetcode.com/problems/contains-duplicate-ii/description/
// Status: Accepted

import java.util.*;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
          return false;
        }
        Hashtable<Integer, Integer> ht = new Hashtable<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
          if(ht.containsKey(nums[i]) && i - ht.get(nums[i]) <= k) {
              return true;
          }
          ht.put(nums[i], i);
        }
        return false;
    }
}
