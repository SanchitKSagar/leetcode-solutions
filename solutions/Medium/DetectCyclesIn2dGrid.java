/**
 * LeetCode #1663 - Detect Cycles in 2D Grid
 * Difficulty : Medium
 * Topics     : Array, Depth-First Search, Breadth-First Search, Union-Find, Matrix
 * Date       : 2026-04-26
 * URL        : https://leetcode.com/problems/detect-cycles-in-2d-grid/
 */

class Solution {
    int m, n;
    int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};

    public boolean containsCycle(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    if (dfs(grid, visited, i, j, -1, -1)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] grid, boolean[][] visited,
                        int x, int y, int px, int py) {
        visited[x][y] = true;

        for (int[] d : dirs) {
            int nx = x + d[0];
            int ny = y + d[1];

            if (nx < 0 || ny < 0 || nx >= m || ny >= n) {
                continue;
            }

            if (grid[nx][ny] != grid[x][y]) {
                continue;
            }

            if (nx == px && ny == py) {
                continue;
            }

            if (visited[nx][ny]) {
                return true;
            }

            if (dfs(grid, visited, nx, ny, x, y)) {
                return true;
            }
        }

        return false;
    }
}
