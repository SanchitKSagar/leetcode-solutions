/**
 * LeetCode #1961 - Maximum Ice Cream Bars
 * Difficulty : Medium
 * Topics     : Array, Greedy, Sorting, Counting Sort
 * Date       : 2026-06-21
 * URL        : https://leetcode.com/problems/maximum-ice-cream-bars/
 */

class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int sum = 0;
        int res = 0;
        int i=0;
        while(i< costs.length ){
            sum += costs[i++];
            if(sum <= coins)
                res++;
            else
                break;
            
        }
        return res;
    }
}
