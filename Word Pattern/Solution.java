// Problem link: https://leetcode.com/problems/word-pattern/description/
// Status: Accepted

import java.util.*;

class Solution {
    public boolean wordPattern(String pattern, String str) {
        String [] words = str.split(" ");
        Hashtable<String, Character> wordHt = new Hashtable<>();
        Hashtable<Character, String> characterHt = new Hashtable<>();
        int len = pattern.length();
        if(len != words.length) return false;
        for(int i = 0; i < len; i++) {
            char c = pattern.charAt(i);
            if((characterHt.containsKey(c) && !characterHt.get(c).equals(words[i])) ||
               (wordHt.containsKey(words[i]) && !wordHt.get(words[i]).equals(c))) return false;
            else if(!characterHt.containsKey(c) && !wordHt.containsKey(words[i])) {
                characterHt.put(c, words[i]);
                wordHt.put(words[i], c);
            }
        }
        return true;
    }
}
