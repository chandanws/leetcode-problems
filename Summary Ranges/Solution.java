// Problem link: https://leetcode.com/problems/summary-ranges/description/
// Status: Accepted

class Solution {
    private final String RIGHTARROW = "->";
    private String getRange(int low, int high) {
        if(low == high) return Integer.toString(low);
        return new String(low + RIGHTARROW + high);
    }
    public List<String> summaryRanges(int[] nums) {
        int len = nums.length;
        ArrayList<String> res = new ArrayList<>();
        if(len == 0) return res;
        int low = nums[0], high = nums[0];
        for(int i = 1; i < len; i++) {
            if(Math.abs(Math.abs(nums[i]) - Math.abs(nums[i - 1])) == 1) {
                high = nums[i];
            } else {
                res.add(getRange(low, high));
                low = nums[i];
                high = nums[i];
            }
        }
        res.add(getRange(low, high));
        return res;
    }
}
