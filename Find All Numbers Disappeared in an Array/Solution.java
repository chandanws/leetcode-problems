// Problem link: https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
// Status: Accepted

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        List<Integer> res = new ArrayList<>(Arrays.asList(new Integer[len + 1]));
        for(int num : nums) res.set(num, 1);
        int pointer = -1;
        for(int i = 1; i < len + 1; i++) {
            if(res.get(i) == null) nums[++pointer] = i;
        }
        res.clear();
        for(int i = 0; i < pointer + 1; i++) res.add(nums[i]);
        return res;
    }
}
