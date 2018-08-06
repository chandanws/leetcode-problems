// Problem link: https://leetcode.com/problems/partition-equal-subset-sum/description/
// Status: Accepted

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) sum += num;
        int half = sum / 2;
        if(half * 2 != sum) return false;
        Arrays.sort(nums);
        for(int i = nums.length - 1; i >= 0; i--) {
            int currentHalf = half;
            for(int j = i; j >= 0; j--) {
                if(nums[j] <= currentHalf) currentHalf -= nums[j];
                if(currentHalf == 0) return true;
            }
        }
        return false;
    }
}
