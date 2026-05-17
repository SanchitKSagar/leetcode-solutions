/**
 * LeetCode #4305 - Check Adjacent Digit Differences
 * Difficulty : Easy
 * Topics     : 
 * Date       : 2026-05-17
 * URL        : https://leetcode.com/problems/count-k-th-roots-in-a-range/
 */

class Solution {
    public boolean isAdjacentDiffAtMostTwo(String s) {
        for(int i=0;i<s.length()-1;i++){
            if(
                ( Math.abs( Integer.valueOf(s.charAt(i)) - 
                            Integer.valueOf(s.charAt(i+1)) ) )
                             > 2)
                return false;
        }
        return true;
    }
}
