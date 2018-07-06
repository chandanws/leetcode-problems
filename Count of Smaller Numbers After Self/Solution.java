// Problem link: https://leetcode.com/problems/count-of-smaller-numbers-after-self/description/
// Status: Accepted

class Solution {
    private int binarySearch(List<Integer> l, int target) {
        int low = 0, high = l.size() - 1;
        while(low < high) {
            int mid = low + ((high - low) / 2);
            if(l.get(mid) == target && ((mid + 1) < l.size() && l.get(mid + 1) > target)) return mid;
            if(l.get(mid) <= target) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> sortedNums = new ArrayList<Integer>();
        List<Integer> res = new ArrayList<Integer>();
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(int num : nums) {
            sortedNums.add(num);
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }
        Collections.sort(sortedNums);
        for(int num : nums) {
            int index = binarySearch(sortedNums, num);
            if(index == 0) res.add(0);
            else if(hm.get(sortedNums.get(index)) > 1) {
                res.add(index + 1 - hm.get(sortedNums.get(index)));
                hm.put(sortedNums.get(index), hm.get(sortedNums.get(index)) - 1);
            } else res.add(index);
            sortedNums.remove(index);
        }
        return res;
    }
}
