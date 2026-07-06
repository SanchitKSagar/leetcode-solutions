/**
 * LeetCode #1222 - Remove Covered Intervals
 * Difficulty : Medium
 * Topics     : Array, Sorting
 * Date       : 2026-07-06
 * URL        : https://leetcode.com/problems/remove-covered-intervals/
 */

class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        for(int[] interval:intervals){
            list.add(interval);
        }

        list.sort((a,b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int res = 0;
        for(int i=1;i<list.size();i++){
            int[] curr = list.get(i);
            int[] prev = list.get(i-1);
            if(curr[0] <= prev[1] && curr[1] >= prev[0] && curr[1] <= prev[1]){
                list.remove(i);
                i--;
            }
        }
        return list.size() - res;
    }
    public void disp(List<int[]> r){
        for(int[] l:r){
            System.out.println(l[0] + " " + l[1]);
        }
    }
}
