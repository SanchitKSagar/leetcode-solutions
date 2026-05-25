/**
 * LeetCode #2001 - Jump Game VII
 * Difficulty : Medium
 * Topics     : String, Dynamic Programming, Sliding Window, Prefix Sum
 * Date       : 2026-05-25
 * URL        : https://leetcode.com/problems/jump-game-vii/
 */

class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        boolean[] b = new boolean[s.length()];
        b[0] = true;
        int left = 0, right = 0;
        for(int i=0;i<s.length();i++){
            if(!b[i])
                continue;
            left = Math.max(right+1, i+minJump);
            right = Math.min( s.length()-1,i+maxJump);
            for(int j=left;j<=right;j++){
                if(s.charAt(j) == '0')
                    b[j] = true;
            }
            if(b[s.length()-1])
                return true;
        }
        return false;
    }
}
