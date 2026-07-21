/**
 * LeetCode #3805 - Maximize Active Section with Trade I
 * Difficulty : Medium
 * Topics     : String, Enumeration
 * Date       : 2026-07-21
 * URL        : https://leetcode.com/problems/maximize-active-section-with-trade-i/
 */

class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int prevsum = -1;
        int i=0, ones = 0;
        int max = 0;
        
        while(i<s.length()){
            if(s.charAt(i) == '1'){
                ones++;
                i++;
            }
            else{
                int curr = 0;
                while(i<s.length() && s.charAt(i) == '0'){
                    curr++;
                    i++;
                }
                if(prevsum > 0)
                    max = Math.max(max, prevsum + curr);
                prevsum = curr;
            }
        }
        return ones + max;
    }
}
