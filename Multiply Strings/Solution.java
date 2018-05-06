// Problem link: https://leetcode.com/problems/multiply-strings/description/
// Status: Accepted

class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        int num1Len = num1.length(), num2Len = num2.length(), carry = 0, k = 1;
        int [] answer = new int[num1Len + num2Len];
        for(int i = num1Len - 1; i >= 0; i--) {
            carry = 0;
            int index = num1Len + num2Len - k++;
            for(int j = num2Len - 1; j >= 0; j--) {
                int product = answer[index] + (((int) num1.charAt(i) - '0') * ((int) num2.charAt(j) - '0')) + carry;
                carry = product / 10;
                answer[index--] = product % 10;
            }
            answer[index] += carry;
        }
        StringBuilder res = new StringBuilder();
        for(int i = num1Len + num2Len - 1; i >= 0; i--) {
            if(i == 0 && answer[i] == 0) continue;
            res.insert(0, answer[i]);
        }
        return res.toString();
    }
}
