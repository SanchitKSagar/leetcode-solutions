/**
 * LeetCode #36 - Valid Sudoku
 * Difficulty : Medium
 * Topics     : Array, Hash Table, Matrix
 * Date       : 2026-08-15
 * URL        : https://leetcode.com/problems/valid-sudoku/
 */

class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j] != '.')
                {
                    if(!(validRow(board, i, j) &&
                    validCol(board, i, j) &&
                    valid3x3(board, i, j))){
                        return false;
                    }
                }
            }
        }
        return true;       
    }
    public boolean validRow(char[][] board, int i, int j){
        Set<Character> set = new HashSet<>();
        for(int col = 0;col<9;col++){
            if(board[i][col] != '.'){
                if(set.contains(board[i][col]))
                    return false;
                set.add(board[i][col]);
            }
        }
        return true;
    }

    public boolean validCol(char[][] board, int i, int j){
        Set<Character> set = new HashSet<>();
        for(int row = 0;row<9;row++){
            if(board[row][j] != '.'){
                if(set.contains(board[row][j]))
                    return false;
                set.add(board[row][j]);
            }
        }
        return true;
    }
    public boolean valid3x3(char[][] board, int i, int j){
        int startr = (i/3)*3;
        int startc = (j/3)*3;
        Set<Character> set = new HashSet<>();
        for(int xr = startr;xr<=startr+2;xr++){
            for(int xc = startc; xc<=startc+2; xc++){
                if(board[xr][xc] != '.'){
                    if(set.contains(board[xr][xc]))
                        return false;
                    set.add(board[xr][xc]);
                }
            }
        }
        return true;
    }
}
