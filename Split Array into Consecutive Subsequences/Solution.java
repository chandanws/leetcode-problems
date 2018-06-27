// Problem link: https://leetcode.com/problems/split-array-into-consecutive-subsequences/description/
// Status: Accepted

class Solution {
    public boolean isPossible(int[] nums) {
        HashMap<Integer, Integer> freqHm = new HashMap<Integer, Integer>();
        for(int num : nums) freqHm.put(num, freqHm.getOrDefault(num, 0) + 1);
        HashMap<Integer, Integer> seqHm = new HashMap<Integer, Integer>();
        for(int num : nums) {
            if(!freqHm.containsKey(num)) continue;
            int start = num;
            if(seqHm.containsKey(start - 1)) {
                seqHm.put(start - 1, seqHm.get(start - 1) - 1);
                if(seqHm.get(start - 1) <= 0) seqHm.remove(start - 1);
                seqHm.put(start, seqHm.getOrDefault(start, 0) + 1);
                freqHm.put(start, freqHm.get(start) - 1);
                if(freqHm.get(start) <= 0) freqHm.remove(start);
            } else {
                int i = start;
                while(i < start + 3) {
                    if(!freqHm.containsKey(i)) return false;
                    freqHm.put(i, freqHm.get(i) - 1);
                    if(freqHm.get(i) <= 0) freqHm.remove(i);
                    i++;
                }
                if(i == start + 3) seqHm.put(i - 1, seqHm.getOrDefault(i - 1, 0) + 1);
            }
        }
        return true;
    }
}
