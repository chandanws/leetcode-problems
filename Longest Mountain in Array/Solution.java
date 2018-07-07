// Problem link: https://leetcode.com/problems/longest-mountain-in-array/description/
// Status: Accepted

class Solution {
    public int longestMountain(int[] A) {
        boolean didU = false, didD = false;
        int up = 1, down = 0, max = 0;
        for(int i = 1; i < A.length; i++) {
            if(A[i] > A[i - 1]) {
                if(didU && didD) up = 1;
                didD = false;
                down = 0;
                didU = true;
                up++;
            } else if(A[i] < A[i - 1]) {
                didD = true;
                down++;
            } else {
                didU = false;
                didD = false;
                up = 1;
                down = 0;
            }
            if(didU && didD) max = Math.max(max, up + down);
        }
        return max;
    }
}
