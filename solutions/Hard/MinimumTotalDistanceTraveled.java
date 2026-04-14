/**
 * LeetCode #2554 - Minimum Total Distance Traveled
 * Difficulty : Hard
 * Topics     : Array, Dynamic Programming, Sorting
 * Date       : 2026-04-14
 * URL        : https://leetcode.com/problems/minimum-total-distance-traveled/
 */

class Solution {
    Long[][] dp;
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        robot.sort(null);
        Arrays.sort(factory, (a,b) -> a[0] - b[0]);
        dp = new Long[robot.size()][factory.length];
        return minDistance(robot, factory, 0, 0);
    }

    public long minDistance(List<Integer> robot, int[][] factory, int ridx, int fidx){

        if(ridx == robot.size())
            return 0;
        if(fidx == factory.length)
            return Long.MAX_VALUE;
        if(dp[ridx][fidx] != null)
            return dp[ridx][fidx];
        long factorySkipped = minDistance(robot, factory, ridx, fidx+1);

        long dist = 0;
        long picked = Long.MAX_VALUE;
        for(int limit = 0;limit<factory[fidx][1] && limit+ridx < robot.size(); limit++){
            dist += Math.abs(robot.get(limit+ridx) - factory[fidx][0]);
            long res = minDistance(robot, factory, ridx+1+limit, fidx+1);
            if(res < Long.MAX_VALUE)
                picked = Math.min(picked, dist+res);
        }
        return dp[ridx][fidx] = Math.min(factorySkipped, picked);
    }
}
