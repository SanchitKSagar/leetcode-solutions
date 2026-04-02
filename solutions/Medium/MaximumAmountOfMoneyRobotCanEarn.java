/**
 * LeetCode #3677 - Maximum Amount of Money Robot Can Earn
 * Difficulty : Medium
 * Topics     : Array, Dynamic Programming, Matrix
 * Date       : 2026-04-02
 * URL        : https://leetcode.com/problems/maximum-amount-of-money-robot-can-earn/
 */

class Solution {

    public int maximumAmount(int[][] coins) {
        int n = coins[0].length;
        int[][] dp = new int[n + 1][3];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE / 2);
        }

        for (int i = 0; i < 3; i++) {
            dp[1][i] = 0;
        }
        for (int[] row : coins) {
            for (int j = 1; j <= n; j++) {
                int x = row[j - 1];
                dp[j][2] = Math.max(
                    Math.max(dp[j - 1][2] + x, dp[j][2] + x),
                    Math.max(dp[j - 1][1], dp[j][1])
                );
                dp[j][1] = Math.max(
                    Math.max(dp[j - 1][1] + x, dp[j][1] + x),
                    Math.max(dp[j - 1][0], dp[j][0])
                );
                dp[j][0] = Math.max(dp[j - 1][0], dp[j][0]) + x;
            }
        }

        return dp[n][2];
    }
}
