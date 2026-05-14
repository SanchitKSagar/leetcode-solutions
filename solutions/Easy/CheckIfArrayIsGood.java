/**
 * LeetCode #2892 - Check if Array is Good
 * Difficulty : Easy
 * Topics     : Array, Hash Table, Sorting
 * Date       : 2026-05-14
 * URL        : https://leetcode.com/problems/check-if-array-is-good/
 */

class Solution {
    public boolean isGood(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for(int n:nums){
            set.add(n);
            if(nums.length - 1 == n){
                count++;
            }
        }
        if(count!=2 || set.size() == nums.length)
            return false;
        
        for(int i=1;i<nums.length;i++){
            if(!set.contains(i))
                return false;
        }
        return true;

    }
}
