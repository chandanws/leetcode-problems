// Problem link: https://leetcode.com/problems/k-diff-pairs-in-an-array/description/
// Status: Accepted

class Solution {
    public int findPairs(int[] nums, int k) {
        int count = 0;
        Arrays.sort(nums);
        HashSet<String> hs = new HashSet<String>();
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                int differences = Math.abs(nums[i] - nums[j]);
                if(hs.contains(nums[i] + "-" + nums[j]) || hs.contains(nums[j] + "-" + nums[i])) continue;
                if(differences > k) break;
                if(differences == k) {
                    hs.add(nums[i] + "-" + nums[j]);
                    hs.add(nums[j] + "-" + nums[i]);
                    count++;
                }
            }
        }
        return count;
    }
}
