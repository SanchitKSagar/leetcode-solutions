/**
 * LeetCode #812 - Rotate String
 * Difficulty : Easy
 * Topics     : String, String Matching
 * Date       : 2026-05-03
 * URL        : https://leetcode.com/problems/rotate-string/
 */

class Solution {
    public boolean rotateString(String s, String goal) {
        return goal.length() == s.length() ? (goal+goal).contains(s): false;
    }
}
