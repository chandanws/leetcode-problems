// Problem link: https://leetcode.com/problems/total-hamming-distance/description/
// Status: Accepted

class Solution {
    public int totalHammingDistance(int[] nums) {
        int totalHammingDist = 0;
        for(int i = 0; i < 32; i++) {
            int numOf1s = 0, numOf0s = 0;
            for(int j = 0; j < nums.length; j++) {
                if(nums[j] % 2 == 0) numOf0s++;
                else numOf1s++;
                nums[j] /= 2;
            }
            totalHammingDist += numOf1s * numOf0s;
        }
        return totalHammingDist;
    }
}
