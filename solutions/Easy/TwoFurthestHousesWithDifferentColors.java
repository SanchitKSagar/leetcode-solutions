/**
 * LeetCode #2199 - Two Furthest Houses With Different Colors
 * Difficulty : Easy
 * Topics     : Array, Greedy
 * Date       : 2026-04-20
 * URL        : https://leetcode.com/problems/two-furthest-houses-with-different-colors/
 */

class Solution {

    public int maxDistance(int[] colors) {
        int n = colors.length;
        int res = 0; 
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (colors[i] != colors[j]) {
                    res = Math.max(res, j - i);
                }
            }
        }
        return res;
    }
}
