// Problem link: https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
// Status: Accepted

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int num : nums) {
            int index = Math.abs(num) - 1;
            if(nums[index] > 0) {
                nums[index] *= -1;
            } else {
                res.add(index + 1);
            }
        }
        return res;
    }
}
