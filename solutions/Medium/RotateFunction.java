/**
 * LeetCode #396 - Rotate Function
 * Difficulty : Medium
 * Topics     : Array, Math, Dynamic Programming
 * Date       : 2026-05-01
 * URL        : https://leetcode.com/problems/rotate-function/
 */

class Solution {
    public int maxRotateFunction(int[] nums) {
        int len = nums.length;
        int f0 = 0;
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            f0 += i*nums[i];
            sum += nums[i];
        }

        int max = f0;
        for(int i=1;i<len;i++){
            int csum = f0 + sum - nums[len-i] * len;
            max = Math.max(max, csum);
            f0 = csum;
        }
        return max;

    }
}
