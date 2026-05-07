/**
 * LeetCode #3981 - Jump Game IX
 * Difficulty : Medium
 * Topics     : Array, Dynamic Programming
 * Date       : 2026-05-07
 * URL        : https://leetcode.com/problems/jump-game-ix/
 */

class Solution {
    public int[] maxValue(int[] nums) {
        int[] prefixMax = new int[nums.length];
        int[] postfixMin = new int[nums.length];
        int res[] = new int[nums.length];

        prefixMax[0] = nums[0];
        for(int i=1;i<nums.length;i++)
            prefixMax[i] = Math.max(prefixMax[i-1], nums[i]);
        
        postfixMin[nums.length-1] = nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--)
            postfixMin[i] = Math.min(postfixMin[i+1], nums[i]);

        res[res.length-1] = prefixMax[res.length-1];
        for(int i=nums.length-2;i>=0;i--){
            if(prefixMax[i] > postfixMin[i+1]){
                res[i] = res[i+1];
            }
            else{
                res[i] = prefixMax[i];
            }
        }
        return res;
    }
}
