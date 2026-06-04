/**
 * LeetCode #4057 - Total Waviness of Numbers in Range I
 * Difficulty : Medium
 * Topics     : Math, Dynamic Programming, Enumeration
 * Date       : 2026-06-04
 * URL        : https://leetcode.com/problems/total-waviness-of-numbers-in-range-i/
 */

class Solution {
    public int totalWaviness(int num1, int num2) {
        int count = 0;
        for(int i=num1;i<=num2;i++){
            String nums = String.valueOf(i);
            for(int idx = nums.length()-2;idx>=1;idx--){
                if(nums.charAt(idx) - '0' > nums.charAt(idx-1) - '0' &&
                    nums.charAt(idx) - '0' > nums.charAt(idx+1) - '0')
                    count++;
                if(nums.charAt(idx) - '0' < nums.charAt(idx-1) - '0' &&
                    nums.charAt(idx) - '0' < nums.charAt(idx+1) - '0')
                    count++;
            }
        }
        return count;
    }
}
