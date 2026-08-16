/**
 * LeetCode #200 - Number of Islands
 * Difficulty : Medium
 * Topics     : Array, Depth-First Search, Breadth-First Search, Union-Find, Matrix
 * Date       : 2026-08-16
 * URL        : https://leetcode.com/problems/number-of-islands/
 */

class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    dfs(grid, i,j,visited);
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid, int i, int j, boolean[][] visited){
        if(j<0 || i<0 || i>= grid.length || j>= grid[0].length)
            return;
        if(visited[i][j])
            return;
        if(grid[i][j] == '0')
            return;

        visited[i][j] = true;
        dfs(grid, i+1, j, visited);
        dfs(grid, i-1, j, visited);
        dfs(grid, i, j-1, visited);
        dfs(grid, i, j+1, visited);
    }
}
