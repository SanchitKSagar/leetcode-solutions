/**
 * LeetCode #1574 - Maximum Product of Two Elements in an Array
 * Difficulty : Easy
 * Topics     : Array, Sorting, Heap (Priority Queue)
 * Date       : 2026-07-27
 * URL        : https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/
 */

class Solution {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int n= nums.length;
        return (nums[n-1] - 1) * (nums[n-2] -1);
    }
}
