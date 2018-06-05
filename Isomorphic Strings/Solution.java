// Problem link: https://leetcode.com/problems/isomorphic-strings/description/
// Status: Accepted

import java.util.*;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        Hashtable<Character, Character> ht1 = new Hashtable<Character, Character>();
        Hashtable<Character, Character> ht2 = new Hashtable<Character, Character>();
        int sLen = s.length();
        for(int i = 0; i < sLen; i++) {
            if(!ht1.containsKey(s.charAt(i)) && !ht2.containsKey(t.charAt(i))) {
                ht1.put(s.charAt(i), t.charAt(i));
                ht2.put(t.charAt(i), s.charAt(i));
            } else {
                if(ht1.containsKey(s.charAt(i)) && ht1.get(s.charAt(i)) != t.charAt(i)) return false;
                if(ht2.containsKey(t.charAt(i)) && ht2.get(t.charAt(i)) != s.charAt(i)) return false;
            }
        }
        return true;
    }
}
