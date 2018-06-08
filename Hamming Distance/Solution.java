// Problem link: https://leetcode.com/problems/hamming-distance/description/
// Status: Accepted

class Solution {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        String binary = Integer.toBinaryString(xor);
        int res = 0;
        for(char c : binary.toCharArray()) if(c == '1') res++;
        return res;
    }
}
