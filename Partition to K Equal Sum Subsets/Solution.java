// Problem link: https://leetcode.com/problems/partition-to-k-equal-sum-subsets/description/
// Status: Accepted

class Solution {
    private boolean search(int [] groups, int [] nums, int index, int target) {
        if(index < 0) return true;
        int v = nums[index--];
        for(int i = 0; i < groups.length; i++) {
            if(groups[i] + v <= target) {
                groups[i] += v;
                if(search(groups, nums, index, target)) return true;
                groups[i] -= v;
            }
            if(groups[i] == 0) return false;
        }
        return false;
    }
    public boolean canPartitionKSubsets(int [] nums, int k) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++) sum += nums[i];
        if(sum % k > 0) return false;
        int target = sum / k, i = nums.length - 1;
        Arrays.sort(nums);
        while(i >= 0 && nums[i] == target) {
            i--;
            k--;
        }
        return search(new int[k], nums, i, target);
    }
}
