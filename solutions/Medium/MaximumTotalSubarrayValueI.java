/**
 * LeetCode #4005 - Maximum Total Subarray Value I
 * Difficulty : Medium
 * Topics     : Array, Greedy
 * Date       : 2026-06-09
 * URL        : https://leetcode.com/problems/maximum-total-subarray-value-i/
 */

class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        long res = (long)Math.abs(max - min) * (long)k;
        return res;
    }
}
