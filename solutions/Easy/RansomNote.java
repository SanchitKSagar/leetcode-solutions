/**
 * LeetCode #383 - Ransom Note
 * Difficulty : Easy
 * Topics     : Hash Table, String, Counting
 * Date       : 2026-08-15
 * URL        : https://leetcode.com/problems/ransom-note/
 */

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote == null || magazine == null)
            return false;
        if(ransomNote.length() == 0)
            return true;
        
        int[] magArr = new int[26];
        int[] ransomArr = new int[26];
        for(char c:magazine.toCharArray()){
            magArr[c-'a']++;
        }

        for(char c:ransomNote.toCharArray()){
            ransomArr[c-'a']++;
        }

        for(int i=0;i<26;i++){
            if(ransomArr[i] != 0 && ransomArr[i] > magArr[i])
                return false;
        }
        return true;

    }
}
