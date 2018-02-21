// Problem link: https://leetcode.com/problems/valid-anagram/description/
// Status: Accepted

import java.util.*;

class Solution {
    public boolean isAnagram(String s, String t) {
        Hashtable<Character, Integer> ht = new Hashtable<>();
        for(char c : s.toCharArray()) {
            if(!ht.containsKey(c)) ht.put(c, 1);
            else ht.put(c, ht.get(c) + 1);
        }
        for(char ch : t.toCharArray()) {
            if(!ht.containsKey(ch)) return false;
            if(ht.get(ch) == 1) ht.remove(ch);
            else ht.put(ch, ht.get(ch) - 1);
        }
        return ht.isEmpty();
    }
}
