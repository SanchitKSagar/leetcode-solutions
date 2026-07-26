/**
 * LeetCode #628 - Maximum Product of Three Numbers
 * Difficulty : Easy
 * Topics     : Array, Math, Sorting
 * Date       : 2026-07-26
 * URL        : https://leetcode.com/problems/maximum-product-of-three-numbers/
 */

class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return Math.max( nums[n-1] * nums[n-2] * nums[n-3] , nums[0] * nums[1] * nums[n-1] );
    }
}
