// Problem link: https://leetcode.com/problems/word-search-ii/description/
// Status: Accepted

class Solution {
    private void dfs(char [][] board, Trie node, int i, int j, HashSet<String> hs, StringBuilder sb) {
        if(board[i][j] == '#') return;
        node = node.alphabet[board[i][j] - 'a'];
        if(node == null) return;
        sb.append(board[i][j]);
        if(node.isEnd) hs.add(sb.toString());
        char c = board[i][j];
        board[i][j] = '#';
        if(i + 1 < board.length) dfs(board, node, i + 1, j, hs, sb);
        if(i - 1 >= 0) dfs(board, node, i - 1, j, hs, sb);
        if(j + 1 < board[0].length) dfs(board, node, i, j + 1, hs, sb);
        if(j - 1 >= 0) dfs(board, node, i, j - 1, hs, sb);
        board[i][j] = c;
        sb.deleteCharAt(sb.length() - 1);
    }
    public List<String> findWords(char [][] board, String [] words) {
        Trie root = new Trie();
        for(String word : words) root.insert(word.toCharArray(), 0);
        HashSet<String> hs = new HashSet<String>();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                dfs(board, root, i, j, hs, new StringBuilder());
            }
        }
        Iterator i = hs.iterator();
        List<String> res = new ArrayList<>();
        while(i.hasNext()) res.add((String) i.next());
        return res;
    }
}

class Trie {
    public Character c;
    public boolean isEnd;
    public Trie [] alphabet;
    public Trie() {
        c = null;
        isEnd = false;
        alphabet = new Trie[26];
    }
    public Trie(Character ch) {
        c = ch;
        isEnd = false;
        alphabet = new Trie[26];
    }
    public void insert(char [] wordArr, int index) {
        if(alphabet[wordArr[index] - 'a'] == null) alphabet[wordArr[index] - 'a'] = new Trie(wordArr[index]);
        if(index + 1 == wordArr.length) alphabet[wordArr[index] - 'a'].isEnd = true;
        else alphabet[wordArr[index] - 'a'].insert(wordArr, index + 1);
    }
}
