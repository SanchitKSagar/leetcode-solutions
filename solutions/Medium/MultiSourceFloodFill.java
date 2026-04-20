/**
 * LeetCode #4283 - Multi Source Flood Fill
 * Difficulty : Medium
 * Topics     : 
 * Date       : 2026-04-20
 * URL        : https://leetcode.com/problems/multi-source-flood-fill/
 */

class Solution {
    public int[][] colorGrid(int n, int m, int[][] sources) {

	        int[][] grid = new int[n][m];
	        Queue<int[]> queue = new LinkedList<>();

	        for(int[] source : sources){
	            grid[source[0]][source[1]] = source[2];
	            queue.offer(new int[]{source[0], source[1]});
	        }

	        int cellFilled = sources.length;
	        int[][] dir = new int[][]{  {1,0}, {0,1}, {-1,0}, {0,-1} };
	        while( !queue.isEmpty() && cellFilled != n * m){
	            int size = queue.size();
	            Set<String> set = new HashSet<>();
	            for(int i=0;i<size;i++){
	                int[] polled = queue.poll();
	                for(int[] d:dir){
	                    int r = d[0] + polled[0];
	                    int c = d[1] + polled[1];

	                    if( r< 0 || r >= n || c<0 || c>= m )
	                        continue;
	                    if(grid[r][c] == 0){
	                        grid[r][c] = grid[polled[0]][polled[1]];
	                    }
	                    else{
	                        if(set.contains(""+r+","+c)){
	                            grid[r][c] = Math.max(grid[r][c], grid[polled[0]][polled[1]]);
	                        }
	                        else{
	                            continue;
	                        }
	                    }
	                    if(!set.contains(""+r+","+c))
	                    	queue.offer(new int[] {r,c});
	                    set.add(""+r+","+c);
	                }                
	            }
	            cellFilled += set.size();
	        }

	        return grid;
	    }
}
