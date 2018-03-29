// Problem link: https://leetcode.com/problems/plus-one/description/
// Status: Accepted

class Solution {
    public int[] plusOne(int[] digits) {
        int remainder = 1, sum = 0, n = digits.length;
        for(int i = n - 1; i >= 0 && remainder == 1; i--) {
            sum = remainder + digits[i];
            digits[i] = sum % 10;
            if(sum < 10) remainder = 0;
        }
        // when overflow happens
        if(digits[0] == 0) {
            int [] result = new int[n + 1];
            result[0] = 1;
            return result;
        }
        return digits;
    }
}
