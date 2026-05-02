/**
 * LeetCode #804 - Rotated Digits
 * Difficulty : Medium
 * Topics     : Math, Dynamic Programming
 * Date       : 2026-05-02
 * URL        : https://leetcode.com/problems/rotated-digits/
 */

class Solution {
    public int rotatedDigits(int n) {
        int res = 0;
        for(int i=1;i<=n;i++){
            if(isGood(i)){
                res++;
            }
        }
        return res;
    }

    public boolean isGood(int n){

        boolean res = false;
        while(n>0){
            int v = n%10;
            if(v == 3 || v== 4|| v==7)
                return false;
            if(v==2||v==5||v==9||v==6)
                res = true;
            n /= 10;
        }
        return res;
    }
}
