// Problem link: https://leetcode.com/problems/word-break/description/
// Status: Accepted

class Solution {
    private Trie root;
    private boolean wordBreakHelper(char [] s, int i, Trie current, HashMap<Integer, HashSet<Trie>> cache) {
        if(i == s.length) return root == current;
        if(cache.containsKey(i) && cache.get(i).contains(current)) return false;
        if(!cache.containsKey(i)) cache.put(i, new HashSet<Trie>());
        if(current.alphabet[s[i] - 'a'] == null) return !cache.get(i).add(current);
        if(current.alphabet[s[i] - 'a'].isEnd) {
            if(wordBreakHelper(s, i + 1, root, cache)) return true;
            cache.get(i + 1).add(root);
        }
        return wordBreakHelper(s, i + 1, current.alphabet[s[i] - 'a'], cache);
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        root = new Trie();
        for(String word : wordDict) root.insert(word.toCharArray(), 0);
        return wordBreakHelper(s.toCharArray(), 0, root, new HashMap<Integer, HashSet<Trie>>());
    }
}

public class Trie {
    boolean isEnd;
    Character c;
    Trie [] alphabet;
    Trie() {
        isEnd = false;
        c = null;
        alphabet = new Trie[26];
    }
    Trie(char ch) {
        isEnd = false;
        c = ch;
        alphabet = new Trie[26];
    }
    void insert(char [] word, int i) {
        if(alphabet[word[i] - 'a'] == null) alphabet[word[i] - 'a'] = new Trie(word[i]);
        if(i + 1 == word.length) alphabet[word[i] - 'a'].isEnd = true;
        else alphabet[word[i] - 'a'].insert(word, i + 1);
    }
}
