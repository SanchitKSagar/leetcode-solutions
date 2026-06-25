/**
 * LeetCode #4074 - Count Subarrays With Majority Element I
 * Difficulty : Medium
 * Topics     : Array, Hash Table, Divide and Conquer, Segment Tree, Merge Sort, Counting, Prefix Sum
 * Date       : 2026-06-25
 * URL        : https://leetcode.com/problems/count-subarrays-with-majority-element-i/
 */

class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        // target appears more than subarray.length/2
        int count = 0;
        for(int i=0;i<nums.length;i++){
            int tgtc = 0;
            for(int j=i;j<nums.length;j++){
                if(nums[j] == target){
                    tgtc ++;
                } 
                if(tgtc > (j-i+1)/2)
                        count++;
            }
        }
        return count;
    }
}
