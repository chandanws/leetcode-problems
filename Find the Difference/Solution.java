// Problem link: https://leetcode.com/problems/find-the-difference/description/
// Status: Accepted

class Solution {
    public char findTheDifference(String s, String t) {
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        for(char c : s.toCharArray()) hm.put(c, hm.getOrDefault(c, 0) + 1);
        Character extraChara = null;
        for(char c : t.toCharArray()) {
            if(hm.containsKey(c)) {
                hm.put(c, hm.get(c) - 1);
                if(hm.get(c) == 0) hm.remove(c);
            } else {
                extraChara = c;
                break;
            }
        }
        return (char) extraChara;
    }
}
