// Problem link: https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
// Status: Accepted

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<Integer>();
        for(int i = 0; i < tokens.length; i++) {
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                int b = s.pop();
                int a = s.pop();
                int c;
                switch(tokens[i]) {
                    case "+":
                        c = a + b;
                        break;
                    case "-":
                        c = a - b;
                        break;
                    case "*":
                        c = a * b;
                        break;
                    default:
                        c = a / b;
                        break;
                }
                s.push(c);
            } else s.push(Integer.parseInt(tokens[i]));
        }
        return s.pop();
    }
}
