/**
 * LeetCode #2639 - Separate the Digits in an Array
 * Difficulty : Easy
 * Topics     : Array, Simulation
 * Date       : 2026-05-11
 * URL        : https://leetcode.com/problems/separate-the-digits-in-an-array/
 */

class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int[] res;
        for(int num:nums){
            String number = String.valueOf(num);
            for(char c:number.toCharArray())
                list.add(c - '0');
        }
        res = new int[list.size()];
        for(int i=0;i<list.size();i++)
            res[i] = list.get(i);
        return res;
    }
}
