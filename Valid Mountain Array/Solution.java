// Problem link: https://leetcode.com/problems/valid-mountain-array/description/
// Status: Accepted

class Solution {
    public boolean validMountainArray(int[] A) {
        if(A.length < 3 || A[0] > A[1]) return false;
        boolean direction = true;
        for(int i = 1; i < A.length; i++) {
            if(A[i - 1] == A[i] || A[i - 1] < A[i] && direction == false) return false;
            if(A[i - 1] > A[i] && direction == true) direction = false;
        }
        return direction == false;
    }
}
