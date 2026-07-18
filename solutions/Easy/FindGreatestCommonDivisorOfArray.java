/**
 * LeetCode #2106 - Find Greatest Common Divisor of Array
 * Difficulty : Easy
 * Topics     : Array, Math, Number Theory
 * Date       : 2026-07-18
 * URL        : https://leetcode.com/problems/find-greatest-common-divisor-of-array/
 */

class Solution {
    public int findGCD(int[] nums) {
        int min = 1001;
        int max = 0;
        for(int num:nums){
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        int ans = 1;
        for(int i=1;i<=min;i++){
            if(min%i == 0 && max %i ==0)
                ans = Math.max(i, ans);
        }
        return ans;
    }
}
