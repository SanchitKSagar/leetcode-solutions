/**
 * LeetCode #1975 - Minimum Distance to the Target Element
 * Difficulty : Easy
 * Topics     : Array
 * Date       : 2026-04-13
 * URL        : https://leetcode.com/problems/minimum-distance-to-the-target-element/
 */

class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int min = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == target)
                min = Math.min(min, Math.abs(start - i));
        }
        return min;
    }
}
