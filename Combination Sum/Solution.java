// Problem link: https://leetcode.com/problems/combination-sum/description/
// Status: Accepted

class Solution {
    List<List<Integer>> res;
    private void helper(int [] candidates, List<Integer> l, int sum, int i) {
        if(sum < 0) return;
        if(sum == 0) {
            res.add(l);
            return;
        }
        for(int j = i; j < candidates.length; j++) {
            List<Integer> newList = new ArrayList<>();
            newList.addAll(l);
            newList.add(candidates[j]);
            helper(candidates, newList, sum - candidates[j], j);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        helper(candidates, new ArrayList<>(), target, 0);
        return res;
    }
}
