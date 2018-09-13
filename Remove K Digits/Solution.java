// Problem link: https://leetcode.com/problems/remove-k-digits/description/
// Status: Accepted

class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length() <= k) return "0";
        Stack<Integer> s = new Stack<Integer>();
        StringBuilder sb = new StringBuilder(num);
        int count = k;
        for(int i = 0; i < num.length() && count > 0; i++) {
            while(!s.isEmpty() && count > 0 &&
                 (num.charAt(s.peek()) - '0') > (num.charAt(i) - '0')) {
                sb.setCharAt(s.pop(), '#');
                count--;
            }
            s.push(i);
        }
        while(count-- > 0) sb.setCharAt(s.pop(), '#');
        count = k;
        for(int i = num.length() - 1; i >= 0 && count > 0; i--) {
            if(sb.charAt(i) == '#') {
                sb.replace(i, i + 1, "");
                count--;
            }
        }
        for(int i = 0; i < num.length(); i++) {
            if(sb.length() > 1 && sb.charAt(0) == '0') sb.replace(0, 1, "");
            else break;
        }
        return sb.toString();
    }
}
