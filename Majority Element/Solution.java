// Problem link: https://leetcode.com/problems/majority-element/description/
// Status: Accepted

import java.util.Hashtable;
class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length, times = (int)Math.floor((float)n/2), majorityNum = 0;
        Hashtable<Integer, Integer> ht = new Hashtable<>();
        for(int i = 0; i < n; i++) {
            if(ht.containsKey(nums[i])) ht.put(nums[i], ht.get(nums[i]) + 1);
            else ht.put(nums[i], 1);
            if(ht.get(nums[i]) > times) { 
                majorityNum = nums[i];
                break;
            }
        }
        return majorityNum;
    }
}
