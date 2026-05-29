/**
 * LeetCode #3606 - Minimum Element After Replacement With Digit Sum
 * Difficulty : Easy
 * Topics     : Array, Math
 * Date       : 2026-05-29
 * URL        : https://leetcode.com/problems/minimum-element-after-replacement-with-digit-sum/
 */

class Solution {
    public int minElement(int[] nums) {
        int res = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            int sum = 0;
            while(nums[i] != 0){
                sum += nums[i] %10;
                nums[i] /= 10;
            }
            res = Math.min(res, sum);
        }
        return res;
    }
}
