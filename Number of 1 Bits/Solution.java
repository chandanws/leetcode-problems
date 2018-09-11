// Problem link: https://leetcode.com/problems/number-of-1-bits/description/
// Status: Accepted

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int numOfOnes = 0;
        for(int i = 0; i < 32; i++) {
            numOfOnes = numOfOnes + (n & 1);
            n >>= 1;
        }
        return numOfOnes;
    }
}
