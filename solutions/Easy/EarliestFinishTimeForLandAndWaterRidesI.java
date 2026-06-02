/**
 * LeetCode #3965 - Earliest Finish Time for Land and Water Rides I
 * Difficulty : Easy
 * Topics     : Array, Two Pointers, Binary Search, Greedy, Sorting
 * Date       : 2026-06-02
 * URL        : https://leetcode.com/problems/earliest-finish-time-for-land-and-water-rides-i/
 */

class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n = landDuration.length;
        int m = waterDuration.length;
        int res = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int waterMustStartAt = landStartTime[i] + landDuration[i];
            for(int j=0;j<m;j++){
                res = Math.min(res, waterMustStartAt + waterDuration[j] 
                                + (waterStartTime[j] > waterMustStartAt ? waterStartTime[j] - waterMustStartAt : 0));
            }
        }

        for(int i=0;i<m;i++){
            int landMustStartAt = waterStartTime[i] + waterDuration[i];
            for(int j=0;j<n;j++){
                res = Math.min(res, landMustStartAt + landDuration[j] 
                                + (landStartTime[j] > landMustStartAt ? landStartTime[j] - landMustStartAt  : 0));
            }
        }
        
        return res;
    }
}
