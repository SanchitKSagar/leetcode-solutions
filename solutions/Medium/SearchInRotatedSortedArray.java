/**
 * LeetCode #33 - Search in Rotated Sorted Array
 * Difficulty : Medium
 * Topics     : Array, Binary Search
 * Date       : 2026-05-22
 * URL        : https://leetcode.com/problems/search-in-rotated-sorted-array/
 */

class Solution {
    public int search(int[] nums, int target) {
        int l=0;
        int h= nums.length-1;

        while(l<=h){
            int mid = l+ (h-l)/2;
            if(nums[mid] == target)
                return mid;
            if(nums[l] <= nums[mid] ){
                if(target < nums[mid] && target >= nums[l])
                    h = mid-1;
                else
                    l = mid+1;
            }
            else
            {
                if(target > nums[mid] && target <= nums[h])
                    l = mid+1;
                else
                    h = mid-1;
            }
        }
        return -1;
    }
}
