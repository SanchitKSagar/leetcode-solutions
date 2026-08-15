/**
 * LeetCode #1428 - Jump Game III
 * Difficulty : Medium
 * Topics     : Array, Depth-First Search, Breadth-First Search
 * Date       : 2026-08-15
 * URL        : https://leetcode.com/problems/jump-game-iii/
 */

class Solution {
    public boolean canReach(int[] arr, int start) {
        return canReach(arr, start, new boolean[arr.length+1]);
    }

    public boolean canReach(int[] arr, int idx, boolean[] visited){
        if(idx < 0 || idx >= arr.length)
            return false;
        if(visited[idx])
            return false;
        if(arr[idx] == 0){
            visited[idx] = true;
            return true;
        }

        visited[idx] = true;
        return canReach(arr, idx + arr[idx], visited) || canReach(arr, idx - arr[idx], visited);
    }
}
