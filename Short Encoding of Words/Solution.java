// Problem link: https://leetcode.com/problems/short-encoding-of-words/description/
// Status: Accepted

class Solution {
    private int numOfWords, wordLen;
    private void helper(Node node, int level) {
        if(node.hm.size() == 0) {
            numOfWords++;
            wordLen += level;
            return;
        }
        for(Map.Entry<Character, Node> entry : node.hm.entrySet()) helper(entry.getValue(), level + 1);
    }
    public int minimumLengthEncoding(String[] words) {
        Node node = new Node(null);
        for(String word : words) node.insert(new StringBuilder(word).reverse().toString());
        numOfWords = 0;
        wordLen = 0;
        helper(node, 0);
        return wordLen + numOfWords;
    }
}

class Node {
    Character val;
    HashMap<Character, Node> hm;
    Node(Character c) {
        val = c;
        hm = new HashMap<Character, Node>();
    }
    void insert(String word) {
        if(word.length() > 0) {
            if(!hm.containsKey(word.charAt(0))) {
                hm.put(word.charAt(0), new Node(word.charAt(0)));
            }
            hm.get(word.charAt(0)).insert(word.substring(1));
        }
    }
}
