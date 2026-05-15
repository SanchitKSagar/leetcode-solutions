/**
 * LeetCode #153 - Find Minimum in Rotated Sorted Array
 * Difficulty : Medium
 * Topics     : Array, Binary Search
 * Date       : 2026-05-15
 * URL        : https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */

class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int i=0;
        int j=n-1;
        int res = nums[0];
        while(i<=j){
            if(nums[i] < nums[j]){
                res = Math.min(res,nums[i]);
                break;
            }
            int mid = (i+j+1)/2;
            if(nums[i] <= nums[mid]){
                res = Math.min(res,nums[mid]);
                i = mid+1;
            }
            else{
                
                res = Math.min(res,nums[mid]);
                j = mid-1;
            }

        }
        return res;
}
}
