/**
 * LeetCode #2714 - Left and Right Sum Differences
 * Difficulty : Easy
 * Topics     : Array, Prefix Sum
 * Date       : 2026-06-06
 * URL        : https://leetcode.com/problems/left-and-right-sum-differences/
 */

class Solution {
    public int[] leftRightDifference(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        left[0] = 0;
        for(int i=1;i<nums.length;i++)
            left[i] = left[i-1] + nums[i-1];
        
        right[right.length-1] = 0;
        for(int i=right.length-2;i>=0;i--)
            right[i] = nums[i+1] + right[i+1];
        
        for(int i=0;i<left.length;i++){
            left[i] = Math.abs(left[i] - right[i]);
        }
        return left;
    }
}
