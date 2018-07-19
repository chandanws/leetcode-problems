// Problem link: https://leetcode.com/problems/implement-trie-prefix-tree/description/
// Status: Accepted

class Trie {
    
    private Character character;
    private boolean isWord;
    private Trie [] arr;

    /** Initialize your data structure here. */
    public Trie() {
        character = null;
        isWord = false;
        arr = new Trie[26];
    }
    
    public Trie(Character c) {
        character = c;
        isWord = false;
        arr = new Trie[26];
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(arr[word.charAt(0) - 'a'] == null) arr[word.charAt(0) - 'a'] = new Trie(word.charAt(0));
        if(word.length() == 1) arr[word.charAt(0) - 'a'].isWord = true;
        else arr[word.charAt(0) - 'a'].insert(word.substring(1));
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(arr[word.charAt(0) - 'a'] == null) return false;
        if(word.length() == 1) return arr[word.charAt(0) - 'a'].isWord;
        return arr[word.charAt(0) - 'a'].search(word.substring(1));
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(arr[prefix.charAt(0) - 'a'] == null) return false;
        if(prefix.length() == 1) return true;
        return arr[prefix.charAt(0) - 'a'].startsWith(prefix.substring(1));
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
