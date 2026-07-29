/**
 * LeetCode #1421 - Find Numbers with Even Number of Digits
 * Difficulty : Easy
 * Topics     : Array, Math
 * Date       : 2026-07-29
 * URL        : https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
 */

class Solution {
    public int findNumbers(int[] nums) {
        int res = 0;
        for(int num:nums){
            if((""+num).length() % 2 == 0){
                res++;
            }
        }
        return res;
    }
}
