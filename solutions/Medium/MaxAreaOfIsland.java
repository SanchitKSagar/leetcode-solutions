/**
 * LeetCode #695 - Max Area of Island
 * Difficulty : Medium
 * Topics     : Array, Depth-First Search, Breadth-First Search, Union-Find, Matrix
 * Date       : 2026-08-16
 * URL        : https://leetcode.com/problems/max-area-of-island/
 */

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    max = Math.max(max, bfs(grid, i,j,visited));
                }
            }
        }
        return max;
    }

    public int bfs(int[][] grid, int i, int j, boolean[][] visited){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {i,j});
        visited[i][j] = true;
        int area = 0;
        int[][] dir = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            int[] polled = q.poll();
            area += 1;
            for(int[] d:dir){
                int nr = polled[0] + d[0];
                int nc = polled[1] + d[1];
                if(nr >= 0 && nr < grid.length 
                    && nc >=0 && nc < grid[0].length 
                    && grid[nr][nc] == 1 
                    && !visited[nr][nc])
                    {
                        visited[nr][nc] = true;
                        q.offer(new int[] {nr,nc});
                    }
            }
        }
        return area;
    }
}
