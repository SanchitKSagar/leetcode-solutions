/**
 * LeetCode #3812 - Smallest Palindromic Rearrangement I
 * Difficulty : Medium
 * Topics     : String, Sorting, Counting Sort
 * Date       : 2026-07-28
 * URL        : https://leetcode.com/problems/smallest-palindromic-rearrangement-i/
 */

class Solution {
    public String smallestPalindrome(String s) {
        int[] arr = new int[26];
        String res = "";
        for(char ch:s.toCharArray()){
            arr[ch-'a']++;
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i] % 2 == 0){
                res +=  String.valueOf((char)('a' + i)).repeat(arr[i]/2);
                arr[i] = 0;
            }
            else{
                res +=  String.valueOf((char)('a' + i)).repeat(arr[i]/2);
                arr[i] = 1;
            }
        }
        StringBuilder r = new StringBuilder(res);
        for(int i=0;i<arr.length;i++){
            if(arr[i] == 1)
                res += (char)('a'+i);
        }
        return res + r.reverse();
    }
}
