// Problem link: https://leetcode.com/problems/contains-duplicate-iii/description/
// Status: Accepted

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums == null || nums.length == 0 || t < 0 || k < 0) {
          return false;
        }
        TreeSet<Long> ts = new TreeSet<>();
        for(int i = 0; i < nums.length; i++) {
          if(ts.contains((long)nums[i])) return true;
          if(ts.floor((long)nums[i]) != null && (long)nums[i] - ts.floor((long)nums[i]) <= t) return true;
          if(ts.ceiling((long)nums[i]) != null && ts.ceiling((long)nums[i]) - (long)nums[i] <= t) return true;
          ts.add((long)nums[i]);
          if(ts.size() > k) {
            ts.remove((long)nums[i - k]);
          }
        }
        return false;
    }
}
