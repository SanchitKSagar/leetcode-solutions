/**
 * LeetCode #1428 - Jump Game III
 * Difficulty : Medium
 * Topics     : Array, Depth-First Search, Breadth-First Search
 * Date       : 2026-05-17
 * URL        : https://leetcode.com/problems/jump-game-iii/
 */

class Solution {
    public boolean canReach(int[] arr, int start) {
        return canReach(arr, start, new HashSet<Integer>());
    }
    public boolean canReach(int[] arr, int idx, Set<Integer> visited){
        if(idx <0 || idx >= arr.length)
            return false;
        if(arr[idx] == 0)
            return true;
        if(visited.contains(idx))
            return false;

        visited.add(idx);
        return canReach(arr, idx + arr[idx], visited) || canReach(arr, idx - arr[idx], visited);
    }
}
