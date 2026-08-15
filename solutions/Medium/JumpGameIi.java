/**
 * LeetCode #45 - Jump Game II
 * Difficulty : Medium
 * Topics     : Array, Dynamic Programming, Greedy
 * Date       : 2026-08-15
 * URL        : https://leetcode.com/problems/jump-game-ii/
 */

class Solution {
    int[] dp;
    public int jump(int[] nums) {
        dp = new int[nums.length];
        return canReach(nums, 0);
    }

    public int canReach(int[] nums, int idx){
        if(idx == nums.length-1)
            return 0;
        if(idx >= nums.length)
            return 10001;
        if(dp[idx] != 0)
            return dp[idx];
        int min = 10001;
        for(int i=1;i<=nums[idx];i++){
            min = Math.min(min, canReach(nums, idx+i));
        }
        dp[idx] = 1+min;
        return 1+min;
    }
}
