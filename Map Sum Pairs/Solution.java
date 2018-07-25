// Problem link: https://leetcode.com/problems/map-sum-pairs/description/
// Status: Accepted

class MapSum {

    public Trie trie;
    
    /** Initialize your data structure here. */
    public MapSum() {
        trie = new Trie();
    }
    
    public void insert(String key, int val) {
        Integer res = trie.findWord(key);
        if(res == null) trie.insert(key, val);
        else if((int) res < val || (int) res > val) trie.insert(key, val - (int) res);
    }
    
    public int sum(String prefix) {
        Integer res = trie.find(prefix);
        return res == null ? 0 : (int) res;
    }
}

class Trie {

    public Integer sum;
    public Integer lastVal;
    public Character c;
    public Trie [] childrens;

    public Trie() {
        sum = 0;
        lastVal = null;
        c = null;
        childrens = new Trie[26];
    }
    
    public Trie(Character ch, Integer currentSum) {
        sum = currentSum;
        lastVal = null;
        c = ch;
        childrens = new Trie[26];
    }
    
    public void insert(String key, int val) {
        if(childrens[key.charAt(0) - 'a'] == null) childrens[key.charAt(0) - 'a'] = new Trie(key.charAt(0), new Integer(val));
        else childrens[key.charAt(0) - 'a'].sum += new Integer(val);
        if(key.length() == 1) {
            if(childrens[key.charAt(0) - 'a'].lastVal == null) childrens[key.charAt(0) - 'a'].lastVal = new Integer(val);
            else childrens[key.charAt(0) - 'a'].lastVal += new Integer(val);
        }
        else childrens[key.charAt(0) - 'a'].insert(key.substring(1), val);
    }
    
    public Integer find(String key) {
        if(childrens[key.charAt(0) - 'a'] == null) return null;
        if(key.length() == 1) return childrens[key.charAt(0) - 'a'].sum;
        return childrens[key.charAt(0) - 'a'].find(key.substring(1));
    }
    
    public Integer findWord(String key) {
        if(childrens[key.charAt(0) - 'a'] == null) return null;
        if(key.length() == 1) return childrens[key.charAt(0) - 'a'].lastVal;
        return childrens[key.charAt(0) - 'a'].findWord(key.substring(1));
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
