/**
 * LeetCode #2248 - Minimum Cost of Buying Candies With Discount
 * Difficulty : Easy
 * Topics     : Array, Greedy, Sorting
 * Date       : 2026-06-01
 * URL        : https://leetcode.com/problems/minimum-cost-of-buying-candies-with-discount/
 */

class Solution {
    public int minimumCost(int[] cost) {
        // if(cost.length==1)
        //     return cost[0];

        Arrays.sort(cost);
        int res = 0;
        int count = 1;
        for(int i=cost.length-1;i>=0;i--,count++){
            if(count % 3 ==0)
                continue;
            res += cost[i];
        }
        return res;
    }
}
