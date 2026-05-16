/**
 * LeetCode #154 - Find Minimum in Rotated Sorted Array II
 * Difficulty : Hard
 * Topics     : Array, Binary Search
 * Date       : 2026-05-16
 * URL        : https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 */

class Solution {
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int n:nums)
            min = Math.min(min,n);
        return min;
    }
}
