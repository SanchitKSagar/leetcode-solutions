/**
 * LeetCode #3405 - Count the Number of Special Characters II
 * Difficulty : Medium
 * Topics     : Hash Table, String
 * Date       : 2026-05-27
 * URL        : https://leetcode.com/problems/count-the-number-of-special-characters-ii/
 */

class Solution {
    public int numberOfSpecialChars(String word) {
        int[] lower = new int[26];
        int[] upper = new int[26];
        Arrays.fill(lower,-1);
        Arrays.fill(upper,-1);

        for(int i=0;i<word.length();i++){
            if(Character.isLowerCase(word.charAt(i))){
                lower[word.charAt(i) - 'a'] = i;
            }
            else
            {
                if(upper[word.charAt(i) - 'A'] == -1)
                    upper[word.charAt(i) - 'A'] = i;
            }
        }
        int res = 0;
        for(int i=0;i<26;i++){
            if(lower[i] != -1 && upper[i] !=-1 && lower[i] < upper[i])
                res++;
        }
        return res;
    }
}
