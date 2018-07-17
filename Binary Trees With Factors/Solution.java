// Problem link: https://leetcode.com/problems/binary-trees-with-factors/description/
// Status: Accepted

class Solution {
    public int numFactoredBinaryTrees(int[] A) {
        long res = 0L, mod = (long) Math.pow(10, 9) + 7;
        Arrays.sort(A);
        HashMap<Integer, Long> cache = new HashMap<Integer, Long>();
        for(int i = 0; i < A.length; i++) {
            cache.put(A[i], 1L);
            for(int j = 0; j < i; j++) {
                if(A[i] % A[j] == 0 && cache.containsKey(A[i] / A[j]))
                    cache.put(A[i], cache.get(A[i]) + cache.get(A[j]) * cache.get(A[i] / A[j]));
            }
        }
        for(long num : cache.values()) res = (res + num) % mod;
        return (int) res;
    }
}
