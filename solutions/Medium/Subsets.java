/**
 * LeetCode #78 - Subsets
 * Difficulty : Medium
 * Topics     : Array, Backtracking, Bit Manipulation
 * Date       : 2026-08-03
 * URL        : https://leetcode.com/problems/subsets/
 */

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        getSubset(nums, 0, list, new ArrayList<>());
        return list;
    }
    public void getSubset(int[] nums, int idx, List<List<Integer>> res, List<Integer> list){
        if(idx == nums.length){
            List<Integer> l = new ArrayList<>(list);
            res.add(l);
            return;
        }
        list.add(nums[idx]);
        getSubset(nums, idx+1, res, list);
        list.remove(list.size()-1);
        getSubset(nums, idx+1, res, list);

    }
}
