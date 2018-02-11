// Problem link: https://leetcode.com/problems/add-two-numbers-ii/description/
// Status: Accepted

class Solution {
    public int singleNumber(int[] nums) {
        int leftoutNumber = 0;
        for(int i = 0; i < nums.length; i++) {
          leftoutNumber ^= nums[i];
        }
        return leftoutNumber;
    }
}
