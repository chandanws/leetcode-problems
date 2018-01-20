// Problem link: https://leetcode.com/problems/design-tic-tac-toe/description/
// Status: Accepted

class TicTacToe {
    int [][] board;
    public TicTacToe(int n) {
       board = new int[n][n]; 
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
        board[row][col] = player;
        boolean tryH = true, tryV = true, tryD1 = true, tryD2 = true;
        for(int i = 0; i < board.length; i++) {
          if(tryH && board[row][i] != player)
            tryH = false;
          if(tryV && board[i][col] != player)
            tryV = false;
          if(tryD1 && board[i][i] != player)
            tryD1 = false;
          if(tryD2 && board[i][board.length-1-i] != player)
            tryD2 = false;
          if(!tryH && !tryV && !tryD1 && !tryD2)
            break;
        }
        if(tryH || tryV || tryD1 || tryD2)
          return player;
        else
          return 0;
    }
}
