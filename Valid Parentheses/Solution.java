// Problem link: https://leetcode.com/problems/valid-parentheses/description/
// Live example link: https://repl.it/MeL8
// Status: Accepted

import java.util.*;

class Solution {
  public static boolean isValid(String s) {
    Stack st = new Stack();
    for (char c : s.toCharArray()) {
      if (c == '(' || c == '[' || c == '{') {
        st.push(c);
      } else {
        if (st.empty()) {
          return false;
        }
        char currChar = (char) st.pop();
        if (c == ')' && currChar != '(' ||
          c == ']' && currChar != '[' ||
          c == '}' && currChar != '{') {
          return false;    
        }
      }
    }
    if (!st.empty()) {
      return false;
    }
    return true;
  }
}
