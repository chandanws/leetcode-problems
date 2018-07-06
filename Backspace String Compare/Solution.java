// Problem link: https://leetcode.com/problems/backspace-string-compare/description/
// Status: Accepted

class Solution {
    public boolean backspaceCompare(String S, String T) {
        ArrayList<Character> s = new ArrayList<Character>();
        for(char c : S.toCharArray()) {
            if(c >= 'a' && c <= 'z') s.add(c);
            else if(c == '#' && s.size() > 0) s.remove(s.size() - 1);
        }
        ArrayList<Character> t = new ArrayList<Character>();
        for(char c : T.toCharArray()) {
            if(c >= 'a' && c <= 'z') t.add(c);
            else if(c == '#' && t.size() > 0) t.remove(t.size() - 1);
        }
        if(s.size() != t.size()) return false;
        StringBuilder strS = new StringBuilder();
        for(char c : s) strS.append(c);
        StringBuilder strT = new StringBuilder();
        for(char c : t) strT.append(c);
        return strS.toString().equals(strT.toString());
    }
}
