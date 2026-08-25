/**
 * LeetCode #4080 - Smallest Missing Multiple of K
 * Difficulty : Easy
 * Topics     : Array, Hash Table
 * Date       : 2026-08-25
 * URL        : https://leetcode.com/problems/smallest-missing-multiple-of-k/
 */

class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int max = 0;
        for(int num:nums){
            set.add(num);
            max = Math.max(max, num);
        }
        int i=1;
        for(;i*k <= max;i++){
            if(!set.contains(i*k))
                return i*k;
        }
        return i*k;
    }
}
