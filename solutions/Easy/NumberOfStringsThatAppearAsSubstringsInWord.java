/**
 * LeetCode #2099 - Number of Strings That Appear as Substrings in Word
 * Difficulty : Easy
 * Topics     : Array, String
 * Date       : 2026-06-29
 * URL        : https://leetcode.com/problems/number-of-strings-that-appear-as-substrings-in-word/
 */

class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int count = 0;
        for(String pattern : patterns){
            if(word.contains(pattern))
                count++;
        }
        return count;
    }
}
