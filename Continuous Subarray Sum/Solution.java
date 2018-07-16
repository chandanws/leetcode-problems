// Problem link: https://leetcode.com/problems/continuous-subarray-sum/description/
// Status: Accepted

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int numOfZeros = nums[0] == 0 ? 1 : 0;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        if(k != 0) hm.put(nums[0] % k, 1);
        for(int i = 1; i < nums.length; i++) {
            if(k != 0) {
                nums[i] += nums[i - 1];
                int remainder = nums[i] % k;
                if(remainder == 0) return true;
                if(hm.containsKey(remainder)) return true;
                else hm.put(remainder, 1);
            } else {
                if(nums[i] == 0) numOfZeros++;
                else numOfZeros = 0;
                if(numOfZeros > 1) return true;
            }
        }
        return false;
    }
}
