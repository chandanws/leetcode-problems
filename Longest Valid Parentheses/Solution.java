// Problem link: https://leetcode.com/problems/longest-valid-parentheses/
// Status: Accepted

class Solution {
    public int longestValidParentheses(String s) {
        int maxLength = 0;
        Stack<Integer> st = new Stack<Integer>();
        st.push(-1);
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                st.push(i);
            } else {
                st.pop();
                if(st.isEmpty()) {
                    st.push(i);
                } else {
                    maxLength = Math.max(maxLength, i - st.peek());
                }
            }
        }
        return maxLength;
    }
}
