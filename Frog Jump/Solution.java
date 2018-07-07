// Problem link: https://leetcode.com/problems/frog-jump/description/
// Status: Accepted

class Solution {
    private int lastStonePos;
    private boolean helper(HashSet<Integer> hs, HashMap<String, Boolean> cache, int posOfFrog, int stepSize) {
        if(!hs.contains(posOfFrog)) return false;
        if(cache.containsKey(posOfFrog + "-" + stepSize)) return cache.get(posOfFrog + "-" + stepSize);
        if(posOfFrog == lastStonePos) return true;
        if(stepSize - 1 >= 1) {
            if(helper(hs, cache, posOfFrog + stepSize - 1, stepSize - 1)) return true;
            cache.put((posOfFrog + stepSize - 1) + "-" + (stepSize - 1), false);
        }
        if(helper(hs, cache, posOfFrog + stepSize, stepSize)) return true;
        cache.put((posOfFrog + stepSize) + "-" + stepSize, false);
        if(posOfFrog > 0) {
            if(helper(hs, cache, posOfFrog + stepSize + 1, stepSize + 1)) return true;
            cache.put((posOfFrog + stepSize + 1) + "-" + (stepSize + 1), false);
        }
        return false;
    }
    public boolean canCross(int[] stones) {
        HashSet<Integer> hs = new HashSet<Integer>();
        for(int stone : stones) hs.add(stone);
        HashMap<String, Boolean> cache = new HashMap<String, Boolean>();
        lastStonePos = stones[stones.length - 1];
        return helper(hs, cache, 0, 1);
    }
}
