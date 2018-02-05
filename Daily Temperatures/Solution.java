// Problem link: https://leetcode.com/problems/daily-temperatures/description/
// Status: Accepted

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int [] res = new int[temperatures.length];
        Stack<Integer> s = new Stack<Integer>();
        for(int i = temperatures.length - 1; i >= 0; i--) {
          while(!s.isEmpty() && temperatures[s.peek()] <= temperatures[i]) {
            s.pop();
          }
          if(!s.isEmpty()) {
            res[i] = s.peek() - i;
          }
          s.push(i);
        }
        return res;
    }
}
