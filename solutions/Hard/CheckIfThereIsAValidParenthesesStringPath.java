/**
 * LeetCode #2349 -  Check if There Is a Valid Parentheses String Path
 * Difficulty : Hard
 * Topics     : Array, Dynamic Programming, Matrix, Bracket Sequences
 * Date       : 2026-09-29
 * URL        : https://leetcode.com/problems/check-if-there-is-a-valid-parentheses-string-path/
 */

class Solution {
    Boolean[][][] dp;
    public boolean hasValidPath(char[][] grid) {
        int[][] pgrid = new int[grid.length][grid[0].length];
        dp = new Boolean[grid.length][grid[0].length][grid.length + grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '(')
                    pgrid[i][j] = 1;
                else
                    pgrid[i][j] = -1;
            }
        }

        return dfs(pgrid, 0, 0, 0);
    }
    public Boolean dfs(int[][] grid, int i, int j, int sum){
        if(i >= grid.length || j >= grid[0].length)
            return false;
        sum += grid[i][j];
        if (sum < 0) {
            return false;
        }
        if(i == grid.length-1 && j == grid[0].length-1){
            if (sum == 0)
                return true;
            return false;
        }
        if(dp[i][j][sum] != null)
            return dp[i][j][sum];
        
        dp[i][j][sum] = dfs(grid, i+1, j, sum ) 
                || dfs(grid, i, j+1, sum );
        return dp[i][j][sum];
    }
}
