// Problem link: https://leetcode.com/problems/word-search/description/
// Status: Accepted

class Solution {
    private boolean dfs(char [][] board, char [] wordArr, int i, int j, int index) {
        if(wordArr.length == index) return true;
        if(i < 0 || j < 0 || i == board.length || j == board[0].length || wordArr[index] != board[i][j]) return false;
        char c = board[i][j];
        board[i][j] = '#';
        if(dfs(board, wordArr, i + 1, j, index + 1)) return true;
        if(dfs(board, wordArr, i - 1, j, index + 1)) return true;
        if(dfs(board, wordArr, i, j + 1, index + 1)) return true;
        if(dfs(board, wordArr, i, j - 1, index + 1)) return true;
        board[i][j] = c;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        char [] wordArr = word.toCharArray();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(dfs(board, wordArr, i, j, 0)) return true;
            }
        }
        return false;
    }
}
