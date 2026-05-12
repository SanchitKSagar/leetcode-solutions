/**
 * LeetCode #1784 - Minimum Initial Energy to Finish Tasks
 * Difficulty : Hard
 * Topics     : Array, Greedy, Sorting
 * Date       : 2026-05-12
 * URL        : https://leetcode.com/problems/minimum-initial-energy-to-finish-tasks/
 */

class Solution {

    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> a[1] - a[0] - (b[1] - b[0]));
        int ans = 0;
        for (int[] task : tasks) {
            ans = Math.max(ans + task[0], task[1]);
        }
        return ans;
    }
}
