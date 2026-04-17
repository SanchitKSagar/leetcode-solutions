/**
 * LeetCode #4139 - Minimum Absolute Distance Between Mirror Pairs
 * Difficulty : Medium
 * Topics     : Array, Hash Table, Math
 * Date       : 2026-04-17
 * URL        : https://leetcode.com/problems/minimum-absolute-distance-between-mirror-pairs/
 */

class Solution {
    public int minMirrorPairDistance(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                min = Math.min(min, Math.abs(i-map.get(nums[i])));
            }
            map.put(reverse(nums[i]),i);
        }
        return min == Integer.MAX_VALUE ? -1:min;
    }
    public int reverse(int n){
        return Integer.valueOf(new StringBuilder("" + n).reverse().toString());
    }
}
