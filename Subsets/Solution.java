// Problem link: https://leetcode.com/problems/subsets/description/
// Status: Accepted

class Solution {
    private void helper(int[] nums, int index, List<Integer> currentList, List<List<Integer>> res) {
        if(index >= nums.length) return;
        currentList.add(nums[index]);
        res.add(new ArrayList<>(currentList));
        helper(nums, index + 1, currentList, res);
        currentList.remove(currentList.size() - 1);
        helper(nums, index + 1, currentList, res);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        helper(nums, 0, new ArrayList<>(), res);
        return res;
    }
}
