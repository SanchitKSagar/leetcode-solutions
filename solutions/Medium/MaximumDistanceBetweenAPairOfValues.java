/**
 * LeetCode #1984 - Maximum Distance Between a Pair of Values
 * Difficulty : Medium
 * Topics     : Array, Two Pointers, Binary Search
 * Date       : 2026-04-19
 * URL        : https://leetcode.com/problems/maximum-distance-between-a-pair-of-values/
 */

class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums2.length;i++){
            map.put(nums2[i],i);
        }

        int max = 0;
        for(int i=0;i<nums1.length && i< nums2.length;i++){
            if(nums2[i] < nums1[i])
                continue;
            int rr = getFirstLessThanNumber(nums1[i], i, nums2, map);
            //System.out.println("" + i + " " + rr);
            max = Math.max (max, rr - i);
        }
        return max;
    }

    public int getFirstLessThanNumber(int num, int i, int[] nums2, Map<Integer, Integer> map){
        int l = i;
        int r = nums2.length-1;
        int res = i;
        while( l <= r){
            int mid = l+ (r-l)/2;
            if(nums2[mid] >= num)
                l = mid+1;
            else {
                r = mid-1;
            }
            if(nums2[mid] >= num)
                res = mid;
        }
        return map.get(nums2[res]);
    }
}
