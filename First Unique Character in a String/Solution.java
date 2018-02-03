// Problem link: https://leetcode.com/problems/copy-list-with-random-pointer/description/
// Status: Accepted

class Solution {
    public int firstUniqChar(String s) {
        char [] charas = s.toCharArray();
        LinkedHashMap<Character, Integer> t = new LinkedHashMap<Character, Integer>();
        int i = 0;
        for(char c : charas) {
          if(t.containsKey(c)) {
            t.put(c, -1);
          } else {
            t.put(c, i);
          }
          i++;
        }
        Iterator itr = t.entrySet().iterator();
        while(itr.hasNext()) {
          Map.Entry me = (Map.Entry)itr.next();
          if(Integer.valueOf((int)me.getValue()) != -1) {
            return Integer.valueOf((int)me.getValue());
          }
        }
        return -1;
    }
}
