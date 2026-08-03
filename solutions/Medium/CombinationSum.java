/**
 * LeetCode #39 - Combination Sum
 * Difficulty : Medium
 * Topics     : Array, Backtracking
 * Date       : 2026-08-03
 * URL        : https://leetcode.com/problems/combination-sum/
 */

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        getSum(candidates, 0, target, res, new ArrayList<>());
        return res;
    }

    public void getSum(int[] nums, int idx, int tgt, List<List<Integer>> res, List<Integer> list){
        if(tgt == 0){
            List<Integer> l = new ArrayList<>(list);
            res.add(l);
            return;
        }

        if(tgt<0 || idx >= nums.length)
            return;

        list.add(nums[idx]);
        getSum(nums, idx, tgt-nums[idx], res, list);
        list.remove(list.size()-1);
        getSum(nums, idx+1, tgt, res, list);
    }
}
