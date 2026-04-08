/**
 * LeetCode #3974 - XOR After Range Multiplication Queries I
 * Difficulty : Medium
 * Topics     : Array, Divide and Conquer, Simulation
 * Date       : 2026-04-08
 * URL        : https://leetcode.com/problems/xor-after-range-multiplication-queries-i/
 */

class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int MOD = 1000000007;
        for(int[] query : queries){

            for(int idx = query[0]; idx <= query[1]; idx+= query[2]){
                nums[idx] = (int) (((long)nums[idx] * query[3] ) % MOD );
            }
        }
        int xor = nums[0];
        for(int i=1;i<nums.length;i++){
            xor = xor ^ nums[i];
        }
        return (int)xor;
    }
}
