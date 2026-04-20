/**
 * LeetCode #1231 - Replace Elements with Greatest Element on Right Side
 * Difficulty : Easy
 * Topics     : Array
 * Date       : 2026-04-20
 * URL        : https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/
 */

class Solution {
    public int[] replaceElements(int[] arr) {
        int prev = arr[arr.length-1];
        arr[arr.length-1] = -1;
        for(int i = arr.length-2;i>=0;i--){
            int t = prev;
            prev = arr[i];
            arr[i] = Math.max(t, arr[i+1]);
        }
        return arr;
    }
}
