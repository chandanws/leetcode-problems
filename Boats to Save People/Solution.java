// Problem link: https://leetcode.com/problems/boats-to-save-people/description/
// Status: Accepted

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0, right = people.length - 1, numBoats = 0;
        while(left <= right) {
            if(people[right] == limit || people[left] + people[right] > limit) {
                numBoats++;
                right--;
            } else {
                right--;
                left++;
                numBoats++;
            }
        }
        return numBoats;
    }
}
