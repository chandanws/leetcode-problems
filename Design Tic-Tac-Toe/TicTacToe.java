// Problem link: https://leetcode.com/problems/design-tic-tac-toe/description/
// Status: Accepted

class TicTacToe {
    private int [][] rows;
    private int [][] cols;
    private int [] diag1;
    private int [] diag2;
    
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        rows = new int[n][2];
        cols = new int[n][2];
        diag1 = new int[2];
        diag2 = new int[2];
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        rows[row][player - 1]++;
        cols[col][player - 1]++;
        if(row == col) diag1[player - 1]++;
        if(row + col == rows.length - 1) diag2[player - 1]++;
        if(rows[row][player - 1] == rows.length ||
          cols[col][player - 1] == cols.length ||
          diag1[player - 1] == rows.length ||
          diag2[player - 1] == rows.length) return player;
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
