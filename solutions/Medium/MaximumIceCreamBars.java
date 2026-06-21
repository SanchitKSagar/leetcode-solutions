/**
 * LeetCode #1961 - Maximum Ice Cream Bars
 * Difficulty : Medium
 * Topics     : Array, Greedy, Sorting, Counting Sort
 * Date       : 2026-06-21
 * URL        : https://leetcode.com/problems/maximum-ice-cream-bars/
 */

class Solution {
    public int maxIceCream(int[] costs, int coins) {
        // Counting Sort
        int[] count = new int[100001];

        int max = 0;
        for(int cost:costs){
            max = Math.max(max, cost);
            count[cost]++;
        } 
        int res = 0;
        for(int i=0;i<=max;i++){
            while(count[i] >=1 && i<=coins){
                res++;
                count[i] --;
                coins -= i;
            }
        }
        return res;
    }
}
