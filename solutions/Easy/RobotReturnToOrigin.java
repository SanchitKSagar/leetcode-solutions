/**
 * LeetCode #657 - Robot Return to Origin
 * Difficulty : Easy
 * Topics     : String, Simulation
 * Date       : 2026-04-05
 * URL        : https://leetcode.com/problems/robot-return-to-origin/
 */

class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;

        for(char c:moves.toCharArray()){
            if(c == 'U'){
                x -= 1;
            } else if (c == 'D'){
                x +=1;
            }else if (c == 'R'){
                y +=1;
            }
            else{
                y -= 1;
            }
        }
        if(x == 0 && y ==0)
            return true;
        return false;
    }
}
