/**
 * LeetCode #55 - Jump Game
 * Difficulty : Medium
 * Topics     : Array, Dynamic Programming, Greedy
 * Date       : 2026-08-15
 * URL        : https://leetcode.com/problems/jump-game/
 */

// class Solution {
//     public boolean canJump(int[] nums) {
//         int goal = nums.length-1;
//         for(int i=nums.length-1;i>=0;i--){
//             if(nums[i]+i >= goal)
//                 goal=i;
//         }
//         return goal == 0;
//     }
// }

// class Solution {
//     Boolean[] dp;
//     public boolean canJump(int[] nums) {
//         dp = new Boolean[nums.length+1];
//         return canJump(nums, 0);
//     }
//     public boolean canJump(int[] nums, int idx){
//         if(idx == nums.length-1){
//             dp[idx] = true;
//             return true;
//         }
//         if(idx >= nums.length)
//             return false;
//         if(dp[idx] != null)
//             return dp[idx];

//         boolean b = false;
//         for(int i=1;i<=nums[idx] && !b;i++){
//             b |= canJump(nums, idx+i);
//         }
//         dp[idx] = b;
//         return b;
//     }
// }

class Solution {
    public boolean canJump(int[] nums) {
        int goal = nums.length-1;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i] + i >= goal){
                goal = i;
            }
        }
        return goal == 0;
    }
}

