/**
 * LeetCode #3408 - Count the Number of Special Characters I
 * Difficulty : Easy
 * Topics     : Hash Table, String
 * Date       : 2026-05-26
 * URL        : https://leetcode.com/problems/count-the-number-of-special-characters-i/
 */

class Solution {
    public int numberOfSpecialChars(String word) {
        Set<Character> set = new HashSet<>();
        for(char c:word.toCharArray())
            set.add(c);
        int res = 0;
        for(char c:set){
            if(c>='a' && c<='z' && set.contains(Character.toUpperCase(c)))
                res++;
        }
        return res;
    }
}
