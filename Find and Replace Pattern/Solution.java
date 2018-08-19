// Problem link: https://leetcode.com/problems/find-and-replace-pattern/description/
// Status: Accepted

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        for(String word : words) {
            HashMap<Character, Character> hm1 = new HashMap<Character, Character>();
            HashMap<Character, Character> hm2 = new HashMap<Character, Character>();
            int i = 0;
            boolean correct = true;
            for(char c : word.toCharArray()) {
                if(!hm1.containsKey(c)) hm1.put(c, pattern.charAt(i));
                if(!hm2.containsKey(pattern.charAt(i))) hm2.put(pattern.charAt(i), c);
                if(hm2.containsKey(pattern.charAt(i)) && hm2.get(pattern.charAt(i)) != c ||
                  hm1.containsKey(c) && hm1.get(c) != pattern.charAt(i)) {
                    correct = false;
                    break;
                }
                i++;
            }
            if(correct) res.add(word);
        }
        return res;
    }
}
