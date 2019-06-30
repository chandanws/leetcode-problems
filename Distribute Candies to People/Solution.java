// Problem link: https://leetcode.com/problems/distribute-candies-to-people/description/
// Status: Accepted

class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int [] ans = new int[num_people];
        int count = 0;
        while(candies > 0) {
            for(int i = 0; i < num_people && candies > 0; i++) {
                if(candies >= (count + 1)) {
                    ans[i] += (count + 1);
                    candies -= (count + 1);
                } else {
                    ans[i] += candies;
                    candies = 0;
                }
                count++;
            }
        }
        return ans;
    }
}
