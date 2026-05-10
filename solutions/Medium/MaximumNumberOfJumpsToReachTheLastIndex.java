/**
 * LeetCode #2855 - Maximum Number of Jumps to Reach the Last Index
 * Difficulty : Medium
 * Topics     : Array, Dynamic Programming
 * Date       : 2026-05-10
 * URL        : https://leetcode.com/problems/maximum-number-of-jumps-to-reach-the-last-index/
 */

class Solution {
    Integer dp[];
    public int maximumJumps(int[] nums, int target) {
        dp = new Integer[nums.length];
        return rec(nums, target, 0, dp);
    }

    public int rec(int[] nums, int t, int i, Integer[] dp){
        if(i == nums.length-1)
            return 0;
        if(dp[i] != null)
            return dp[i];
        int c = -1;
        for(int j=i+1;j<nums.length;j++){
            if(Math.abs(nums[j]-nums[i]) <= t){
                int n = rec(nums,t,j, dp);
                if(n!=-1)
                    c = Math.max(c, n+1);
            }
        }
        dp[i] = c;
        return c;
    }
}
