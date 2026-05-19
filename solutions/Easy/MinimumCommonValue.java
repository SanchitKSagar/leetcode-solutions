/**
 * LeetCode #2634 - Minimum Common Value
 * Difficulty : Easy
 * Topics     : Array, Hash Table, Two Pointers, Binary Search
 * Date       : 2026-05-19
 * URL        : https://leetcode.com/problems/minimum-common-value/
 */

class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int i=nums1.length-1;
        int j=nums2.length-1;
        int min = Integer.MAX_VALUE;
        while(i>=0 && j>=0){
            if(nums1[i] > nums2[j]){
                i--;
            }
            else if (nums1[i] < nums2[j]){
                j--;
            }
            else{
                min = Math.min(min, nums1[i]);
                i--;
                j--;
            }
        }
        return min == Integer.MAX_VALUE ? -1:min;
    }
}
