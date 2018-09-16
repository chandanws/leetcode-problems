// Problem link: https://leetcode.com/problems/sudoku-solver/description/
// Status: Accepted

class Solution {
    private boolean SudokuHelper(char [][] board) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] == '.') {
                    HashSet<Integer> hs = new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
                    for(int a = 0; a < 9; a++) {
                        if(board[i][a] != '.' && hs.contains(board[i][a] - '0')) hs.remove(board[i][a] - '0');
                    }
                    for(int a = 0; a < 9; a++) {
                        if(board[a][j] != '.' && hs.contains(board[a][j] - '0')) hs.remove(board[a][j] - '0');
                    }
                    int startI = i / 3 * 3;
                    int startJ = j / 3 * 3;
                    for(int r = startI; r < startI + 3; r++) {
                        for(int c = startJ; c < startJ + 3; c++) {
                            if(board[r][c] != '.' && hs.contains(board[r][c] - '0')) hs.remove(board[r][c] - '0');
                        }
                    }
                    if(!hs.isEmpty()) {
                        Iterator itr = hs.iterator();
                        while(itr.hasNext()) {
                            board[i][j] = (char) ((int) itr.next() + '0');
                            if(SudokuHelper(board)) return true;
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public void solveSudoku(char[][] board) {
        SudokuHelper(board);
    }
}
