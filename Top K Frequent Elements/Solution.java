// Problem link: https://leetcode.com/problems/top-k-frequent-elements/description/
// Status: Accepted

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int mostFreq = Integer.MIN_VALUE;
        for(int num : nums) {
            int count = hm.getOrDefault(num, 0) + 1;
            hm.put(num, count);
            if(count > mostFreq) mostFreq = count;
        }
        ArrayList<ArrayList<Integer>> l = new ArrayList<>();
        for(int i = 0; i < mostFreq; i++) l.add(new ArrayList<>());
        for(Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            l.get(entry.getValue() - 1).add(entry.getKey());
        }
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = mostFreq - 1; i >= 0; i--) {
            int size = l.get(i).size();
            for(int j = 0; j < size && k > 0; j++, k--) res.add(l.get(i).get(j));
        }
        return res;
    }
}
