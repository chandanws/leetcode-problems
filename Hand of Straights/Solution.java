// Problem link: https://leetcode.com/problems/hand-of-straights/description/
// Status: Accepted

class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        Arrays.sort(hand);
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int len = hand.length;
        for(int i = 0; i < len; i++) hm.put(hand[i], hm.getOrDefault(hand[i], 0) + 1);
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for(int i = 0; i < len; i++) nums.add(hand[i]);
        while(nums.size() > 0) {
            int num = nums.get(0);
            for(int j = 0; j < W; j++) {
                if(!hm.containsKey(num + j) || hm.get(num + j) <= 0) return false;
                hm.put(num + j, hm.get(num + j) - 1);
                nums.remove(nums.indexOf(num + j));
            }
        }
        return true;
    }
}
