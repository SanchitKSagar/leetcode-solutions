/**
 * LeetCode #1446 - Angle Between Hands of a Clock
 * Difficulty : Medium
 * Topics     : Math
 * Date       : 2026-06-18
 * URL        : https://leetcode.com/problems/angle-between-hands-of-a-clock/
 */

class Solution {
    public double angleClock(int hour, int minutes) {
        double res = 0.0d;
        int minutesAngle = minutes * 6;
        double hourAngle = (hour % 12) * 30;
        hourAngle = hourAngle + (minutes * 0.5);
        res = Math.abs(hourAngle - minutesAngle);
        return Math.min(res, 360-res);
    }
}
