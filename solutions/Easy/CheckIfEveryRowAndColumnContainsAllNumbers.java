/**
 * LeetCode #2254 - Check if Every Row and Column Contains All Numbers
 * Difficulty : Easy
 * Topics     : Array, Hash Table, Matrix
 * Date       : 2026-08-15
 * URL        : https://leetcode.com/problems/check-if-every-row-and-column-contains-all-numbers/
 */

class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        for(int i=0;i<n;i++){
            Set<Integer> set = new HashSet<>();
            Set<Integer> rset = new HashSet<>();
            for(int j=0;j<n;j++){
                if(matrix[i][j] >=1 && matrix[i][j] <= n){
                    set.add(matrix[i][j]);
                }if(matrix[j][i] >=1 && matrix[j][i] <= n){
                    rset.add(matrix[j][i]);
                }
            }
            if(set.size() != n)
                return false;
            if(rset.size() != n)
                return false;
        }
        return true;
    }
}
