/**
 * LeetCode #1833 - Find the Highest Altitude
 * Difficulty : Easy
 * Topics     : Array, Prefix Sum
 * Date       : 2026-06-19
 * URL        : https://leetcode.com/problems/find-the-highest-altitude/
 */

class Solution {
    public int largestAltitude(int[] gain) {
        int res = 0;
        int tgain = 0;
        for(int g:gain){
            tgain += g;
            res = Math.max(res, tgain);
        }
        return res;
    }
}
