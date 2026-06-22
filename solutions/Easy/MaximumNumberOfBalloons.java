/**
 * LeetCode #1297 - Maximum Number of Balloons
 * Difficulty : Easy
 * Topics     : Hash Table, String, Counting
 * Date       : 2026-06-22
 * URL        : https://leetcode.com/problems/maximum-number-of-balloons/
 */

class Solution {
    public int maxNumberOfBalloons(String text) {
        //a-0,b-1,l-2,o-3,n-4
        int[] arr = new int[5];
        for(char ch:text.toCharArray()){
            if(ch == 'a'){
                arr[0] ++;
            }else if(ch == 'b'){
                arr[1]++;
            }else if(ch == 'l'){
                arr[2]++;
            }else if(ch == 'o'){
                arr[3]++;
            }else if(ch == 'n'){
                arr[4]++;
            }
        }
        arr[2] = arr[2]/2;
        arr[3] = arr[3]/2;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            min = Math.min(min, arr[i]);
        }
        return min == Integer.MAX_VALUE ? 0: min;
    }
}
