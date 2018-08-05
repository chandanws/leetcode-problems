// Problem link: https://leetcode.com/problems/replace-words/description/
// Status: Accepted

class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        Trie trie = new Trie();
        for(String root : dict) trie.insert(root);
        String [] words = sentence.split(" ");
        int i = -1;
        while(++i < words.length) {
            int index = trie.search(words[i], 1);
            if(index > -1) words[i] = words[i].substring(0, index);
        }
        return String.join(" ", words);
    }
}

class Trie {
    Character c;
    boolean isEnd;
    Trie [] alphabet;
    Trie() {
        c = null;
        isEnd = false;
        alphabet = new Trie[26];
    }
    Trie(Character ch) {
        c = ch;
        isEnd = false;
        alphabet = new Trie[26];
    }
    void insert(String word) {
        if(alphabet[word.charAt(0) - 'a'] == null) alphabet[word.charAt(0) - 'a'] = new Trie(word.charAt(0));
        if(word.length() == 1) alphabet[word.charAt(0) - 'a'].isEnd = true;
        else alphabet[word.charAt(0) - 'a'].insert(word.substring(1));
    }
    int search(String word, int level) {
        if(alphabet[word.charAt(0) - 'a'] == null) return -1;
        if(alphabet[word.charAt(0) - 'a'].isEnd) return level;
        if(word.length() == 1) return alphabet[word.charAt(0) - 'a'].isEnd ? level : -1;
        return alphabet[word.charAt(0) - 'a'].search(word.substring(1), level + 1);
    }
}
