/**
 * LeetCode #2160 - Minimum Operations to Make a Uni-Value Grid
 * Difficulty : Medium
 * Topics     : Array, Math, Sorting, Matrix
 * Date       : 2026-04-28
 * URL        : https://leetcode.com/problems/minimum-operations-to-make-a-uni-value-grid/
 */

class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        for(int[] g:grid){
            for(int gg:g){
                sum += gg;
                list.add(gg);
            }
        }
        sum = sum / (grid.length * grid[0].length);
        list.sort(null);
        
        if(list.size() % 2 == 0)
            return Math.min(performOps(list, (list.size()/2)-1, x), performOps(list, (list.size()/2), x));
        return performOps(list, list.size()/2, x);
    }

    public int performOps(List<Integer> list, int idx, int x){
        
        int val = list.get(idx);
        int res = 0;
        for(int l:list){
            if(l == val)
                continue;
            
            if(Math.abs(l-val) % x == 0) {
                res += Math.abs(l-val)/ x;
            }
            else{
                return -1;
            }
        }
        return res;
    }
}
