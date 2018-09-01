// Problem link: https://leetcode.com/problems/3sum/description/
// Status: Accepted

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        HashSet<String> hs = new HashSet<String>();
        for(int i = 0; i < nums.length; i++) {
            int l = i + 1, r = nums.length - 1;
            while(l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if(sum == 0) {
                    if(!hs.contains(nums[i] + "|" + nums[l] + "|" + nums[r])) {
                        res.add(new ArrayList<>(Arrays.asList(nums[i], nums[l], nums[r])));
                        hs.add(nums[i] + "|" + nums[l] + "|" + nums[r]);
                    }
                    l++;
                    r--;
                } else if(sum > 0) r--;
                else l++;
            }
        }
        return res;
    }
}
