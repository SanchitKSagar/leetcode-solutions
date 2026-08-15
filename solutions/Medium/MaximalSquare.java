/**
 * LeetCode #221 - Maximal Square
 * Difficulty : Medium
 * Topics     : Array, Dynamic Programming, Matrix
 * Date       : 2026-08-15
 * URL        : https://leetcode.com/problems/maximal-square/
 */

class Solution {
    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix[0].length;i++){
            dp[matrix.length-1][i] = matrix[matrix.length-1][i] - '0';
        }
        for(int i=0;i<matrix.length;i++){
            dp[i][matrix[0].length-1] = matrix[i][matrix[0].length-1] - '0';
        }
        for(int i = matrix.length-2;i>=0;i--){
            for(int j = matrix[0].length-2;j>=0;j--){
                if(matrix[i][j] == '0'){
                    dp[i][j] = 0;
                }
                else{
                    if(matrix[i+1][j] == '1' && matrix[i][j+1] == '1'){
                        dp[i][j] = 1 + Math.min(dp[i+1][j+1], Math.min(dp[i][j+1], dp[i+1][j]));
                    }
                    else{
                        dp[i][j] = 1;
                    }
                }
            }
        }
        int res = 0;
        for(int[] d:dp){
            for(int dd:d){
                res = Math.max(res, dd);
            }
        }
        return res * res;
    }
}
