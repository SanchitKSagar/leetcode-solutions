/**
 * LeetCode #2199 - Two Furthest Houses With Different Colors
 * Difficulty : Easy
 * Topics     : Array, Greedy
 * Date       : 2026-04-20
 * URL        : https://leetcode.com/problems/two-furthest-houses-with-different-colors/
 */

class Solution {

    public int maxDistance(int[] colors) {
        int n = colors.length;
        int res = 0; 
        for(int i=n-1;i>=0;i--){
            if(colors[0] != colors[i]){
                res = Math.max(res, i);
                break;
            }
        }
        
        for(int i=0;i<n;i++){
            if(colors[colors.length-1] != colors[i]){
                res = Math.max(res, colors.length-1 - i);
                break;
            }
        }
        return res;
    }
}
