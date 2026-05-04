/**
 * LeetCode #48 - Rotate Image
 * Difficulty : Medium
 * Topics     : Array, Math, Matrix
 * Date       : 2026-05-04
 * URL        : https://leetcode.com/problems/rotate-image/
 */

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
		
		for( int i=0;i<n/2;i++ ) {
			for(int j=i;j<n-1-i;j++) {
                swap(matrix,i,j,n-1-j,i);
                swap(matrix,n-1-j,i,n-1-i,n-1-j);
                swap(matrix,n-1-i,n-1-j,j,n-1-i);
			}
		}
    }
    public void swap(int[][] m, int i,int j, int ii, int jj){
        int temp = m[i][j];
        m[i][j] = m[ii][jj];
        m[ii][jj] = temp; 
    }
}
