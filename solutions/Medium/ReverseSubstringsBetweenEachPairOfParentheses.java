/**
 * LeetCode #1298 - Reverse Substrings Between Each Pair of Parentheses
 * Difficulty : Medium
 * Topics     : String, Stack, Bracket Sequences
 * Date       : 2026-09-27
 * URL        : https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/
 */

class Solution {
    Set<Integer> set = new HashSet<>();
    public String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int i=0;
        // while(i<s.length() && s.charAt(i) != '('){
        //     sb.append(s.charAt(i++));
        // }
        sb.append(rev(s,0));
        // i = s.length()-1;
        // StringBuilder sbt = new StringBuilder();
        // while(i>=0 && s.charAt(i) != ')'){
        //     sbt.append(s.charAt(i--));
        // }
        // sb.append(sbt.reverse().toString());
        return sb.toString();
    }
    public String rev(String s, int idx){

        StringBuilder sb = new StringBuilder();
        for(int i=idx;i<s.length();i++){
            if(set.contains(i)){
                continue;
            }
            set.add(i);
            if(s.charAt(i) == '('){
                sb.append( rev(s, i+1));
            }
            else if(s.charAt(i) == ')'){
                return sb.reverse().toString();
            }
            else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
