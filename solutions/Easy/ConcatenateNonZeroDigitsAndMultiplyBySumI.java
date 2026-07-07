/**
 * LeetCode #4135 - Concatenate Non-Zero Digits and Multiply by Sum I
 * Difficulty : Easy
 * Topics     : Math
 * Date       : 2026-07-07
 * URL        : https://leetcode.com/problems/concatenate-non-zero-digits-and-multiply-by-sum-i/
 */

class Solution {
    public long sumAndMultiply(int n) {
        String num = String.valueOf(n);
        String res = "";
        int sum = 0;
        for(char ch : num.toCharArray()){
            if(ch != '0'){
                res += ch;
                sum += Integer.valueOf( ch - '0');
            }
        }
        if(res.equals(""))
            return 0;
        long l = Long.valueOf(res);
        return (long) l*sum;
    }
}
