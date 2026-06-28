/**
 * LeetCode #1956 - Maximum Element After Decreasing and Rearranging
 * Difficulty : Medium
 * Topics     : Array, Greedy, Sorting
 * Date       : 2026-06-28
 * URL        : https://leetcode.com/problems/maximum-element-after-decreasing-and-rearranging/
 */

class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int ans = 1;
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] >= ans + 1) {
                ans++;
            }
        }
        
        return ans;
    }
}
