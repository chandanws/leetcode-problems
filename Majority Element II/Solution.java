// Problem link: https://leetcode.com/problems/majority-element-ii/description/
// Status: Accepted

class Solution {
    public List<Integer> majorityElement(int [] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums.length == 0) return res;
        int candidate1 = 0, count1 = 0;
        int candidate2 = 0, count2 = 0;
        for(int num : nums) {
            if(num == candidate1) count1++;
            else if(num == candidate2) count2++;
            else if(count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if(count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        for(int num : nums) {
            if(candidate1 == num) count1++;
        }
        count2 = 0;
        for(int num : nums) {
            if(candidate2 == num) count2++;
        }
        if(count1 > nums.length / 3) res.add(candidate1);
        if(count2 > nums.length / 3 && (res.size() == 0 || res.get(0) != candidate2)) res.add(candidate2);
        return res;
    }
}
