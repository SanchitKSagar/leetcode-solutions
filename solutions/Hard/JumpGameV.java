/**
 * LeetCode #1466 - Jump Game V
 * Difficulty : Hard
 * Topics     : Array, Dynamic Programming, Sorting
 * Date       : 2026-05-24
 * URL        : https://leetcode.com/problems/jump-game-v/
 */

class Solution {
    Integer[] dp;
    public int maxJumps(int[] arr, int d) {
        int max = 0;
        dp = new Integer[arr.length];
        for(int i=0;i<arr.length;i++){
            max = Math.max(max,possibleJumps(arr, i, d));
        }
        return max;
    }

    public int possibleJumps(int[] arr, int idx, int d){
        if(idx < 0 || idx >= arr.length)
            return 0;
        if(dp[idx] != null)
            return dp[idx];
        int left = idx - d < 0 ? 0:idx-d;
        int right = idx + d >= arr.length ? arr.length-1:idx+d;
        int max = 0;
        
        for(int j=idx-1; j>=left; j--){
            if(arr[j] < arr[idx])
                max = Math.max(max, possibleJumps(arr, j, d));
            else
                break;
        }

        for(int j=idx+1;j<=right;j++){
            if(arr[j] < arr[idx])
                max = Math.max(max, possibleJumps(arr, j, d));
            else
                break;
        }
        dp[idx] = 1+max;
        return 1+max;
    }
}
