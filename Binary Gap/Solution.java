// Problem link: https://leetcode.com/problems/binary-gap/description/
// Status: Accepted

class Solution {
    public int binaryGap(int N) {
        String bin = Integer.toBinaryString(N);
        int countOnes = 0, max = 0, currentMax = 0;
        for(int i = 0; i < bin.length(); i++) {
            if(bin.charAt(i) == '1') countOnes++;
            if(bin.charAt(i) == '1') {
                max = Math.max(max, currentMax);
                currentMax = 1;
            } else currentMax++;
        }
        if(countOnes <= 1) return 0;
        return max;
    }
}
