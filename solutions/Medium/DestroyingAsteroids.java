/**
 * LeetCode #2245 - Destroying Asteroids
 * Difficulty : Medium
 * Topics     : Array, Greedy, Sorting
 * Date       : 2026-05-31
 * URL        : https://leetcode.com/problems/destroying-asteroids/
 */

class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long m = mass;
        for(int ast:asteroids){
            if(ast <= m)
                m += ast;
            else
                return false;
        }
        return true;
    }
}
