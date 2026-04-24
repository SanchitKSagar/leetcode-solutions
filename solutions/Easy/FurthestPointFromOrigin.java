/**
 * LeetCode #3019 - Furthest Point From Origin
 * Difficulty : Easy
 * Topics     : String, Counting
 * Date       : 2026-04-24
 * URL        : https://leetcode.com/problems/furthest-point-from-origin/
 */

class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int leftc = 0;
        int rightc = 0;
        int blank = 0;
        for(char c:moves.toCharArray()){
            if(c == 'L')
                leftc ++;
            else if(c == 'R')
                rightc ++;
            else
                blank++;
        }
        if(leftc < rightc){
            return rightc + blank - leftc;
        }
        return leftc + blank - rightc;
    }
}
