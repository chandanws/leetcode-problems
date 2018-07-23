// Problem link: https://leetcode.com/problems/decode-string/description/
// Status: Accepted

class Solution {
    public String decodeString(String s) {
        Stack<Integer> timesStack = new Stack<Integer>();
        Stack<String> strStack = new Stack<String>();
        int i = -1;
        String res = "";
        while(++i < s.length()) {
            if(Character.isDigit(s.charAt(i))) {
                String times = "";
                while(Character.isDigit(s.charAt(i))) times += s.charAt(i++);
                i--;
                timesStack.push(Integer.parseInt(times));
            } else if(s.charAt(i) == '[') {
                strStack.push(res);
                res = "";
            } else if(s.charAt(i) == ']') {
                StringBuilder sb = new StringBuilder(strStack.pop());
                int kTimes = timesStack.pop();
                for(int j = 0; j < kTimes; j++) sb.append(res);
                res = sb.toString();
            } else res += s.charAt(i);
        }
        return res;
    }
}
