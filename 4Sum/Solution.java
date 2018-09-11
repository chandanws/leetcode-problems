// Problem link: https://leetcode.com/problems/4sum/description/
// Status: Accepted

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        HashMap<Integer, List<List<Integer>>> hm = new HashMap<Integer, List<List<Integer>>>();
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(!hm.containsKey(nums[i] + nums[j])) hm.put(nums[i] + nums[j], new ArrayList<>());
                hm.get(nums[i] + nums[j]).add(new ArrayList<>(Arrays.asList(i, j)));
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        HashSet<String> hs = new HashSet<String>();
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                int remain = target - (nums[i] + nums[j]);
                if(hm.containsKey(remain)) {
                    for(int k = 0; k < hm.get(remain).size(); k++) {
                        if(hm.get(remain).get(k).get(0) != i &&
                           hm.get(remain).get(k).get(0) != j &&
                           hm.get(remain).get(k).get(1) != i &&
                           hm.get(remain).get(k).get(1) != j &&
                           hm.get(remain).get(k).get(0) < hm.get(remain).get(k).get(1)) {
                            List<Integer> ans = Arrays.asList(
                                nums[i],
                                nums[j],
                                nums[hm.get(remain).get(k).get(0)],
                                nums[hm.get(remain).get(k).get(1)]
                            );
                            Collections.sort(ans);
                            String ansInStr = Arrays.toString(ans.toArray());
                            if(hs.contains(ansInStr)) continue;
                            res.add(new ArrayList<>(ans));
                            hs.add(ansInStr);
                        }
                    }
                }
            }
        }
        return res;
    }
}
