// Problem link: https://leetcode.com/problems/4sum-ii/description/
// Status: Accepted

class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> hm2 = new HashMap<Integer, Integer>();
        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < A.length; j++) {
                hm2.put(C[i] + D[j], hm2.getOrDefault(C[i] + D[j], 0) + 1);
            }
        }
        int res = 0;
        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < A.length; j++) {
                int sum = A[i] + B[j];
                res += hm2.getOrDefault(sum <= 0 ? Math.abs(sum) : -sum, 0);
            }
        }
        return res;
    }
}
