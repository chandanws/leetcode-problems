// Problem link: https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
// Status: Accepted

import java.util.*;

class Solution {
    private Integer isAnagram(int i, String s, String p, Hashtable<Character, Integer> ht) {
        int pLen = p.length(), sLen = s.length();
        if(i + pLen > sLen) return 0;
        Hashtable<Character, Integer> htClone = (Hashtable)ht.clone();
        for(int j = i; j - i < pLen && j < sLen; j++) {
            char c = s.charAt(j);
            if(htClone.containsKey(c)) {
                int count = htClone.get(c);
                if(count == 1) htClone.remove(c);
                else htClone.put(c, count - 1);
            } else {
                if(ht.containsKey(c)) return 0;
                return j;
            }
        }
        return htClone.size() == 0 ? -1 : 0;
    }
    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        List<Integer> res = new ArrayList<>();
        if(sLen == 0 || pLen > sLen) return res;
        Hashtable<Character, Integer> ht = new Hashtable<>();
        for(int i = 0; i < pLen; i++) {
            char c = p.charAt(i);
            if(ht.containsKey(c)) ht.put(c, ht.get(c) + 1);
            else ht.put(c, 1);
        }
        for(int i = 0; i < sLen; i++) {
            Integer r = isAnagram(i, s, p, ht);
            if(r == -1) {
                res.add(i);
                while(i + pLen < sLen && s.charAt(i) == s.charAt(i + pLen)) res.add(++i);
            }
            else if(r != 0) i = r;
        }
        return res;
    }
}
