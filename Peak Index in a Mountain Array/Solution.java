// Problem link: https://leetcode.com/problems/peak-index-in-a-mountain-array/description/
// Status: Accepted

class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int len = A.length, i = 1;
        while(i < len - 1) {
            if(A[i - 1] < A[i] && A[i] > A[i + 1]) break;
            i++;
        }
        return i;
    }
}
