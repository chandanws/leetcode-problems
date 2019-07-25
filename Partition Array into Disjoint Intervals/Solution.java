// Problem link: https://leetcode.com/problems/partition-array-into-disjoint-intervals/description/
// Status: Accepted

class Solution {
    public int partitionDisjoint(int[] A) {
        int [] leftMax = new int[A.length];
        int max = A[0];
        leftMax[0] = max;
        for(int i = 1; i < A.length; i++) {
            if(max < A[i]) max = A[i];
            leftMax[i] = max;
        }
        int [] rightMin = new int[A.length];
        int min = A[A.length - 1];
        rightMin[A.length - 1] = min;
        for(int i = A.length - 2; i >= 0; i--) {
            if(min > A[i]) min = A[i];
            rightMin[i] = min;
        }
        for(int i = 1; i < A.length; i++) {
            if(leftMax[i - 1] <= rightMin[i]) return i;
        }
        throw null;
    }
}
