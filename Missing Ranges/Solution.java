// Problem link: https://leetcode.com/problems/missing-ranges/description/
// Status: Accepted

class Solution {
    private final String RIGHTARROW = "->";
    private String getRange(int low, int high) {
        if(low == high) return low + "";
        return new String(low + RIGHTARROW + high);
    }
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        int len = nums.length;
        ArrayList<String> res = new ArrayList<>();
        int low = lower;
        for(int i = 0; i < len; i++) {
            if(nums[i] > low) res.add(getRange(low, nums[i] - 1));
            if(nums[i] == Integer.MAX_VALUE) break;
            low = nums[i] + 1;
        }
        if(len == 0 || upper > nums[len - 1]) res.add(getRange(low, upper));
        return res;
    }
}
