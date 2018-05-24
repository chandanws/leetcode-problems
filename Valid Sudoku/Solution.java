// Problem link: https://leetcode.com/problems/valid-sudoku/description/
// Status: Accepted

class Solution {
    private boolean isValidThreeByThreeBox(int a, int b, char [][] board) {
        int [] threeByThreeChecker = new int[9];
        for(int i = a; i < a + 3; i++) {
            for(int j = b; j < b + 3; j++) {
                int indexForThreeByThree = Character.getNumericValue(board[i][j]);
                if(indexForThreeByThree != -1) {
                    if(threeByThreeChecker[indexForThreeByThree - 1] == 1) return false;
                    else threeByThreeChecker[indexForThreeByThree - 1] = 1;
                }
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++) {
            int [] rowChecker = new int[9];
            int [] colChecker = new int[9];
            for(int j = 0; j < 9; j++) {
                int indexForCol = Character.getNumericValue(board[j][i]);
                if(indexForCol != -1) {
                    if(colChecker[indexForCol - 1] == 1) return false;
                    else colChecker[indexForCol - 1] = 1;
                }
                int indexForRow = Character.getNumericValue(board[i][j]);
                if(indexForRow != -1) {
                    if(rowChecker[indexForRow - 1] == 1) return false;
                    else rowChecker[indexForRow - 1] = 1;
                }
            }
        }
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(!isValidThreeByThreeBox(i * 3, j * 3, board)) return false;
            }
        }
        return true;
    }
}
