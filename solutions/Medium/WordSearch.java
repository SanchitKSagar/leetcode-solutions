/**
 * LeetCode #79 - Word Search
 * Difficulty : Medium
 * Topics     : Array, String, Backtracking, Depth-First Search, Matrix
 * Date       : 2026-08-15
 * URL        : https://leetcode.com/problems/word-search/
 */

class Solution {
	    public boolean exist(char[][] board, String word) {
	        
	        for(int i=0;i<board.length;i++){
	            for(int j=0;j<board[i].length;j++){
	                //if(board[i][j] == word.charAt(0)){
	                    if(dfs(board, i, j, 0, word, "", new boolean[board.length][board[0].length]))
	                        return true;
	                //}
	            }
	        }
	        return false;
	    }
	    public boolean dfs(char[][] board, int i, int j, int idx, String word, String res, boolean[][] visited){
	        
	        if(res.equals(word))
	            return true;
	        if(i<0 || j<0 || i>=board.length || j>=board[0].length)
	            return false;
	        if(visited[i][j])
	            return false;
	        if(res.equals(word))
	            return true;

	        if(word.charAt(idx) != board[i][j])
	            return false;
	        visited[i][j] = true;
	        String r = res + board[i][j];
	        boolean br = dfs(board, i+1,j,idx+1,word,r, visited) || 
	                dfs(board, i-1,j,idx+1,word,r, visited) || 
	                dfs(board, i,j+1,idx+1,word,r, visited) || 
	                dfs(board, i,j-1,idx+1,word,r, visited) ;
	        visited[i][j] = false;
	        return br;
	}
}
