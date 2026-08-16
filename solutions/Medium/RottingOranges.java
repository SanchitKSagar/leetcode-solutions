/**
 * LeetCode #1036 - Rotting Oranges
 * Difficulty : Medium
 * Topics     : Array, Breadth-First Search, Matrix
 * Date       : 2026-08-16
 * URL        : https://leetcode.com/problems/rotting-oranges/
 */

class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int total = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if (grid[i][j] == 2)
                    q.offer(new int[] {i,j});
                if(grid[i][j] != 0)
                    total ++;
            }
        }
        int count = 0;
        int[][] dir = new int[][] {{1,0}, {-1,0}, {0,1}, {0,-1}};
        while(!q.isEmpty()){
            int size = q.size();
            while(size!=0){
                int[] popped = q.poll();
                for(int[] d:dir){
                    int nr = popped[0] + d[0];
                    int nc = popped[1] + d[1];
                    if(nr >=0 && nr < grid.length 
                        && nc >= 0 && nc < grid[0].length
                        && grid[nr][nc] == 1 ){
                            q.offer(new int[]{nr,nc});
                            grid[nr][nc] = 2;
                        }
                }
                size--;
            }
            count ++;
        }
        int rot = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j] == 2)
                    rot ++;
            }
        }
        if(rot == total)
            return count >0 ? count-1 : 0;
        return -1;
    }
}
