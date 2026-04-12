/**
 * LeetCode #4271 - Find the Degree of Each Vertex
 * Difficulty : Easy
 * Topics     : 
 * Date       : 2026-04-12
 * URL        : https://leetcode.com/problems/find-the-degree-of-each-vertex/
 */

class Solution {
    public int[] findDegrees(int[][] matrix) {
        int[] res = new int[matrix.length];
        for(int i=0;i<matrix.length;i++){
            int num = 0;
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j] == 1)
                    num++;
            }
            res[i] = num;
        }
        return res;
    }
}
