/**
 * LeetCode #4168 - Mirror Distance of an Integer
 * Difficulty : Easy
 * Topics     : Math
 * Date       : 2026-04-18
 * URL        : https://leetcode.com/problems/mirror-distance-of-an-integer/
 */

class Solution {
    public int mirrorDistance(int n) {
        return Math.abs( 
            n - Integer.valueOf(
                new StringBuilder("" + n).reverse().toString()
            )
        );
    }
}
