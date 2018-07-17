// Problem link: https://leetcode.com/problems/word-break/description/
// Status: Accepted

class Solution {
    private Trie root;
    private HashMap<String, HashSet<Trie>> cache;
    private void updateHashMap(String s, Trie trie) {
        if(!cache.containsKey(s)) cache.put(s, new HashSet<Trie>());
        cache.get(s).add(trie);
    }
    private boolean dp(Trie trie, String s) {
        if(s.length() == 0) return trie.end;
        if(!trie.hm.containsKey(s.charAt(0))) return false;
        if(cache.containsKey(s) && cache.get(s).contains(trie)) return false;
        boolean res1 = false, res2 = false;
        if(trie.hm.get(s.charAt(0)).end) res1 = dp(root, s.substring(1));
        if(!res1) updateHashMap(s.substring(1), root);
        res2 = dp(trie.hm.get(s.charAt(0)), s.substring(1));
        if(!res2) updateHashMap(s.substring(1), trie.hm.get(s.charAt(0)));
        return res1 || res2;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        root = new Trie(null, false);
        for(String word : wordDict) root.insert(word);
        cache = new HashMap<String, HashSet<Trie>>();
        return dp(root, s);
    }
}

class Trie {
    Boolean end;
    Character c;
    HashMap<Character, Trie> hm;
    Trie(Character ch, Boolean isEnd) {
        c = ch;
        end = isEnd;
        hm = new HashMap<Character, Trie>();
    }
    void insert(String word) {
        if(word.length() == 0) return;
        if(!hm.containsKey(word.charAt(0))) hm.put(word.charAt(0), new Trie(word.charAt(0), word.length() == 1));
        else if(word.length() == 1) hm.get(word.charAt(0)).end = true;
        hm.get(word.charAt(0)).insert(word.substring(1));
    }
}
