/**
 * LeetCode #2265 - Partition Array According to Given Pivot
 * Difficulty : Medium
 * Topics     : Array, Two Pointers, Simulation
 * Date       : 2026-06-08
 * URL        : https://leetcode.com/problems/partition-array-according-to-given-pivot/
 */

class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] res = new int[nums.length];
        Arrays.fill(res, pivot);
        int idx = 0;
        for(int num:nums){
            if(num < pivot)
                res[idx++] = num;
        }

        idx = res.length-1;
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i] > pivot)
                res[idx--] = nums[i];
        }
        return res;
    }
}
