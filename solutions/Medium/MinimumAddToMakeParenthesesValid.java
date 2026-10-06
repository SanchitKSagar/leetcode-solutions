/**
 * LeetCode #957 - Minimum Add to Make Parentheses Valid
 * Difficulty : Medium
 * Topics     : String, Stack, Greedy, Bracket Sequences
 * Date       : 2026-10-06
 * URL        : https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
 */

class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch == '(')
                stack.push(ch);
            else{
                if(stack.isEmpty() || stack.peek() == ')')
                    stack.push(')');
                else
                    stack.pop();

            }
        }
        // System.out.println(stack);
        return stack.size();
    }
}
