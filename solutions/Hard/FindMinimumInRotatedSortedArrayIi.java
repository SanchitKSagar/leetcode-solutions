/**
 * LeetCode #154 - Find Minimum in Rotated Sorted Array II
 * Difficulty : Hard
 * Topics     : Array, Binary Search
 * Date       : 2026-05-16
 * URL        : https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 */

class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while(left + 1 < right){
            int mid = left + (right- left)/2;
            if(nums[mid] > nums[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return Math.min (nums[left], nums[right]);
    }
}
