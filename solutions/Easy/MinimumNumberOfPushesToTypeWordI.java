/**
 * LeetCode #3275 - Minimum Number of Pushes to Type Word I
 * Difficulty : Easy
 * Topics     : Math, String, Greedy
 * Date       : 2026-07-30
 * URL        : https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-i/
 */

class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        if(n<=8)
            return n;
        int m = n/8;
        int res = 0;
        int i=1;
        while(m!=0){
            res += 8*i++;
            m--;
        }
        int rem = n%8;
        res +=rem*i;
        return res;
    }
}
