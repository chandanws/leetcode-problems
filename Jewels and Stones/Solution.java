// Problem link: https://leetcode.com/problems/copy-list-with-random-pointer/description/
// Status: Accepted

class Solution {
    public int numJewelsInStones(String J, String S) {
        char [] jChar = J.toCharArray();
        HashSet<Character> hs = new HashSet<Character>();
        for(int i = 0; i < jChar.length; i++) {
          hs.add(jChar[i]);
        }
        char [] sChar = S.toCharArray();
        int count = 0;
        for(int i = 0; i < sChar.length; i++) {
          if(hs.contains(sChar[i])) {
            count++;
          }
        }
        return count;
    }
}
