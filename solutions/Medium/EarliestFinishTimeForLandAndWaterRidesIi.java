/**
 * LeetCode #3967 - Earliest Finish Time for Land and Water Rides II
 * Difficulty : Medium
 * Topics     : Array, Two Pointers, Binary Search, Greedy, Sorting
 * Date       : 2026-06-03
 * URL        : https://leetcode.com/problems/earliest-finish-time-for-land-and-water-rides-ii/
 */

class Solution {
    class Node{
        int s;
        int e;
        int d;
        Node(int s, int d){
            this.s = s;
            this.d = d;
            this.e = s+d;
        }

        @Override
        public String toString(){
            return " " + s + " " + e + " " + d;
        }
    }
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        Node leastEndTimeLand = null;
        Node leastEndTimeWater = null;
        int l = Integer.MAX_VALUE;
        for(int i=0;i<landStartTime.length;i++){
            if(landStartTime[i] + landDuration[i] < l){
                leastEndTimeLand = new Node(landStartTime[i], landDuration[i]);
                l = landStartTime[i] + landDuration[i];
            }
        }
        //System.out.println(leastEndTimeLand);
        l = Integer.MAX_VALUE;
        for(int i=0;i<waterStartTime.length;i++){
            if(waterStartTime[i] + waterDuration[i] < l){
                leastEndTimeWater = new Node(waterStartTime[i], waterDuration[i]);
                l = waterStartTime[i] + waterDuration[i];
            }
        }
        //System.out.println(leastEndTimeWater);

        int res = Integer.MAX_VALUE;

        for(int i=0;i<waterStartTime.length;i++){
            res = Math.min (res, leastEndTimeLand.e + (
                        waterStartTime[i] <= leastEndTimeLand.e ? 
                            waterDuration[i] :
                            waterDuration[i] + waterStartTime[i] - leastEndTimeLand.e));
        }

        for(int i=0;i<landStartTime.length;i++){
            res = Math.min (res, leastEndTimeWater.e + (
                        landStartTime[i] <= leastEndTimeWater.e ? 
                            landDuration[i] :
                            landDuration[i] + landStartTime[i] - leastEndTimeWater.e));
        }
        return res;
    }
}
