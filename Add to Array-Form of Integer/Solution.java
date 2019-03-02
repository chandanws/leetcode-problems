// Problem link: https://leetcode.com/problems/add-to-array-form-of-integer/description/
// Status: Accepted

class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> ans = new ArrayList<>();
        int i = A.length, curr = K;
        while(--i >= 0 || curr > 0) {
            if(i >= 0) curr += A[i];
            ans.add(0, curr % 10);
            curr /= 10;
        }
        return ans;
    }
}
