/**
 * LeetCode #3931 - Process String with Special Operations I
 * Difficulty : Medium
 * Topics     : String, Simulation
 * Date       : 2026-06-16
 * URL        : https://leetcode.com/problems/process-string-with-special-operations-i/
 */

class Solution {
    public String processStr(String s) {
        StringBuilder res = new StringBuilder("");
        for(char ch:s.toCharArray()){
            if(ch == '*'){
                if(res.length() >=1){
                    res.deleteCharAt(res.length()-1);
                }
            }
            else if (ch == '#'){
                res.append(res.toString());
            }
            else if (ch == '%'){
                res = res.reverse();
            }
            else{
                res.append(ch);
            }
        }
        return res.toString();
    }
}
