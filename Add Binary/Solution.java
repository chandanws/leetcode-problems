// Problem link: https://leetcode.com/problems/add-binary/description/
// Status: Accepted

class Solution {
    public String addBinary(String a, String b) {
        Stack<Character> s1 = new Stack();
        Stack<Character> s2 = new Stack();
        for(char c : a.toCharArray()) s1.push(c);
        for(char c : b.toCharArray()) s2.push(c);
        int carry = 0;
        StringBuilder res = new StringBuilder();
        while(!s1.isEmpty() || !s2.isEmpty()) {
            int sum = carry;
            if(!s1.isEmpty()) sum += ((int) s1.pop() - '0');
            if(!s2.isEmpty()) sum += ((int) s2.pop() - '0');
            res.insert(0, sum % 2); 
            carry = sum / 2;
        }
        if(carry != 0) res.insert(0, 1);
        return res.toString();
    }
}
