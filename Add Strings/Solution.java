// Problem link: https://leetcode.com/problems/add-strings/description/
// Status: Accepted

class Solution {
    public String addStrings(String num1, String num2) {
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        for(char c : num1.toCharArray()) s1.push(c);
        for(char c : num2.toCharArray()) s2.push(c);
        StringBuilder res = new StringBuilder();
        int carry = 0;
        while(!s1.isEmpty() || !s2.isEmpty()) {
            int sum = carry;
            if(!s1.isEmpty()) sum += ((int) s1.pop() - '0');
            if(!s2.isEmpty()) sum += ((int) s2.pop() - '0');
            res.insert(0, sum % 10);
            carry = sum / 10;
        }
        if(carry != 0) res.insert(0, 1);
        return res.toString();
    }
}
