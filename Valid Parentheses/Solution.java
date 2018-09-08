// Problem link: https://leetcode.com/problems/valid-parentheses/description/
// Status: Accepted

class Solution {
    final private char roundBracketOpen = '(';
    final private char roundBracketClose = ')';
    final private char curlyBracketOpen = '{';
    final private char curlyBracketClose = '}';
    final private char squareBracketOpen = '[';
    final private char squareBracketClose = ']';
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(char c : s.toCharArray()) {
            switch(c) {
                case roundBracketOpen:
                    stack.push(roundBracketClose);
                    break;
                case roundBracketClose:
                    if(stack.isEmpty() || !stack.isEmpty() && stack.pop() != roundBracketClose) return false;
                    break;
                case curlyBracketOpen:
                    stack.push(curlyBracketClose);
                    break;
                case curlyBracketClose:
                    if(stack.isEmpty() || !stack.isEmpty() && stack.pop() != curlyBracketClose) return false;
                    break;
                case squareBracketOpen:
                    stack.push(squareBracketClose);
                    break;
                case squareBracketClose:
                    if(stack.isEmpty() || !stack.isEmpty() && stack.pop() != squareBracketClose) return false;
                    break;
                default:
                    break;
            }
        }
        return stack.isEmpty();
    }
}
