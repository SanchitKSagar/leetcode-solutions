/**
 * LeetCode #1507 - Check if There is a Valid Path in a Grid
 * Difficulty : Medium
 * Topics     : Array, Depth-First Search, Breadth-First Search, Union-Find, Matrix
 * Date       : 2026-04-28
 * URL        : https://leetcode.com/problems/check-if-there-is-a-valid-path-in-a-grid/
 */

class Solution {
    public boolean hasValidPath(int[][] grid) {
        Set<String> set = new HashSet<>();
        switch(grid[0][0]){
            case 1: return dfs(grid, 0,0, set, 'R');
            case 2: return dfs(grid, 0,0, set, 'D');
            case 3: return dfs(grid, 0,0, set, 'D');
            case 4: return dfs(grid, 0,0, set, 'R') || dfs(grid, 0,0, new HashSet<String>(), 'D');
            case 5: return (grid.length == 1 && grid[0].length == 1);
            case 6: return dfs(grid, 0,0, set, 'R');
        }
        return false;
    }

    public boolean dfs(int[][] grid, int row, int col, Set<String> visited, char dir){
        if(row<0 || row >= grid.length || col <0 || col >= grid[0].length)
            return false;
        
        if(row == grid.length-1  && col == grid[0].length-1){
            switch (grid[row][col]){
                case 1: return dir == 'R';
                case 2: return dir == 'D';
                case 3: return dir == 'R';
                case 4: return false;
                case 5: return (dir == 'D' || dir == 'R');
                case 6: return dir == 'D';
            }
        }

        String curr = "" + row + "," + col;
        if(visited.contains(curr))
            return false;
        visited.add(curr);

        switch(grid[row][col]) {

            case 1: 
            if(curr.equals("0,0") || dir == 'L' || dir == 'R'){
                return dfs(grid, row, col-1, visited, 'L') || dfs(grid, row, col+1, visited, 'R');
            }
            break;
            case 2:
            if(curr.equals("0,0") || dir == 'U' || dir == 'D'){
                return dfs(grid, row-1, col, visited, 'U') || dfs(grid, row+1, col, visited, 'D');
            }
            break;
            case 3:
            if(curr.equals("0,0") || dir == 'R' || dir == 'U'){
                return dfs(grid, row, col-1, visited, 'L') || dfs(grid, row+1, col, visited, 'D');
            }
            break;
            case 4:
            if(curr.equals("0,0") || dir == 'L' || dir == 'U'){
                return dfs(grid, row, col+1, visited, 'R') || dfs(grid, row+1, col, visited, 'D');
            }
            break;
            case 5:
            if(curr.equals("0,0") || dir == 'R' || dir == 'D'){
                return dfs(grid, row-1, col, visited, 'U') || dfs(grid, row, col-1, visited, 'L');
            }
            break;
            case 6:
            if(curr.equals("0,0") || dir == 'D' || dir == 'L'){
                return dfs(grid, row-1, col, visited, 'U') || dfs(grid, row, col+1, visited, 'R');
            }
            break;
        }
        return false;
    }
}
