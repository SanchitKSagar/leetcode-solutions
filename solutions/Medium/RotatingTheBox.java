/**
 * LeetCode #1972 - Rotating the Box
 * Difficulty : Medium
 * Topics     : Array, Two Pointers, Matrix
 * Date       : 2026-05-06
 * URL        : https://leetcode.com/problems/rotating-the-box/
 */

class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int n = boxGrid.length;
        int m = boxGrid[0].length;

        char[][] res = new char[m][n];

        for(char[] r:res){
            Arrays.fill(r,'.');
        }

        for(int i=0;i<n;i++){
            int stones = 0;
            int processed = 0;
            for(int j=0;j<m;j++){
                if(boxGrid[i][j] == '#')
                    stones++;
                if(boxGrid[i][j] == '*') { 
	                	res[j][n-1-i] = '*';
	                	if( stones != 0 && processed >= stones){
	                		accumulateStones(i,j, stones,res,n,false);
	                		processed = -1;
	                		stones = 0;
	                	}
	            }
                processed++;
            }
            if (stones>0){
                accumulateStones(i,m, stones,res,n,true);
            }
        }
        return res;
    }

    public void accumulateStones(int row, int col, int stones, char[][] res, int rowslen,boolean isEnd){
        if (!isEnd)
            res[col][rowslen-1-row] = '*';
        col -=1;

        while(stones!=0){
            res[col][rowslen-1-row] = '#';
            col--;
            stones--;
        }    
    }
}
