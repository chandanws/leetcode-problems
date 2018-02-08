// Problem link: https://leetcode.com/problems/contains-duplicate/description/
// Status: Accepted

class Solution {
    public boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length == 0) {
            return false;
        }
        HashSet<Integer> hs = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++) {
            if(!hs.contains(nums[i])) {
                hs.add(nums[i]);
            } else {
                return true;
            }
        }
        return false;
    }
}
