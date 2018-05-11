// Problem link: https://leetcode.com/problems/find-the-duplicate-number/description/
// Status: Accepted

class Solution {
    // we can easily use HashSet to find duplicate number if O(N) space is allowed.
    public int findDuplicate(int[] nums) {
        HashSet<Integer> hs = new HashSet<Integer>();
        for(int num : nums) {
            if(hs.contains(num)) return num;
            else hs.add(num);
        }
        return Integer.MAX_VALUE; // should never comes here
    }
    // when modifying the array is allowed with constraint of constant space. Running time is O(N) 
    public int findDuplicate(int[] nums) {
        int len = nums.length, i = 0, index = 0;
        while(i < len) {
            index = Math.abs(nums[i++]);
            if(nums[index] < 0) break;
            nums[index] *= -1;
        }
        return index;
    }
    // when modifying the array isn't allowed with constraint of constant space. We can do Binary search. Running time is
    // O(N*logN).
    public int findDuplicate(int[] nums) {
        int len = nums.length, low = 1, high = len;
        while(low < high) {
            int count = 0, mid = (high - low) / 2 + low;
            for(int num : nums) if(num > mid) count++;
            if(count < (len - mid)) high = mid;
            else low = mid + 1;
        }
        return high;
    }
}
