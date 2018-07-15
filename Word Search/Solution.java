// Problem link: https://leetcode.com/problems/word-search/description/
// Status: Accepted

class Solution {
    private boolean dfs(char[][] board, String word, int i, int j) {
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || 
           board[i][j] != word.charAt(0) ||
           board[i][j] == '@') return false;
        if(word.length() == 1) return true;
        char temp = board[i][j];
        board[i][j] = '@';
        if(dfs(board, word.substring(1), i + 1, j)) return true;
        if(dfs(board, word.substring(1), i - 1, j)) return true;
        if(dfs(board, word.substring(1), i, j + 1)) return true;
        if(dfs(board, word.substring(1), i, j - 1)) return true;
        board[i][j] = temp;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        if(word.length() == 0 || board.length * board[0].length < word.length()) return false;
        for(int i = 0; i < board.length; i++) {
            for(int j =  0; j < board[0].length; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(dfs(board, word, i, j)) return true;
                }
            }
        }
        return false;
    }
}
