/**
 * LeetCode #1112 - Find Words That Can Be Formed by Characters
 * Difficulty : Easy
 * Topics     : Array, Hash Table, String, Counting
 * Date       : 2026-08-15
 * URL        : https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/
 */

class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] charArray = new int[26];
        for(char c:chars.toCharArray()){
            charArray[c-'a']++; 
        }
        int resLength = 0;
        for(String word:words){
            if(charsContainsWord(word, charArray))
                resLength += word.length();
        }
        return resLength;
    }
    public boolean charsContainsWord(String word, int[] charArr){
        int[] wordArr = new int[26];
        for(char c:word.toCharArray()){
            wordArr[c-'a']++;
        }
        for(int i=0;i<26;i++){
            if(wordArr[i] != 0 && wordArr[i] > charArr[i]){
                return false;
            }
        }
        return true;
    }
}
